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
    public ResponseEntity frasesDoUsuario(Authentication authentication){
        var frasesDoUsuario = phraseService.frasesDoUsuario(authentication);
        return ResponseEntity.ok().body(frasesDoUsuario);
    }

    @PutMapping("frase/revisao")
    public ResponseEntity revisao(@RequestBody PhraseUpdateDays dados, Authentication authentication){
        phraseService.updateNextSeen(dados, authentication);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("frases/para_revisar")
    public ResponseEntity paraRevisar(Authentication authentication){
        var frasesParaRevisar = phraseService.paraRevisar(authentication);
        return ResponseEntity.ok().body(frasesParaRevisar);
    }

}
