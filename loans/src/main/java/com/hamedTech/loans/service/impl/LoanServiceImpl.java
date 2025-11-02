package com.hamedTech.loans.service.impl;

import com.hamedTech.loans.constants.LoansConstants;
import com.hamedTech.loans.dto.LoansDto;
import com.hamedTech.loans.entity.Loans;
import com.hamedTech.loans.exception.LoansAlreadyExists;
import com.hamedTech.loans.repository.LoansRepository;
import com.hamedTech.loans.service.ILoansService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements ILoansService {

    private final LoansRepository loansRepository;


    @Override
    public void createLoan(String mobileNumber) {

        Optional<Loans> loans = loansRepository.findLoansByMobileNumber(mobileNumber);

        if(loans.isPresent()){
            throw new LoansAlreadyExists("Loan is Alreasy exists for use with moile number" + mobileNumber);
        }

        loansRepository.save(createNewLoans(mobileNumber));


    }

    private Loans createNewLoans(String mobileNumber) {

        Loans newLoan = new Loans();

        newLoan.setMobileNumber(mobileNumber);

        Long randomNumber = 100000000000L + new Random().nextLong(90000000000L);

        newLoan.setLoanNumber(randomNumber.toString());
        newLoan.setLoanType(LoansConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);

        return newLoan;


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
