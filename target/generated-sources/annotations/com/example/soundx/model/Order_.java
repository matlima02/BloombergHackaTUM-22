package com.example.soundx.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static volatile SingularAttribute<Order, Integer> amount;
	public static volatile SingularAttribute<Order, Double> price;
	public static volatile SingularAttribute<Order, Integer> customerId;
	public static volatile SingularAttribute<Order, Integer> artistId;
	public static volatile SingularAttribute<Order, Integer> id;
	public static volatile SingularAttribute<Order, String> type;

	public static final String AMOUNT = "amount";
	public static final String PRICE = "price";
	public static final String CUSTOMER_ID = "customerId";
	public static final String ARTIST_ID = "artistId";
	public static final String ID = "id";
	public static final String TYPE = "type";

}

