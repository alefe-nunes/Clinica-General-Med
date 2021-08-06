package br.com.zup.ClinicaGeneralMed.controllers;

import br.com.zup.ClinicaGeneralMed.dtos.PacienteDTO;
import br.com.zup.ClinicaGeneralMed.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public PacienteDTO paciente(@RequestBody PacienteDTO paciente) {
        return pacienteService.cadastrar(paciente);
    }

    @GetMapping
    public List<PacienteDTO> pacientes() {
        return pacienteService.exibir();
    }

}
