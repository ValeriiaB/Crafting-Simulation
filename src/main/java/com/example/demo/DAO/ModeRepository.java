package com.example.demo.DAO;


import com.example.demo.DataBase.Mode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Transactional
@Repository
public interface ModeRepository extends CrudRepository<Mode, Long>{

}
