package com.esauhp.desafio4.repository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@ToString
@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column (name="id")
    private long id;
    @Getter @Setter @Column (name="nombre")
    private String name;
    @Getter @Setter @Column (name="apellidos")
    private String lastName;

    //@Temporal(TemporalType.DATE) @Getter @Column (name="fecha_nac")
    @Getter @Column (name="fecha_nac")
    private String dateN;

    public void setDateN(String dateN) {
        this.dateN = dateN;
    }

    @Getter @Setter @Column (name="dni")
    private String dni;


    public Customer(){

    }

    public Customer(String name, String lastName, String dateN, String dni) {
        this.name = name;
        this.lastName = lastName;
        /*SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.dateN = formatter.parse(dateN);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        this.dateN=dateN;
        this.dni = dni;
    }
}
