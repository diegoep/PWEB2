package br.edu.ifpb.uploadservice.repository;

import br.edu.ifpb.uploadservice.domain.Arquivo;
import br.edu.ifpb.uploadservice.domain.RegistroArquivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static br.edu.ifpb.uploadservice.domain.RegistroArquivo.*;

public interface RegistroArquivoRepository extends JpaRepository<RegistroArquivo, Long> {
    public List<RegistroArquivo> findAllByStatus(@Param("status") EnvioArquivoStatus status);
}
