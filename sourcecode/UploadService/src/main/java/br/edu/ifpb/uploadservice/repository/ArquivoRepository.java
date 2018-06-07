package br.edu.ifpb.uploadservice.repository;

import br.edu.ifpb.uploadservice.domain.Arquivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArquivoRepository extends JpaRepository<Arquivo, Long> {

}
