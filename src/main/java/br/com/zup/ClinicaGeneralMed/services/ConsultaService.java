package br.com.zup.ClinicaGeneralMed.services;

import br.com.zup.ClinicaGeneralMed.dtos.ConsultaDTO;
import br.com.zup.ClinicaGeneralMed.dtos.MedicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private MedicoService medicoService;
    @Autowired
    private PacienteService pacienteService;
    private List<ConsultaDTO> consultas = new ArrayList<>();

    public MedicoDTO verificaConsulta(ConsultaDTO consulta){
        for(ConsultaDTO item : consultas){
            if(item.getDate().equals(consulta.getDate()) && item.getPacienteDTO().equals(consulta.getPacienteDTO())){
                throw new RuntimeException("Consulta não pode ser marcada nessa data");
            }
        }

        return consulta;
    }

    public ConsultaDTO cadastrar(ConsultaDTO consulta){
        medicoService.verificaMedico(consulta.getMedicoDTO());
        pacienteService.verificaPaciente(consulta.getPacienteDTO());
        verificaConsulta(consulta);
        this.consultas.add(consulta);

        return consulta;
    }

}
