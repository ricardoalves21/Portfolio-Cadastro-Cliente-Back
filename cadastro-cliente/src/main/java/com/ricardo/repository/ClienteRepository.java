package com.ricardo.repository;

import com.ricardo.dto.ClienteDTO;
import com.ricardo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
