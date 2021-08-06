package br.com.zup.ClinicaGeneralMed.services;

import br.com.zup.ClinicaGeneralMed.dtos.ConsultaDTO;
import br.com.zup.ClinicaGeneralMed.dtos.MedicoDTO;
import br.com.zup.ClinicaGeneralMed.dtos.PacienteDTO;
import br.com.zup.ClinicaGeneralMed.exceptions.ErroGeralException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private MedicoService medicoService;
    @Autowired
    private PacienteService pacienteService;
    private List<ConsultaDTO> consultas = new ArrayList<>();

    public ConsultaDTO verificarDuplicidade(ConsultaDTO consulta) {
        for (ConsultaDTO item : consultas) {
            if (item.getCodConsulta().equals(consulta.getCodConsulta())) {
                throw new ErroGeralException("Consulta já marcada!");
            } else if (item.getDate().equals(consulta.getDate()) && item.getMedicoDTO().getCRM().equals(consulta.getMedicoDTO().getCRM())) {
                throw new ErroGeralException("Consulta não pode ser marcada nessa data e/ou hora!");
            } else if (item.getDate().equals(consulta.getDate()) && item.getPacienteDTO().getCpf().equals(consulta.getPacienteDTO().getCpf())) {
                throw new ErroGeralException("Já há uma consulta marcada para esse paciente nesse horário!");
            }
        }
        validarConsulta(consulta);
        return consulta;

    }

    public ConsultaDTO validarConsulta(ConsultaDTO consulta) {
        LocalDateTime hoje = LocalDateTime.now();
        if (consulta.getDate().isBefore(hoje)) {
            throw new ErroGeralException("Data inválida!");
        }
        return consulta;
    }

    public ConsultaDTO cadastrarConsulta(ConsultaDTO consulta) {
        MedicoDTO medico = medicoService.validaMedico(consulta.getMedicoDTO());
        PacienteDTO paciente = pacienteService.validaPaciente(consulta.getPacienteDTO());
        consulta.setMedicoDTO(medico);
        consulta.setPacienteDTO(paciente);
        verificarDuplicidade(consulta);
        this.consultas.add(consulta);
        medico.getPacientes().add(paciente);

        return consulta;
    }

    public List<ConsultaDTO> exibirConsulta() {
        return this.consultas;
    }

    public List<ConsultaDTO> deletarConsulta(String codigo) {
        ConsultaDTO consulta = null;
        PacienteDTO paciente = null;

        for (ConsultaDTO item : consultas) {
            if (item.getCodConsulta().equals(codigo)) {
                consulta = item;
                paciente = item.getPacienteDTO();
            }
        }

        if (consulta != null && paciente != null) {
            consulta.getMedicoDTO().getPacientes().remove(paciente);
        }

        if (this.consultas.removeIf(item -> item.getCodConsulta().equals(codigo))) {
            return this.consultas;
        }
        throw new ErroGeralException("Consulta não encontrada!");
    }

    public ConsultaDTO remarcarConsulta(String codigo, ConsultaDTO consulta) {
        for (ConsultaDTO item : consultas) {
            if (item.getCodConsulta().equals(codigo)) {
                item.setDate(validarConsulta(consulta).getDate());
                return item;
            }
        }
        throw new ErroGeralException("Nenhuma consulta encontrada!");
    }

}
