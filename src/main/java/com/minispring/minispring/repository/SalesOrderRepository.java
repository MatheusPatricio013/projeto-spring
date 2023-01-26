package com.minispring.minispring.repository;

import com.minispring.minispring.model.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesOrderRepository extends JpaRepository<SalesOrder,Long> {
    @Query("select * from salesOrder where externalReference = ?")
    SalesOrder findByExternalReference(String external);
}
