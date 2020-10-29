package com.demo.sicredi.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
/**
 * Created by maiquelknechtel on 25/10/20.
 */
@Entity(name = "associado")
public class Associado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    @OneToMany()
    private List<Voto> listVoto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Voto> getListVoto() {
        return listVoto;
    }

    public void setListVoto(List<Voto> listVoto) {
        this.listVoto = listVoto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
