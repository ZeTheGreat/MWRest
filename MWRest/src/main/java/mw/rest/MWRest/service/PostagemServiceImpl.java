package mw.rest.MWRest.service;

import lombok.Setter;
import mw.rest.MWRest.model.Postagem;
import mw.rest.MWRest.repository.PostagemRepository;
import mw.rest.MWRest.service.api.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(value = "postagemService")
public class PostagemServiceImpl implements PostagemService {

    @Autowired
    @Setter
    private PostagemRepository postagemRepository;

    @Override
    public Postagem inserirPostagem(Postagem postagem) {
        return postagemRepository.save(postagem);
    }

    @Override
    public void excluirPostagem(Long idPostagem) {
        postagemRepository.deleteById(idPostagem);
    }

    @Override
    public List<Postagem> BuscarTodos() {
        return (List<Postagem>) postagemRepository.findAll();
    }

    @Override
    public List<Postagem> buscarPostagem(String titulo) {
        return (List<Postagem>) postagemRepository.findByTitulo(titulo);
    }

    @Override
    public Optional<Postagem> buscarPorId(Long idPostagem) {
        return postagemRepository.findById(idPostagem);
    }
}
