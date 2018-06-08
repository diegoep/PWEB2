package br.edu.ifpb.uploadservice.service.erros;

public class FalhaAoEscreverArquivo extends Exception {
    public FalhaAoEscreverArquivo(String message) {
        super(message);
    }
}
