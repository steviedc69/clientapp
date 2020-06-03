
package com.realdolmen.maven.clientrepository.services;

import com.realdolmen.maven.clientrepository.domain.Address;
import com.realdolmen.maven.clientrepository.exceptions.NoQueryPossibleException;
import com.realdolmen.maven.clientrepository.repositories.AddressRepository;
import java.util.List;

/**
 *
 * @author SDOAX36
 */
public class AddressService {
    private AddressRepository addressRepository;
    
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    
    public List<Address> findAllAddresses() throws NoQueryPossibleException{
        return addressRepository.findAll();
    }
    
     public Address findById(int id) throws NoQueryPossibleException {
        return addressRepository.findById(id);
    }
     
     public boolean addAddress(int code, String address){
         return false;
     }
     
     public boolean removeAddress(Address address){
         addressRepository.deleteItem(address);
         return false;
     }
    
    //Insert Address
    
    //findAddressById
    
    //findAllAddressForClientPerson(int id)
    //zoek een adres die van een bepaald persoon
    
    //findAllAddressFromClientFirm(int id)
    
}
