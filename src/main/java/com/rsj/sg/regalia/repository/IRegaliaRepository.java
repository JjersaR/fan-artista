package com.rsj.sg.regalia.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rsj.sg.regalia.entity.Regalia;

@Repository
public interface IRegaliaRepository extends JpaRepository<Regalia, UUID> {

}
