package mw.rest.MWRest.service.api;

import mw.rest.MWRest.model.Postagem;

import java.util.List;
import java.util.Optional;

public interface PostagemService {

    public Postagem inserirPostagem(Postagem postagem);

    public void excluirPostagem(Long idPostagem);

    public List<Postagem> BuscarTodos();

    public List<Postagem> buscarPostagem(String titulo);

    public Optional<Postagem> buscarPorId(Long idPostagem);
}
