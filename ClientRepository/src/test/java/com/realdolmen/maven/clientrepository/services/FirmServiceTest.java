
package com.realdolmen.maven.clientrepository.services;

import com.realdolmen.maven.clientrepository.domain.Firm;
import com.realdolmen.maven.clientrepository.domain.PostalCode;
import com.realdolmen.maven.clientrepository.exceptions.NoQueryPossibleException;
import com.realdolmen.maven.clientrepository.repositories.FirmRepository;
import static com.realdolmen.maven.clientrepository.repositories.FirmRepository.KEY;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FirmServiceTest {
    
  private FirmService firmService;
    
    @Mock
    private FirmRepository firmRepository;
    
    @Before
    public void init(){
        firmService = new FirmService(firmRepository);
    }
    
    @Test
    public void testFindAll() throws Exception {
    }

    @Test
    public void testFindById() throws Exception {
    }  
    
    @Test
    public void insertFirmTestSuccess() throws Exception {
      Firm firm = new Firm();
      when(firmRepository.insertItem(firm)).thenReturn(firm);
       
      Firm result = firmService.insertFirm(firm);  
      
        assertEquals(result, firm);
        verify(firmRepository, times(1)).insertItem(firm);
    }
    
      @Test
    public void insertPostalCodeTestExceptionThrown() throws NoQueryPossibleException{
    }
}
