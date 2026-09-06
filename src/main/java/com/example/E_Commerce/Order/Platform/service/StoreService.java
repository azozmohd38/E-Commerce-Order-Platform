package com.example.E_Commerce.Order.Platform.service;

import com.example.E_Commerce.Order.Platform.dto.*;
import com.example.E_Commerce.Order.Platform.entities.*;
import com.example.E_Commerce.Order.Platform.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


// Git Commit: Create StoreService
@Service
@RequiredArgsConstructor
@Transactional
public class StoreService implements CrudService<StoreDTO> {


    private final StoreRepository repo;
}


