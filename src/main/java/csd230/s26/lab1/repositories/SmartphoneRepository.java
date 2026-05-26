package csd230.s26.lab1.repositories;

import csd230.s26.lab1.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SmartphoneRepository extends JpaRepository<ProductEntity, Long> {
}