package com.rajbir.core.converter;

/**
 * Created by Sony on 08-09-2017.
 */
public interface DtoConverter<T, S> {
    S convertToDto(T t);

    T convertFromDto(S s);
}
