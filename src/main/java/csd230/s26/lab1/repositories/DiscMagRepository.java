package csd230.s26.lab1.repositories;

import csd230.s26.lab1.entities.DiscMagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscMagRepository extends JpaRepository<DiscMagEntity, Long> {
}