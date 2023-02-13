package zodd.volt.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import zodd.volt.api.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    UserDetails findByLogin(String login);
}
