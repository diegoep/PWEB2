package br.edu.ifpb.uploadservice.consumer.command;

import io.eventuate.Command;

public class EfetuaReservaEspacoCommand implements Command {

    private Long tamanhoArquivo;

    public Long getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    public void setTamanhoArquivo(Long tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }
}
