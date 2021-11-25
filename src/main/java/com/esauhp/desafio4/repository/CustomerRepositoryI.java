package com.esauhp.desafio4.repository;

import java.util.List;

public interface CustomerRepositoryI {
    List<Customer> findByName(String nombre);
    Customer getClientes(Customer customer);
    List<Customer> getCustomersList();
    void addCustomer(Customer customer);
    void deleteCustomer(long id);
    void updateCustomer(Customer customer);
}
