package br.edu.ifpb.uploadservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "uploadservice")
public class UploadServiceConfig {

    private ReservaEspaco reservaEspaco;

    public static class ReservaEspaco {
        private Integer tempoExpiracaoEmMinutos = 15;

        public Integer getTempoExpiracaoEmMinutos() {
            return tempoExpiracaoEmMinutos;
        }

        public void setTempoExpiracaoEmMinutos(Integer tempoExpiracaoEmMinutos) {
            this.tempoExpiracaoEmMinutos = tempoExpiracaoEmMinutos;
        }
    }

    public ReservaEspaco getReservaEspaco() {
        return reservaEspaco;
    }

    public void setReservaEspaco(ReservaEspaco reservaEspaco) {
        this.reservaEspaco = reservaEspaco;
    }
}
