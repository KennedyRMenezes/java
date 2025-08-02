package phrases;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import phrases.controller.ConsoleUserInput;
import phrases.dto.ConfigLoader;
import phrases.dto.UserDAO;
import phrases.model.User;

public class PhrasesProject {

    public static void main(String[] args) {

            try{

                // ********* INPUT DO USUÁRIO ***********

                Scanner scan = new Scanner(System.in);

                ConsoleUserInput input = new ConsoleUserInput(scan);
                User user = input.readUser();
                System.out.println(user);

                // ConsolePhraseInput input_phrase = new ConsolePhraseInput(scan);
                // Phrase phrase = input_phrase.readPhrase();
                // System.out.println(phrase);

                // Origin origin = new Origin(phrase.getOrigin());
                // Author author = new Author(phrase.getAuthor());

                // System.out.println("Origem e Author da Frase anterior: " + origin + ", " + author);

                // TODO: Lógica de Inserção do BD (primeiro origem, autor, usuario e depois a frase)

                // ********* CRIAÇÃO DE INSTANCIA NO BANCO DE DADOS ***********

                // USUARIO
                Properties config = ConfigLoader.loadProperties("config.phrases.properties");
                UserDAO userDAO = new UserDAO(config);
                userDAO.insertUser(user);
                System.out.println("Usuário inserido com sucesso!");


                // ORIGEM


                // AUTOR


                // CONTROLE FRASES



                scan.close();

            }catch (IOException e) {
                System.err.println("Erro ao carregar config: " + e.getMessage());
            }catch (SQLException e) {
                System.err.println("Erro ao inserir usuário: " + e.getMessage());
            }catch(Exception e){
                System.out.println("Error: " + e);
            }finally{
                System.out.println("\nFim do programa!\n");
            }
    }

}
