package br.edu.ifpb.producer.repository;

import br.edu.ifpb.producer.domain.Conteudo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConteudoRepository extends JpaRepository<Conteudo, Long> {

}
