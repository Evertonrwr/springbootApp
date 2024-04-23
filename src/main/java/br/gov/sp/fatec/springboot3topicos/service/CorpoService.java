package br.gov.sp.fatec.springboot3topicos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3topicos.entity.Corpo;
import br.gov.sp.fatec.springboot3topicos.repository.CorpoRepository;

@Service
public class CorpoService {
    @Autowired
    private CorpoRepository corpoRepository;

    public List<Corpo> getAll(){
        return corpoRepository.findAll();
    }
    public Corpo insert(Corpo corpo){
        if(corpo.getNome() == null || corpo.getNome().isBlank()
            || corpo.getDistancia() == null || corpo.getDescricao() == null || corpo.getDescricao().isBlank()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
            }


        return corpoRepository.save(corpo);

    }
    public List<Corpo> getByNomeDistancia(String nome, Float distancia){
        return corpoRepository.getByDistanciaNome(nome, distancia);
    }
    
}
