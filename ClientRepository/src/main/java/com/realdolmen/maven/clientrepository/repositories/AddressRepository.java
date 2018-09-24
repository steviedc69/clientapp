package com.realdolmen.maven.clientrepository.repositories;

import com.realdolmen.maven.clientrepository.domain.Address;
import java.sql.ResultSet;



public class AddressRepository extends AbstractRepository<Address, Integer>{

    //private static final String TABLE;
    public static final String TABLE = "address";
    public static final String KEY = "id";
    public static final String TYPE ="";
    //public static final PostalCode Pcode;
    
    public AddressRepository() {
        super(TABLE, KEY);
    }

    @Override
    public Address createObject(ResultSet resultSet) {
       
     //To change body of generated methods, choose Tools | Templates.
        try {
            Address address = new Address();
            address.setTypeAddress(resultSet.getString(ADDRESS));
            address.setStreet(resultSet.getString(NR));
                
        } catch (Exception e) {
        }
        return null;
    
    }
    
    public List findAll(){
        
    }
        
}
