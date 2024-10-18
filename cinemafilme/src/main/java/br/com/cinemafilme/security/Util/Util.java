package br.com.cinemafilme.security.Util;

import br.com.cinemafilme.security.dtos.AddressResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Util {
    public AddressResponseDTO searchAddress(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://viacep.com.br/ws/{cep}/json/", AddressResponseDTO.class, cep);
    }
}
