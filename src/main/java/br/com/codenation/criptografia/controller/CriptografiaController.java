package br.com.codenation.criptografia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * CriptografiaController
 */
@RestController
@RequestMapping("/criptografia")
@ResponseBody
public class CriptografiaController {

    @GetMapping("/{token}")
    public void decifrarCodigo(@PathVariable("token") final String token) {
        
        // TO-DO: Fazer a requisição na API da Codenation e salvar o resultado no arquivo resources/answer.json

        // TO-DO: Ler o arquivo answer.json e descriptografar a mensagem do campo "cifrado" 
        // utilizando o campo "numero_casas" e preencher o campo "decifrado"

        // TO-DO: Gerar resumo criptográfico do texto decifrado usando o algoritmo sha1
        // e atualizar o campo "resumo_criptografico" no arquivo answer.json

    }

}