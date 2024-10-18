package br.com.cinemafilme.security.services;

import br.com.cinemafilme.security.Util.Util;
import br.com.cinemafilme.security.dtos.AddressRequestDTO;
import br.com.cinemafilme.security.dtos.AddressResponseDTO;
import br.com.cinemafilme.security.entities.Address;
import br.com.cinemafilme.security.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    Util util;
    @Autowired
    AddressRepository addressRepository;
    /*
    public AddressResponseDTO searchAddress(String cep, Integer numero) {

        AddressResponseDTO viacep = util.searchAddress(cep, numero);

        AddressResponseDTO address = new AddressResponseDTO();
        address.setCep(viacep.getCep());
        address.setLogradouro(viacep.getLogradouro());
        address.setNumero(numero);
        address.setBairro(viacep.getBairro());
        address.setLocalidade(viacep.getLocalidade());
        address.setUf(viacep.getUf());
        address.setEstado(viacep.getEstado());
        return address;
    }*/

    public AddressResponseDTO searchAddress(AddressRequestDTO addressRequestDTO) {
        AddressResponseDTO viaCepRequest = util.searchAddress(addressRequestDTO.getCep());

        AddressResponseDTO address = new AddressResponseDTO();
        address.setCep(viaCepRequest.getCep());
        address.setLogradouro(viaCepRequest.getLogradouro());
        address.setNumero( addressRequestDTO.getNumero());
        address.setBairro(viaCepRequest.getBairro());
        address.setLocalidade(viaCepRequest.getLocalidade());
        address.setUf(viaCepRequest.getUf());
        address.setEstado(viaCepRequest.getEstado());

        Address convertAddress = address.toAddress(address);
        addressRepository.save(convertAddress);
        return address;

    }
}







