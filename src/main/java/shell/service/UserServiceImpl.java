package shell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shell.model.User;
import shell.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User findOneByLogin(String login) {
      return userRepository.findOneByLogin(login);
    }

    public User findOneById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public void deleteById(Long Id) {
        userRepository.deleteById(Id);
    }

    public List<User> findAllUser () {
        return userRepository.findAll();
    }
}
