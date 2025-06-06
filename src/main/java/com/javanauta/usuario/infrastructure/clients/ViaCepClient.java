package com.javanauta.usuario.infrastructure.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "via-cep", url = "${viacep.url}")

 public interface ViaCepClient {

        @GetMapping("/ws/{cep}/json/")// Não precisa de um RI, pois usa por padrão que seria o Usuario
        ViaCepDTO buscaDadosEndereco (@PathVariable("cep") String cep);


}
