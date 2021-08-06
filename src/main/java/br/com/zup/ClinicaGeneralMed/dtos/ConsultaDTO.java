package br.com.zup.ClinicaGeneralMed.dtos;

import java.time.LocalDateTime;

public class ConsultaDTO {

    private String codConsulta;
    private PacienteDTO paciente;
    private MedicoDTO medico;
    private LocalDateTime date;
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
        return paciente;
    }

    public void setPacienteDTO(PacienteDTO pacienteDTO) {
        this.paciente = pacienteDTO;
    }

    public MedicoDTO getMedicoDTO() {
        return medico;
    }

    public void setMedicoDTO(MedicoDTO medicoDTO) {
        this.medico = medicoDTO;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Boolean getPedidoExame() {
        return pedidoExame;
    }

    public void setPedidoExame(Boolean pedidoExame) {
        this.pedidoExame = pedidoExame;
    }
}




