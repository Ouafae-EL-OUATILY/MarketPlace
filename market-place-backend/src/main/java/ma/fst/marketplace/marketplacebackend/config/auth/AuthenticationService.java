package com.madani.market_place.config.auth;

import com.madani.market_place.model.Client;
import com.madani.market_place.repository.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import com.madani.market_place.config.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<?> register(RegisterRequest request) {
        if (userRepo.findByMail(request.getMail()).isEmpty()) {
            var user = Client.builder()
                    .name(request.getName())
                    .mail(request.getMail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .build();

            userRepo.save(user);
            var jwtToken = jwtService.generateToken(user);

            return new ResponseEntity<>(AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>("The email is already registered", HttpStatus.CONFLICT);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getMail(), request.getPassword())
        );
        var user = userRepo.findByMail(request.getMail())
                .orElseThrow(()-> new EntityNotFoundException("AuthenticationService: user not found"));
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
