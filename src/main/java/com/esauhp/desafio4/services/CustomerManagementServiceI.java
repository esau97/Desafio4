package com.esauhp.desafio4.services;

import com.esauhp.desafio4.repository.Customer;

import java.util.List;

public interface CustomerManagementServiceI {
     List<Customer> findByName(String nombre);
     Customer getClientes(Customer customer);
     List<Customer> getCustomersList();
     void addCustomer(Customer customer);
     void deleteCustomer(long id);
     void updateCustomer(Customer customer);
}
