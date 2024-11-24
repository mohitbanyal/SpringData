package com.example.Springdata.repository;

import com.example.Springdata.Entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "customer", path = "people")
public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long>, CrudRepository<Customer,Long> {

    List<Customer> findByLastName(@Param("name") String lastName);

    Customer findById(long id);
}
