package org.bookingsystemrestapi.api.service.user;

import org.bookingsystemrestapi.api.model.Usuario;
import org.bookingsystemrestapi.api.repository.user.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioServiceImpl implements UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(String id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(String id, Usuario usuario) {
        Usuario existingUser = usuarioRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Usuario no encontrado"));

        if (usuario.getNombre() != null){
            existingUser.setNombre(usuario.getNombre());
        }
        if (usuario.getEmail() != null){
            existingUser.setEmail(usuario.getEmail());
        }
        if (usuario.getTelefono() != null){
            existingUser.setTelefono(usuario.getTelefono());
        }

        return usuarioRepository.save(existingUser);
    }

    @Override
    public void deleteById(String id) {
        usuarioRepository.deleteById(id);
    }
}