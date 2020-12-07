package com.eleiatech.orderquoteservice.repository.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_quote",schema = "stock_management")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderQuote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_quote_id")
    private long orderQuoteId;

    @Column(name = "company_id")
    private long companyId;

    @Column(name = "order_No")
    private String orderNo;

    @Column(name = "date_raised")
    private Date dateRaised;

    @Column(name = "date_ordered")
    private Date dateOrdered;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "status_id")
    private int statusId;

    @Column(name = "date_due")
    private Date dateDue;

    @Column(name = "order_type")
    private boolean orderType;

    @Column(name = "comment")
    private String comment;

    @Builder.Default
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdDate = new Date();

    @Builder.Default
    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatedDate = new Date();

    @Column(name = "is_deleted")
    private boolean deleted;
}
