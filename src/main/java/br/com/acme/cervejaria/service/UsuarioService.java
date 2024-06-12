package br.com.acme.cervejaria.service;

import br.com.acme.cervejaria.model.Role;
import br.com.acme.cervejaria.model.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();
    List<Usuario> findAllUsuariosAtivos();
    List<Usuario> findAllByStatusList(List<Integer> status);
    List<Usuario> findAllByRoles(List<Role> roles);
}
