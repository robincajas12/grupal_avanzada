package com.project007.converters;

import jakarta.nosql.AttributeConverter;
import java.math.BigDecimal;

public class BigDecimalConverter implements AttributeConverter<BigDecimal, String> {

    @Override
    public String convertToDatabaseColumn(BigDecimal attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.toString();
    }

    @Override
    public BigDecimal convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return new BigDecimal(dbData);
    }
}
