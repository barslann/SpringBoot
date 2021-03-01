package com.coderman.hibernateentityrelationsexample.entity;

import javax.persistence.*;


@Embeddable
public class Address {
    @Column(table = "address")
    private String street;
    @Column(table = "address")
    private String city;
    @Column(table = "address")
    private String state;
    @Column(table = "address")
    @Transient
    private long zipcode;
}

/*
    One-to-One
        -@OneToOne(mappedBy = "address")
        - her iki tarafda iliski kurulursa hibernate e bunu soylemek gerekiyor
        -İlişkiyi çift yönlü yapmak istersek bu durumda @OneToOne annotasyonu ilişkinin diğer tarafına da konmalıdır.
            Bu durumda Hibernate’in iki entity arasındaki ilişkiyi kurmak veya kaldırmak için uygulama kodu içerisinde hangi taraftaki property üzerinde yapılan değişiklikleri dikkate alması gerektiğini söylememiz gerekir.
            Bunun için @OneToOne annotasyonundaki mappedBy attribute’u kullanılır

 */