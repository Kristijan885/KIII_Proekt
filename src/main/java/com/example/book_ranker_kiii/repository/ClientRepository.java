package com.example.book_ranker_kiii.repository;

import com.example.book_ranker_kiii.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
