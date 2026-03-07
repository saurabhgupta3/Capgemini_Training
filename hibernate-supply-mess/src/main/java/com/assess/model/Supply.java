package com.assess.model;

import java.sql.Date;
import jakarta.persistence.*;

@Entity
public class Supply {

    @Id
    int billno;

    @ManyToOne
    @JoinColumn(name = "Sid")
    Supplier supplier;

    @OneToOne
    @JoinColumn(name = "itemid")
    Item item;

    Date datesupply;
    int price;
    int qty;
}