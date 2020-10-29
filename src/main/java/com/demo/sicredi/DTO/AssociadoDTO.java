package com.demo.sicredi.DTO;

import com.demo.sicredi.domain.Associado;
/**
 * Created by maiquelknechtel on 25/10/20.
 */
public class AssociadoDTO {

    private Integer id;
    private String nome;
    private String cpf;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Associado build(){
        Associado a = new Associado();
        a.setCpf(cpf);
        a.setNome(nome);
        return a;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
