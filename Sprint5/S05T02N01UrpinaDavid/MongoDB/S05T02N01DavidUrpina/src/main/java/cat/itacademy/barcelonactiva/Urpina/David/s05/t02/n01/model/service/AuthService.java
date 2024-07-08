package cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.service;

import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.dto.LoginDTO;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.domain.User;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.dto.AuthResponseDTO;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.dto.UserRegistrationDTO;
import org.springframework.security.core.Authentication;

public interface AuthService {
    AuthResponseDTO register(UserRegistrationDTO userRegistrationDTO);
    AuthResponseDTO authenticate(LoginDTO loginDTO);
    User getUserFromAuthentication(Authentication authentication);
}