package com.ricardo.exception;

public class ExcecaoRegistroNaoEncontrado extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcecaoRegistroNaoEncontrado(Long id) {
        super("Registro não encontrado com o id: " + id);
    }

}
