package com.valtech.training.registerservice.vos;

import java.time.LocalDate;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;

public record UserVO(long id,String name,int age,String mobile,String email,Boolean kid,Subscription subscription) {
	public static UserVO from(User user) {
		return new UserVO(user.getId(),user.getName(),user.getAge(),user.getMobile(),user.getEmail(),user.getKid(),user.getSubscription());
	}
	public User to(Subscription sub){
		User user= new User(id,name,age,mobile,email,kid);
		user.setSubscription(sub);
		return user;
	}


}
