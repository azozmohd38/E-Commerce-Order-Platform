package com.example.E_Commerce.Order.Platform.service;

import com.example.E_Commerce.Order.Platform.repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.nio.file.Files.find;
import static java.util.Collections.copy;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService implements CrudService<CustomerDTO> {

    private final CustomerRepository repo;

    public CustomerDTO create(CustomerDTO d) {

        Customer e = new Customer();

        copy(d, e);

        e.setIsActive(true);

        return CustomerDTO.convertToDTO(repo.save(e));
    }
    public List<CustomerDTO> getAll() {

        return CustomerDTO.convertToDTO(
                repo.findAllByIsActiveTrue()
        );
    }
    public CustomerDTO getById(Long id) {

        return CustomerDTO.convertToDTO(
                find(id)
        );
    }


}
