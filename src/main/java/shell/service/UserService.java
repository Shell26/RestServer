package shell.service;

import shell.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    User findOneByLogin(String login);

    User findOneById(Long id);

    void deleteById(Long Id);

    List<User> findAllUser();
}
