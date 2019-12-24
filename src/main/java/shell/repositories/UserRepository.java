package shell.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shell.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findOneByLogin(String login);

}
