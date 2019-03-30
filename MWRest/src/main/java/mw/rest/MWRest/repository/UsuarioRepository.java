package mw.rest.MWRest.repository;

import mw.rest.MWRest.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Usuario findByNome(String nome);
}
