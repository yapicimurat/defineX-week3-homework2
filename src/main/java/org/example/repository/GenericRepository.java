package org.example.repository;

import org.example.model.BaseModel;

import java.util.List;

public interface GenericRepository<T extends BaseModel> {

    void save(T model);
    void delete(T model);
    List<T> getAll();


}
