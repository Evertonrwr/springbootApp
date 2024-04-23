package br.gov.sp.fatec.springboot3topicos.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springboot3topicos.entity.Corpo;

public interface CorpoRepository extends JpaRepository<Corpo, Long>{

    @Query("select c from Corpo c where c.nome like %?1% and c.distancia > ?2")
    public List<Corpo> getByDistanciaNome(String nome, Float distancia);
    
}
