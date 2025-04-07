package org.bandahealth.idempiere.graphql.model;

import java.math.BigDecimal;

public class DashboardProductUsage {
	private Integer productId;
	private String name;
	private BigDecimal current;
	private BigDecimal previous;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getCurrent() {
		return current;
	}

	public void setCurrent(BigDecimal current) {
		this.current = current;
	}

	public BigDecimal getPrevious() {
		return previous;
	}

	public void setPrevious(BigDecimal previous) {
		this.previous = previous;
	}
}
