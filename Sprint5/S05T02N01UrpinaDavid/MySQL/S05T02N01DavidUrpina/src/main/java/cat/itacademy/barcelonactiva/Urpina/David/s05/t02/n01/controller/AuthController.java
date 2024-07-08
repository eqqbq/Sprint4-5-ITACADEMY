package cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.controller;

import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.dto.LoginDTO;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.domain.User;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.dto.AuthResponseDTO;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.dto.UserRegistrationDTO;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.repository.UserRepository;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.service.AuthService;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.domain.Role.PLAYER;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> registerUser(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        User user = new User();
        user.setUserName(userRegistrationDTO.getUserName());
        user.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
        user.setRoles(PLAYER);
        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return ResponseEntity.ok(AuthResponseDTO.builder().token(jwtToken).build());
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> loginUser(@RequestBody LoginDTO loginDTO){
        return ResponseEntity.ok(authService.authenticate(loginDTO));
    }
}



