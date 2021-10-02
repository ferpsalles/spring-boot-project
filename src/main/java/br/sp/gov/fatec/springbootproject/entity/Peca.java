package br.sp.gov.fatec.springbootproject.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="pec_peca")
public class Peca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name ="pec_id")
    private Long id;

    @Column (name ="pec_descricao")
    private String descricao;

    @Column (name ="pec_codigo")
    private String codigo;

    @Column (name ="pec_categoria")
    private String categoria;

    @JsonIgnore
    @ManyToMany(fetch=FetchType.LAZY, mappedBy = "pecas")
    private Set<Aviao> avioes;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public Set<Aviao> getAvioes() {
        return avioes;
    }

    public void setAvioes(Set<Aviao> avioes) {
        this.avioes = avioes;
    }
}
