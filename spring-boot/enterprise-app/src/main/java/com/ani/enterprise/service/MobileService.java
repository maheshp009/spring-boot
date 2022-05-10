package com.ani.enterprise.service;

import com.ani.enterprise.dto.MobileDto;

import java.util.List;

public interface MobileService {

    String createMobile(MobileDto dto);

    void removeMobile(Long id);

    List<MobileDto> showAllMobiles();

    MobileDto updateMobile(MobileDto dto);
}
