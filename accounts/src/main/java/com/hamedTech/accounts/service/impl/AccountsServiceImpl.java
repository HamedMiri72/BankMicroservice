package com.hamedTech.accounts.service.impl;

import com.hamedTech.accounts.constants.AccountsConstants;
import com.hamedTech.accounts.dto.AccountsDto;
import com.hamedTech.accounts.dto.CustomerDto;
import com.hamedTech.accounts.entity.Accounts;
import com.hamedTech.accounts.entity.Customer;
import com.hamedTech.accounts.exception.CustomerAlreadyExistsException;
import com.hamedTech.accounts.exception.ResourceNotFoundException;
import com.hamedTech.accounts.mapper.AccountsMapper;
import com.hamedTech.accounts.mapper.CustomerMapper;
import com.hamedTech.accounts.repository.AccountRepository;
import com.hamedTech.accounts.repository.CustomerRepository;
import com.hamedTech.accounts.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AccountsServiceImpl implements IAccountService {


    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    /**
     * create account
     * @param customerDto
     */
    @Override
    public void createAccounts(CustomerDto customerDto) {


        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findCustomerByMobileNumber(customerDto.getMobileNumber());

        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistsException("Customer with mobile number provided exists: "+ customerDto.getMobileNumber());
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Hamed miri");

        Customer savedCustomer = customerRepository.save(customer);

        accountRepository.save(createNewAccounts(savedCustomer));

    }



    private Accounts createNewAccounts(Customer customer){

        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());

        Long randomAccountNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccountNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Hamed miri");

        return newAccount;

    }

    /**
     *
     * @param mobileNumber
     * @return
     */
    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findCustomerByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "MobileNumber", mobileNumber));

        Accounts accounts = accountRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString()));

        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountsDto(AccountsMapper.mapToDto(accounts, new AccountsDto()));

        return customerDto;
    }

    /**
     *
     * @param customerDto
     * @return
     */
    @Override
    public Boolean updateAccount(CustomerDto customerDto) {

        boolean isUpdated = false;

        AccountsDto accountsDto = customerDto.getAccountsDto();

        if(accountsDto != null){
            Accounts accounts = accountRepository.findById(accountsDto.getAccountNumber())
                    .orElseThrow(() -> new ResourceNotFoundException("Account", "accountNumber", accountsDto.getAccountNumber().toString()));

            AccountsMapper.mapToEntity(accountsDto, accounts);
            accounts = accountRepository.save(accounts);

            Long customerId = accounts.getCustomerId();

            Customer customer = customerRepository.findById(customerId)
                    .orElseThrow(() -> new ResourceNotFoundException("Customer", "customerId", customerId.toString()));

            CustomerMapper.mapToCustomer(customerDto, customer);
            customer = customerRepository.save(customer);

            isUpdated = true;

        }

        return isUpdated;

    }

    @Override
    public boolean deleteAccount(String mobileNumber) {

        Customer customer = customerRepository.findCustomerByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));

//        Accounts accounts = accountRepository.findByCustomerId(customer.getCustomerId())
//                        .orElseThrow(() -> new ResourceNotFoundException("Account", "CustomerId", customer.getCustomerId().toString()));
//
//
//        accountRepository.deleteById(accounts.getAccountNumber());

        accountRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());

        return true;

    }


}
