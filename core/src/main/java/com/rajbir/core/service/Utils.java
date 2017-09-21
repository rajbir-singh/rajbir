package com.rajbir.core.service;

import org.springframework.stereotype.Service;

/**
 * Created by Sony on 07-09-2017.
 */
@Service
public class Utils {
    public static boolean isEmptyObject(Object o) {
        return o == null;
    }
    public static boolean isNotEmptyObject(Object o) {
        return !isEmptyObject(o);
    }
}
