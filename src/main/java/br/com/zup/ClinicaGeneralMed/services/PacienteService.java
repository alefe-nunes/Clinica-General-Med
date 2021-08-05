package br.com.zup.ClinicaGeneralMed.services;

import br.com.zup.ClinicaGeneralMed.dtos.PacienteDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {

    private List<PacienteDTO> pacientes = new ArrayList<>();

    public PacienteDTO verificarDuplicidade(PacienteDTO paciente){
        for(PacienteDTO item : pacientes){
            if(item.getCpf().equals(paciente.getCpf())){
                throw new RuntimeException("Paciente já existe!");
            }
        }

        return paciente;
    }

    public PacienteDTO validaPaciente(PacienteDTO paciente){
        for(PacienteDTO item : pacientes){
            if(item.getCpf().equals(paciente.getCpf())){
                return item;
            }
        }
        throw new RuntimeException("Paciente não cadastrado!");
    }

    public PacienteDTO cadastrar(PacienteDTO paciente){
        this.pacientes.add(verificarDuplicidade(paciente));

        return paciente;
    }

    public List<PacienteDTO> exibir(){
        return this.pacientes;
    }

}
