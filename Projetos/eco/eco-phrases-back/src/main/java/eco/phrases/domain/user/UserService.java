package eco.phrases.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void cadastrar(String nome,
                          String email,
                          String foto,
                          String googleId){

        var user = userRepository.findByGoogleId(googleId);

        if( user.isPresent() ){
            return;
        }

        var novoUsuario = new User(null, nome, email, foto, googleId);

        userRepository.save(novoUsuario);
    }

}
