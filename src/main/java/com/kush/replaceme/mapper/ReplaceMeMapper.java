package com.kush.replaceme.mapper;

import com.kush.replaceme.dto.request.CreateReplaceMeDto;
import com.kush.replaceme.dto.response.GetReplaceMeDto;
import com.kush.replaceme.entity.ReplaceMeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class ReplaceMeMapper {

    @Mapping(target = "id", ignore = true)
    public abstract ReplaceMeEntity toReplaceMeEntity(CreateReplaceMeDto createReplaceMeDto);

    public abstract GetReplaceMeDto toGetReplaceMeDto(ReplaceMeEntity replaceMeEntity);
}
