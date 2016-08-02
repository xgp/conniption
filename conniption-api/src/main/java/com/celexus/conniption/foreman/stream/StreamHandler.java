package com.celexus.conniption.foreman.stream;

public interface StreamHandler<T> {
    public void handle(T t);
}