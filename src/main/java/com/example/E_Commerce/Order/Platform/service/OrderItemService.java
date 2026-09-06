package com.example.E_Commerce.Order.Platform.service;

import com.example.E_Commerce.Order.Platform.entities.OrderItem;
import com.example.E_Commerce.Order.Platform.repositories.OrderItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.nio.file.Files.find;
import static java.util.Collections.copy;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderItemService implements CrudService<OrderItemDTO> {

    private final OrderItemRepository repo;
    public OrderItemDTO create(OrderItemDTO d) {

        OrderItem e = new OrderItem();

        copy(d, e);

        e.setIsActive(true);

        return OrderItemDTO.convertToDTO(
                repo.save(e)
        );
    }


    public List<OrderItemDTO> getAll() {

        return OrderItemDTO.convertToDTO(
                repo.findAllByIsActiveTrue()
        );
    }


    public OrderItemDTO getById(Long id) {

        return OrderItemDTO.convertToDTO(
                find(id)
        );
    }


    public OrderItemDTO update(Long id, OrderItemDTO d) {

        OrderItem e = find(id);

        copy(d, e);

        return OrderItemDTO.convertToDTO(
                repo.save(e)
        );
    }

}