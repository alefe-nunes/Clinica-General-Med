package br.com.zup.ClinicaGeneralMed.controllers;

import br.com.zup.ClinicaGeneralMed.dtos.ExameDTO;
import br.com.zup.ClinicaGeneralMed.services.ExameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exame")
public class ExameController {

    @Autowired
    private ExameService exameService;

    @PostMapping
    public ExameDTO cadastrarExame(@RequestBody ExameDTO exameDTO) {
        return exameService.cadastrarExame(exameDTO);
    }

    @GetMapping
    public List<ExameDTO> exibirExames() {
        return exameService.exibirExames();

    }

    @DeleteMapping("/{codigo}")
    public List<ExameDTO> deletarExame(@PathVariable String codigo){
        return exameService.deletarExame(codigo);
    }

}
