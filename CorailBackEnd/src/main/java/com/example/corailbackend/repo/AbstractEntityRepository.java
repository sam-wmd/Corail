package com.example.corailbackend.repo;

import com.example.corailbackend.entities.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public interface AbstractEntityRepository<T extends AbstractEntity> extends JpaRepository<T, Integer> {

}