package br.sp.gov.fatec.springbootproject.service;

import br.sp.gov.fatec.springbootproject.entity.Aviao;
import java.util.List;

public interface SegurancaService {

    public Aviao novoAviao (String modelo, String prefixo, String propulsao, String categoria, String descricao, String codigo);

    public List<Aviao> buscarTodosAvioes();
}