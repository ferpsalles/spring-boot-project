package br.sp.gov.fatec.springbootproject.service;

import br.sp.gov.fatec.springbootproject.Repository.AviaoRepository;
import br.sp.gov.fatec.springbootproject.Repository.PecaRepository;
import br.sp.gov.fatec.springbootproject.entity.Aviao;
import br.sp.gov.fatec.springbootproject.entity.Peca;

import java.util.List;
import java.util.HashSet;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SegurancaServiceImpl implements SegurancaService {

   

    @Autowired
    AviaoRepository aviaoRepo;

    @Autowired
    PecaRepository pecaRepo;

    @Transactional
    public Aviao novoAviao (String modelo, String prefixo, String propulsao, String categoria, String descricao, String codigo) {
        
        Peca peca = pecaRepo.findByCodigo(codigo);
        if (peca == null) {
            peca = new Peca();
		    peca.setCodigo(codigo);
            peca.setCategoria(categoria);
            peca.setDescricao(descricao);
		    pecaRepo.save(peca);
        }

        Aviao aviao  = new Aviao();
		aviao.setModelo(modelo);
        aviao.setPrefixo(prefixo);
        aviao.setPropulsao(propulsao);
		aviao.setPeca(new HashSet<Peca>());
        aviao.getPeca().add(peca);
        aviaoRepo.save(aviao);
        
        return aviao;

    }

    public List<Aviao> buscarTodosAvioes(){
      return aviaoRepo.findAll();

    }
    
}
