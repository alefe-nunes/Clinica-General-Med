package br.com.zup.ClinicaGeneralMed.dtos;

import br.com.zup.ClinicaGeneralMed.enums.Especialidades;

import java.util.List;

public class Medico extends Pessoa {

    private List<Paciente> pacientes;
    private String CRM;
    private Especialidades especialidades;
    public Medico() {

    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public Especialidades getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(Especialidades especialidades) {
        this.especialidades = especialidades;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
}


