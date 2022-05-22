package com.seogineer.springbootmultilanguage.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Languages {
    @Id @GeneratedValue
    private Integer id;
    private String locale;
    private String messageKey;
    private String messageContent;
}
