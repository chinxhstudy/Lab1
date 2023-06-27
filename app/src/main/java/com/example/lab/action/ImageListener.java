package com.example.lab.action;

public interface ImageListener<T> {
    void start();

    void finish(T t);
}
