package br.edu.ifpb.uploadservice.service;

import br.edu.ifpb.uploadservice.domain.Arquivo;
import br.edu.ifpb.uploadservice.repository.ArquivoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArquivoServico{

    private final ArquivoRepository arquivoRepository;

    public ArquivoServico(ArquivoRepository arquivoRepository) {
        this.arquivoRepository = arquivoRepository;
    }

    public List<Arquivo> listarArquivos(){
        return arquivoRepository.findAll();
    }

    public Arquivo salvarArquivo(Arquivo arquivo){
        return arquivoRepository.save(arquivo);
    }

    public void deletarArquivo(Long id){
        arquivoRepository.deleteById(id);
    }

}
