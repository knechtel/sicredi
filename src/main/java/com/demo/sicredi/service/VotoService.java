package com.demo.sicredi.service;

import com.demo.sicredi.DAO.VotoDAO;
import com.demo.sicredi.DTO.VotoDTO;
import com.demo.sicredi.domain.Pauta;
import com.demo.sicredi.domain.Voto;
import com.demo.sicredi.domain.VotoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Created by maiquelknechtel on 25/10/20.
 */
@Service
public class VotoService {

    @Autowired
    private VotoDAO votoDAO;


    public void finalizaVotacao(Pauta pauta){

        List<Voto> listVoto = votoDAO.findClosePauta(pauta.getId());
        Integer cntSim = 0, cntNao = 0;

        for (Voto v : listVoto) {
            if (v.getVotoEnum() == VotoEnum.NAO) {
                cntNao++;
            } else if (v.getVotoEnum() == VotoEnum.SIM) {
                cntSim++;
            }
        }
        System.out.println(pauta.getTexto());
        System.out.println("id = " + pauta.getId());
        System.out.println("votos SIM = " + cntSim);
        System.out.println("votos NAO = " + cntNao);
    }


    public boolean associadoVotou(VotoDTO votoDTO) {
        List<Voto> listVoto = votoDAO.findByIdAssociadoAndPauta(votoDTO.getIdAssociado(), votoDTO.getIdPauta());
        if (listVoto != null && listVoto.size() > 0) {
            return true;
        }
        return false;
    }

    public Voto save(Voto voto){
        return votoDAO.save(voto);
    }

}
