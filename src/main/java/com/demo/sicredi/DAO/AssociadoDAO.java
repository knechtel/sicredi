package com.demo.sicredi.DAO;




import com.demo.sicredi.domain.Associado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 * Created by maiquelknechtel on 25/10/20.
 */
@Repository
public interface AssociadoDAO extends CrudRepository<Associado, Integer> {


}
