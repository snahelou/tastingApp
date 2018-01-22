package com.snahelou.rumtasting.util;

import org.dozer.BeanFactory;

import java.util.UUID;


public class UuidBeanFactory implements BeanFactory {
    @Override
    public Object createBean(Object source, Class<?> sourceClass,
            String targetBeanId) {
        if (source == null) {
            return null;
        }

        UUID uuidSrc = (UUID) source;
        UUID uuidDest = new UUID(uuidSrc.getMostSignificantBits(),
                uuidSrc.getLeastSignificantBits());
        return uuidDest;
    }
}