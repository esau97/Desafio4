package com.esauhp.desafio4.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.LinkedList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryI{
    @Autowired
    private EntityManager entityManager;

    // Nos permite consultar con nuestra base de datos si existe un cliente con el mismo nombre, si existe uno o más de un cliente se devuelve una lista con todos ellos
    @Override
    public List<Customer> findByName(String nombre) {
        String consulta ="FROM Customer WHERE nombre=:nombre";
        List<Customer> customerList = entityManager.createQuery(consulta)
                .setParameter("nombre",nombre)
                .getResultList();
        if(customerList.isEmpty()){
            return new LinkedList<>();
        }
        return customerList;
    }

    // Esta consulta nos devuelve el cliente (En caso de que este exista)
    @Override
    public Customer getClientes(Customer customer) {
        String consulta ="FROM Customer WHERE nombre=:nombre";
        List<Customer> customerList = entityManager.createQuery(consulta)
                .setParameter("nombre", customer.getName())
                .getResultList();
        if(customerList.isEmpty()){
            return null;
        }
        return customerList.get(0);
    }

    // Se obtiene la lista de los clientes que se encuentran en la base de datos
    @Override
    public List<Customer> getCustomersList() {
        String consulta = "FROM Customer";
        List<Customer> customerList = entityManager.createQuery(consulta)
                .getResultList();
        if(customerList.isEmpty()){
            return null;
        }
        return customerList;
    }

    // Añadimos un nuevo cliente
    @Override
    public void addCustomer(Customer customer) {
        entityManager.merge(customer);
    }

    // Eliminamos un cliente dado su id
    @Override
    public void deleteCustomer(long id) {
        Customer customer = entityManager.find(Customer.class,id);
        entityManager.remove(customer);
    }

    // Si el cliente existe en la base de datos lo actualiza
    @Override
    public void updateCustomer(Customer customer) {
        entityManager.merge(customer);
    }

}
