package com.ani.enterprise.repository;

import com.ani.enterprise.domain.Mobile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//@Component
@Repository // this will communicate with datasource
public class MobileRepositoryImpl implements MobileRepository {

    private final List<Mobile> mobiles = new ArrayList<>();

    @Override
    public void save(Mobile mobile) {
        // mobile will be saved to database
        mobiles.add(mobile);
    }

    @Override
    public void delete(Long id) {
        mobiles.removeIf( mobile -> Objects.equals(mobile.getId(), id));
    }

    @Override
    public List<Mobile> findAll() {
        return mobiles;
    }

    @Override
    public Mobile update(Mobile mobile) {
        int index = mobiles.indexOf(mobile);
        return mobiles.set(index, mobile);
    }
}
