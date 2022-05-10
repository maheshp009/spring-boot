package com.ani.enterprise.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.*;


@JacksonXmlRootElement(localName = "Mobile")
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MobileDto {

    @JacksonXmlProperty
    private Long id;

    @JacksonXmlProperty
    private String number;

    @JacksonXmlProperty
    private String country;

    @JacksonXmlProperty
    private Boolean isDualSim;
}
