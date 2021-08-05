package br.com.zup.ClinicaGeneralMed.services;

import br.com.zup.ClinicaGeneralMed.dtos.ConsultaDTO;
import br.com.zup.ClinicaGeneralMed.dtos.ExameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ExameService {
    @Autowired
    private ConsultaService consultaService;
    private List<ExameDTO> exames = new ArrayList<>();

    public ConsultaDTO verificaExame(ExameDTO exame) {
        for (ConsultaDTO item : consultaService.exibirConsulta()) {
            if (item.getPedidoExame()) {
                return item;
            }
        }
        throw new RuntimeException("Exame não aprovado!");
    }

    public ExameDTO cadastrarExame(ExameDTO exame) {
        ConsultaDTO consulta =  verificaExame(exame);
        exame.setMedicoDTO(consulta.getMedicoDTO());
        exame.setPacienteDTO(consulta.getPacienteDTO());
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

}

