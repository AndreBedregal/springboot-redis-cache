package pe.javanatic.rediscache.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pe.javanatic.rediscache.dao.UserRepository;
import pe.javanatic.rediscache.model.User;

import java.util.UUID;

@Service
public class UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class.getName());
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Cacheable(value = "usersCache", key = "#id")
    public User findById(UUID id) {
        LOGGER.info("Find user by id...");
        return userRepository.findById(id).orElse(null);
    }

    @CachePut(value = "usersCache", key ="#user.id")
    public User save(User user) {
        LOGGER.info("Save user...");
        return userRepository.save(user);
    }

    @CacheEvict(value = "usersCache", key = "#id")
    public void deleteById(UUID id) {
        LOGGER.info("Delete user...");
        userRepository.deleteById(id);
    }

    public Iterable<User> findAll() {
        LOGGER.info("Find all users...");
        return userRepository.findAll();
    }
}
