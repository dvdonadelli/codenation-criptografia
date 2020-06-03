package br.com.codenation.criptografia.model;

import com.google.gson.annotations.SerializedName;

public class Answer {

    @SerializedName("numero_casas")
    private int numeroCasas;
    private String token;
    private String cifrado;
    private String decifrado;
    @SerializedName("resumo_criptografico")
    private String resumoCriptografico;

    /**
     * @return int return the numeroCasas
     */
    public int getNumeroCasas() {
        return numeroCasas;
    }

    /**
     * @param numeroCasas the numeroCasas to set
     */
    public void setNumeroCasas(int numeroCasas) {
        this.numeroCasas = numeroCasas;
    }

    /**
     * @return String return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return String return the cifrado
     */
    public String getCifrado() {
        return cifrado;
    }

    /**
     * @param cifrado the cifrado to set
     */
    public void setCifrado(String cifrado) {
        this.cifrado = cifrado;
    }

    /**
     * @return String return the decifrado
     */
    public String getDecifrado() {
        return decifrado;
    }

    /**
     * @param decifrado the decifrado to set
     */
    public void setDecifrado(String decifrado) {
        this.decifrado = decifrado;
    }

    /**
     * @return String return the resumoCriptografico
     */
    public String getResumoCriptografico() {
        return resumoCriptografico;
    }

    /**
     * @param resumoCriptografico the resumoCriptografico to set
     */
    public void setResumoCriptografico(String resumoCriptografico) {
        this.resumoCriptografico = resumoCriptografico;
    }

}