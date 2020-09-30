package com.example.repository;

import com.example.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Grzegorz Nowakowski
 */
public interface ItemsRepository extends JpaRepository<Items, Long> {
    @Override
    List<Items> findAll();

    @Override
    Items save(Items entity);

    @Override
    void delete(Long id);

    Items findById(Long id);
}
