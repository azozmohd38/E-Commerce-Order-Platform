package com.example.E_Commerce.Order.Platform.service;

import com.example.E_Commerce.Order.Platform.dto.StoreDTO;
import com.example.E_Commerce.Order.Platform.entities.Store;
import com.example.E_Commerce.Order.Platform.repositories.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreService implements CrudService<StoreDTO> {

    private final StoreRepository repo;


    public StoreDTO create(StoreDTO d) {

        Store e = new Store();

        copy(d, e);

        e.setIsActive(true);

        return StoreDTO.convertToDTO(
                repo.save(e)
        );
    }


    public List<StoreDTO> getAll() {

        return StoreDTO.convertToDTO(
                repo.findAllByIsActiveTrue()
        );
    }


    public StoreDTO getById(Long id) {

        return StoreDTO.convertToDTO(
                find(id)
        );
    }


    public StoreDTO update(Long id, StoreDTO d) {

        Store e = find(id);

        copy(d, e);

        return StoreDTO.convertToDTO(
                repo.save(e)
        );
    }


    public void delete(Long id) {

        Store e = find(id);

        e.setIsActive(false);

        repo.save(e);
    }


    Store find(Long id) {

        return EntityHelper.active(
                repo,
                id,
                "Store"
        );
    }


    private void copy(StoreDTO d, Store e) {

        e.setName(d.getName());

        e.setLocation(d.getLocation());
    }


    public Map<String, Long> getStoreStats(Long storeId) {

        find(storeId);

        Long products =
                repo.countActiveProductsByStore(storeId);

        Long customers =
                repo.countActiveCustomersByStore(storeId);

        Long orders =
                repo.countActiveOrdersByStore(storeId);

        Map<String, Long> stats = new HashMap<>();

        stats.put("products", products);

        stats.put("customers", customers);

        stats.put("orders", orders);

        return stats;
    }
}