package br.edu.ifpb.producer.commandproducer.command;

import io.eventuate.tram.commands.common.Command;

public class EfetuaReservaEspacoCommand implements Command {

    public EfetuaReservaEspacoCommand(Long conteudoId, Long tamanhoArquivo) {
        this.conteudoId = conteudoId;
        this.tamanhoArquivo = tamanhoArquivo;
    }

    private Long conteudoId;

    private Long tamanhoArquivo;

    public Long getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    public void setTamanhoArquivo(Long tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }

    public Long getConteudoId() {
        return conteudoId;
    }

    public void setConteudoId(Long conteudoId) {
        this.conteudoId = conteudoId;
    }
}
