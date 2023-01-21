package com.minispring.minispring.repository;

import com.minispring.minispring.model.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface SalesOrderRepository extends JpaRepository<SalesOrder,Long> {
}
