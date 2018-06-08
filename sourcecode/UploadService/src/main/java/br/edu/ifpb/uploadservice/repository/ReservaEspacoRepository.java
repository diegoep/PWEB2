package br.edu.ifpb.uploadservice.repository;

import br.edu.ifpb.uploadservice.domain.RegistroArquivo;
import br.edu.ifpb.uploadservice.domain.ReservaEspaco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReservaEspacoRepository extends JpaRepository<ReservaEspaco, String> {

    public List<ReservaEspaco> findAllByStatus(@Param("status") ReservaEspaco.ReservaEspacoStatus status);
    public Optional<ReservaEspaco> findFirstByCodigoReserva(@Param("codigo") String codigo);
}
