package com.example.corailbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.corailbackend.entity.AbstractEntity;

@Service
public interface AbstractEntityRepository<T extends AbstractEntity> extends JpaRepository<T, Integer> {

}
