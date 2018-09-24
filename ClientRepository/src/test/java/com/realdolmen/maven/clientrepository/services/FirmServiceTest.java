
package com.realdolmen.maven.clientrepository.services;

import com.realdolmen.maven.clientrepository.domain.Firm;
import com.realdolmen.maven.clientrepository.exceptions.NoQueryPossibleException;
import com.realdolmen.maven.clientrepository.repositories.FirmRepository;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.Ignore;
import org.mockito.Mock;

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
      @Ignore
    @Test
    public void insertFirmTestSuccess() throws Exception {
    }

    @Test
    public void testRemovePerson() throws NoQueryPossibleException {
        Firm firm = new Firm();
        firmService.removeFirm(firm);
        verify(firmRepository, times(1)).deleteItem(firm);    
    }
}
