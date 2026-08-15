package eco.phrases.controller;

import eco.phrases.domain.phrase.PhraseRepository;
import eco.phrases.domain.phrase.PhraseResponseData;
import eco.phrases.domain.user.UserRepository;
import eco.phrases.domain.user.UserResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpClient;

@RestController
public class EcoController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhraseRepository phraseRepository;


    @GetMapping("/users")
    public ResponseEntity listUsers(){
        var users = userRepository.findAll().stream().map(UserResponseData::new);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/phrases/{id}")
    public ResponseEntity listPhrases(@PathVariable Long id){
        var phrases = phraseRepository
                .findByUserId(id)
                .stream()
                .map(PhraseResponseData::new)
                .toList();
        return ResponseEntity.ok(phrases);
    }


}
