package whu.csy.test_1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import whu.csy.test_1.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
