package com.eleiatech.orderquoteservice.service;

import com.eleiatech.orderquoteservice.repository.entity.OrderQuote;
import com.eleiatech.orderquoteservice.request.OrderQuoteCreateRequest;
import com.eleiatech.orderquoteservice.request.OrderQuoteUpdateRequest;

import java.util.List;

public interface IOrderQuoteRepositoryService {

    OrderQuote createOrderQuote(OrderQuoteCreateRequest orderQuoteCreateRequest);

    OrderQuote updateOrderQuote(long orderQuoteId,OrderQuoteUpdateRequest orderQuoteUpdateRequest);

    OrderQuote getOrderQuote(long orderQuoteId);

    List<OrderQuote> getOrderQuotesWithCompany(long companyId);

    List<OrderQuote> getOrderQuotesWithStatus(int statusId);

    List<OrderQuote> getOrderQuotesWithOrderType(boolean orderType);

    List<OrderQuote> getAllOrdersQuotes();

    void deleteOrderQuote(long orderQuoteId);

    void deleteOrderQuotesWithCompany(long companyId);

    void deleteOrderQuotesWithStatus(int statusId);

    void deleteOrderQuotesWithOrderType(boolean orderType);



}
