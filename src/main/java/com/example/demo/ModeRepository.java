package com.example.demo;


import org.springframework.data.repository.CrudRepository;
import javax.transaction.Transactional;


@Transactional
public interface ModeRepository extends CrudRepository<Mode, Long>{

}
