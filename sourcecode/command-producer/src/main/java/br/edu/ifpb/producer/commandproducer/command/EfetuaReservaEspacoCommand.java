package br.edu.ifpb.producer.commandproducer.command;

import io.eventuate.tram.commands.common.Command;

public class EfetuaReservaEspacoCommand implements Command {

    public EfetuaReservaEspacoCommand() {
    }

    public EfetuaReservaEspacoCommand(Long conteudoId, Long tamanhoArquivo) {
        this.conteudoId = conteudoId;
        this.tamanhoArquivo = tamanhoArquivo;
    }

    private Long conteudoId;

    private Long tamanhoArquivo;

    private String codigoReserva;

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

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
