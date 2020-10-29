package com.demo.sicredi.service;

import com.demo.sicredi.DAO.PautaDAO;
import com.demo.sicredi.domain.Pauta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by maiquelknechtel on 25/10/20.
 */
@Service
public class PautaService {

    @Autowired
    private PautaDAO pautaDAO;

    public void save(Pauta pauta) {
        pautaDAO.save(pauta);
    }

    public Pauta findById(Integer id) {
        return pautaDAO.findById(id).orElse(null);
    }

    public List<Pauta> findAll(){
        return (List<Pauta>) pautaDAO.findAll();
    }
}
