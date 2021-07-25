package com.ericazevedo.bookstoremanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ericazevedo.bookstoremanager.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
