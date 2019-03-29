package mw.rest.MWRest.service.api;

import mw.rest.MWRest.model.Usuario;

import java.util.List;

public interface UsuarioService {

    public Usuario inserirUsuario(String nome, String usuario, String senha, String email);

    public List<Usuario> buscar(String nome);

    public Usuario buscar(Long id);

    public List<Usuario> buscarTodos();

    public Usuario salvar(Usuario usuario);
}
