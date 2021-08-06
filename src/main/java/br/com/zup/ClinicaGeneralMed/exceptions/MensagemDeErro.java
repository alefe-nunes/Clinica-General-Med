package br.com.zup.ClinicaGeneralMed.exceptions;

import java.util.List;

public class MensagemDeErro {

    private int satatusCode;
    private List<Erro> erros;

    public MensagemDeErro(int satatusCode, List<Erro> erros) {
        this.satatusCode = satatusCode;
        this.erros = erros;
    }

    public int getSatatusCode() {
        return satatusCode;
    }

    public void setSatatusCode(int satatusCode) {
        this.satatusCode = satatusCode;
    }

    public List<Erro> getErros() {
        return erros;
    }

    public void setErros(List<Erro> erros) {
        this.erros = erros;
    }
}
