
package com.realdolmen.maven.clientrepository.facade;

import com.realdolmen.maven.clientrepository.domain.*;
import com.realdolmen.maven.clientrepository.exceptions.*;
import com.realdolmen.maven.clientrepository.repositories.*;
import com.realdolmen.maven.clientrepository.services.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;


public class ClientFacade {
    private PostalCodeService postalCodeService;
    private AddressService addressService;
    private PersonService personService;
    private FirmService firmService;

    public ClientFacade() {
        this.postalCodeService = new PostalCodeService(new PostalCodeRepository());
        //need implementation
        this.addressService = new AddressService();
        this.personService = new PersonService(new PersonRepository());
        this.firmService = new FirmService(new FirmRepository());
    }

    public List<Klant> getAllClients(){
        List<Klant> clients = new ArrayList<>();
        try {
            List<Person>persons = personService.findAll();
            persons.forEach(p -> clients.add((Klant)p) );
            List<Firm> firms = firmService.findAll();
            firms.forEach(f -> clients.add((Klant)f));
            Collections.sort(clients,(o1, o2)-> Integer.compare(o1.getNumber(), o2.getNumber()) );
        } catch (NoQueryPossibleException ex) {
            ex.printStackTrace();
        }
        return clients;
    }
    
    
    public Klant findClientById(int id,char c){
        Klant klant = null;
        try {
            switch(c){
                case 'p' : klant = personService.findById(id);
                break;
                case 'f' : klant = firmService.findById(id);
                break;
                default : klant = null;
            }

        } catch (NoQueryPossibleException ex) {
            ex.printStackTrace();
        }
        return klant;
    }
    
    
    public boolean addAddressforPerson(int id, Address address) throws NoPersonFoundException
    {
        try
        {
            if(personService.findById(id) == null)
        {
            throw new NoPersonFoundException();
        }
            else
            {
                //addressService.addAddress(id, address);
                return true;
            }
        }catch(NoQueryPossibleException e)
        {
            throw new NoPersonFoundException();
        }
        
    }
        
    public boolean addAddressforFirm(int id, Address address) throws NoPersonFoundException
    {
        try
        {
            if(firmService.findById(id) == null)
        {
            throw new NoPersonFoundException();
        }
            else
            {
                //firmService.addAddress(id, address);
                return true;
            }
        }catch(NoQueryPossibleException e)
        {
            throw new NoPersonFoundException();
        }
        
    }
    
    
    
    
    
}
