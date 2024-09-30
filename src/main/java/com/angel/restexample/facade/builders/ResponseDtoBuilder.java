package com.angel.restexample.facade.builders;

import com.angel.restexample.domain.Userz;
import com.angel.restexample.dto.ResponseDto;
import lombok.Setter;

import java.util.function.Consumer;

@Setter
public class ResponseDtoBuilder {

    private Userz source;

    public ResponseDtoBuilder with (Consumer<ResponseDtoBuilder> builderConsumer) {
        builderConsumer.accept(this);
        return this;
    }

    public ResponseDto build () {

        ResponseDto responseDto = new ResponseDto();
        responseDto.setName(source.getName());
        responseDto.setActive(source.isActive());
        responseDto.setCreated(source.getCreated());
        responseDto.setId(source.getId());
        responseDto.setToken(source.getToken());
        responseDto.setLastLogin(source.getLastLogin());
        responseDto.setModified(source.getModified());

        return responseDto;
    }
}
