package br.com.cinemafilme.security.repositories;

import java.util.Optional;

import br.com.cinemafilme.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository("user") //faz referência à conexão com o banco de dados
//interface que extende o JpaRepository que fornece métodos para acessar e manipular os dados dos usuários no banco de dados
public interface UserRepository extends JpaRepository<User, Integer> {
    //Optional-> pode ou não receber valor na consulta realizada ao banco
    //<User> indica o objeto a ser retornado
    //findByUsername(String username)-> realiza busca, no banco, pelo username do usuário
    Optional<User> findByUsername(String username);

    //Boolean-> identifica se a busca é true ou false
    //existsByUsername(String username)-> verifica a existência do username no banco
    Boolean existsByUsername(String username);

    //existsByEmail(String email)-> verifica a existência do e-mail
    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}