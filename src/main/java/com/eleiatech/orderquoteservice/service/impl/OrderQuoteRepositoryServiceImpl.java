package com.eleiatech.orderquoteservice.service.impl;

import com.eleiatech.orderquoteservice.exception.exceptions.DataAlreadyDeletedException;
import com.eleiatech.orderquoteservice.exception.exceptions.DataNotFoundException;
import com.eleiatech.orderquoteservice.repository.OrderQuoteRepository;
import com.eleiatech.orderquoteservice.repository.entity.OrderQuote;
import com.eleiatech.orderquoteservice.request.OrderQuoteCreateRequest;
import com.eleiatech.orderquoteservice.request.OrderQuoteUpdateRequest;
import com.eleiatech.orderquoteservice.service.IOrderQuoteRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OrderQuoteRepositoryServiceImpl implements IOrderQuoteRepositoryService {

    private final OrderQuoteRepository orderQuoteRepository;

    @Override
    public OrderQuote createOrderQuote(OrderQuoteCreateRequest orderQuoteCreateRequest) {
        OrderQuote orderQuote = OrderQuote.builder()
                .companyId(orderQuoteCreateRequest.getCompanyId())
                .orderNo(orderQuoteCreateRequest.getOrderNo())
                .dateRaised(orderQuoteCreateRequest.getDateRaised())
                .dateOrdered(orderQuoteCreateRequest.getDateOrdered())
                .companyName(orderQuoteCreateRequest.getCompanyName())
                .firstName(orderQuoteCreateRequest.getFirstName())
                .lastName(orderQuoteCreateRequest.getLastName())
                .statusId(orderQuoteCreateRequest.getStatusId())
                .dateDue(orderQuoteCreateRequest.getDateDue())
                .orderType(orderQuoteCreateRequest.isOrderType())
                .comment(orderQuoteCreateRequest.getComment())
                .createdDate(new Date())
                .build();

        return orderQuoteRepository.save(orderQuote);
    }

    @Override
    public OrderQuote updateOrderQuote(long orderQuoteId,OrderQuoteUpdateRequest orderQuoteUpdateRequest) {
        OrderQuote orderQuote = getOrderQuote(orderQuoteId);

                orderQuote.setCompanyId(orderQuoteUpdateRequest.getCompanyId());
                orderQuote.setOrderNo(orderQuoteUpdateRequest.getOrderNo());
                orderQuote.setDateRaised(orderQuoteUpdateRequest.getDateRaised());
                orderQuote.setDateOrdered(orderQuoteUpdateRequest.getDateOrdered());
                orderQuote.setCompanyName(orderQuoteUpdateRequest.getCompanyName());
                orderQuote.setFirstName(orderQuoteUpdateRequest.getFirstName());
                orderQuote.setLastName(orderQuoteUpdateRequest.getLastName());
                orderQuote.setStatusId(orderQuoteUpdateRequest.getStatusId());
                orderQuote.setDateDue(orderQuoteUpdateRequest.getDateDue());
                orderQuote.setOrderType(orderQuoteUpdateRequest.isOrderType());
                orderQuote.setComment(orderQuoteUpdateRequest.getComment());
                orderQuote.setUpdatedDate(new Date());


        return orderQuoteRepository.save(orderQuote);
    }

    @Override
    public OrderQuote getOrderQuote(long orderQuoteId) {
        OrderQuote orderQuote = orderQuoteRepository.getByOrderQuoteIdAndDeletedFalse(orderQuoteId);

        if(Objects.isNull(orderQuote)){
            throw new DataNotFoundException("Order/Quote ","Order Quote Id: " + orderQuoteId);
        }
        return orderQuote;
    }

    @Override
    public List<OrderQuote> getOrderQuotesWithCompany(long companyId) {
        List<OrderQuote> orderQuoteList = orderQuoteRepository.getByCompanyIdAndDeletedFalse(companyId);

        if(orderQuoteList.isEmpty()){
            throw new DataNotFoundException("Company ","");
        }

        return orderQuoteList;
    }

    @Override
    public List<OrderQuote> getOrderQuotesWithStatus(int statusId) {
        List<OrderQuote> orderQuoteList = orderQuoteRepository.getByStatusIdAndDeletedFalse(statusId);

        if(orderQuoteList.isEmpty()){
            throw new DataNotFoundException("Status ","");
        }

        return orderQuoteList;
    }

    @Override
    public List<OrderQuote> getOrderQuotesWithOrderType(boolean orderType) {
        List<OrderQuote> orderQuoteList = orderQuoteRepository.getByOrderTypeAndDeletedFalse(orderType);

        if(orderQuoteList.isEmpty()){
            throw new DataNotFoundException("Order Type ","");
        }

        return orderQuoteList;
    }

    @Override
    public List<OrderQuote> getAllOrdersQuotes() {
        List<OrderQuote> orderQuoteList = orderQuoteRepository.getAllByDeletedFalse();

        if(orderQuoteList.isEmpty()){
            throw new DataNotFoundException("","");
        }

        return orderQuoteList;
    }

    @Override
    public void deleteOrderQuote(long orderQuoteId) {
        OrderQuote orderQuote = orderQuoteRepository.getByOrderQuoteIdAndDeletedFalse(orderQuoteId);
        orderQuote.setUpdatedDate(new Date());
        orderQuote.setDeleted(true);
        orderQuoteRepository.save(orderQuote);


    }

    @Override
    public void deleteOrderQuotesWithCompany(long companyId) {

        List<OrderQuote> orderQuoteList;
        try {
            orderQuoteList = getOrderQuotesWithCompany(companyId);
        }catch (DataNotFoundException dataNotFoundException){
            throw new DataAlreadyDeletedException("Company ", "Company Id: "+companyId);
        }
        orderQuoteList.forEach(args->args.setUpdatedDate(new Date()));
        orderQuoteList.forEach(args->args.setDeleted(true));
        orderQuoteRepository.saveAll(orderQuoteList);
    }

    @Override
    public void deleteOrderQuotesWithStatus(int statusId) {

        List<OrderQuote> orderQuoteList;
        try {
            orderQuoteList = getOrderQuotesWithStatus(statusId);
        }catch (DataNotFoundException dataNotFoundException){
            throw new DataAlreadyDeletedException("Status ", "Status Id: "+statusId);
        }
        orderQuoteList.forEach(args->args.setUpdatedDate(new Date()));
        orderQuoteList.forEach(args->args.setDeleted(true));
        orderQuoteRepository.saveAll(orderQuoteList);
    }

    @Override
    public void deleteOrderQuotesWithOrderType(boolean orderType) {

        List<OrderQuote> orderQuoteList;
        try {
            orderQuoteList = getOrderQuotesWithOrderType(orderType);
        }catch (DataNotFoundException dataNotFoundException){
            throw new DataAlreadyDeletedException("Order Type ", "Order Type: "+orderType);
        }
        orderQuoteList.forEach(args->args.setUpdatedDate(new Date()));
        orderQuoteList.forEach(args->args.setDeleted(true));
        orderQuoteRepository.saveAll(orderQuoteList);
    }
}
