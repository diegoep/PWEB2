package br.edu.ifpb.uploadservice.service.erros;

public class CaminhoInexistente extends Exception {
    public CaminhoInexistente(String message) {
        super(message);
    }
}
