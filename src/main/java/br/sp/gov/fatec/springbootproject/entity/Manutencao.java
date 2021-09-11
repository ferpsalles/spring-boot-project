package br.sp.gov.fatec.springbootproject.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="man_manutencao")
public class Manutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name ="man_id")
    private long id;

    @Column (name ="man_data")
    private Date data;

    @Column (name ="man_procedimento")
    private String procedimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "avi_id")
    private Aviao aviao;

      
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    
    
}
