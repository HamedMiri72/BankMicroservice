package com.hamedTech.loans.service;

import com.hamedTech.loans.dto.LoansDto;

public interface ILoansService {


    /**
     *
     * @param loansDto
     */
    void createLoan(String mobileNumber);

    /**
     *
     * @param mobileNumber
     * @return
     */
    LoansDto fetchLoanDetails(String mobileNumber);

    /**
     *
     * @param loansDto
     * @return
     */
    boolean updateLoanDetails(LoansDto loansDto);

    /**
     *
     * @param mobileNumber
     * @return
     */
    boolean deleteLoanDetails(String mobileNumber);
}
