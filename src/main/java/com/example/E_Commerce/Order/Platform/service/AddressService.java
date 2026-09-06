package com.example.E_Commerce.Order.Platform.service;

import com.example.E_Commerce.Order.Platform.dto.AddressDTO;
import com.example.E_Commerce.Order.Platform.entities.Address;
import com.example.E_Commerce.Order.Platform.repositories.AddressRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AddressService implements CrudService<AddressDTO> {

    private final AddressRepository repo;


    public AddressDTO create(AddressDTO d) {

        Address e = new Address();

        copy(d, e);

        e.setIsActive(true);

        return AddressDTO.convertToDTO(
                repo.save(e)
        );
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


    public void delete(Long id) {

        Address e = find(id);

        e.setIsActive(false);

        repo.save(e);
    }


    Address find(Long id) {

        return EntityHelper.active(
                repo,
                id,
                "Address"
        );
    }


    private void copy(AddressDTO d, Address e) {

        e.setStreet(d.getStreet());

        e.setCity(d.getCity());

        e.setPostalCode(d.getPostalCode());

        e.setType(d.getType());
    }
}