package med.voll.api.domain.medico;

import med.voll.api.domain.consulta.Consulta;
import med.voll.api.domain.endereco.DadosEndereco;
import med.voll.api.domain.paciente.DadosCadastroPaciente;
import med.voll.api.domain.paciente.Paciente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class MedicoRepositoryTest {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private TestEntityManager em;

    @Test
    @DisplayName("Deveria devolver null quando unico medico cadastrado nao esta disponivel na data")
    void escolherMedicoAleatorioLivreNaDataCenario1() {
        // given ou arrange
        var proximaSegundaAs10 = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .atTime(10,0);

        var medico = cadastrarMedico("Medico", "medico@voll.med", "123456", Especialidade.CARDIOLOGIA);
        var paciente = cadastrarPaciente("Paciente", "paciente@email.com","00000000000");
        cadastrarConsulta(medico, paciente, proximaSegundaAs10);

        // when ou act
        var medicoLivre = medicoRepository.escolherMedicoAleatorioLivreNaData(Especialidade.CARDIOLOGIA, proximaSegundaAs10);

        // then ou assert
        assertThat(medicoLivre).isNull();

    }

    @Test
    @DisplayName("Deveria devolver medico quando ele estiver disponivel na data")
    void escolherMedicoAleatorioLivreNaDataCenario2() {
        var proximaSegundaAs10 = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .atTime(10,0);

        var medico = cadastrarMedico("Medico", "medico@voll.med", "123456", Especialidade.CARDIOLOGIA);

        var medicoLivre = medicoRepository.escolherMedicoAleatorioLivreNaData(Especialidade.CARDIOLOGIA, proximaSegundaAs10);
        assertThat(medicoLivre).isEqualTo(medico);

    }

    // Consulta de debug (erro: nome do arquivo properties estava errado)
    // ERRO: application.teste.properties
    // CORRETO: applicatin-teste.properties (com o hífen "-"_
//    @Test
//    @DisplayName("Deveria devolver null quando unico medico cadastrado nao esta disponivel na data")
//    void escolherMedicoAleatorioLivreNaDataCenario1() {
//        var proximaSegundaAs10 = LocalDate.now()
//                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
//                .atTime(10, 0);
//
//        var medico = cadastrarMedico(
//                "Medico",
//                "medico@voll.med",
//                "123456",
//                Especialidade.CARDIOLOGIA
//        );
//
//        var paciente = cadastrarPaciente(
//                "Paciente",
//                "paciente@email.com",
//                "00000000000"
//        );
//
//        cadastrarConsulta(medico, paciente, proximaSegundaAs10);
//
//        // Força o Hibernate a enviar os INSERTs para o banco
//        em.flush();
//
//        // Verifica se a consulta foi realmente persistida
//        var consultaSalva = em.getEntityManager()
//                .createQuery("""
//                select c from Consulta c
//                where c.medico.id = :medicoId
//                and c.data = :data
//                """, Consulta.class)
//                .setParameter("medicoId", medico.getId())
//                .setParameter("data", proximaSegundaAs10)
//                .getSingleResult();
//
//        System.out.println("DATA SALVA:     " + consultaSalva.getData());
//        System.out.println("DATA PROCURADA: " + proximaSegundaAs10);
//
//        assertThat(consultaSalva.getData())
//                .isEqualTo(proximaSegundaAs10);
//
//        assertThat(consultaSalva.getMedico().getId())
//                .isEqualTo(medico.getId());
//
//        // Limpa o contexto de persistência
//        em.clear();
//
//        var consultas = em.getEntityManager()
//                .createQuery("select c from Consulta c", Consulta.class)
//                .getResultList();
//
//        consultas.forEach(c ->
//                System.out.println(
//                        "DB -> ID: " + c.getId()
//                                + " | MEDICO: " + c.getMedico().getId()
//                                + " | DATA: " + c.getData()
//                )
//        );
//
//        System.out.println("MEDICO CADASTRADO: " + medico.getId());
//        System.out.println("DATA DA BUSCA: " + proximaSegundaAs10);
//
//        var medicoLivre = medicoRepository
//                .escolherMedicoAleatorioLivreNaData(
//                        Especialidade.CARDIOLOGIA,
//                        proximaSegundaAs10
//                );
//
//        System.out.println("MEDICO ENCONTRADO: " + medicoLivre);
//
//        assertThat(medicoLivre).isNull();
//    }

    private void cadastrarConsulta(Medico medico, Paciente paciente, LocalDateTime data){
        em.persist(new Consulta(null, medico, paciente, data));
    }

    private Medico cadastrarMedico(String nome, String email, String crm, Especialidade especialidade){
        var medico = new Medico(dadosMedico(nome, email, crm, especialidade));
        em.persist(medico);
        return medico;
    }

    private Paciente cadastrarPaciente(String nome, String email, String cpf){
        var paciente = new Paciente(dadosPaciente(nome, email, cpf));
        em.persist(paciente);
        return paciente;
    }

    private DadosCadastroMedico dadosMedico(String nome, String email, String crm, Especialidade especialidade){
        return new DadosCadastroMedico(
                nome,
                email,
                "61999999999",
                crm,
                especialidade,
                dadosEndereco()
        );
    }

    private DadosCadastroPaciente dadosPaciente(String nome, String email, String cpf){
        return new DadosCadastroPaciente(
          nome,
          email,
          "61999999999",
          cpf,
          dadosEndereco()
        );
    }

    private DadosEndereco dadosEndereco(){
        return new DadosEndereco(
                "rua xpto",
                "bairro",
                "00000000",
                "Brasilia",
                "DF",
                null,
                null

        );
    }
}