package com.ricardo.dto.mapper;

import com.ricardo.dto.ClienteDTO;
import com.ricardo.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public ClienteDTO toDTO(Cliente cliente) {

        if(cliente == null) {
            return null;
        }

        return new ClienteDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getEndereco()
        );
    }

    public Cliente toEntity(ClienteDTO clienteDTO) {

        if(clienteDTO == null) {
            return null;
        }

        Cliente cliente = new Cliente();

        if(clienteDTO.id() != null) {
            cliente.setId(clienteDTO.id());
        }

        cliente.setNome(clienteDTO.nome());
        cliente.setEmail(clienteDTO.email());
        cliente.setTelefone(clienteDTO.telefone());
        cliente.setEndereco(clienteDTO.endereco());

        return cliente;
    }

}
