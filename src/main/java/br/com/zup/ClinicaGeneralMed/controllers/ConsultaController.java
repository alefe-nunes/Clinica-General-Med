package br.com.zup.ClinicaGeneralMed.controllers;

import br.com.zup.ClinicaGeneralMed.dtos.ConsultaDTO;
import br.com.zup.ClinicaGeneralMed.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ConsultaDTO cadastrarConsulta(@RequestBody ConsultaDTO consultaDTO) {
        return consultaService.cadastrarConsulta(consultaDTO);
    }

    @GetMapping
    public List<ConsultaDTO> exibirConsulta() {
        return consultaService.exibirConsulta();
    }

    @DeleteMapping("/remover/{codigo}")
    public List<ConsultaDTO> deletarConsulta(@PathVariable String codigo){
        return consultaService.deletarConsulta(codigo);
    }

    @PutMapping("/remarcar/{codigo}")
    public ConsultaDTO remarcarConsulta(@PathVariable String codigo, @RequestBody ConsultaDTO consulta){
        return consultaService.remarcarConsulta(codigo,consulta);
    }

}
