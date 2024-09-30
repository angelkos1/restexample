package com.angel.restexample.facade;

import com.angel.restexample.dto.RequestDto;
import com.angel.restexample.dto.ResponseDto;
import com.angel.restexample.exception.InputDataException;

import java.security.NoSuchAlgorithmException;

public interface UserzFacade {

    ResponseDto register(RequestDto requestDto) throws InputDataException, NoSuchAlgorithmException;
}
