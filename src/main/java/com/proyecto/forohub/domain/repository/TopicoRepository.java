package com.proyecto.forohub.domain.repository;

import com.proyecto.forohub.domain.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    boolean existsByTitleIgnoreCase(String title);
    boolean existsByMessageIgnoreCase(String message);
    Page<Topico> findByActiveTrue(Pageable paged);
}