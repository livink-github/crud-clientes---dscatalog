package br.com.livik.clientmaneger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.livik.clientmaneger.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
