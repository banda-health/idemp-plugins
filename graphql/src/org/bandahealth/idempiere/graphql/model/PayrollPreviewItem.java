package org.bandahealth.idempiere.graphql.model;

import java.math.BigDecimal;

/**
 * One computed component line in a stateless net-pay preview. Maps to the GraphQL type
 * {@code BH_PayrollPreviewItem}; getters are PascalCase to match the schema field names.
 */
public class PayrollPreviewItem {
	private String Value;
	private String Name;
	private String BH_Category;
	private BigDecimal BH_EmployeeAmount;
	private BigDecimal BH_EmployerAmount;

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		this.Value = value;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getBH_Category() {
		return BH_Category;
	}

	public void setBH_Category(String bh_Category) {
		this.BH_Category = bh_Category;
	}

	public BigDecimal getBH_EmployeeAmount() {
		return BH_EmployeeAmount;
	}

	public void setBH_EmployeeAmount(BigDecimal bh_EmployeeAmount) {
		this.BH_EmployeeAmount = bh_EmployeeAmount;
	}

	public BigDecimal getBH_EmployerAmount() {
		return BH_EmployerAmount;
	}

	public void setBH_EmployerAmount(BigDecimal bh_EmployerAmount) {
		this.BH_EmployerAmount = bh_EmployerAmount;
	}
}
