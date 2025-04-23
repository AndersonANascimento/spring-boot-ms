package br.com.prodam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prodam.model.Book;

public interface BookRepopsitory extends JpaRepository<Book, Long> {

}
