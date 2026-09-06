package com.example.E_Commerce.Order.Platform.service;

import com.example.E_Commerce.Order.Platform.entities.Shipment;
import com.example.E_Commerce.Order.Platform.repositories.ShipmentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.nio.file.Files.find;
import static java.util.Collections.copy;

@Service
@RequiredArgsConstructor
@Transactional
public class ShipmentService implements CrudService<ShipmentDTO> {
    private final ShipmentRepository repo;
    public ShipmentDTO create(ShipmentDTO d) {

        Shipment e = new Shipment();

        copy(d, e);

        e.setIsActive(true);

        return ShipmentDTO.convertToDTO(
                repo.save(e)
        );
    }


    public List<ShipmentDTO> getAll() {

        return ShipmentDTO.convertToDTO(
                repo.findAllByIsActiveTrue()
        );
    }


    public ShipmentDTO getById(Long id) {

        return ShipmentDTO.convertToDTO(
                find(id)
        );
    }


    public ShipmentDTO update(Long id, ShipmentDTO d) {

        Shipment e = find(id);

        copy(d, e);

        return ShipmentDTO.convertToDTO(
                repo.save(e)
        );
    }

}
