package com.eleiatech.orderquoteservice.request;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class OrderQuoteUpdateRequest {

    private long companyId;
    private String orderNo;
    private Date dateRaised;
    private Date dateOrdered;
    private String companyName;
    private String firstName;
    private String lastName;
    private int statusId;
    private Date dateDue;
    private boolean orderType;
    private String comment;
}
