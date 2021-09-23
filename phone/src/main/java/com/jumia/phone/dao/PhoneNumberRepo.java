package com.jumia.phone.dao;

import com.jumia.phone.entity.PhoneNumber;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface PhoneNumberRepo extends JpaRepository<PhoneNumber, Long> {
    @Query(
        value = "SELECT * FROM CUSTOMER c WHERE c.phone REGEXP ? ORDER BY c.id",
        countQuery = "SELECT COUNT(*) FROM CUSTOMER",
        nativeQuery = true
    )
    public Page<PhoneNumber> findAndFilter(String regex, Pageable pageable) ;
}
