package br.com.zup.ClinicaGeneralMed.dtos;

import br.com.zup.ClinicaGeneralMed.enuns.TipoDeExame;
import java.time.LocalDateTime;

public class ExameDTO {

    private String codExame;
    private PacienteDTO pacienteDTO;
    private MedicoDTO medicoDTO;
    private TipoDeExame tipoDeExame;
    private LocalDateTime date;

    public ExameDTO() {
    }

    public String getCodExame() {
        return codExame;
    }

    public void setCodExame(String codExame) {
        this.codExame = codExame;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}


