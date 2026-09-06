package com.example.E_Commerce.Order.Platform.service;

import com.example.E_Commerce.Order.Platform.entities.Payment;
import com.example.E_Commerce.Order.Platform.repositories.PaymentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.nio.file.Files.find;
import static java.util.Collections.copy;

@Service
@RequiredArgsConstructor
@Transactional
public class PaymentService implements CrudService<PaymentDTO> {

    private final PaymentRepository repo;
    public PaymentDTO create(PaymentDTO d) {

        Payment e = new Payment();

        copy(d, e);

        e.setIsActive(true);

        return PaymentDTO.convertToDTO(
                repo.save(e)
        );
    }


    public List<PaymentDTO> getAll() {

        return PaymentDTO.convertToDTO(
                repo.findAllByIsActiveTrue()
        );
    }


    public PaymentDTO getById(Long id) {

        return PaymentDTO.convertToDTO(
                find(id)
        );
    }


    public PaymentDTO update(Long id, PaymentDTO d) {

        Payment e = find(id);

        copy(d, e);

        return PaymentDTO.convertToDTO(
                repo.save(e)
        );
    }
    public void delete(Long id) {

        Payment e = find(id);

        e.setIsActive(false);

        repo.save(e);
    }




}

