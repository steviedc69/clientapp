
package com.realdolmen.maven.clientrepository.services;

import com.realdolmen.maven.clientrepository.domain.Firm;
import com.realdolmen.maven.clientrepository.domain.Person;
import com.realdolmen.maven.clientrepository.domain.PostalCode;
import com.realdolmen.maven.clientrepository.exceptions.NoQueryPossibleException;
import com.realdolmen.maven.clientrepository.repositories.PersonRepository;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {
    
   private PersonService personService;
    
    @Mock
    private PersonRepository personRepository;
    
    @Before
    public void init(){
        personService = new PersonService(personRepository);
    }

  
    @Test
    public void testFindAll() throws Exception {
    }

  
    @Test
    public void testFindById() throws Exception {
    }
    
   @Test
    public void insertPersonTestSuccess() throws Exception {
      Person person = new Person();
      when(personRepository.insertItem(person)).thenReturn(person);
       
      Person result = personService.insertPerson(person);  
      
      assertEquals(result, person);
        verify(personRepository, times(1)).insertItem(person);
    }
      
      @Ignore
      @Test
    public void insertPersonTestExceptionThrown() throws NoQueryPossibleException{
        when(personRepository.insertItem(null)).thenThrow(NoQueryPossibleException.class);
       
        Person result = personService.insertPerson(null);
        assertNull(result);
        
    }
}
