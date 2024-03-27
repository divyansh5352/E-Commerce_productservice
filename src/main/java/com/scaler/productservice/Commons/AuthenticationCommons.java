package com.scaler.productservice.Commons;

import com.scaler.productservice.DTO.userDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class AuthenticationCommons {
    private RestTemplate restTemplate;
    public AuthenticationCommons( RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    public userDTO validateToken(String token ){
        ResponseEntity<userDTO>userDTOResponseEntity =
        restTemplate.postForEntity(
                "http://localhost:8181.users/validate/"+ token,
                null,
                userDTO.class);

        if ( userDTOResponseEntity.getBody() == null ){
            return null;
        }
        return userDTOResponseEntity.getBody();
    }
}
