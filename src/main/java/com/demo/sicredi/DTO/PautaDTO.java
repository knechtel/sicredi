package com.demo.sicredi.DTO;

import com.demo.sicredi.domain.Pauta;
/**
 * Created by maiquelknechtel on 25/10/20.
 */
public class PautaDTO {

    private Integer id;
    private String texto ;
    private Integer second = 60;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public Pauta build(PautaDTO pautaDTO){
        Pauta p = new Pauta();
        p.setTexto(pautaDTO.getTexto());
        p.setSecond(pautaDTO.getSecond());
        return p;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
