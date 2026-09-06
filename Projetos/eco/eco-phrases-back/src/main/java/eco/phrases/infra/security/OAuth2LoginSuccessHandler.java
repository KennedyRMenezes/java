package eco.phrases.infra.security;

import eco.phrases.domain.user.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class OAuth2LoginSuccessHandler
        implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication)
            throws IOException {

        OAuth2User oauth2User =
                (OAuth2User) authentication.getPrincipal();

        String googleId = oauth2User.getAttribute("sub");
        String name = oauth2User.getAttribute("name");
        String email = oauth2User.getAttribute("email");
        String photo = oauth2User.getAttribute("picture");

        userService.cadastrar(
                name,
                email,
                photo,
                googleId
        );

        String token = tokenService.gerarToken(email);

        response.sendRedirect("http://localhost:5500/html/perfil.html?token=" + token);
    }
}