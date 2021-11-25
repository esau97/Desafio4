package com.esauhp.desafio4.services;

import com.esauhp.desafio4.repository.Customer;
import com.esauhp.desafio4.repository.CustomerRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerManagementImpl implements CustomerManagementServiceI {


    @Autowired
    private CustomerRepositoryI customerRepositoryI;

    // Nos permite consultar con nuestra base de datos si existe un cliente con el mismo nombre, si existe uno o más de un cliente se devuelve una lista con todos ellos
    @Override
    public List<Customer> findByName(String nombre) {
        return customerRepositoryI.findByName(nombre);
    }

    // Esta consulta nos devuelve el cliente (En caso de que este exista)
    @Override
    public Customer getClientes(Customer customer) {
        return customerRepositoryI.getClientes(customer);
    }

    // Se obtiene la lista de los clientes que se encuentran en la base de datos
    @Override
    public List<Customer> getCustomersList() {
        return customerRepositoryI.getCustomersList();
    }

    // Añadimos un nuevo cliente
    @Override
    public void addCustomer(Customer customer) {
        customerRepositoryI.addCustomer(customer);
    }

    // Eliminamos un cliente dado su id
    @Override
    public void deleteCustomer(long id) {
        customerRepositoryI.deleteCustomer(id);
    }

    // Si el cliente existe en la base de datos lo actualiza
    @Override
    public void updateCustomer(Customer customer) {
        customerRepositoryI.updateCustomer(customer);
    }


}
