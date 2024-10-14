package br.com.cinemafilme.security.repositories;
import java.util.Optional;

import br.com.cinemafilme.security.entities.Role;
import br.com.cinemafilme.security.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository("role")
public interface RoleRepository extends JpaRepository<Role, Integer> {
    //findByName(RoleEnum name)-> busca pelo nome, porém só aceita se existir no enum RoleEnum
    Optional<Role> findByName(RoleEnum name);
}
