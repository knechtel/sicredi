package com.demo.sicredi.service;

import com.demo.sicredi.DAO.AssociadoDAO;
import com.demo.sicredi.DTO.AssociadoDTO;
import com.demo.sicredi.domain.Associado;
import com.demo.sicredi.util.ApiCpf;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

@Service
public class AssociadoService {

    @Autowired
    private AssociadoDAO associadoDAO;

    private final static String CPF_VALIDO = "true";

    static Logger logger = LoggerFactory.getLogger(com.demo.sicredi.service.AssociadoService.class);

    public Associado save(Associado associado) {
        return associadoDAO.save(associado);
    }



    public boolean validaCPF(AssociadoDTO associadoDTO) {
        boolean retorno = false;
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://www.treinaweb.com.br/ferramentas-para-desenvolvedores/validar/")

                    .build();

            ApiCpf api = retrofit.create(ApiCpf.class);

            Response<ResponseBody> response = api.validaCPF(associadoDTO.getCpf()).execute();

            if (response.body().string().contains((CPF_VALIDO)))
                retorno = true;
            else
                retorno = false;
        } catch (IOException e) {
            logger.error("ERRO .",e);
        } finally {
            return retorno;
        }
    }


    public Associado findById(Integer id) {
        return associadoDAO.findById(id).orElse(null);
    }
}
