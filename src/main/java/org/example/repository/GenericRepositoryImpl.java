package org.example.repository;

import org.example.model.BaseModel;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class GenericRepositoryImpl<T extends BaseModel> implements GenericRepository<T>{
    Set<T> dataSource = new HashSet<>();

    @Override
    public void save(T model) {
        model.setCreatedAt(LocalDateTime.now());
        dataSource.add(model);
    }

    @Override
    public void delete(T model) {
        model.setDeleted(true);
        model.setDeletedAt(LocalDateTime.now());
        dataSource.remove(model);
    }

    @Override
    public List<T> getAll() {
        return dataSource.stream().collect(Collectors.toList());
    }
}
