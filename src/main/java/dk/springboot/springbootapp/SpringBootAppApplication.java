package dk.springboot.springbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class SpringBootAppApplication {

    private final CustomerRepository customerRepository;

    public SpringBootAppApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAppApplication.class, args);
    }

    private Response greet() {
        return new Response("Smack You Up EP");
    }

    private record Response(String msg) {
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping
    public void getCustomer(@RequestBody CustomerRequest request) {
        Customer customer = new Customer();
        customer.setAge(request.age());
        customer.setName(request.name());
        customer.setEmail(request.email());
        customerRepository.save(customer);
    }

    @DeleteMapping("{customerID}")
    public void deleteCustomer(@PathVariable("customerID") Long id) {
        //todo: perform business logic, if id exists. etc..
        customerRepository.deleteById(id);
    }

//    @PatchMapping("{customerID}")
//    public void updateCustomer(@PathVariable("customerID") Long id) {
//        customerRepository.
//    }
}
