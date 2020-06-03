package br.com.codenation.criptografia.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.FileSystems;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;

import javax.swing.KeyStroke;

import com.google.gson.Gson;

import org.springframework.stereotype.Service;

import br.com.codenation.criptografia.model.Answer;

/**
 * CriptografiaService
 */
@Service
public class CriptografiaService {

    private static final String url = "https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=";
    private static final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10)).build();

    private static final int akc = KeyStroke.getKeyStroke('a', 0).getKeyCode();
    private static final int zkc = KeyStroke.getKeyStroke('z', 0).getKeyCode();

    private static final Gson gson = new Gson();

    public void realizarDesafio(String token) throws IOException, InterruptedException {

        // Requisição para a Codenation
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url + token)).GET().build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        Answer data = gson.fromJson(response.body(), Answer.class);

        StringBuilder decifrado = new StringBuilder();

        for (int i = 0; i < data.getCifrado().length(); i++) {
            KeyStroke t = KeyStroke.getKeyStroke(data.getCifrado().charAt(i), 0);

            int kc = t.getKeyCode();

            if (kc >= akc && kc <= zkc) {
                int temp = kc - data.getNumeroCasas();
                kc = temp < akc ? zkc - (akc - (temp + 1)) : temp;
            }

            decifrado.append((char) kc);
        }

        data.setDecifrado(decifrado.toString());
        data.setResumoCriptografico(criptografando(data.getDecifrado()));

        String answer = gson.toJson(data);

        criarArquivo(answer);
    }

    public void criarArquivo(String conteudo) throws IOException {
        // Criando o arquivo
        File answer = new File(
                FileSystems.getDefault().getPath("src/main/resources").toAbsolutePath().toString() + "/answer.json");

        if (answer.createNewFile())
            System.out.println("File is created!");
        else
            System.out.println("File already exists.");

        // Escrevendo o retorno da requisição no arquivo answer.json
        FileWriter writer = new FileWriter(answer);
        writer.write(conteudo);
        writer.close();
    }

    public static String criptografando(String entrada) 
    { 
        try { 
            MessageDigest md = MessageDigest.getInstance("SHA-1"); 

            byte[] messageDigest = md.digest(entrada.getBytes()); 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            
            String hashtext = no.toString(16); 

            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            
            return hashtext; 
        } 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    }
}