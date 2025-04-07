package org.bandahealth.idempiere.graphql.model;

import java.math.BigDecimal;

public class DashboardGeneralData {
	private Integer totalPatientsServed;
	private Integer newPatientsRegistered;
	private BigDecimal averageNumberOfProductsDelivered;
	private BigDecimal averageChargePerPatient;
	private BigDecimal averageProductTurnover;
	private BigDecimal percentVitalsTracked;
	private BigDecimal percentDiagnosesCoded;
	private BigDecimal percentNotes;
	private BigDecimal percentCompletedLabs;
	private BigDecimal percentVisitsCompleted;

	public Integer getTotalPatientsServed() {
		return totalPatientsServed;
	}

	public void setTotalPatientsServed(Integer totalPatientsServed) {
		this.totalPatientsServed = totalPatientsServed;
	}

	public Integer getNewPatientsRegistered() {
		return newPatientsRegistered;
	}

	public void setNewPatientsRegistered(Integer newPatientsRegistered) {
		this.newPatientsRegistered = newPatientsRegistered;
	}

	public BigDecimal getAverageNumberOfProductsDelivered() {
		return averageNumberOfProductsDelivered;
	}

	public void setAverageNumberOfProductsDelivered(BigDecimal averageNumberOfProductsDelivered) {
		this.averageNumberOfProductsDelivered = averageNumberOfProductsDelivered;
	}

	public BigDecimal getAverageChargePerPatient() {
		return averageChargePerPatient;
	}

	public void setAverageChargePerPatient(BigDecimal averageChargePerPatient) {
		this.averageChargePerPatient = averageChargePerPatient;
	}

	public BigDecimal getAverageProductTurnover() {
		return averageProductTurnover;
	}

	public void setAverageProductTurnover(BigDecimal averageProductTurnover) {
		this.averageProductTurnover = averageProductTurnover;
	}

	public BigDecimal getPercentVitalsTracked() {
		return percentVitalsTracked;
	}

	public void setPercentVitalsTracked(BigDecimal percentVitalsTracked) {
		this.percentVitalsTracked = percentVitalsTracked;
	}

	public BigDecimal getPercentDiagnosesCoded() {
		return percentDiagnosesCoded;
	}

	public void setPercentDiagnosesCoded(BigDecimal percentDiagnosesCoded) {
		this.percentDiagnosesCoded = percentDiagnosesCoded;
	}

	public BigDecimal getPercentNotes() {
		return percentNotes;
	}

	public void setPercentNotes(BigDecimal percentNotes) {
		this.percentNotes = percentNotes;
	}

	public BigDecimal getPercentCompletedLabs() {
		return percentCompletedLabs;
	}

	public void setPercentCompletedLabs(BigDecimal percentCompletedLabs) {
		this.percentCompletedLabs = percentCompletedLabs;
	}

	public BigDecimal getPercentVisitsCompleted() {
		return percentVisitsCompleted;
	}

	public void setPercentVisitsCompleted(BigDecimal percentVisitsCompleted) {
		this.percentVisitsCompleted = percentVisitsCompleted;
	}
}
