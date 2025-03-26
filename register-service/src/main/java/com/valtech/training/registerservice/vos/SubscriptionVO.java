package com.valtech.training.registerservice.vos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;

public record SubscriptionVO(long id,int amount,String subscriptionStart,String subscriptionEnd,List<Long> userId ) {

	public static final DateTimeFormatter FORMATTER=DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	
	public static SubscriptionVO from(Subscription sub) {
		String startDate=sub.getSubscriptionStart().format(FORMATTER);
		String endDate=sub.getSubscriptionEnd().format(FORMATTER);

		return new SubscriptionVO(sub.getId(),sub.getAmount(),startDate,endDate);
	}
	public Subscription to(){
		LocalDate startDate=LocalDate.parse(subscriptionStart,FORMATTER);
		LocalDate endDate=LocalDate.parse(subscriptionEnd,FORMATTER);
		return new Subscription(id,amount, startDate, endDate);

	}
}
