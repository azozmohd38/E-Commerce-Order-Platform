package com.example.E_Commerce.Order.Platform.service;

import com.example.E_Commerce.Order.Platform.dto.PaymentDTO;
import com.example.E_Commerce.Order.Platform.entities.Order;
import com.example.E_Commerce.Order.Platform.entities.Payment;
import com.example.E_Commerce.Order.Platform.entities.Shipment;
import com.example.E_Commerce.Order.Platform.repositories.OrderRepository;
import com.example.E_Commerce.Order.Platform.repositories.PaymentRepository;
import com.example.E_Commerce.Order.Platform.repositories.ShipmentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class PaymentService implements CrudService<PaymentDTO> {

    private final PaymentRepository repo;
    private final OrderRepository orderRepository;

    private final ShipmentRepository shipmentRepository;

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

    Payment find(Long id) {

        return EntityHelper.active(
                repo,
                id,
                "Payment"
        );
    }

    private void copy(PaymentDTO d, Payment e) {
        e.setAmount(d.getAmount());
        e.setMethod(d.getMethod());
        e.setStatus(d.getStatus());
        e.setPaidDate(d.getPaidDate());
    }

    public PaymentDTO payOrder(
            Long orderId,
            String method) {


        Order order = EntityHelper.active(
                orderRepository,
                orderId,
                "Order"
        );
        if (order.getPayment() != null &&
                Boolean.TRUE.equals(order.getPayment().getIsActive())) {

            throw new RuntimeException(
                    "Order is already paid"
            );


        }
        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setAmount(
                order.getTotalAmount()
        );

        payment.setMethod(method);
        payment.setStatus("PAID");
        payment.setPaidDate(new Date());
        payment.setIsActive(true);
        payment.setCreatedDate(new Date());

        payment = repo.save(payment);

        order.setPayment(payment);
        order.setStatus("PAID");
        order.setUpdatedDate(new Date());
        orderRepository.save(order);


        Shipment shipment = new Shipment();
        shipment.setOrder(order);
        shipment.setTrackingNumber(
                UUID.randomUUID().toString()
        );

        shipment.setStatus("CREATED");
        shipment.setIsActive(true);
        shipment.setCreatedDate(new Date());
        shipment = shipmentRepository.save(shipment);

        order.setShipment(shipment);
        orderRepository.save(order);

        return PaymentDTO.convertToDTO(payment);
    }
}







