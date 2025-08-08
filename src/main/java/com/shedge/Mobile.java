package com.shedge;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "owner")
public class Mobile {
    private String Model;
    private short year;
    private String owner;
}
