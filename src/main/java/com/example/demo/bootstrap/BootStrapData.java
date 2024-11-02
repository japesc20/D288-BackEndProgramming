package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;


@Component
public class BootStrapData implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(BootStrapData.class);
    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        /**
         * Array [5] of sample customers including all non-null fields + division id
         * First name, last name, address, zipcode, phone number, division id (divID: start with 2)
         */
        String[][] sampleCustomerArray = {
                {"Jakob", "Petrakovics", "123 Eazy St", "48188", "(515)515-5155", "2"},
                {"Kirstie", "Steelans", "1752 Later Blvd", "23755", "(335)345-6256", "3"},
                {"Karson", "Lett", "11236 Earlier Dr", "71563", "(157)987-3345", "4"},
                {"Steven", "Krokoski", "14 Past Rd", "99123", "(100)343-3445", "5"},
                {"Theodore", "Mzozchivsky", "789 Moment St", "10098", "(554)246-7566", "6"},
        };

        // Add sample customers to data
        for (int i=0; i < Arrays.stream(sampleCustomerArray).count(); ++i) {

            if(customerRepository.count() > 5) {
                log.info(String.valueOf("Number of customers in Repo: " + customerRepository.count()));
                return;
            }

            // Instantiate a new Customer object
            Customer newCustomer = new Customer();

            // Use setters for all new customer fields
            newCustomer.setFirstName(sampleCustomerArray[i][0]);
            newCustomer.setLastName(sampleCustomerArray[i][1]);
            newCustomer.setAddress(sampleCustomerArray[i][2]);
            newCustomer.setPostal_code(sampleCustomerArray[i][3]);
            newCustomer.setPhone(sampleCustomerArray[i][4]);

            // Set division ID for customer
            Long divisionId = Long.valueOf(sampleCustomerArray[i][5]);
            Division division = divisionRepository.findById(divisionId)
                    .orElseThrow(() -> new IllegalArgumentException("Division not found for ID: " + divisionId));
            newCustomer.setDivision(division);

            customerRepository.save(newCustomer);

//            // Debugger to make sure each customer is saved
//            log.info("Saved new customer: " + newCustomer.getFirstName() + " " + newCustomer.getLastName());
        }
//        // Debugging - Not populating in DB
//        log.info("Number of customers after saving: " + customerRepository.count());
//        List<Customer> customers = customerRepository.findAll();
//        customers.forEach(customer -> log.info("Customer in DB: " + customer.getFirstName() + " " + customer.getLastName()));
    }
}
