package com.realdolmen.maven.clientrepository.repositories;

import com.realdolmen.maven.clientrepository.domain.PostalCode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostalCodeRepository extends AbstractRepository<PostalCode, Integer> {

    public static final String TABLE_NAME = "client_person";
    public static final String KEY = "postal_code";
    public static final String CITY = "city";

    public PostalCodeRepository() {
        super(TABLE_NAME, KEY);
    }

    @Override
    public PostalCode createObject(ResultSet resultSet) {
        try {
            PostalCode postalCode = new PostalCode();
            postalCode.setNumber(resultSet.getInt(KEY));
            postalCode.setCity(resultSet.getString(CITY));
            return postalCode;
        } catch (SQLException ex) {
            Logger.getLogger(PostalCodeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void getObjectId(PostalCode postalcode) {
        return o.();
    }
