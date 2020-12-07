package com.eleiatech.orderquoteservice.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderQuoteResponse {

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
    private Date createdDate;
    private Date updatedDate;
}
