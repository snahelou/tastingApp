package com.snahelou.rumtasting.data.entity;

import com.snahelou.rumtasting.controller.dto.enums.AromaEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class AromaConverter implements AttributeConverter<AromaEnum, String>{

    @Override
    public String convertToDatabaseColumn(AromaEnum attribute) {
        return attribute.getAroma();
    }

    @Override
    public AromaEnum convertToEntityAttribute(String dbData) {
        return AromaEnum.fromString(dbData);
    }
}
