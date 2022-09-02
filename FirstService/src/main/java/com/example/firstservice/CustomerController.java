package com.example.firstservice;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CustomerController{

    private List<Customer> customers ;

    public CustomerController() {
        customers = new ArrayList<>();
        customers.add(new Customer("101", "Joh" , "Male", 25));
        customers.add(new Customer("1018", "Peter", "Male", 24));
        customers.add(new Customer("1019", "Sara", "Female", 23));
        customers.add(new Customer("1110", "Rose", "Female", 23));
        customers.add(new Customer("1001", "Emma", "Female", 30));
        // ✨ New! 👇 Populate the in-memory store ✨
//        this.customers.addAll(defaultItems());
    }

//    private static List<Customer> defaultItems() {
//        return List.of(
//                new Customer("101", "John" , "Male", 25),
//                new Customer("1018", "Peter", "Male", 24),
//                new Customer("1019", "Sara", "Female", 23),
//                new Customer("1110", "Rose", "Female", 23),
//                new Customer("1001", "Emma", "Female", 30)
//        );
//    }



    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getCustomers() {

        return customers;
    }
    @RequestMapping(value = "/customerbyid/{id}", method = RequestMethod.GET)
    public Customer getCustomerByID(@PathVariable("id") String ID){

            for (Customer customer : customers) {
                if (customer.getID().equals(ID)) {
                    return customer;
                }
            }
        return null;
    }
    @RequestMapping(value = "/customerbyname/{n}", method = RequestMethod.GET)
    public Customer getCustomerByName(@PathVariable("n") String n) {
        for (Customer customer : customers) {
            if (customer.getName().equals(n)) {
                return customer;
            }
        }
        return null;
    }
    @RequestMapping(value = "/customerDelByid/{id}", method = RequestMethod.DELETE)
    public boolean delCustomerByID(@PathVariable("id") String ID){
        Customer keep = new Customer();
        for (Customer customer : customers) {
            System.out.println(customer.getName());
            if (customer.getID().equals(ID)) {
                keep = customer;
            }
        }
        this.customers.remove(keep);
        return true;
    }
    @RequestMapping(value = "/customerDelByname/{n}", method = RequestMethod.DELETE)
    public boolean delCustomerByName(@PathVariable("n") String n){
        Customer keep = new Customer();
        for (Customer customer : customers) {
            System.out.println(customer.getName());
            if (customer.getName().equals(n)) {
                keep = customer;
            }
        }
        this.customers.remove(keep);
        return true;
    }
    @RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
    public boolean addCustomer(@RequestParam("id") String ID, @RequestParam("name") String n, @RequestParam("sex") String s, @RequestParam("age") int a){
        this.customers.add(new Customer(ID, n, s, a));
        return true;
    }
    @RequestMapping(value = "/addCustomer2", method = RequestMethod.POST)
    public boolean addCustomer2(@RequestParam("id") String ID, @RequestParam("name") String n, @RequestParam("sex") String s, @RequestParam("age") int a){
        this.customers.add(new Customer(ID, n, s, a));
        return true;
    }
}
