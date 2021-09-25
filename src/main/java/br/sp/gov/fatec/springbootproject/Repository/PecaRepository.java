package br.sp.gov.fatec.springbootproject.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import br.sp.gov.fatec.springbootproject.entity.Peca;



public interface PecaRepository  extends JpaRepository<Peca,Long>{

    public List<Peca> findByAvioesModelo(String modelo);

    public Peca findByCodigo (String codigo);
    
}
