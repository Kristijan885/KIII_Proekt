package com.example.book_ranker_kiii.service.impl;

import com.example.book_ranker_kiii.model.Client;
import com.example.book_ranker_kiii.repository.ClientRepository;
import com.example.book_ranker_kiii.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public List<Client> listAll() {
        return this.clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return this.clientRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
