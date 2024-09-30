package com.angel.restexample.facade.builders;

import com.angel.restexample.domain.Phonez;
import com.angel.restexample.domain.Userz;
import com.angel.restexample.dto.PhonezDto;
import lombok.Setter;

import java.util.function.Consumer;

@Setter
public class PhonezBuilder {

    private PhonezDto source;

    public PhonezBuilder with(Consumer<PhonezBuilder> builderConsumer) {
        builderConsumer.accept(this);
        return this;
    }

    public Phonez build(final Userz userz) {

        final Phonez phonez = new Phonez();

        phonez.setNumber(source.getNumber());
        phonez.setCountryCode(source.getCountryCode());
        phonez.setCityCode(source.getCityCode());
        phonez.setUser(userz);

        return phonez;
    }
}
