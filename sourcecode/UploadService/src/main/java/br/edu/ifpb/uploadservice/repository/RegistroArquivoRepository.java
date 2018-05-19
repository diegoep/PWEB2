package br.edu.ifpb.uploadservice.repository;

import br.edu.ifpb.uploadservice.domain.Arquivo;
import br.edu.ifpb.uploadservice.domain.RegistroArquivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroArquivoRepository extends JpaRepository<RegistroArquivo, Long> {

}
