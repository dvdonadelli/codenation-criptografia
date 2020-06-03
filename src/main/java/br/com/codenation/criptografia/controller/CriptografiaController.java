package br.com.codenation.criptografia.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.codenation.criptografia.service.CriptografiaService;

/**
 * CriptografiaController
 */
@RestController
@RequestMapping("/criptografia")
@ResponseBody
public class CriptografiaController {

    @Autowired
    private CriptografiaService service;

    @GetMapping("/{token}")
    public void decifrarCodigo(@PathVariable("token") final String token) throws IOException, InterruptedException {

        // TO-DO: Ler o arquivo answer.json e descriptografar a mensagem do campo
        // "cifrado"
        // utilizando o campo "numero_casas" e preencher o campo "decifrado"

        service.realizarDesafio(token);

        // TO-DO: Gerar resumo criptográfico do texto decifrado usando o algoritmo sha1
        // e atualizar o campo "resumo_criptografico" no arquivo answer.json

    }

}