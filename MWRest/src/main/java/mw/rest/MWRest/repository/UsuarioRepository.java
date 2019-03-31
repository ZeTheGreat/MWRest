package mw.rest.MWRest.repository;

import mw.rest.MWRest.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    List<Usuario> findByNome(String nome);

    Usuario findUsuarioById(Long id);
}
