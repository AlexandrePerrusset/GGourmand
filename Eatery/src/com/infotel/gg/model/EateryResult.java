package com.infotel.gg.model;

import java.util.List;

public class EateryResult {
	
	private long count;
	private List<Eatery> eateries;
	
	public EateryResult(long count, List<Eatery> eateries) {
		super();
		this.count = count;
		this.eateries = eateries;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public List<Eatery> getEateries() {
		return eateries;
	}

	public void setEateries(List<Eatery> eateries) {
		this.eateries = eateries;
	}
	
	
	

}
