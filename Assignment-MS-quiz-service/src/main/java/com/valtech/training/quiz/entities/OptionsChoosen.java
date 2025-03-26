package com.valtech.training.quiz.entities;



public class OptionsChoosen {
   private long optionChoosenId;
   private String optionChoosen;
   
   
   
  public OptionsChoosen() {
	
   }
  
  public OptionsChoosen(long id, String optionChoosen) {
	super();
	this.optionChoosenId = id;
	this.optionChoosen = optionChoosen;
  }
  
  public long getOptionChoosenId() {
	return optionChoosenId;
  }
 public void setOptionChoosenId(long id) {
	this.optionChoosenId = id;
 }
 public String getOptionChoosen() {
	return optionChoosen;
 }
 public void setOptionChoosen(String optionChoosen) {
	this.optionChoosen = optionChoosen;
 }
   
   
  
}

 
 
 
 