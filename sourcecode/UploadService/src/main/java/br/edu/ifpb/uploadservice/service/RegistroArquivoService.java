package br.edu.ifpb.uploadservice.service;

import br.edu.ifpb.uploadservice.domain.Arquivo;
import br.edu.ifpb.uploadservice.domain.RegistroArquivo;
import br.edu.ifpb.uploadservice.domain.RegistroArquivo.EnvioArquivoStatus;
import br.edu.ifpb.uploadservice.domain.ReservaEspaco;
import br.edu.ifpb.uploadservice.repository.ArquivoRepository;
import br.edu.ifpb.uploadservice.repository.RegistroArquivoRepository;
import br.edu.ifpb.uploadservice.repository.ReservaEspacoRepository;
import br.edu.ifpb.uploadservice.service.erros.CaminhoInexistente;
import br.edu.ifpb.uploadservice.service.erros.FalhaAoEscreverArquivo;
import br.edu.ifpb.uploadservice.service.erros.ReservaTokenInvalido;
import br.edu.ifpb.uploadservice.service.erros.StatusDeRegistroInvalido;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegistroArquivoService {
    private final RegistroArquivoRepository registroArquivoRepository;
    private final ReservaEspacoRepository reservaEspacoRepository;
    private final ArquivoRepository arquivoRepository;

    public RegistroArquivoService(RegistroArquivoRepository registroArquivoRepository, ReservaEspacoRepository reservaEspacoRepository, ArquivoRepository arquivoRepository) {
        this.registroArquivoRepository = registroArquivoRepository;
        this.reservaEspacoRepository = reservaEspacoRepository;
        this.arquivoRepository = arquivoRepository;
    }

    public List<RegistroArquivo> listarRegistros(){
        return registroArquivoRepository.findAll();
    }

    public List<RegistroArquivo> listarRegistrosPorStatus(String status) throws StatusDeRegistroInvalido {
        List<RegistroArquivo> registros = new ArrayList<>();
        if(status != null){
            try{
                EnvioArquivoStatus reservaStatus = EnvioArquivoStatus.valueOf(status);
                registros = registroArquivoRepository.findAllByStatus(reservaStatus);
            }catch(IllegalArgumentException e){
                throw new StatusDeRegistroInvalido("Status de registro inválido");
            }
        }else{
            registros = registroArquivoRepository.findAll();
        }

        return registros;
    }

    
    public RegistroArquivo efetuarUpload(String nome, String tokenReserva, Long tamanho, byte[] fatia) throws CaminhoInexistente, FalhaAoEscreverArquivo, ReservaTokenInvalido {
        ReservaEspaco reserva = reservaEspacoRepository.findFirstByCodigoReserva(tokenReserva).orElseThrow(()-> new ReservaTokenInvalido("Token inválido"));
        ZonedDateTime inicio = ZonedDateTime.now();
        String path = reserva.getLocalArmazenamento().getCaminho() + File.separator + nome;
        try(FileOutputStream out = new FileOutputStream(path)){
            out.write(fatia);
            out.flush();
        } catch (FileNotFoundException e) {
            throw new CaminhoInexistente("Caminho para salvar não foi encontrado");
        } catch (IOException e) {
            throw new FalhaAoEscreverArquivo(("Ocorreu um problema ao tentar salvar o arquivo"));
        }
        Arquivo arquivo = new Arquivo();
        arquivo.setNome(nome);
        arquivo.setFormato(FilenameUtils.getExtension(nome));
        arquivo.setTamanho(tamanho);
        arquivo.setLocalArmazenamento(reserva.getLocalArmazenamento());
        arquivoRepository.save(arquivo);

        RegistroArquivo registro = new RegistroArquivo();
        registro.setArquivo(arquivo);
        registro.setTotalFatiasEsperadas(1);
        registro.setFatiasEnviadas(1);
        registro.setProgresso(100);
        registro.setInicio(inicio);
        registro.setUltimaModificacao(ZonedDateTime.now());
        registro.setStatus(EnvioArquivoStatus.FINALIZADO);
        registro.setReservaEspaco(reserva);

        registroArquivoRepository.save(registro);

        return registro;
    }
}
