package br.sp.gov.fatec.springbootproject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sp.gov.fatec.springbootproject.entity.Autorizacao;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long>{

    public List<Autorizacao> findByUsuariosNome(String nome);

    public Autorizacao findByNome(String nome);
    
}