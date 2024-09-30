package com.angel.restexample.services;

import com.angel.restexample.domain.Userz;
import com.angel.restexample.exception.InputDataException;

import java.security.NoSuchAlgorithmException;

public interface UserzService {

    Userz register(Userz user) throws InputDataException, NoSuchAlgorithmException;

    void checkUserExist(String email) throws InputDataException;
}
