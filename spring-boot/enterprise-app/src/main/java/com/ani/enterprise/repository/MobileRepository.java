package com.ani.enterprise.repository;

import com.ani.enterprise.domain.Mobile;

import java.util.List;

public interface MobileRepository {
    void save(Mobile mobile);

    void delete(Long id);

    List<Mobile> findAll();

    Mobile update(Mobile mobile);
}
