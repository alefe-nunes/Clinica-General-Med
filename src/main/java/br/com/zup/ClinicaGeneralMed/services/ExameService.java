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

    public void verificaExame(ExameDTO exame){
        for(ConsultaDTO item : consultaService.exibirConsulta()){
            if(!item.getPedidoExame()){
                throw new RuntimeException("Exame não aprovado!");
            }
        }
    }

    public ExameDTO cadastrar(ExameDTO exame){
        verificaExame(exame);
        this.exames.add(exame);
    }

}
