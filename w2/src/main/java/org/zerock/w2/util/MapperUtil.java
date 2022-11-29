package org.zerock.w2.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

// ModelMapper의 설정을 변경하고 쉽게 사용할 수 있게 함.
public enum MapperUtil {
    INSTANCE;

    private ModelMapper modelMapper;

    MapperUtil() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                // private으로 선언된 필드도 접근 가능하도록 설정을 변경
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public ModelMapper get() {
        return modelMapper;
    }
}
