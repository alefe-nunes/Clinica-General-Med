package br.com.zup.ClinicaGeneralMed.dtos;

import javax.validation.constraints.NotBlank;

public abstract class Pessoa {

    @NotBlank (message = "{validacao.nome}")
    private String nome;
    @NotBlank (message = "{validacao.cpf}")
    private String cpf;
    @NotBlank (message = "{validacao.endereco}")
    private  String endereco;
    private String telefone;

    public Pessoa() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}


