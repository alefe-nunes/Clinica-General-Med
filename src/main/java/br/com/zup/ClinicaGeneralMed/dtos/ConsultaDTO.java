package br.com.zup.ClinicaGeneralMed.dtos;

import java.util.Date;

public class ConsultaDTO {

    private String codConsulta;
    private PacienteDTO pacienteDTO;
    private MedicoDTO medicoDTO;
    private Date date;
    private Boolean pedidoExame;

    public ConsultaDTO() {
    }

    public String getCodConsulta() {
        return codConsulta;
    }

    public void setCodConsulta(String codConsulta) {
        this.codConsulta = codConsulta;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getPedidoExame() {
        return pedidoExame;
    }

    public void setPedidoExame(Boolean pedidoExame) {
        this.pedidoExame = pedidoExame;
    }
}




