package br.gov.sp.fatec.springboot3topicos.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gov.sp.fatec.springboot3topicos.entity.Corpo;
import br.gov.sp.fatec.springboot3topicos.service.CorpoService;
@RestController
@RequestMapping(value = "/corpo")
@CrossOrigin
public class CorpoController {
    @Autowired
    private CorpoService corpoService;

    @GetMapping
    public List<Corpo> getAll(){
        return corpoService.getAll();
    }

    @PostMapping
    public Corpo insert(@RequestBody Corpo corpo){
        return corpoService.insert(corpo);
    }
    @GetMapping(value = "/{nome}/{distancia}")
    public List<Corpo> getByNomeDistancia(@PathVariable("nome")String nome, @PathVariable("distancia")Float distancia){
        return corpoService.getByNomeDistancia(nome, distancia);
    }
}
