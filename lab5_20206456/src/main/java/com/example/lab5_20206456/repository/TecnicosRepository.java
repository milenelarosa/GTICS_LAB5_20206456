package com.example.lab5_20206456.repository;

import com.example.lab5_20206456.entity.Tecnicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicosRepository extends JpaRepository<Tecnicos, Integer> {

}
