package com.hamedTech.loans.repository;

import com.hamedTech.loans.entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoansRepository extends JpaRepository<Loans, Long> {

    Optional<Loans> findLoansByMobileNumber(String mobileNumber);


}
