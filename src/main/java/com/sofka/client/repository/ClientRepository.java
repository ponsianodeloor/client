package com.sofka.client.repository;

import com.sofka.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, String> {
    Optional<Object> findByUsername(String username);
}
