package br.com.zup.ClinicaGeneralMed.dtos;

import br.com.zup.ClinicaGeneralMed.enuns.Especialidade;

import java.util.ArrayList;
import java.util.List;

public class MedicoDTO {

    private String nome;
    private String crm;
    private Especialidade especialidade;
    private List<PacienteDTO> listaDePacientes = new ArrayList<>();

    public MedicoDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public List<PacienteDTO> getListaDePacientes() {
        return listaDePacientes;
    }

    public void setListaDePacientes(List<PacienteDTO> listaDePacientes) {
        this.listaDePacientes = listaDePacientes;
    }
}


