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
    public ExameDTO cadastrarExame(@RequestBody ExameDTO exame) {
        return exameService.cadastrarExame(exame);
    }

    @GetMapping
    public List<ExameDTO> exibirExames() {
        return exameService.exibirExames();

    }

    @PutMapping("/remarcar/{codigo}")
    public ExameDTO remarcarExame(@PathVariable String codigo, @RequestBody ExameDTO exame) {
        return exameService.remarcarExame(codigo, exame);
    }

    @DeleteMapping("/remover/{codigo}")
    public List<ExameDTO> deletarExame(@PathVariable String codigo) {
        return exameService.deletarExame(codigo);
    }

}
