/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdolmen.maven.clientrepository.services;

import com.realdolmen.maven.clientrepository.domain.Person;
import com.realdolmen.maven.clientrepository.domain.PostalCode;
import com.realdolmen.maven.clientrepository.exceptions.NoQueryPossibleException;
import com.realdolmen.maven.clientrepository.repositories.PostalCodeRepository;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PostalCodeServiceTest {
    
    private PostalCodeService postalCodeService;

    @Mock
    private PostalCodeRepository postalCodeRepository;
    
    @Before
    public void init(){
        postalCodeService = new PostalCodeService(postalCodeRepository);
    }

    @Test
    public void testAddPostalCode() {
    }


    @Test
    public void testFindAllPostalCodes() throws Exception {
    }

    @Test
    public void testFindAllPostalCodesFromTheNine() throws Exception {
    }


    @Test
    public void testFindById() throws Exception {
    }


    @Test
    public void testRemovePostalCode() {
    }


    @Test
    public void testUpdatePostalCode() {
    }
    
     @Test
    public void insertPostalCodeTest() throws Exception {
        
    }
    
      @Test
    public void insertPostalCodeTestSuccess() throws Exception {
      PostalCode postalCode = new PostalCode();
      when(postalCodeRepository.insertItem(postalCode)).thenReturn(postalCode);
    //injected value, with no need for testing => mock it
    
      PostalCode result = postalCodeService.insertPostalCode(postalCode);  
      
      assertEquals(result, postalCode);
        verify(postalCodeRepository, times(1)).insertItem(postalCode);
    }
    
    @Test
    public void insertPostalCodeTestExceptionThrown() throws NoQueryPossibleException{
    }
}
