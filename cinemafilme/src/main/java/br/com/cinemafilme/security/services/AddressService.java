package br.com.cinemafilme.security.services;

import br.com.cinemafilme.security.Util.Util;
import br.com.cinemafilme.security.dtos.AddressRequestDTO;
import br.com.cinemafilme.security.dtos.AddressResponseDTO;
import br.com.cinemafilme.security.entities.Address;
import br.com.cinemafilme.security.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    Util util;
    @Autowired
    AddressRepository addressRepository;


    public AddressResponseDTO saveAddress(AddressRequestDTO addressRequestDTO) {
        AddressResponseDTO viaCepRequest = util.searchAddress(addressRequestDTO.getCep());

        AddressResponseDTO address = new AddressResponseDTO();
        address.setCep(viaCepRequest.getCep());
        address.setLogradouro(viaCepRequest.getLogradouro());
        address.setNumero(addressRequestDTO.getNumero());
        address.setBairro(viaCepRequest.getBairro());
        address.setLocalidade(viaCepRequest.getLocalidade());
        address.setUf(viaCepRequest.getUf());
        address.setEstado(viaCepRequest.getEstado());


        Address convertAddress = address.toAddress(address);
        Address savedAddress = addressRepository.save(convertAddress);
        address.setId(savedAddress.getId());

        return address;

    }

    public Address findById(Integer id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        return optionalAddress.orElseThrow(() -> new RuntimeException("Address not found with id: " + id));

    }
}






