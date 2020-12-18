package com.lab.triangle;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ResultCache {
    private Map<Integer, Triangle> cacheMap;// = new Map<Integer, Triangle>;
}
