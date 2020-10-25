package com.demo.sicredi.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
/**
 * Created by maiquelknechtel on 25/10/20.
 */
@Entity(name = "pauta")
public class Pauta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String texto;
    private Integer second;
    private transient boolean possibleToVote = false;

    @OneToMany(mappedBy = "pauta")
    private List<Voto> listVoto;

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<Voto> getListVoto() {
        return listVoto;
    }

    public void setListVoto(List<Voto> listVoto) {
        this.listVoto = listVoto;
    }

    public boolean isPossibleToVote() {
        return possibleToVote;
    }

    public void setPossibleToVote(boolean possibleToVote) {
        this.possibleToVote = possibleToVote;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, texto, second, possibleToVote, listVoto);
    }
}
