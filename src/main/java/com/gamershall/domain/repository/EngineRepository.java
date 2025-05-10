package com.gamershall.domain.repository;

import com.gamershall.domain.model.Engine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EngineRepository extends JpaRepository<Engine, Long> {

    Optional<Engine> findByNome(String Nome);
}
