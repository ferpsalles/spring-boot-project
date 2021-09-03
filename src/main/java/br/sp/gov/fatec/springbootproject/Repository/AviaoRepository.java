package br.sp.gov.fatec.springbootproject.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.sp.gov.fatec.springbootproject.entity.Aviao;

public interface AviaoRepository extends JpaRepository<Aviao,Long> {

    public Aviao findByPrefixo (String prefixo);

    public List<Aviao> findByModeloContainsOrPrefixoContains(String modelo, String prefixo);
    
}
