package com.example.book_ranker_kiii.service;

import com.example.book_ranker_kiii.model.Client;

import java.util.List;

public interface ClientService {

    public List<Client> listAll();

    public Client findById(Long id);
}
