package com.celexus.conniption.model.stream;

public interface StreamHandler<T> {
    public void handle(T t);
}