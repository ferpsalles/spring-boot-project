package br.sp.gov.fatec.springbootproject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import br.sp.gov.fatec.springbootproject.entity.Manutencao;


public interface ManutencaoRepository extends JpaRepository<Manutencao,Long>{

   public List<Manutencao> findByAviaoModelo(String modelo);



}
