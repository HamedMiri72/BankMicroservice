package com.hamedTech.loans.service.impl;

import com.hamedTech.loans.dto.LoansDto;
import com.hamedTech.loans.repository.LoansRepository;
import com.hamedTech.loans.service.ILoansService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements ILoansService {

    private final LoansRepository loansRepository;


    @Override
    public void createLoan(LoansDto loansDto) {


    }

    @Override
    public LoansDto fetchLoanDetails(String mobileNumber) {
        return null;
    }

    @Override
    public boolean updateLoanDetails(LoansDto loansDto) {
        return true;
    }

    @Override
    public boolean deleteLoanDetails(String mobileNumber) {
        return true;
    }
}
