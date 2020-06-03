package br.com.codenation.criptografia.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.FileSystems;
import java.time.Duration;

import org.springframework.stereotype.Service;

/**
 * CriptografiaService
 */
@Service
public class CriptografiaService {

    private static final String url = "https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=";
    private static final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10)).build();

    public void realizarDesafio(String token) throws IOException, InterruptedException {

        // Requisição para a Codenation
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url + token)).GET().build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        File answer = new File(
                FileSystems.getDefault().getPath("src/main/resources").toAbsolutePath().toString() + "/answer.json");

        // Criando o arquivo
        if (answer.createNewFile())
            System.out.println("File is created!");
        else
            System.out.println("File already exists.");

        // Escrevendo o retorno da requisição no arquivo answer.json
        FileWriter writer = new FileWriter(answer);
        writer.write(response.body());
        writer.close();
    }
}