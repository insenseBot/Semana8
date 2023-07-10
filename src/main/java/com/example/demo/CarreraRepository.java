package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "carreras", path = "carreras")
public interface CarreraRepository extends CrudRepository<Carrera, Integer>, PagingAndSortingRepository<Carrera, Integer>{
    List <Carrera> findByNombre(@Param("nombre") String nombre);
}
