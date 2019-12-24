package shell.service;

import shell.model.Role;

import java.util.Set;

public interface RoleService {

    Set<Role> getRole();

    Set<Role> getRoleByName(String nameRole);
}
