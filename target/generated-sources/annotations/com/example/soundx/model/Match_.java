package com.example.soundx.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Match.class)
public abstract class Match_ {

	public static volatile SingularAttribute<Match, Integer> matchArtistId;
	public static volatile SingularAttribute<Match, Integer> id;
	public static volatile SingularAttribute<Match, Integer> matchCustomerId;
	public static volatile SingularAttribute<Match, Integer> matchedAmount;
	public static volatile SingularAttribute<Match, Double> matchedPrice;

	public static final String MATCH_ARTIST_ID = "matchArtistId";
	public static final String ID = "id";
	public static final String MATCH_CUSTOMER_ID = "matchCustomerId";
	public static final String MATCHED_AMOUNT = "matchedAmount";
	public static final String MATCHED_PRICE = "matchedPrice";

}

