package com.test.model;

public class CountDateVO {
	private int nocount_date;
	private int count_date;

	public int getNocount_date() {
		return nocount_date;
	}

	public void setNocount_date(int nocount_date) {
		this.nocount_date = nocount_date;
	}

	public int getCount_date() {
		return count_date;
	}

	public void setCount_date(int count_date) {
		this.count_date = count_date;
	}

	public CountDateVO(int nocount_date, int count_date) {
		this.nocount_date = nocount_date;
		this.count_date = count_date;
	}
}
