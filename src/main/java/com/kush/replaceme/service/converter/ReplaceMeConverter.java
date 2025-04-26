package com.kush.replaceme.service.converter;

import com.kush.replaceme.controller.dto.request.CreateReplaceMeDto;
import com.kush.replaceme.controller.dto.response.GetReplaceMeDto;
import com.kush.replaceme.repository.entity.ReplaceMeEntity;

import org.springframework.stereotype.Service;

@Service
public class ReplaceMeConverter {

    public ReplaceMeEntity toReplaceMeEntity(CreateReplaceMeDto createReplaceMeDto) {
        ReplaceMeEntity replaceMeEntity = new ReplaceMeEntity();
        replaceMeEntity.setName(createReplaceMeDto.name());

        return replaceMeEntity;
    }

    public GetReplaceMeDto toGetReplaceMeDto(ReplaceMeEntity replaceMeEntity) {
        return new GetReplaceMeDto(
                replaceMeEntity.getId(),
                replaceMeEntity.getName()
        );
    }
}
