package com.hamedTech.loans.mapper;
import com.hamedTech.loans.dto.LoansDto;
import com.hamedTech.loans.entity.Loans;

public class LoansMapper {


    public static LoansDto toLoansDto(Loans loans, LoansDto loansDto){

        loansDto.setLoanType(loans.getLoanType());
        loansDto.setLoanNumber(loans.getLoanNumber());
        loansDto.setTotalLoan(loans.getTotalLoan());
        loansDto.setAmountPaid(loans.getAmountPaid());
        loansDto.setMobileNumber(loans.getMobileNumber());
        loansDto.setOutstandingAmount(loans.getOutstandingAmount());

        return loansDto;
    }


    public static Loans toLoans(LoansDto loansDto, Loans loans){

        loans.setLoanType(loansDto.getLoanType());
        loans.setLoanNumber(loansDto.getLoanNumber());
        loans.setMobileNumber(loansDto.getMobileNumber());
        loans.setTotalLoan(loansDto.getTotalLoan());
        loans.setAmountPaid(loansDto.getAmountPaid());
        loans.setOutstandingAmount(loansDto.getOutstandingAmount());


        return loans;
    }
}
