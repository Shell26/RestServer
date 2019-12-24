package shell.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import shell.model.Role;
import shell.model.User;
import shell.service.RoleService;
import shell.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(path = "/rest")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostMapping(path = "/user")
    public User getUser(@RequestBody String login) {
        return userService.findOneByLogin(login);
    }

    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        return userService.findAllUser();
    }

    @DeleteMapping(value = "/admin/delete/{*}")
    public ResponseEntity deleteUser(@PathVariable("*") Long id) {
        userService. deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/admin/edit/{*}")
    public ResponseEntity editUser(@RequestBody User user, @PathVariable("*") Long userId) {
        User oldUser = userService.findOneById(userId);
        oldUser.setName(user.getName());
        oldUser.setLogin(user.getLogin());
        oldUser.setPassword(user.getPassword());
        userService.addUser(oldUser);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/admin/save")
    public ResponseEntity saveUsers(@RequestBody User user) {
        Set<Role> roleUserSet =  user.getRoles();
       Optional<Role> userRole = roleUserSet.stream().filter(role -> role.getRole().equals("USER")).findFirst();
        if (userRole.isPresent()) {
            user.setRoles(roleService.getRoleByName("USER"));
        } else {
            user.setRoles(roleService.getRoleByName("ADMIN"));
        }
        userService.addUser(user);
        return ResponseEntity.ok().build();
    }
}
