package com.example.E_Commerce.Order.Platform.service;


import com.example.E_Commerce.Order.Platform.repositories.AddressRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class AddressService implements CrudService<AddressDTO> {

    private final AddressRepository repo;


}