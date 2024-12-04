package com.example.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BlogRepositoryImpl implements BlogRepository{
    @Override
    public void save() {
        System.out.println("BlogRepositoryImpl.save");
    }

    @Override
    public void delete() {
        System.out.println("BlogRepositoryImpl.delete");
    }

    @Override
    public void update() {
        System.out.println("BlogRepositoryImpl.update");
    }

    @Override
    public void list() {
        System.out.println("BlogRepositoryImpl.list");
    }
}
