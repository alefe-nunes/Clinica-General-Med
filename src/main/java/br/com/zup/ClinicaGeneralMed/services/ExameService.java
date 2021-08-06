package br.com.zup.ClinicaGeneralMed.services;

import br.com.zup.ClinicaGeneralMed.dtos.ConsultaDTO;
import br.com.zup.ClinicaGeneralMed.dtos.ExameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExameService {
    @Autowired
    private ConsultaService consultaService;
    private List<ExameDTO> exames = new ArrayList<>();

    public ConsultaDTO verificaPedidoExame(ExameDTO exame) {
        ConsultaDTO consulta = null;
        for (ConsultaDTO item : consultaService.exibirConsulta()) {
            if(item.getMedicoDTO().getCRM().equals(exame.getMedicoDTO().getCRM())) {
                consulta = item;
                if(consulta.getPedidoExame()){
                    return consulta;
                }
            }
        }
        throw new RuntimeException("Exame não aprovado!");
    }

    public ExameDTO verificarDuplicidade(ExameDTO exame) {
        for (ExameDTO item : exames) {
            if (item.getCodExame().equals(exame.getCodExame())) {
                throw new RuntimeException("Exame já marcado!");
            } else if(item.getDate().equals(exame.getDate()) && item.getMedicoDTO().getCRM().equals(exame.getMedicoDTO().getCRM())){
                throw new RuntimeException("Exame não pode ser marcado nessa data e/ou hora!");
            } else if(item.getDate().equals(exame.getDate()) && item.getPacienteDTO().getCpf().equals(exame.getPacienteDTO().getCpf())){
                throw new RuntimeException("Já há um exame marcado para esse paciente nesse horário!");
            }
        }
        validarExame(exame);
        return exame;

    }

    public ExameDTO validarExame(ExameDTO exame){
        LocalDateTime hoje = LocalDateTime.now();
        if(exame.getDate().isBefore(hoje)){
            throw new RuntimeException("Data inválida!");
        }
        return exame;
    }

    public ExameDTO cadastrarExame(ExameDTO exame) {
        ConsultaDTO consulta = verificaPedidoExame(exame);
        exame.setMedicoDTO(consulta.getMedicoDTO());
        exame.setPacienteDTO(consulta.getPacienteDTO());
        verificarDuplicidade(exame);
        this.exames.add(exame);

        return exame;
    }

    public List <ExameDTO> exibirExames () {
        return this.exames;

    }

    public List<ExameDTO> deletarExame(String codigo){
        if(exames.removeIf(exame -> exame.getCodExame().equals(codigo))){
            return this.exames;
        }
        throw new RuntimeException("Nenhum exame encontrado!");
    }

    public ExameDTO remarcarExame(String codigo, ExameDTO exame){
        for(ExameDTO item : exames){
            if(item.getCodExame().equals(codigo)){
                item.setDate(validarExame(exame).getDate());
                return item;
            }
        }
        throw new RuntimeException("Exame não encontrado!");
    }

}