package com.demo.sicredi.domain;


import javax.persistence.*;
import java.io.Serializable;
/**
 * Created by maiquelknechtel on 25/10/20.
 */
@Entity(name = "voto")
public class Voto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private VotoEnum votoEnum;
    @ManyToOne()
    @JoinColumn(name = "id_pauta", foreignKey = @ForeignKey(name = "id_voto"))
    private Pauta pauta;
    @ManyToOne()
    @JoinColumn(name = "id_associado", foreignKey = @ForeignKey(name = "id"))
    private Associado associado;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public VotoEnum getVotoEnum() {
        return votoEnum;
    }

    public void setVotoEnum(VotoEnum votoEnum) {
        this.votoEnum = votoEnum;
    }

    public Pauta getPauta() {
        return pauta;
    }

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }

    public Associado getAssociado() {
        return associado;
    }

    public void setAssociado(Associado associado) {
        this.associado = associado;
    }
}
