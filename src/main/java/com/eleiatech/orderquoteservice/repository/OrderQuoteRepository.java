package com.eleiatech.orderquoteservice.repository;

import com.eleiatech.orderquoteservice.repository.entity.OrderQuote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderQuoteRepository extends JpaRepository<OrderQuote,Long> {

    OrderQuote getByOrderQuoteIdAndDeletedFalse(long orderQuoteId);

    List<OrderQuote> getAllByDeletedFalse();

    List<OrderQuote> getByCompanyIdAndDeletedFalse(long companyId);

    List<OrderQuote> getByStatusIdAndDeletedFalse(int statusId);

    List<OrderQuote> getByOrderTypeAndDeletedFalse(boolean orderType);

}
