package nl.gettoworktogether.spring_data_jpa.repository;

import nl.gettoworktogether.spring_data_jpa.model.Customer;

//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public Collection<Customer> findAllByLastName(String name);

//    @Query("SELECT c FROM customers c WHERE LOWER(c.first_name) = LOWER(:name)")
//    Customer retrieveByFirstName(@Param("name") String name);

}