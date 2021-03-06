package br.sp.gov.fatec.springbootproject.service;
import org.springframework.security.core.userdetails.UserDetailsService;

import br.sp.gov.fatec.springbootproject.entity.Aviao;
import br.sp.gov.fatec.springbootproject.entity.Usuario;
import java.util.List;

public interface SegurancaService extends UserDetailsService {

    public Aviao novoAviao (String modelo, String prefixo, String propulsao, String categoria, String descricao, String codigo);

    public List<Aviao> buscarTodosAvioes();

    public Usuario novoUsuario(String nome, String email, String senha, String autorizacao);

    public List<Usuario> buscarTodosUsuarios();
}