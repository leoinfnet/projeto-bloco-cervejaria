package br.com.acme.cervejaria.service.impl;

import br.com.acme.cervejaria.model.Role;
import br.com.acme.cervejaria.model.Usuario;
import br.com.acme.cervejaria.repository.UsuarioRepository;
import br.com.acme.cervejaria.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> findAllUsuariosAtivos() {
        List<Usuario> allAtivos = usuarioRepository.findAllAtivos();
        return allAtivos;
    }

    @Override
    public List<Usuario> findAllByStatusList(List<Integer> status) {
        return usuarioRepository.findAllByStatusIn(status);
    }
    @Override
    public List<Usuario> findAllByRoles(List<Role> roles) {
        return usuarioRepository.findAllByRoles(roles);
    }
}
