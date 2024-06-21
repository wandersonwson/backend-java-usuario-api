package dev.wson.usuario_api.repositorios;

import dev.wson.usuario_api.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCpf(String cpf);
    List<Usuario> findByNomeLike(String nome);
}