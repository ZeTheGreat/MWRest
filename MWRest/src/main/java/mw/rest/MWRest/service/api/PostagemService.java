package mw.rest.MWRest.service.api;

import mw.rest.MWRest.model.Postagem;

import java.util.List;

public interface PostagemService {

    public Postagem inserirPostagem(Postagem postagem);

    public void excluirPostagem(Long idPostagem);

    public List<Postagem> BuscarTodos();

    public List<Postagem> buscarPostagem(String nome);

    public Postagem buscarPorId(Long idPostagem);
}
