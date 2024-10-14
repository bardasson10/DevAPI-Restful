package br.com.cinemafilme.security.services;


import br.com.cinemafilme.security.entities.Role;
import br.com.cinemafilme.security.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
