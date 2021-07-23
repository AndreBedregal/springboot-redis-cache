package pe.javanatic.rediscache.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.javanatic.rediscache.model.User;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
}
