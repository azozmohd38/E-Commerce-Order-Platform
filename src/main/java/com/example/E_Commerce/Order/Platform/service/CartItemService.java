package com.example.E_Commerce.Order.Platform.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CartItemService implements CrudService<CartItemDTO> {


}

