package com.example.E_Commerce.Order.Platform.service;

import com.example.E_Commerce.Order.Platform.dto.CustomerDTO;
import com.example.E_Commerce.Order.Platform.entities.Customer;
import com.example.E_Commerce.Order.Platform.repositories.CustomerRepository;
import com.example.E_Commerce.Order.Platform.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService implements CrudService<CustomerDTO> {

    private final CustomerRepository repo;

    private final OrderRepository orderRepository;


    public CustomerDTO create(CustomerDTO d) {

        Customer e = new Customer();

        copy(d, e);

        e.setIsActive(true);

        return CustomerDTO.convertToDTO(
                repo.save(e)
        );
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


    public CustomerDTO update(Long id, CustomerDTO d) {

        Customer e = find(id);

        copy(d, e);

        return CustomerDTO.convertToDTO(
                repo.save(e)
        );
    }


    public void delete(Long id) {

        Customer e = find(id);

        e.setIsActive(false);

        repo.save(e);
    }


    Customer find(Long id) {

        return EntityHelper.active(
                repo,
                id,
                "Customer"
        );
    }


    private void copy(CustomerDTO d, Customer e) {

        e.setName(d.getName());

        e.setEmail(d.getEmail());

        e.setPhoneNumber(d.getPhoneNumber());

        e.setGender(d.getGender());
    }


    public Double getTotalSpent(Long customerId) {

        find(customerId);

        return orderRepository.getTotalSpentByCustomer(customerId);
    }
}