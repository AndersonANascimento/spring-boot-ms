package br.com.prodam.cambio_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prodam.cambio_service.model.Cambio;

public interface CambioRepository extends JpaRepository<Cambio, Long> {

	Cambio findByFromAndTo(String from, String to);
}
