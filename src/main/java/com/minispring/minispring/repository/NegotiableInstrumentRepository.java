package com.minispring.minispring.repository;

import com.minispring.minispring.model.Invoice;
import com.minispring.minispring.model.NegotiableInstrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NegotiableInstrumentRepository extends JpaRepository<NegotiableInstrument,Long>{
}
