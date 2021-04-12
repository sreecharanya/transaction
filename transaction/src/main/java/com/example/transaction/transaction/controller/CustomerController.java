package com.example.transaction.transaction.controller;


import com.example.transaction.customermodel.Customer;
import com.example.transaction.customermodel.CustomerDetails;
import com.example.transaction.customermodel.NewCustomer;
import com.example.transaction.transaction.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
public class CustomerController {

    @Autowired(required=true)
    private CustomerService customerService;

    @Autowired
    private Long id;


    @PostMapping(path = "/register")
    public String registerCustomer(@RequestBody NewCustomer newCustomer) {
        List<Customer> customers = new ArrayList<>();
        customers = customerService.getAllCustomers();
        boolean validCustomer = false;
        String statusMsg = null;
        Customer saveCustomer = new Customer();
        if (newCustomer != null) {

            if (newCustomer.getCustomerName() != "") {

                if (customers != null && customers.size() > 0) {
                    statusMsg = "Hi Customer";
                    return statusMsg;
                } else {
                    validCustomer = true;
                }
            } else {
                statusMsg = "Enter valid name";
                return statusMsg;

            }
        } else {
            statusMsg = "Enter valid name";
            return statusMsg;
        }

        if (validCustomer) {
            saveCustomer.setCustomerName(newCustomer.getCustomerName());

            customerService.saveCustomer(saveCustomer);
            statusMsg = "Customer successfully registered";
        }
        return statusMsg;
    }

    @GetMapping(path = "/maketransaction/{id}")
    @ResponseBody
    public CustomerDetails makeTransaction(@PathVariable("id") Long id){

        Customer customer =customerService.getCustomerDetailsById(id);
        CustomerDetails customerDetails=new CustomerDetails();

        if(customer !=null){
            customerDetails.setCustomerId(customer.getCustomerId());
            customerDetails.setCustomerName(customer.getCustomerName());
            customerDetails.setMonth(customer.getMonth());
            customerDetails.setAmount(customer.getAmount());
            if(customer.getAmount()>50 && customer.getAmount()<100){
                customer.setPoints((int) (customer.getAmount()-50));
            }else {
                if(customer.getAmount()>100)
                {
                    customer.setPoints((int) ((customer.getAmount()-100)*2+50));
                }else
                {
                    customer.setPoints(0);
                }
            }
        }
customerService.saveCustomer(customer);
        return customerDetails;
    }

    @GetMapping(path = "/viewPoints/{id}")
    @ResponseBody
    public CustomerDetails viewPoints(@PathVariable("id") Long id){

        Customer customer =customerService.getCustomerDetailsById(id);
        CustomerDetails customerDetails=new CustomerDetails();

        if(customer !=null){
            customerDetails.setCustomerId(customer.getCustomerId());
            customerDetails.setCustomerName(customer.getCustomerName());
            customerDetails.setMonth(customer.getMonth());
            customerDetails.setAmount(customer.getAmount());
            if(customer.getAmount()>50 && customer.getAmount()<100){
                customer.setPoints((int) (customer.getAmount()-50));
            }else {
                if(customer.getAmount()>100)
                {
                    customer.setPoints((int) ((customer.getAmount()-100)*2+50));
                }else
                {
                    customer.setPoints(0);
                }
            }
        }
        customerService.saveCustomer(customer);
        return customerDetails;
    }


}
