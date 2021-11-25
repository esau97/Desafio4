package com.esauhp.desafio4.config;

import com.esauhp.desafio4.repository.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppContext {

    @Bean
    public Customer cliente() {
        //Cliente cliente = new Cliente("Antonio","Garcia Benitez","2021-04-05","483959483Q");
        Customer customer = new Customer();
        customer.setName("Antonio");
        customer.setLastName("Garcia Benitez");
        /*SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            customer.setDateN(formatter.parse("2021-04-05"));
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        customer.setDateN("2021-04-05");
        customer.setDni("483959483Q");
        return customer;
    }
}
