package com.example.Springdata;

import com.example.Springdata.Entity.Customer;
import com.example.Springdata.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringdataApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringdataApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringdataApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository customerRepository){
	return(args) -> {
			//save fe customers
		customerRepository.save(new Customer("Mohit","Banyal"));
		customerRepository.save(new Customer("Jasgeet", "kour"));
		customerRepository.save(new Customer("Puneet", "Banyal"));
		customerRepository.save(new Customer("Sanampreet", "kour"));

		log.info("Customer found with findAll()");
		log.info("-----------------------------");
		customerRepository.findAll().forEach(customer ->{
			log.info(customer.toString());
		});

		log.info("");
		log.info("Customer found with findById(1L)");
		log.info("-----------------------------");
		log.info(customerRepository.findById(1).toString());

		log.info("");
		log.info("Customer found with findBylastName(Banyal)");
		log.info("-----------------------------");
		customerRepository.findByLastName("Banyal").forEach(customer ->{
			log.info(customer.toString());
		});
		log.info("");
		};
	}
}
