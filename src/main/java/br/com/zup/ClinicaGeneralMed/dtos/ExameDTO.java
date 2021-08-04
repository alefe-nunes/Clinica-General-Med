package br.com.zup.ClinicaGeneralMed.dtos;

import br.com.zup.ClinicaGeneralMed.enuns.TipoDeExame;

import java.time.LocalDate;
import java.util.Date;

public class ExameDTO {

    private PacienteDTO pacienteDTO;
    private MedicoDTO medicoDTO;
    private TipoDeExame tipoDeExame;
    private Date date;

    public ExameDTO() {
    }

    public PacienteDTO getPacienteDTO() {
        return pacienteDTO;
    }

    public void setPacienteDTO(PacienteDTO pacienteDTO) {
        this.pacienteDTO = pacienteDTO;
    }

    public MedicoDTO getMedicoDTO() {
        return medicoDTO;
    }

    public void setMedicoDTO(MedicoDTO medicoDTO) {
        this.medicoDTO = medicoDTO;
    }

    public TipoDeExame getTipoDeExame() {
        return tipoDeExame;
    }

    public void setTipoDeExame(TipoDeExame tipoDeExame) {
        this.tipoDeExame = tipoDeExame;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}


