
package com.realdolmen.maven.clientrepository.services;

import com.realdolmen.maven.clientrepository.domain.Firm;
import com.realdolmen.maven.clientrepository.repositories.FirmRepository;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.mockito.Mock;


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
}
