package com.efacture.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efacture.dev.model.Agence;

public interface AgenceRespository extends JpaRepository<Agence, Long> {

}
