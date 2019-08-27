package net.proselyte.springsecurityapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDto {
    String request;
    String username;
    Long price;
}
