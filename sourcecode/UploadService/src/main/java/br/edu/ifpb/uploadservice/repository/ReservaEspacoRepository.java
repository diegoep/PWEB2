package br.edu.ifpb.uploadservice.repository;

import br.edu.ifpb.uploadservice.domain.RegistroArquivo;
import br.edu.ifpb.uploadservice.domain.ReservaEspaco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaEspacoRepository extends JpaRepository<ReservaEspaco, String> {

}
