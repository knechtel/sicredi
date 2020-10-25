package com.demo.sicredi.DAO;


import com.demo.sicredi.domain.Voto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maiquelknechtel on 25/10/20.
 */
@Repository
public interface VotoDAO extends CrudRepository<Voto, Integer> {

    @Query("Select vt from voto  vt where vt.associado.id = :idAssociado and vt.pauta.id = :idPauta")
    public List<Voto> findByIdAssociadoAndPauta(@Param("idAssociado") Integer idAssociado, @Param("idPauta") Integer idPauta );

    @Query("Select vt from voto  vt where  vt.pauta.id = :idPauta")
    public List<Voto> findClosePauta(@Param("idPauta") Integer idPauta);
}
