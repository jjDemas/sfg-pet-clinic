package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.Collections;
import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<ID, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T object){

        if(object != null) {
            if (object.getId() == 0L) {
                object.setId(getNextId());
            }

            map.put((ID )object.getId(), object);
        } else {
            throw new RuntimeException("object cannot be NULL!");
        }

        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf((Map.Entry<ID, T>entry)->entry.getValue().equals(object));
    }

    private Long getNextId(){

        Long nextId = null;

        try {
            nextId = (Long) Collections.max(map.keySet()) + 1;
        } catch( NoSuchElementException e) {
            nextId = 1L;
        }
        return nextId;
    }
}
