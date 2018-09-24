package com.realdolmen.maven.clientrepository.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import com.realdolmen.maven.clientrepository.exceptions.NoQueryPossibleException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import com.realdolmen.maven.clientrepository.domain.*;

public class AddressRepositoryTest {
    
    private AddressRepository addressRepository;
    
    @Mock
    private ResultSet resultSet;
    
    @Before
    public void init(){
        addressRepository = new AddressRepository();
    }
    
    @Test
    public void findAllTestSuccess()throws NoQueryPossibleException{
        List<Address>addresses = addressRepository.findAll();
        assertFalse(addresses.isEmpty());
    }
    
    @Ignore
    @Test
    public void createObjectTestSucces() throws SQLException, NoQueryPossibleException{
        //init data
        when(resultSet.getString(AddressRepository.TYPE))
                .thenReturn("type");
        when(resultSet.getString(AddressRepository.ADDRESS))
                .thenReturn("street");
        when(resultSet.getInt(AddressRepository.ADDRNR))
                .thenReturn(2);
        when(resultSet.getInt(AddressRepository.POSTALCODE))
                .thenReturn(1);
        //test the test object
        Address result = addressRepository.createObject(resultSet);
        //verify the result
        assertEquals("type",result.getTypeAddress());
        assertEquals("street", result.getStreet());
        assertEquals(2, result.getNumber());
        assertEquals(1, result.getPostalCode());
        verify(resultSet,times(1)).getString(AddressRepository.TYPE);
        verify(resultSet,times(1)).getString(AddressRepository.ADDRESS);
        verify(resultSet, times(1)).getInt(AddressRepository.ADDRNR);
        verify(resultSet, times(1)).getInt(AddressRepository.POSTALCODE);
    }
    
    @Test
    public void createObjectTestThrowsSQLException()throws SQLException{
        //init data
        when(resultSet.getString(AddressRepository.ADDRESS))
                .thenThrow(SQLException.class);
        //test the object
        Address result = addressRepository.createObject(resultSet);
        //verify the result
        assertNull(result);
        verify(resultSet,times(1)).getString(AddressRepository.ADDRESS);
        verifyNoMoreInteractions(resultSet);
    }
    
}
