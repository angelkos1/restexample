package com.angel.restexample.facade.builders;

import com.angel.restexample.domain.Userz;
import com.angel.restexample.dto.RequestDto;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;
import java.util.function.Consumer;

@Setter
public class UserzBuilder {

    private RequestDto source;

    public UserzBuilder with(Consumer<UserzBuilder> builderConsumer) {
        builderConsumer.accept(this);
        return this;
    }

    public Userz build() {

        Userz userz = new Userz();
        final UUID uuid = UUID.randomUUID();


        userz.setId(uuid.toString());

        userz.setLastLogin(new Date());
        userz.setActive(true);
        userz.setPassword(source.getPassword());
        userz.setEmail(source.getEmail());
        userz.setName(source.getName());

        return userz;
    }
}
