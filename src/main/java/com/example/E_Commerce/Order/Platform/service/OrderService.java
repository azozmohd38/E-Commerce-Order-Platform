package com.example.E_Commerce.Order.Platform.service;

import com.example.E_Commerce.Order.Platform.entities.Order;
import com.example.E_Commerce.Order.Platform.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.nio.file.Files.find;
import static java.util.Collections.copy;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService implements CrudService<OrderDTO> {

    private final OrderRepository repo;

    public OrderDTO create(OrderDTO d) {

        Order e = new Order();

        copy(d, e);

        e.setIsActive(true);

        return OrderDTO.convertToDTO(
                repo.save(e)
        );
    }


    public List<OrderDTO> getAll() {

        return OrderDTO.convertToDTO(
                repo.findAllByIsActiveTrue()
        );
    }


    public OrderDTO getById(Long id) {

        return OrderDTO.convertToDTO(
                find(id)
        );
    }


    public OrderDTO update(Long id, OrderDTO d) {

        Order e = find(id);

        copy(d, e);

        return OrderDTO.convertToDTO(
                repo.save(e)
        );
    }
    public void delete(Long id) {

        Order e = find(id);

        e.setIsActive(false);

        repo.save(e);
    }



}