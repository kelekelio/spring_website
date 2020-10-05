package com.example.repository;

import com.example.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Grzegorz Nowakowski
 */
public interface TasksRepository extends JpaRepository<Tasks, Long> {

    @Override
    List<Tasks> findAll();

    @Override
    Tasks save(Tasks entity);

    @Override
    void delete(Long id);

    Tasks findById(Long id);

}
