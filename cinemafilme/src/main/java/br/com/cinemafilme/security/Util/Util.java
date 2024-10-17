package br.com.cinemafilme.security.Util;

import br.com.cinemafilme.security.entities.Address;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Util {
    public Address searchAddress(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://viacep.com.br/ws/{cep}/json/", Address.class, cep);
    }
}
