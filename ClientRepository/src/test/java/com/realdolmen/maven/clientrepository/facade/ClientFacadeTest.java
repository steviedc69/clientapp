/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdolmen.maven.clientrepository.facade;

import org.junit.Test;
import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
/**
 *
 * @author SDOAX36
 */
PersonRepository personRepository;

    @Mock
    private PersonService personService;

    @Mock
    private AddressService addressService;

    @Before
    public void init() {
        personRepository = new PersonRepository();
        personService = new PersonService(personRepository);
        addressService = new AddressService();
    }


public class ClientFacadeTest {
    
    public ClientFacadeTest() {
    }

    /**
     * Test of getAllClients method, of class ClientFacade.
     */
    @Test
    public void testGetAllClients() {
    }

    /**
     * Test of findClientById method, of class ClientFacade.
     */
    @Test
    public void testFindClientById() {
    }
    
    
    @Test
    public void testAddAddressForPersonSuccess() throws NoQueryPossibleException {
        //init mock data 
        
        when(addressService.addAddress()).thenReturn("address");

        //do the test
        boolean result = ClientFacade.addAddressforPerson(id, address);

        //verify your result
        assertTrue(result);
        verify(personService, times(1)).findById(0);
        verify(addressService times(1)).AddAddress();

    }

    @Test
    public void testAddAddressForFirmSuccess() {
        //init data

        //do the test
        //verify your result
    }

    @Test
    public void AddAddressThrowsException() throws NoPersonFoundException {
        //init data 
        when(personService.findById()).thenThrow(NoPersonFoundException);

        //test
        //verify
    }
    
}
