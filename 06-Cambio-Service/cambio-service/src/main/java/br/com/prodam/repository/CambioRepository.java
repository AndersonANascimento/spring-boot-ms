package br.com.prodam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prodam.model.Cambio;

public interface CambioRepository extends JpaRepository<Cambio, Long> {

	Cambio findByFromAndTo(String from, String to);
}
