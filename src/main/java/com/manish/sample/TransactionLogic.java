package com.manish.sample;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 
 * @author mjoshi
 *
 */
public class TransactionLogic {
	
	/**
	 * Calculate the totals of spent and income by year-month criteria
	 * @param doNotCalculateDonuts
	 * @param transactions
	 */
	public void calculate(Boolean doNotCalculateDonuts, List<Transaction> transactions){
		Calendar cal = Calendar.getInstance();
		Map<String, List<Transaction>> yearMonthMap = new TreeMap<String, List<Transaction>>();
		for(Transaction txn : transactions) {
			cal.setTimeInMillis(txn.getClearDate().getTime());
			String key = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1);
			if(yearMonthMap.containsKey(key)){
				yearMonthMap.get(key).add(txn);
			} else {
				List<Transaction> txnList = new ArrayList<Transaction>();
				txnList.add(txn);
				yearMonthMap.put(key, txnList);
			}
		}
		for(Entry<String, List<Transaction>> entrySet : yearMonthMap.entrySet()){
			Iterator<Transaction> iterator = entrySet.getValue().iterator();
			IncomeExpense ie = new IncomeExpense();
			ie.setYearMonth(entrySet.getKey());
			ie.setSpent(0.0);
			ie.setIncome(0.0);
			while(iterator.hasNext()){
				Transaction txn = iterator.next();
				getIncomeOrExpediture(txn, ie, doNotCalculateDonuts);
			}
			System.out.println(ie.toString());
			getAverage(entrySet.getValue(), entrySet.getKey());
		}
	}
	

	/**
	 * Calculate average for a month
	 * Spent Average is defined as total number of transactions spent greater than $500 (negative).
	 * Income Average is defined as total number of transaction which are greater than $500
	 * @param transactions
	 * @param key
	 */
	public void getAverage(List<Transaction> transactions, String key){
		double income =0.0;
		double expenses = 0.0;
		int incomeCounter=0;
		int expenseCounter=0;
		for(Transaction txn: transactions){
			if(txn.getAmount() != null){
				if(txn.getAmount() >= 500){
					income = income + txn.getAmount();
					incomeCounter++;
				}
				if(txn.getAmount() < -500){
					expenses = expenses + txn.getAmount();
					expenseCounter++;
				}
			}
		}
		System.out.println("\"average\": {\"spent\":\"$"+ String.format("%.2f", Math.abs(expenses/expenseCounter)) +"\", \"income\": \"$" + String.format("%.2f", Math.abs(income/incomeCounter)) + "\"}}");
	}
	

	/**
	 * This getIncome of Expenditure method is used to add incomes from the amount. 
	 * Any positive amount value is being calculated as income and negative value from the service is being calculated as expense.
	 * Boolean caluclate donuts is being used to check if donut expenses are supposed to be added to the overall calculation of expenses.
	 * @param txn
	 * @param ie
	 * @param doNotCalculateDonuts
	 */
	public void getIncomeOrExpediture(Transaction txn, IncomeExpense ie, Boolean doNotCalculateDonuts){
		if(txn.getAmount() != null){
			if(txn.getAmount() >= 0){
				ie.setIncome(ie.addIncome(txn.getAmount()));
			}else{
				if(doNotCalculateDonuts){
					if(!txn.getMerchant().equalsIgnoreCase("KRISPY KREME DONUTS") && !txn.getMerchant().equalsIgnoreCase("DUNKIN #336784")){
						ie.setSpent(ie.addExpenditure(txn.getAmount()));
					} 
				}else{
					ie.setSpent(ie.addExpenditure(txn.getAmount()));
				}
			}
			
		}
	}
	
	


}
