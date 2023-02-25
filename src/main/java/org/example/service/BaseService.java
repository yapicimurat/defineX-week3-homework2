package org.example.service;

import org.example.model.BaseModel;

import java.util.List;

public interface BaseService<T extends BaseModel> {
    List<T> getAll();
    void delete(T model);
}
