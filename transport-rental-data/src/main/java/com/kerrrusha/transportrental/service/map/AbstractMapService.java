package com.kerrrusha.transportrental.service.map;

import com.kerrrusha.transportrental.model.BaseEntity;

import java.util.*;

import static java.util.Objects.isNull;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    private final Map<Long, T> map = new HashMap<>();

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
        if (isNull(object)) {
            throw new RuntimeException("#save - object cannot be null");
        }
        if (isNull(object.getId())) {
            object.setId(getNextId());
        }
        map.put(object.getId(), object);
        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        try {
            return Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException ignored) {
            return 1L;
        }
    }

}
