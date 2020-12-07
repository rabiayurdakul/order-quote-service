package com.eleiatech.orderquoteservice.controller;

import com.eleiatech.orderquoteservice.repository.entity.OrderQuote;
import com.eleiatech.orderquoteservice.request.OrderQuoteCreateRequest;
import com.eleiatech.orderquoteservice.request.OrderQuoteUpdateRequest;
import com.eleiatech.orderquoteservice.response.InternalApiResponse;
import com.eleiatech.orderquoteservice.response.OrderQuoteResponse;
import com.eleiatech.orderquoteservice.service.IOrderQuoteRepositoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/order-quote")
public class OrderQuoteController {

    private final IOrderQuoteRepositoryService orderQuoteRepositoryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public InternalApiResponse<OrderQuoteResponse> createOrderQuote(@RequestBody OrderQuoteCreateRequest orderQuoteCreateRequest){

        OrderQuote orderQuote = orderQuoteRepositoryService.createOrderQuote(orderQuoteCreateRequest);

        OrderQuoteResponse orderQuoteResponse = OrderQuoteResponse.builder()
                .companyId(orderQuote.getCompanyId())
                .orderNo(orderQuote.getOrderNo())
                .dateRaised(orderQuote.getDateRaised())
                .dateOrdered(orderQuote.getDateOrdered())
                .companyName(orderQuote.getCompanyName())
                .firstName(orderQuote.getFirstName())
                .lastName(orderQuote.getLastName())
                .statusId(orderQuote.getStatusId())
                .dateDue(orderQuote.getDateDue())
                .orderType(orderQuote.isOrderType())
                .comment(orderQuote.getComment())
                .createdDate(orderQuote.getCreatedDate())
                .updatedDate(orderQuote.getUpdatedDate())
                .build();
        return InternalApiResponse.<OrderQuoteResponse>builder()
                .hasError(false)
                .httpStatus(HttpStatus.CREATED)
                .payload(orderQuoteResponse)
                .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/update/{orderQuoteId}")
    public InternalApiResponse<OrderQuoteResponse> updateOrderQuote(@PathVariable("orderQuoteId") long orderQuoteId, @RequestBody OrderQuoteUpdateRequest orderQuoteUpdateRequest){

        OrderQuote orderQuote = orderQuoteRepositoryService.updateOrderQuote(orderQuoteId, orderQuoteUpdateRequest);
        OrderQuoteResponse orderQuoteResponse = OrderQuoteResponse.builder()
                .companyId(orderQuote.getCompanyId())
                .orderNo(orderQuote.getOrderNo())
                .dateRaised(orderQuote.getDateRaised())
                .dateOrdered(orderQuote.getDateOrdered())
                .companyName(orderQuote.getCompanyName())
                .firstName(orderQuote.getFirstName())
                .lastName(orderQuote.getLastName())
                .statusId(orderQuote.getStatusId())
                .dateDue(orderQuote.getDateDue())
                .orderType(orderQuote.isOrderType())
                .comment(orderQuote.getComment())
                .createdDate(orderQuote.getCreatedDate())
                .updatedDate(orderQuote.getUpdatedDate())
                .build();
        return InternalApiResponse.<OrderQuoteResponse>builder()
                .hasError(false)
                .httpStatus(HttpStatus.OK)
                .payload(orderQuoteResponse)
                .build();
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/get/{orderQuoteId}")
    public InternalApiResponse<OrderQuoteResponse> getOrderQuote(@PathVariable("orderQuoteId") long orderQuoteId){
        OrderQuote orderQuote = orderQuoteRepositoryService.getOrderQuote(orderQuoteId);

        OrderQuoteResponse orderQuoteResponse = OrderQuoteResponse.builder()
                .companyId(orderQuote.getCompanyId())
                .orderNo(orderQuote.getOrderNo())
                .dateRaised(orderQuote.getDateRaised())
                .dateOrdered(orderQuote.getDateOrdered())
                .companyName(orderQuote.getCompanyName())
                .firstName(orderQuote.getFirstName())
                .lastName(orderQuote.getLastName())
                .statusId(orderQuote.getStatusId())
                .dateDue(orderQuote.getDateDue())
                .orderType(orderQuote.isOrderType())
                .comment(orderQuote.getComment())
                .createdDate(orderQuote.getCreatedDate())
                .updatedDate(orderQuote.getUpdatedDate())
                .build();
        return InternalApiResponse.<OrderQuoteResponse>builder()
                .hasError(false)
                .httpStatus(HttpStatus.OK)
                .payload(orderQuoteResponse)
                .build();

    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/get/{companyId}/company")
    public InternalApiResponse<List<OrderQuoteResponse>> getOrderQuotesWithCompany(@PathVariable("companyId") long companyId){
        List<OrderQuote> orderQuoteList = orderQuoteRepositoryService.getOrderQuotesWithCompany(companyId);

        List<OrderQuoteResponse> orderQuoteResponseList = orderQuoteList.stream()
                .map(arg-> OrderQuoteResponse.builder()
                        .companyId(arg.getCompanyId())
                        .orderNo(arg.getOrderNo())
                        .dateRaised(arg.getDateRaised())
                        .dateOrdered(arg.getDateOrdered())
                        .companyName(arg.getCompanyName())
                        .firstName(arg.getFirstName())
                        .lastName(arg.getLastName())
                        .statusId(arg.getStatusId())
                        .dateDue(arg.getDateDue())
                        .orderType(arg.isOrderType())
                        .comment(arg.getComment())
                        .createdDate(arg.getCreatedDate())
                        .updatedDate(arg.getUpdatedDate())
                        .build())
                .collect(Collectors.toList());
        return InternalApiResponse.<List<OrderQuoteResponse>>builder()
                .hasError(false)
                .httpStatus(HttpStatus.OK)
                .payload(orderQuoteResponseList)
                .build();

    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/get/{statusId}/status")
    public InternalApiResponse<List<OrderQuoteResponse>> getOrderQuotesWithStatus(@PathVariable("statusId") int statusId){

        List<OrderQuote> orderQuoteList = orderQuoteRepositoryService.getOrderQuotesWithStatus(statusId);

        List<OrderQuoteResponse> orderQuoteResponseList = orderQuoteList.stream()
                .map(arg-> OrderQuoteResponse.builder()
                        .companyId(arg.getCompanyId())
                        .orderNo(arg.getOrderNo())
                        .dateRaised(arg.getDateRaised())
                        .dateOrdered(arg.getDateOrdered())
                        .companyName(arg.getCompanyName())
                        .firstName(arg.getFirstName())
                        .lastName(arg.getLastName())
                        .statusId(arg.getStatusId())
                        .dateDue(arg.getDateDue())
                        .orderType(arg.isOrderType())
                        .comment(arg.getComment())
                        .createdDate(arg.getCreatedDate())
                        .updatedDate(arg.getUpdatedDate())
                        .build())
                .collect(Collectors.toList());
        return InternalApiResponse.<List<OrderQuoteResponse>>builder()
                .hasError(false)
                .httpStatus(HttpStatus.OK)
                .payload(orderQuoteResponseList)
                .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/get/{orderType}/orderType")
    public InternalApiResponse<List<OrderQuoteResponse>> getOrderQuotesWithOrderType(@PathVariable("orderType") boolean orderType){

        List<OrderQuote> orderQuoteList = orderQuoteRepositoryService.getOrderQuotesWithOrderType(orderType);

        List<OrderQuoteResponse> orderQuoteResponseList = orderQuoteList.stream()
                .map(arg-> OrderQuoteResponse.builder()
                        .companyId(arg.getCompanyId())
                        .orderNo(arg.getOrderNo())
                        .dateRaised(arg.getDateRaised())
                        .dateOrdered(arg.getDateOrdered())
                        .companyName(arg.getCompanyName())
                        .firstName(arg.getFirstName())
                        .lastName(arg.getLastName())
                        .statusId(arg.getStatusId())
                        .dateDue(arg.getDateDue())
                        .orderType(arg.isOrderType())
                        .comment(arg.getComment())
                        .createdDate(arg.getCreatedDate())
                        .updatedDate(arg.getUpdatedDate())
                        .build())
                .collect(Collectors.toList());
        return InternalApiResponse.<List<OrderQuoteResponse>>builder()
                .hasError(false)
                .httpStatus(HttpStatus.OK)
                .payload(orderQuoteResponseList)
                .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getAll")
    public InternalApiResponse<List<OrderQuoteResponse>> getAllOrdersQuotes(){

        List<OrderQuote> orderQuoteList = orderQuoteRepositoryService.getAllOrdersQuotes();

        List<OrderQuoteResponse> orderQuoteResponseList = orderQuoteList.stream()
                .map(arg-> OrderQuoteResponse.builder()
                        .companyId(arg.getCompanyId())
                        .orderNo(arg.getOrderNo())
                        .dateRaised(arg.getDateRaised())
                        .dateOrdered(arg.getDateOrdered())
                        .companyName(arg.getCompanyName())
                        .firstName(arg.getFirstName())
                        .lastName(arg.getLastName())
                        .statusId(arg.getStatusId())
                        .dateDue(arg.getDateDue())
                        .orderType(arg.isOrderType())
                        .comment(arg.getComment())
                        .createdDate(arg.getCreatedDate())
                        .updatedDate(arg.getUpdatedDate())
                        .build())
                .collect(Collectors.toList());
        return InternalApiResponse.<List<OrderQuoteResponse>>builder()
                .hasError(false)
                .httpStatus(HttpStatus.OK)
                .payload(orderQuoteResponseList)
                .build();
    }



    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{orderQuoteId}")
    public InternalApiResponse<String> deleteOrderQuote(@PathVariable("orderQuoteId") long orderQuoteId){
        orderQuoteRepositoryService.deleteOrderQuote(orderQuoteId);

        return InternalApiResponse.<String>builder()
                .hasError(false)
                .httpStatus(HttpStatus.OK)
                .payload("Deleted")
                .build();

    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{companyId}/company")
    public InternalApiResponse<String> deleteOrderQuotesWithCompany(@PathVariable("companyId") long companyId){
        orderQuoteRepositoryService.deleteOrderQuotesWithCompany(companyId);

        return InternalApiResponse.<String>builder()
                .hasError(false)
                .httpStatus(HttpStatus.OK)
                .payload("Deleted")
                .build();

    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{statusId}/status")
    public InternalApiResponse<String> deleteOrderQuotesWithStatus(@PathVariable("statusId") int statusId){
        orderQuoteRepositoryService.deleteOrderQuotesWithStatus(statusId);

        return InternalApiResponse.<String>builder()
                .hasError(false)
                .httpStatus(HttpStatus.OK)
                .payload("Deleted")
                .build();

    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{orderType}/orderType")
    public InternalApiResponse<String> deleteOrderQuotesWithOrderType(@PathVariable("orderType") boolean orderType){
        orderQuoteRepositoryService.deleteOrderQuotesWithOrderType(orderType);

        return InternalApiResponse.<String>builder()
                .hasError(false)
                .httpStatus(HttpStatus.OK)
                .payload("Deleted")
                .build();

    }


}
