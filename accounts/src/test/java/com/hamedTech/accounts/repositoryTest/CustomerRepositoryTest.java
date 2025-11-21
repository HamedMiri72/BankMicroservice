package com.hamedTech.accounts.repositoryTest;

import com.hamedTech.accounts.entity.Customer;
import com.hamedTech.accounts.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Testcontainers
@ActiveProfiles("test")
public class CustomerRepositoryTest {

    @Container
    static MySQLContainer<?> mysqlContainer = new MySQLContainer<>("mysql:8.0")
            .withDatabaseName("accountstestdb")
            .withUsername("root")
            .withPassword("root");

    @DynamicPropertySource
    static void registerDynamicPropertySource(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysqlContainer::getJdbcUrl);
        registry.add("spring.datasource.username", mysqlContainer::getUsername);
        registry.add("spring.datasource.password", mysqlContainer::getPassword);
    }

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testFindCustomerByMobileNumber() {

        Customer customer = new Customer();
        customer.setName("hamed miri");
        customer.setEmail("hamedmiri72@gmail.com");
        customer.setMobileNumber("7355848222");

        customerRepository.save(customer);

        Optional<Customer> result =
                customerRepository.findCustomerByMobileNumber("7355848222");

        assertTrue(result.isPresent());
        assertEquals("hamed miri", result.get().getName());
    }
}
