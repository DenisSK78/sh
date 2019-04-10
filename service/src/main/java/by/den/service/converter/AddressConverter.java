package by.den.service.converter;

import by.den.model.Address;
import by.den.service.model.AddressDTO;
import by.den.service.model.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class AddressConverter {

    public static AddressDTO addressToAddressDTO(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setIdUser(address.getIdUser());
        addressDTO.setCountry(address.getCountry());
        addressDTO.setSity(address.getSity());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setHouse(address.getHouse());
        addressDTO.setBuilding(address.getBuilding());
        addressDTO.setFlat(address.getFlat());
        return addressDTO;
    }

}
