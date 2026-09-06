package eco.phrases.controller;

import eco.phrases.domain.phrase.*;
import eco.phrases.domain.user.User;
import eco.phrases.domain.user.UserRepository;
import eco.phrases.domain.user.UserResponseData;
import eco.phrases.domain.user.UserResponseProfileData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
public class EcoController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhraseRepository phraseRepository;

    @Autowired
    private PhraseService phraseService;


    @GetMapping("/usuario")
    public ResponseEntity listUsers(){
        var users = userRepository.findAll().stream().map(UserResponseData::new);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/frases/usuario/{id}")
    public ResponseEntity listUserPhrases(@PathVariable Long id){
        var phrases = phraseRepository
                .findByUserId(id)
                .stream()
                .map(PhraseResponseData::new)
                .toList();
        return ResponseEntity.ok(phrases);
    }

    @PostMapping("/frase")
    public ResponseEntity insertPhrase(@RequestBody @Valid PhraseInsertData dados, Authentication authentication){
        String email = authentication.getName();
        var phraseInserted = phraseService.cadastrar(dados, email);
        return  ResponseEntity.ok().body(phraseInserted);
    }

    @DeleteMapping("/frase/{id}")
    public ResponseEntity<Void> deletePhrase(@PathVariable Long id, Authentication authentication){

        phraseService.deletePhrase(id, authentication);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping("user/info")
    public Principal user(Principal user){
        return user;
    }

    @GetMapping("/perfil")
    public ResponseEntity<UserResponseProfileData> getPerfil(@AuthenticationPrincipal String email){

        User user = userRepository.findByEmail(email);

        UserResponseProfileData responseProfile = new UserResponseProfileData(
                user.getName(), user.getEmail(), user.getPhoto()
        );

        return ResponseEntity.ok().body(responseProfile);

    }

    @GetMapping("frases/minhas")
    public ResponseEntity minhasFrases(Authentication authentication){

        String email = authentication.getName();

        User usuario = userRepository.findByEmail(email);

        var frases = phraseRepository.findByUser(usuario)
                .stream()
                .map(PhraseResponseData::new)
                .toList();

        return ResponseEntity.ok().body(frases);
    }

}
