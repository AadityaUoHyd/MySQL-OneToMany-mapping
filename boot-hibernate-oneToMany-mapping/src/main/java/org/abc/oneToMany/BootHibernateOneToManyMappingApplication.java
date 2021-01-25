package org.abc.oneToMany;

import org.abc.oneToMany.Repo.CustomerRepo;
import org.abc.oneToMany.model.Customer;
import org.abc.oneToMany.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootHibernateOneToManyMappingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BootHibernateOneToManyMappingApplication.class, args);
	}

	@Autowired
	private CustomerRepo custRepo;

	//I'm testing via CLI, one can use POST and GET using controller.
	@Override
	public void run(String... args) throws Exception {

		//Hard-coding Customer details for test.
		Customer cust = new Customer("Aadi", "aadi@gmail.com");

		//Hard-Coding Order details of above customer for test.
		Order order1 = new Order("My 1st Order as Book");
		Order order2 = new Order("My 2nd Order as Pen");
		Order order3 = new Order("My 3rd Order as Pencil");

		cust.getOrders().add(order1);
		cust.getOrders().add(order2);
		cust.getOrders().add(order3);

		//Saving in usersdb database of MySQL. 
		this.custRepo.save(cust);
	}
}