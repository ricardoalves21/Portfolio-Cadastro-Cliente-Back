package com.ricardo.service;

import com.ricardo.dto.ClienteDTO;
import com.ricardo.dto.mapper.ClienteMapper;
import com.ricardo.exception.ExcecaoRegistroNaoEncontrado;
import com.ricardo.model.Cliente;
import com.ricardo.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Validated
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;


    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public List<ClienteDTO> list() {
        return clienteRepository.findAll()
                .stream()
                .map(clienteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ClienteDTO buscaCliente(Long id) {
        return clienteRepository.findById(id).map(clienteMapper::toDTO)
                .orElseThrow( () -> new ExcecaoRegistroNaoEncontrado(id));
    }

    public void excluiCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public ClienteDTO create(ClienteDTO cliente) {
        return clienteMapper.toDTO(clienteRepository.save(clienteMapper.toEntity(cliente)));
    }

    public ClienteDTO atualizaCliente(ClienteDTO cliente, Long id) {
        return clienteRepository.findById(id)
                .map(r -> {
                    r.setNome(cliente.nome());
                    r.setEmail(cliente.email());
                    r.setTelefone(cliente.telefone());
                    r.setEndereco(cliente.endereco());
                    return clienteMapper.toDTO(clienteRepository.save(r));
                }).orElseThrow( () -> new ExcecaoRegistroNaoEncontrado(id));
    }

}
