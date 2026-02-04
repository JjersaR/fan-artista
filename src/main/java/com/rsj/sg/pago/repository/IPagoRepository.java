package com.rsj.sg.pago.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rsj.sg.pago.entity.Pago;

@Repository
public interface IPagoRepository extends JpaRepository<Pago, UUID> {

}
