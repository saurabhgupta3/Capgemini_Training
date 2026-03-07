package com.assess.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Item {
	@Id
	int itemid;
	String name;
	String type;
}
