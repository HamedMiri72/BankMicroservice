package com.hamedTech.accounts.service.impl;

import com.hamedTech.accounts.dto.AccountsDto;
import com.hamedTech.accounts.dto.CardDto;
import com.hamedTech.accounts.dto.CustomerDetailsDto;
import com.hamedTech.accounts.dto.LoansDto;
import com.hamedTech.accounts.entity.Accounts;
import com.hamedTech.accounts.entity.Customer;
import com.hamedTech.accounts.exception.ResourceNotFoundException;
import com.hamedTech.accounts.mapper.AccountsMapper;
import com.hamedTech.accounts.mapper.CustomerDetailsMapper;
import com.hamedTech.accounts.mapper.CustomerMapper;
import com.hamedTech.accounts.repository.AccountRepository;
import com.hamedTech.accounts.repository.CustomerRepository;
import com.hamedTech.accounts.service.ICustomerDetailsService;
import com.hamedTech.accounts.service.client.CardsFeignClient;
import com.hamedTech.accounts.service.client.LoansFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerDetailsServiceImpl implements ICustomerDetailsService {


    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    private final CardsFeignClient cardsFeignClient;
    private final LoansFeignClient loansFeignClient;


    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findCustomerByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "Mobile Number", mobileNumber));

        Accounts accounts = accountRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Account", "CustomerId", customer.getCustomerId().toString()));

        CustomerDetailsDto customerDetailsDto = CustomerDetailsMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToDto(accounts, new AccountsDto()));

        ResponseEntity<CardDto> cardDtoResponseEntity = cardsFeignClient.fetchCardsDetails(mobileNumber);
        customerDetailsDto.setCardDto(cardDtoResponseEntity.getBody());

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        return customerDetailsDto;

    }
}
