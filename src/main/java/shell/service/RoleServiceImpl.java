package shell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shell.model.Role;
import shell.repositories.RoleRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

   public Set<Role> getRole () {
       return new HashSet<Role>(roleRepository.findAll());
    }

    @Override
    public Set<Role> getRoleByName(String nameRole) {
        return roleRepository.findByRole(nameRole);
    }
}
