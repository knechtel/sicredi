package com.demo.sicredi.controller;


import com.demo.sicredi.DTO.AssociadoDTO;
import com.demo.sicredi.DTO.UserDTO;
import com.demo.sicredi.domain.Associado;
import com.demo.sicredi.service.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by maiquelknechtel on 25/10/20.
 */
@RestController
@RequestMapping("/api/associado")
public class AssociadoController {
    @Autowired
    private AssociadoService associadoService;

    @RequestMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public UserDTO save(@RequestBody AssociadoDTO associadoDTO) {
        if (associadoService.validaCPF(associadoDTO)) {
            associadoService.save(associadoDTO.build());
            return new UserDTO("ABLE_TO_VOTE");
        } else {
            return new UserDTO("UNABLE_TO_VOTE");
        }

    }

    @RequestMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Iterable<Associado> getPauta(){
        return associadoService.findAll();
    }
}
