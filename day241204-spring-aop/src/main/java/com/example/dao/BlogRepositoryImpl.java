package com.example.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BlogRepositoryImpl implements BlogRepository{
    @Override
    public void save() {
        System.out.println("执行方法之前，记录当前用户的身份，操作时间等日志信息");

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
