package br.com.zup.ClinicaGeneralMed.services;

import br.com.zup.ClinicaGeneralMed.dtos.ConsultaDTO;
import br.com.zup.ClinicaGeneralMed.dtos.MedicoDTO;
import br.com.zup.ClinicaGeneralMed.dtos.PacienteDTO;
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

    public ConsultaDTO verificaConsulta(ConsultaDTO consulta) {
        for (ConsultaDTO item : consultas) {
            if (item.getDate().equals(consulta.getDate()) && item.getPacienteDTO().equals(consulta.getPacienteDTO())) {
                throw new RuntimeException("Consulta não pode ser marcada nessa data");
            }
        }
        return consulta;

    }


    public ConsultaDTO cadastrarConsulta(ConsultaDTO consulta) {
        MedicoDTO medico = medicoService.validaMedico(consulta.getMedicoDTO());
        PacienteDTO paciente = pacienteService.validaPaciente(consulta.getPacienteDTO());
        consulta.setMedicoDTO(medico);
        consulta.setPacienteDTO(paciente);
        verificaConsulta(consulta);
        this.consultas.add(consulta);
        medico.getPacientes().add(paciente);

        return consulta;
    }

    public List <ConsultaDTO> exibirConsulta () {
        return this.consultas;
    }

}
