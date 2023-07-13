package com.ricardo.controller;

import com.ricardo.dto.ClienteDTO;
import com.ricardo.model.Cliente;
import com.ricardo.service.ClienteService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private ClienteService clienteService;
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<ClienteDTO> list() {
        return clienteService.list();
    }

    @GetMapping("/{id}") //Um parametro individual (não objeto) sempre deverá estar entre chaves.
    public ClienteDTO buscaCliente(@PathVariable Long id) {
        return clienteService.buscaCliente(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluiCliente(@PathVariable Long id) {
        clienteService.excluiCliente(id);
    }

    @PutMapping("/{id}")
    public ClienteDTO atualizaCliente(@RequestBody ClienteDTO cliente, @PathVariable Long id) {
        return clienteService.atualizaCliente(cliente, id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ClienteDTO create(@RequestBody @Valid @NotNull ClienteDTO cliente) {
        return clienteService.create(cliente);
    }

}
