package com.ani.enterprise.service;

import com.ani.enterprise.domain.Mobile;
import com.ani.enterprise.dto.MobileDto;
import com.ani.enterprise.exception.InvalidCountryException;
import com.ani.enterprise.repository.MobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

//@Component
@Service // this will perform operations on data
public class MobileServiceImpl implements MobileService {

    private static final List<String> countries = List.of("IN", "US", "UK");
    @Autowired
    private MobileRepository repository;

    @Override
    public String createMobile(MobileDto dto) {

        if(!countries.contains(dto.getCountry())) {
            throw new InvalidCountryException(dto.getCountry() + " Not Allowed For Production ");
        }

        Mobile domain = new Mobile(
                dto.getId(),
                dto.getNumber(),
                dto.getCountry(),
                dto.getIsDualSim()
        );

        repository.save(domain);

        return "success";
    }

    @Override
    public void removeMobile(Long id) {
        repository.delete(id);
    }

    @Override
    public List<MobileDto> showAllMobiles() {
        return repository.findAll().stream()
                .map(
                        mobile ->  new MobileDto(
                                mobile.getId(),
                                mobile.getNumber(),
                                mobile.getCountry(),
                                mobile.getIsDualSim()
                        )
                ).collect(
                        Collectors.toList()
                );
    }

    @Override
    public MobileDto updateMobile(MobileDto dto) {

        if(!countries.contains(dto.getCountry())) {
            throw new InvalidCountryException(dto.getCountry() + " Not Allowed For Production ");
        }

        Mobile mobile = new Mobile(
                dto.getId(),
                dto.getNumber(),
                dto.getCountry(),
                dto.getIsDualSim()
        );

        Mobile updated = repository.update(mobile);

        return new MobileDto(
                updated.getId(),
                updated.getNumber(),
                updated.getCountry(),
                updated.getIsDualSim()
        );
    }
}
