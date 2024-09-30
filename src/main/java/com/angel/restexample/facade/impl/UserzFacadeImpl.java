package com.angel.restexample.facade.impl;

import com.angel.restexample.domain.Phonez;
import com.angel.restexample.domain.Userz;
import com.angel.restexample.dto.PhonezDto;
import com.angel.restexample.dto.RequestDto;
import com.angel.restexample.dto.ResponseDto;
import com.angel.restexample.exception.InputDataException;
import com.angel.restexample.facade.UserzFacade;
import com.angel.restexample.facade.builders.PhonezBuilder;
import com.angel.restexample.facade.builders.ResponseDtoBuilder;
import com.angel.restexample.facade.builders.UserzBuilder;
import com.angel.restexample.services.PhonezService;
import com.angel.restexample.services.UserzService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.security.NoSuchAlgorithmException;

@Component
public class UserzFacadeImpl implements UserzFacade {

    private final UserzService userService;
    private final PhonezService phonezService;

    public UserzFacadeImpl(UserzService userService, PhonezService phonezService) {
        this.userService = userService;
        this.phonezService = phonezService;
    }

    @Override
    @Transactional
    public ResponseDto register(final RequestDto requestDto) throws InputDataException, NoSuchAlgorithmException {

        userService.checkUserExist(requestDto.getEmail());
        final Userz userz = new UserzBuilder().with(bf -> bf.setSource(requestDto)).build();

        final Userz savedUser = userService.register(userz);

        if (!CollectionUtils.isEmpty(requestDto.getPhones())) {

            for (final PhonezDto dto : requestDto.getPhones()) {
                final Phonez phonez = new PhonezBuilder().with(bc -> bc.setSource(dto)).build(savedUser);
                phonezService.savePhonez(phonez);
            }
        }

        return new ResponseDtoBuilder().with(bc -> bc.setSource(savedUser)).build();
    }
}
