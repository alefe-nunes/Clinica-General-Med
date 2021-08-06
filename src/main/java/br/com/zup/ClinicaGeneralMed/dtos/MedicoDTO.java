package br.com.zup.ClinicaGeneralMed.dtos;

import br.com.zup.ClinicaGeneralMed.enuns.Especialidade;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class MedicoDTO extends Pessoa {

    private List<PacienteDTO> pacientes = new ArrayList<>();
    @NotBlank (message = "{validacao.crm}")
    private String CRM;
    @NotNull (message = "{validacao.especilidade}")
    private Especialidade especialidade;

    public MedicoDTO() {

    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public List<PacienteDTO> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<PacienteDTO> pacientes) {
        this.pacientes = pacientes;
    }
}


