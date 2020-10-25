package com.demo.sicredi.service;

import com.demo.sicredi.DAO.VotoDAO;
import com.demo.sicredi.DTO.VotoDTO;
import com.demo.sicredi.domain.Voto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotoService {

    @Autowired
    private VotoDAO votoDAO;

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
