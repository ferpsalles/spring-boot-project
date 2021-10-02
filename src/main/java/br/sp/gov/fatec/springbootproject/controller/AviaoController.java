package br.sp.gov.fatec.springbootproject.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import br.sp.gov.fatec.springbootproject.service.SegurancaService;
import org.springframework.beans.factory.annotation.Autowired;
import br.sp.gov.fatec.springbootproject.entity.Aviao;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value ="/aviao")
public class AviaoController {

    @Autowired
    private SegurancaService segurancaService;

    @GetMapping
    public List <Aviao> buscarTodosAvioes (){
        return segurancaService.buscarTodosAvioes();
    }

    @PostMapping
    public Aviao novoAviao (@RequestBody Aviao aviao){
        return segurancaService.novoAviao(aviao.getModelo(), aviao.getPrefixo(), aviao.getPropulsao(), "Categoria", "Descrição", "Código");

    }

}