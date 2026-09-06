package com.example.E_Commerce.Order.Platform.service;

import com.example.E_Commerce.Order.Platform.dto.OrderDTO;
import com.example.E_Commerce.Order.Platform.entities.*;
import com.example.E_Commerce.Order.Platform.repositories.CartItemRepository;
import com.example.E_Commerce.Order.Platform.repositories.CartRepository;
import com.example.E_Commerce.Order.Platform.repositories.OrderItemRepository;
import com.example.E_Commerce.Order.Platform.repositories.OrderRepository;
import com.example.E_Commerce.Order.Platform.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService implements CrudService<OrderDTO> {

    private final OrderRepository repo;

    private final CartRepository cartRepository;

    private final CartItemRepository cartItemRepository;

    private final OrderItemRepository orderItemRepository;

    private final ProductRepository productRepository;


    public OrderDTO create(OrderDTO d) {

        Order e = new Order();

        copy(d, e);

        e.setIsActive(true);

        e.setCreatedDate(new Date());

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

        e.setUpdatedDate(new Date());

        return OrderDTO.convertToDTO(
                repo.save(e)
        );
    }


    public void delete(Long id) {

        Order e = find(id);

        e.setIsActive(false);

        e.setUpdatedDate(new Date());

        repo.save(e);
    }


    Order find(Long id) {

        return EntityHelper.active(
                repo,
                id,
                "Order"
        );
    }


    private void copy(OrderDTO d, Order e) {

        e.setOrderDate(d.getOrderDate());

        e.setStatus(d.getStatus());

        e.setTotalAmount(d.getTotalAmount());
    }


    public OrderDTO placeOrder(Long cartId) {

        Cart cart = EntityHelper.active(
                cartRepository,
                cartId,
                "Cart"
        );

        List<CartItem> cartItems =
                cartItemRepository.findAllByCartAndIsActiveTrue(cart);

        if (cartItems.isEmpty()) {

            throw new RuntimeException(
                    "Cart is empty"
            );
        }

        double totalAmount = 0.0;

        for (CartItem cartItem : cartItems) {

            Product product = cartItem.getProduct();

            if (product == null ||
                    !Boolean.TRUE.equals(product.getIsActive())) {

                throw new RuntimeException(
                        "Product is missing or inactive"
                );
            }

            if (cartItem.getQuantity() > product.getStockQuantity()) {

                throw new RuntimeException(
                        "Product is out of stock: " + product.getName()
                );
            }

            totalAmount +=
                    product.getPrice() * cartItem.getQuantity();
        }

        Order order = new Order();

        order.setCustomer(cart.getCustomer());

        order.setOrderDate(new Date());

        order.setStatus("PLACED");

        order.setTotalAmount(totalAmount);

        order.setIsActive(true);

        order.setCreatedDate(new Date());

        order = repo.save(order);

        for (CartItem cartItem : cartItems) {

            Product product = cartItem.getProduct();

            OrderItem orderItem = new OrderItem();

            orderItem.setOrder(order);

            orderItem.setProduct(product);

            orderItem.setQuantity(
                    cartItem.getQuantity()
            );

            orderItem.setUnitPrice(
                    product.getPrice()
            );

            orderItem.setIsActive(true);

            orderItem.setCreatedDate(new Date());

            orderItemRepository.save(orderItem);

            product.setStockQuantity(
                    product.getStockQuantity()
                            - cartItem.getQuantity()
            );

            product.setUpdatedDate(new Date());

            productRepository.save(product);
        }

        for (CartItem cartItem : cartItems) {

            cartItem.setIsActive(false);

            cartItem.setUpdatedDate(new Date());

            cartItemRepository.save(cartItem);
        }

        return OrderDTO.convertToDTO(order);
    }


    public List<OrderDTO> getOrdersByCustomer(Long customerId) {

        return OrderDTO.convertToDTO(
                repo.getOrdersByCustomer(customerId)
        );
    }
}