package com.realdolmen.maven.clientrepository.repositories;

import com.realdolmen.maven.clientrepository.domain.Address;
import com.realdolmen.maven.clientrepository.domain.PostalCode;
import com.realdolmen.maven.clientrepository.exceptions.NoQueryPossibleException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class AddressRepository extends AbstractRepository<Address, Integer>{

    //private static final String TABLE;
    public static final String TABLE = "address";
    public static final String ADDRESS= "street";
    public static final String  ADDRNR= "number";
    public static final String KEY = "id";
    public static final String TYPE ="type";
    public static  final String  POSTALCODE = "postal_code" ;
    public static final String PCode= "1070";
    public static final String CITY = "city";
    public static final String BOX = "box";
    public static final String  CLIENT_PERSON="client_person";
    public static final String  CLIENT_FIRM="client_firm";
    private PostalCodeRepository postalRep ;
    
    public AddressRepository() {
        super(TABLE, KEY);
    }

    @Override
    public Address createObject(ResultSet resultSet) {
       
     //To change body of generated methods, choose Tools | Templates.
        try {
            Address address = new Address();
            PostalCode pCode = new PostalCode();
            postalRep = new PostalCodeRepository();
            address.setTypeAddress(resultSet.getString(ADDRESS));
            address.setNumber(resultSet.getInt(ADDRNR));
            address.setTypeAddress(resultSet.getString(TYPE));
          // address.setPostalCode(POSTALCODE.);
          //address.setPostalCode(POSTALCODE, PostalCodeRepository.CITY);
          //
            try {
                address.setPostalCode(postalRep.findById(resultSet.getInt(POSTALCODE)));
            } catch (NoQueryPossibleException ex) {
            }
       //   PostalCodeRepository.
          
            
            //address.setPostalCode(resultSet.);
            
            return address;
                
        } catch (SQLException e) {
            Logger.getLogger(AddressRepository.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    
    }
    
    public List findAll(){
        return null;
}
        
    }
        

