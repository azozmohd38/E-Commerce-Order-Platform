package com.example.E_Commerce.Order.Platform.service;

import com.example.E_Commerce.Order.Platform.entities.Store;
import com.example.E_Commerce.Order.Platform.repositories.StoreRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.nio.file.Files.find;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreService implements CrudService<StoreDTO> {

    private final StoreRepository repo;

    @Override
    public StoreDTO create(StoreDTO d) {
        Store e = new Store();
        copy(d, e);
        e.setIsActive(true);
        return StoreDTO.convertToDTO(repo.save(e));


    }
    @Override
    public List<StoreDTO> getAll() {
        return StoreDTO.convertToDTO(
                repo.findAllByIsActiveTrue()
        );
    }
    @Override
    public StoreDTO getById(Long id) {
        return StoreDTO.convertToDTO(
                find(id)
        );
    }
    @Override
    public StoreDTO update(Long id, StoreDTO d) {
        Store e = find(id);
        copy(d, e);
        return StoreDTO.convertToDTO(
                repo.save(e)
        );
    }

    @Override
    public void delete(Long id) {
        Store e = find(id);
        e.setIsActive(false);
        repo.save(e);
    }





}
