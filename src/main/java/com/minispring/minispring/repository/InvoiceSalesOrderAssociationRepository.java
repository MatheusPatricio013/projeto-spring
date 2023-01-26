package com.minispring.minispring.repository;

import com.minispring.minispring.model.Invoice;
import com.minispring.minispring.model.InvoiceSalesOrderAssociation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceSalesOrderAssociationRepository extends JpaRepository<InvoiceSalesOrderAssociation,Long> {
}
