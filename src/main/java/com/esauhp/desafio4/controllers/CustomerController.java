package com.esauhp.desafio4.controllers;


import com.esauhp.desafio4.repository.Customer;
import com.esauhp.desafio4.services.CustomerManagementServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/home/en/")
public class CustomerController {
    @Autowired
    private CustomerManagementServiceI customerManagementServiceI;


    @GetMapping("/searchByName")
    public String findByNameForm(Model model){
        return "/findByName";
    }

    // Al buscar clientes por el nombre, mostramos una lista con todos los clientes que tengan ese mismo nombre (Si no hay ningún cliente se muestra vacío)
    @PostMapping("/findCustomer")
    public String searchByName(@ModelAttribute Customer newCustomer,Model model)
    {
        String name =newCustomer.getName();
        System.out.println(name);
        List<Customer> customerList = customerManagementServiceI.findByName(name);
        model.addAttribute("customerList",customerList);
        System.out.println("Esta vacia "+customerList.isEmpty());

        return "showCustomersView";
    }

    // Obtenemos la lista con todos los clientes y la mostramos
    @GetMapping("/customers")
    public String getCustomer(Model model){
        List<Customer> customerList =  customerManagementServiceI.getCustomersList();
        model.addAttribute("customerList",customerList);

        return "/showCustomersView";
    }

    // Se muestra la vista con el formulario para crear el nuevo cliente
    @GetMapping("/newCustomer")
    public String newCustomerForm(Model model) {
        return "/newCustomerView";
    }


    // Creamos un nuevo cliente y lo añadimos a la base de datos. Al añadirlo, redireccionamos para mostrar la lista de clientes con el nuevo cliente añadido
    @PostMapping("/createCustomer")
    public String saveCustomer(@ModelAttribute Customer newCustomer, Model model) {

        // Se retorna actualizado al modelo.
        model.addAttribute("newCustomer", newCustomer);
        customerManagementServiceI.addCustomer(newCustomer);

        return "redirect:./customers";
    }
}
