package com.rakib.jwtsecurity.user;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public class BaseEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
}
