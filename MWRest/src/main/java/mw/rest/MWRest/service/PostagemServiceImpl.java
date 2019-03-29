package mw.rest.MWRest.service;

import mw.rest.MWRest.model.Postagem;
import mw.rest.MWRest.service.api.PostagemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "postagemService")
public class PostagemServiceImpl implements PostagemService {
    @Override
    public Postagem inserirPostagem(Postagem postagem) {
        return null;
    }

    @Override
    public void excluirPostagem(Long idPostagem) {

    }

    @Override
    public List<Postagem> BuscarTodos() {
        return null;
    }

    @Override
    public List<Postagem> buscarPostagem(String nome) {
        return null;
    }

    @Override
    public Postagem buscarPorId(Long idPostagem) {
        return null;
    }
}
