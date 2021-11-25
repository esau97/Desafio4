package com.esauhp.desafio4;

import com.esauhp.desafio4.config.AppContext;
import com.esauhp.desafio4.repository.Customer;
import com.esauhp.desafio4.services.CustomerManagementServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Desafio4Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Desafio4Application.class, args);
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		Customer c = ctx.getBean(Customer.class);
		System.out.println("***************************************************************");
		System.out.println(c.toString());
		System.out.println("***************************************************************");
	}

	// Servicio
	@Autowired
	private CustomerManagementServiceI customerManagementServiceI;


	@Override
	public void run(String... args) throws Exception {
		/**
		 * Creamos un nuevo cliente
		 */
		/*
			Cliente cliente1 = new Cliente("Antonio","Garcia Benitez","2021-04-05","483959483Q");
			clienteManagementServiceI.addClientes(cliente1);
		*/


		//ApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		//Customer customer1 = ctx.getBean(Customer.class);
		/**
		 * Obtenemos el cliente que acabamos de crear para comprobar si nos lo ha añadido correctamente
		 */
		/*Customer customer2 = customerManagementServiceI.getClientes(customer1);
		if(customer2 !=null){
			System.out.println("**************************************************************");
			System.out.println(customer2.toString());
			System.out.println("**************************************************************");
		}*/
	}
}
