package com.demo.sicredi.DTO;


import com.demo.sicredi.domain.VotoEnum;
/**
 * Created by maiquelknechtel on 25/10/20.
 */
public class VotoDTO {
    private VotoEnum votoEnum;
    private Integer idPauta;
    private Integer idAssociado;

    public VotoEnum getVotoEnum() {
        return votoEnum;
    }

    public void setVotoEnum(VotoEnum votoEnum) {
        this.votoEnum = votoEnum;
    }

    public Integer getIdPauta() {
        return idPauta;
    }

    public void setIdPauta(Integer idPauta) {
        this.idPauta = idPauta;
    }

    public Integer getIdAssociado() {
        return idAssociado;
    }

    public void setIdAssociado(Integer idAssociado) {
        this.idAssociado = idAssociado;
    }


}
