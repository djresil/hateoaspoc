package com.hateoas.poc.service;


import com.hateoas.poc.model.Auto;
import com.hateoas.poc.repository.AutoRepository;


import com.hateoas.poc.service.bo.PageBO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutosService {

    private final AutoRepository autoRepository;

    public AutosService(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;

    }


    public Auto findById(Long id) {

        return autoRepository.getById(id);
    }


    public List<Auto> findAllWithLimitOffset(Long id, int limit, int offset) {


        return autoRepository.findByAgenciaIdAndMore(id, limit, offset);
    }


    public PageBO<Auto> findWithPage(Long id, int limit, int offset, String url) {

        int start = 0;
        int offsetUrl = offset;
                
        List<Auto> autoList = autoRepository.findByAgenciaId(id);
        List<Auto> nueva = new ArrayList<>();

        for (int i = offset; i < autoList.size(); i++) {
            nueva.add(autoList.get(i));
        }
        int end = Math.min(limit, nueva.size());

        if (offset <= 0) {
            offset += 1;
        }

        Page<Auto> page = new PageImpl(nueva.subList(start, end), PageRequest.of(limit, offset), nueva.size());
        return PageBO.build(page, url, limit, offsetUrl);
    }

}
