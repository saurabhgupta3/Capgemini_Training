package com.gal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderedItem {
	@Id
	@GeneratedValue
	long ordereditemid;
	@ManyToOne
	AnOrder order;
	
	@ManyToOne
	Item item;
	Integer qty;
}
