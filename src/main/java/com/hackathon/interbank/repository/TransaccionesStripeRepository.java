package com.hackathon.interbank.repository;


import com.hackathon.interbank.swagger.entity.TransaccionesStripe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionesStripeRepository extends JpaRepository<TransaccionesStripe, Long> {
}
