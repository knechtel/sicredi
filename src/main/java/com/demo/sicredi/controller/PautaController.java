package com.demo.sicredi.controller;

import com.demo.sicredi.DTO.PautaDTO;
import com.demo.sicredi.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * Created by maiquelknechtel on 25/10/20.
 */
@RestController
@RequestMapping("/api/pauta")
public class PautaController {
    @Autowired
    private PautaService pautaService;

    @RequestMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public HttpEntity<?> save(@RequestBody PautaDTO pautaDTO) {
        pautaService.save(pautaDTO.build(pautaDTO));
        return ResponseEntity.ok().build();

    }


}
