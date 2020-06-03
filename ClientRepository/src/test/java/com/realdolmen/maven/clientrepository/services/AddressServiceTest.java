/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdolmen.maven.clientrepository.services;

import com.realdolmen.maven.clientrepository.domain.Address;
import com.realdolmen.maven.clientrepository.exceptions.NoQueryPossibleException;
import com.realdolmen.maven.clientrepository.repositories.AddressRepository;
import java.sql.ResultSet;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;


import static org.mockito.Mockito.*;
/**
 *
 * @author SDOAX36
 */
@RunWith(MockitoJUnitRunner.class)
public class AddressServiceTest {
    
    private AddressService addressService;
    
    
    @Mock
    private AddressRepository addressRepository;
    
    @Before
    public void init(){
        //addressService = new AddressService();
       addressService = new AddressService(addressRepository);
    }
    
    @Test
    public void findAllTestSuccess()throws NoQueryPossibleException{
        List<Address>address = addressRepository.findAll();
        when(addressRepository.findAll()).thenReturn(address);
        assertEquals(1, addressRepository.findAll());
        verify(addressRepository,times(0)).findAll();
        
    }
    
    @Test
    public void findByIdTest() throws NoQueryPossibleException{
       
    }
    
    
    
}
