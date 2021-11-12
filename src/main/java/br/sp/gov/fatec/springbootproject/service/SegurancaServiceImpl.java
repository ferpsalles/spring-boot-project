package br.sp.gov.fatec.springbootproject.service;

import br.sp.gov.fatec.springbootproject.Repository.AviaoRepository;
import br.sp.gov.fatec.springbootproject.Repository.PecaRepository;
import br.sp.gov.fatec.springbootproject.Repository.UsuarioRepository;
import br.sp.gov.fatec.springbootproject.Repository.AutorizacaoRepository;
import br.sp.gov.fatec.springbootproject.entity.Autorizacao;
import br.sp.gov.fatec.springbootproject.entity.Aviao;
import br.sp.gov.fatec.springbootproject.entity.Peca;
import br.sp.gov.fatec.springbootproject.entity.Usuario;
import br.sp.gov.fatec.springbootproject.service.SegurancaService;
import java.util.stream.Collectors;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    @Autowired
    UsuarioRepository usuarioRepo;

    @Autowired
    AutorizacaoRepository autorizacaoRepo;

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

    @Override
    @Transactional
    public Usuario novoUsuario(String nome, String email, String senha, String autorizacao) {
        
        Autorizacao aut = autorizacaoRepo.findByNome(autorizacao);
        if(aut == null) {
            aut = new Autorizacao();
            aut.setNome(autorizacao);
            autorizacaoRepo.save(aut);
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setAutorizacoes(new HashSet<Autorizacao>());
        usuario.getAutorizacoes().add(aut);
        usuarioRepo.save(usuario);

        return usuario;
    }

    @Override
    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Usuario usuario = usuarioRepo.findByNome(username);
    if (usuario == null) {
      throw new UsernameNotFoundException("Usuário " + username + " não encontrado!");
    }
    return User.builder().username(username).password(usuario.getSenha())
        .authorities(usuario.getAutorizacoes().stream()
            .map(Autorizacao::getNome).collect(Collectors.toList())
            .toArray(new String[usuario.getAutorizacoes().size()]))
        .build();
  }
    
}