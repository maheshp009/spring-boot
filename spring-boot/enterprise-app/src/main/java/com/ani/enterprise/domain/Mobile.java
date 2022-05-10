package com.ani.enterprise.domain;

import lombok.*;

import java.util.Objects;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Mobile { // object of these classes will represent rows, class represents table
    private Long id;
    private String number;
    private String country;
    private Boolean isDualSim;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mobile mobile = (Mobile) o;
        return Objects.equals(id, mobile.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
