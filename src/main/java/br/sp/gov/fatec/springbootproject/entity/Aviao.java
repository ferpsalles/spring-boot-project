package br.sp.gov.fatec.springbootproject.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.sp.gov.fatec.springbootproject.controller.View;

@Entity
@Table(name ="avi_aviao")
public class Aviao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name ="avi_id")
    @JsonView(View.AviaoCompleto.class)
    private long id;


    @Column (name ="avi_modelo")
    @JsonView(View.AviaoSimplificado.class)
    private String modelo;


    @Column (name ="avi_prefixo")
    @JsonView(View.AviaoSimplificado.class)
    private String prefixo;


    @Column (name ="avi_propulsao")
    @JsonView(View.AviaoCompleto.class)
    private String propulsao;

    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name ="ape_aviao_peca",
        joinColumns = { @JoinColumn(name="avi_id")},
        inverseJoinColumns = {@JoinColumn(name="pec_id")})
    @JsonView(View.AviaoSimplificado.class)
    private Set<Peca> pecas;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="aviao")
    private Set<Manutencao> manutencao;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getPrefixo() {
        return prefixo;
    }
    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }
    public String getPropulsao() {
        return propulsao;
    }
    public void setPropulsao(String propulsao) {
        this.propulsao = propulsao;
    }
    
    public Set<Peca> getPeca() {
        return pecas;
    }

    public void setPeca(Set<Peca> pecas) {
        this.pecas = pecas;
    }
    public void setManutencao(HashSet<Manutencao> hashSet) {
    }
    public HashSet<Manutencao> getManutencao() {
        return null;
    }
    

}
