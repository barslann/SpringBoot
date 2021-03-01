package com.coderman.hibernateentityrelationsexample.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@SecondaryTable(name = "address")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @OneToMany
    private Set<Pet> pets = new HashSet<>();

    private Address address;

}

/*
    ONE-TO-ONE
        -JoinColumn - var olan entityde yeni column olusturmak icin kullaniliyor
            -name attribute - column adi
            -referencedColumnName - diger entityden hangi kolonun referans olarak alinacagi

         -JoinTable - iki enitity iliskisini yeni tabloda olusturmak istenirse kullaniliyor
            -name attribute - column adi
            -joinColumns = @JoinColumn(name = "owner_id") - o an ki entitynin primary key kolonuna isim vermek icin yapiliyot
                eger kullanilmazsa kolon adi "id" olarak yapiyor
            -inverseJoincolumns a gerek yok. Cunku kendi hazir olarak diger entitynin adini "id" ekleyerek database koyuyor
                ex: "address_id"

        Çift yönlü ilişkilerde ayrıca @JoinTable veya @JoinColumn annotasyonları da ilişkiyi yöneten taraf üzerinden tanımlanmak zorundadır.
        Aksi takdirde JPA/Hibernate hata verecektir.


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")

 */