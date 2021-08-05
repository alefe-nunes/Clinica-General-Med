package br.com.zup.ClinicaGeneralMed.controllers;

import br.com.zup.ClinicaGeneralMed.dtos.MedicoDTO;
import br.com.zup.ClinicaGeneralMed.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public MedicoDTO cadastrarMedico(@RequestBody MedicoDTO medico){
        return medicoService.cadastrar(medico);
    }

    @GetMapping
    public List<MedicoDTO> exibir(){
        return medicoService.exibir();
    }

}
