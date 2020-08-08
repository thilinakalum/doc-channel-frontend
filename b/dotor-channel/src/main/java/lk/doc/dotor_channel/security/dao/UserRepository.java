package lk.doc.dotor_channel.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.doc.dotor_channel.security.entities.User;


/**
 * @author Kavish Manjitha Perera
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByUsername(String username);
}
