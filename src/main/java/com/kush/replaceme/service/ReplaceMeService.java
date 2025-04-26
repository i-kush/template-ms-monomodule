package com.kush.replaceme.service;

import com.kush.replaceme.controller.dto.request.CreateReplaceMeDto;
import com.kush.replaceme.controller.dto.response.GetReplaceMeDto;
import com.kush.replaceme.exception.NotFoundException;
import com.kush.replaceme.repository.ReplaceMeRepository;
import com.kush.replaceme.repository.entity.ReplaceMeEntity;
import com.kush.replaceme.service.converter.ReplaceMeConverter;

import org.springframework.stereotype.Service;

@Service
public class ReplaceMeService {

    private final ReplaceMeRepository replaceMeRepository;
    private final ReplaceMeConverter replaceMeConverter;

    public ReplaceMeService(ReplaceMeRepository replaceMeRepository, ReplaceMeConverter replaceMeConverter) {
        this.replaceMeRepository = replaceMeRepository;
        this.replaceMeConverter = replaceMeConverter;
    }

    public GetReplaceMeDto createReplaceMe(CreateReplaceMeDto createReplaceMeDto) {
        ReplaceMeEntity replaceMeEntity = replaceMeConverter.toReplaceMeEntity(createReplaceMeDto);
        ReplaceMeEntity createdReplaceMeEntity = replaceMeRepository.save(replaceMeEntity);
        return replaceMeConverter.toGetReplaceMeDto(createdReplaceMeEntity);
    }

    public GetReplaceMeDto findReplaceMeById(long id) {
        ReplaceMeEntity replaceMeEntity = replaceMeRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("No such id " + id));

        return replaceMeConverter.toGetReplaceMeDto(replaceMeEntity);
    }
}
