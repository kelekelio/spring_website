package com.example.repository;

import com.example.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Grzegorz Nowakowski
 */
public interface ItemsRepository extends JpaRepository<Tasks, Long> {

}
