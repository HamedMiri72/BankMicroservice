package com.hamedTech.accounts.mapper;

import com.hamedTech.accounts.dto.CustomerDto;
import com.hamedTech.accounts.entity.Customer;

public class CustomerMapper {


    public static CustomerDto mapToCustomerDto(Customer customer, CustomerDto customerDto){

        customerDto.setEmail(customer.getEmail());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());

        return customerDto;
    }



    public static Customer mapToCustomerDto(CustomerDto customerDto, Customer customer){

        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());

        return customer;
    }
}
