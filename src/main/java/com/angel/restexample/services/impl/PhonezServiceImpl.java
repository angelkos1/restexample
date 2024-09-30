package com.angel.restexample.services.impl;

import com.angel.restexample.domain.Phonez;
import com.angel.restexample.repository.PhonezRepository;
import com.angel.restexample.services.PhonezService;
import org.springframework.stereotype.Service;

@Service
public class PhonezServiceImpl implements PhonezService {

    private final PhonezRepository phonezRepository;

    public PhonezServiceImpl(final PhonezRepository phonezRepository) {
        this.phonezRepository = phonezRepository;
    }

    @Override
    public void savePhonez(final Phonez phonez) {
        phonezRepository.save(phonez);
    }
}
