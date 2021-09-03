package br.sp.gov.fatec.springbootproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="avi_aviao")
public class Aviao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name ="avi_id")
    private long id;
    @Column (name ="avi_modelo")
    private String modelo;
    @Column (name ="avi_prefixo")
    private String prefixo;
    @Column (name ="avi_propulsao")
    private String propulsao;
    public long getId() {
        return id;
    }
    public void setId(long id) {
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
    
    
}
