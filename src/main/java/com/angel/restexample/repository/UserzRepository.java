package com.angel.restexample.repository;

import com.angel.restexample.domain.Userz;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserzRepository extends CrudRepository<Userz, String> {

    @Query(value = "SELECT u from Userz u " +
            "WHERE (u.email = :email)"
    )
    Userz buscarPorMail(
            @Param("email") String email
    );
}
