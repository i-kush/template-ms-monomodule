package com.kush.replaceme.service;

import com.kush.replaceme.dto.request.CreateReplaceMeDto;
import com.kush.replaceme.dto.response.GetReplaceMeDto;
import com.kush.replaceme.entity.ReplaceMeEntity;
import com.kush.replaceme.exception.NotFoundException;
import com.kush.replaceme.mapper.ReplaceMeMapper;
import com.kush.replaceme.repository.ReplaceMeRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplaceMeService {

    private final ReplaceMeRepository replaceMeRepository;
    private final ReplaceMeMapper replaceMeConverter;

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
