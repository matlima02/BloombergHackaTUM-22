package src.main.java.com.example.soundx.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import src.main.java.com.example.soundx.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
