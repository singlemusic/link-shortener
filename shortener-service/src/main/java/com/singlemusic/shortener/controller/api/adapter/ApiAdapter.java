package com.singlemusic.shortener.controller.api.adapter;

public interface ApiAdapter<A, E> {
    A toApi(E entity);

    E toEntity(A api);
}
