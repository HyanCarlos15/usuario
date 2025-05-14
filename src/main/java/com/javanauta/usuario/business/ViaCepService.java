package com.javanauta.usuario.business;


import com.javanauta.usuario.infrastructure.clients.ViaCepClient;
import com.javanauta.usuario.infrastructure.clients.ViaCepDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ViaCepService {

    private final ViaCepClient client;

    public ViaCepDTO buscaDadosEndereco (String cep) {
            return client.buscaDadosEndereco(processarCep(cep));
    }

    private String processarCep(String cep) {
        String cepFormatado = cep.replace(" ", "").
                replace("-", "");

        if (!cepFormatado.matches("[0-9+]")
                || Objects.equals(cepFormatado.length(),  8)) {
            throw new IllegalArgumentException("CEP contém caracteres inválidos");
        }
        return cepFormatado;
    }
}
