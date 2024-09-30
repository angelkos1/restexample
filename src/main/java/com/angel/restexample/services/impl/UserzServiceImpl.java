package com.angel.restexample.services.impl;

import com.angel.restexample.config.AppConfig;
import com.angel.restexample.domain.Userz;
import com.angel.restexample.exception.InputDataException;
import com.angel.restexample.repository.UserzRepository;
import com.angel.restexample.services.UserzService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserzServiceImpl implements UserzService {

    private static final String EMAIL_REGEX = "^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    private final AppConfig appConfig;
    private final UserzRepository userzRepository;

    public UserzServiceImpl(final AppConfig appConfig, UserzRepository userzRepository) {
        this.appConfig = appConfig;
        this.userzRepository = userzRepository;
    }

    @Override
    public Userz register(final Userz u) throws InputDataException, NoSuchAlgorithmException {

        validateStrRegex(u.getEmail(), EMAIL_REGEX);
        validateStrRegex(u.getPassword(), appConfig.getPasswordRegex());


        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(
                u.getPassword().getBytes(StandardCharsets.UTF_8));

        u.setPassword(bytesToHex(encodedhash));
        u.setToken(buildToken(u));
        userzRepository.save(u);

        final Optional<Userz> userz = userzRepository.findById(u.getId());

        return userz.orElse(null);
    }

    @Override
    public void checkUserExist(final String email) throws InputDataException {

        final Userz userz = userzRepository.buscarPorMail(email);

        if (Objects.nonNull(userz)) {
            throw new InputDataException("El correo ya fue registrado");
        }
    }

    private void validateStrRegex(final String str, final String regex) throws InputDataException {
        if (!str.matches(regex)) {
            throw new InputDataException("el campo no cumple con los requisitos establecidos");
        }
    }

    private String buildToken(
            Userz userz
    ) {
        return Jwts
                .builder()
                .subject(userz.getEmail())
                .issuedAt(new Date(System.currentTimeMillis()))
                .signWith(getSignInKey(userz.getPassword()), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignInKey(final String password) {
        byte[] keyBytes = Decoders.BASE64.decode(password);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private static String bytesToHex(final byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (final byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }

            hexString.append(hex);
        }

        return hexString.toString();
    }
}
