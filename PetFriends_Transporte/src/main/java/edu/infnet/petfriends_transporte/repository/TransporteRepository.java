package edu.infnet.petfriends_transporte.repository;

import edu.infnet.petfriends_transporte.domain.Transporte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransporteRepository extends JpaRepository<Transporte, Long> {
}