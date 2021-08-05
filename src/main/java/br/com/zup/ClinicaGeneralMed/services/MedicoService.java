package br.com.zup.ClinicaGeneralMed.services;

import br.com.zup.ClinicaGeneralMed.dtos.MedicoDTO;
import br.com.zup.ClinicaGeneralMed.dtos.PacienteDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicoService {
    private List<MedicoDTO> medicos = new ArrayList<>();

    public MedicoDTO verificaMedico(MedicoDTO medico){
        for(MedicoDTO item : medicos){
            if(item.getCRM().equals(medico.getCRM())){
                throw new RuntimeException("Médico já existe!");
            }
        }

        return medico;
    }

    public MedicoDTO validaMedico(MedicoDTO medico){
        for(MedicoDTO item : medicos){
            if(item.getCRM().equals(medico.getCRM())){
                return item;
            }
        }
        throw new RuntimeException("Médico não cadastrado!");
    }

    public MedicoDTO cadastrar(MedicoDTO medico){
        this.medicos.add(verificaMedico(medico));

        return medico;
    }

    public List<MedicoDTO> exibir(){
        return this.medicos;
    }

}
