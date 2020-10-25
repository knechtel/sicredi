package com.demo.sicredi.controller;


import com.demo.sicredi.DTO.VotoDTO;
import com.demo.sicredi.DTO.VotoFormDTO;
import com.demo.sicredi.domain.Associado;
import com.demo.sicredi.domain.Pauta;
import com.demo.sicredi.domain.Voto;
import com.demo.sicredi.service.AssociadoService;
import com.demo.sicredi.service.PautaService;
import com.demo.sicredi.service.VotoService;
import com.demo.sicredi.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Created by maiquelknechtel on 25/10/20.
 */
@RestController
@RequestMapping("/api/voto")
public class VotoController {
    @Autowired
    private VotoService votoService;
    @Autowired
    private AssociadoService associadoService;
    @Autowired
    private PautaService pautaService;

    @RequestMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public VotoFormDTO save(@RequestBody VotoDTO votoDTO) {
        if (votoService.associadoVotou(votoDTO)) {
            return new VotoFormDTO("UNABLE_TO_VOTE!");
        } else {
            Associado associado = associadoService.findById(votoDTO.getIdAssociado());
            Pauta pauta = pautaService.findById(votoDTO.getIdPauta());
            List<Pauta> listPauta = Util.getListPauta();

            for (Pauta pmemory : listPauta) {
                if (pmemory.getId() == pauta.getId() && pmemory.isPossibleToVote() == true) {
                    Voto voto = new Voto();
                    voto.setVotoEnum(votoDTO.getVotoEnum());
                    voto.setAssociado(associado);
                    voto.setPauta(pauta);
                    votoService.save(voto);
                    return new VotoFormDTO("REGISTERED_VOTE!");
                }
            }
        }
        return new VotoFormDTO("UNABLE_TO_VOTE!");
    }
}
