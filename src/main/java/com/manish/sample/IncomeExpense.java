package com.manish.sample;

public class IncomeExpense {
	
	private String yearMonth;
	private Double spent ;
	private Double income ;
	public String getYearMonth() {
		return yearMonth;
	}
	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}
	public Double getSpent() {
		return spent;
	}
	public void setSpent(Double spent) {
		this.spent = spent;
	}
	public Double getIncome() {
		return income;
	}
	public void setIncome(Double income) {
		this.income = income;
	}
	
	public Double addIncome(Double newIncome){
		return this.income + newIncome;
	}

	public Double addExpenditure(Double newExpenditure){
		return this.spent + newExpenditure;
	}
	@Override
	public String toString() {
		return "{" + yearMonth +  ":{ \" spent \": $" +  String.format("%.2f", Math.abs(spent)) +"\", \"income \":\"$" + String.format("%.2f", income) +"\"}" ;
	}

}
