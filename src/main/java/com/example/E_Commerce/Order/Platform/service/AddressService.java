package com.example.E_Commerce.Order.Platform.service;


import com.example.E_Commerce.Order.Platform.entities.Address;
import com.example.E_Commerce.Order.Platform.repositories.AddressRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.nio.file.Files.find;
import static java.util.Collections.copy;

@Service
@RequiredArgsConstructor
@Transactional
public class AddressService implements CrudService<AddressDTO> {

    private final AddressRepository repo;

    public AddressDTO create(AddressDTO d) {

        Address e = new Address();

        copy(d, e);

        e.setIsActive(true);

        return AddressDTO.convertToDTO(repo.save(e));
    }


    public List<AddressDTO> getAll() {

        return AddressDTO.convertToDTO(
                repo.findAllByIsActiveTrue()
        );
    }


    public AddressDTO getById(Long id) {

        return AddressDTO.convertToDTO(
                find(id)
        );
    }


    public AddressDTO update(Long id, AddressDTO d) {

        Address e = find(id);

        copy(d, e);

        return AddressDTO.convertToDTO(
                repo.save(e)
        );
    }
}