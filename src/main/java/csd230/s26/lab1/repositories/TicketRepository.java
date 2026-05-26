package csd230.s26.lab1.repositories;

import csd230.s26.lab1.entities.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
}