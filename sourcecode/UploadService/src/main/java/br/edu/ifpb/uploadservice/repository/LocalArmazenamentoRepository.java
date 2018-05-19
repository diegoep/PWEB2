package br.edu.ifpb.uploadservice.repository;

import br.edu.ifpb.uploadservice.domain.LocalArmazenamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LocalArmazenamentoRepository extends JpaRepository<LocalArmazenamento, Long> {

    @Query("SELECT l FROM LocalArmazenamento l WHERE l.espacoDisponivel > :espacoMinimo")
    public Optional<LocalArmazenamento> findPrimeiroLocalArmazenamentoDisponivel(@Param("espacoMinimo") Long espacoMinimo);

}
