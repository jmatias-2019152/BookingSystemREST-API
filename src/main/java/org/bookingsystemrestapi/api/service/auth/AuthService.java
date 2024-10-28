package org.bookingsystemrestapi.api.service.auth;

import org.bookingsystemrestapi.api.model.Usuario;
import org.bookingsystemrestapi.api.repository.user.UsuarioRepository;
import org.bookingsystemrestapi.api.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public String login(String email, String password) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null) {
            throw new RuntimeException("Invalid credentials");
        }
        System.out.println(password + "  /   "+ usuario.getPassword());
        if (usuario != null && passwordEncoder.matches(password, usuario.getPassword())) {
            System.out.println(usuario);
            return jwtTokenUtil.generateToken(usuario.getId());
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
