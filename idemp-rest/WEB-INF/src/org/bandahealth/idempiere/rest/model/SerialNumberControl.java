package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.compiere.model.MSerNoCtl;

public class SerialNumberControl extends BaseEntity {

	private int startNumber;
	private int incrementNumber;
	private int currentNext;
	private String prefix;
	private String suffix;
	@JsonIgnore
	private MSerNoCtl model;

	public SerialNumberControl() {
	}

	public SerialNumberControl(MSerNoCtl model) {
		super(model, model.getName(), model.getDescription(), null);
		this.startNumber = model.getStartNo();
		this.incrementNumber = model.getIncrementNo();
		this.currentNext = model.getCurrentNext();
		this.prefix = model.getPrefix();
		this.suffix = model.getSuffix();
		this.model = model;
	}

	public int getStartNumber() {
		return startNumber;
	}

	public void setStartNumber(int startNumber) {
		this.startNumber = startNumber;
	}

	public int getIncrementNumber() {
		return incrementNumber;
	}

	public void setIncrementNumber(int incrementNumber) {
		this.incrementNumber = incrementNumber;
	}

	public int getCurrentNext() {
		return currentNext;
	}

	public void setCurrentNext(int currentNext) {
		this.currentNext = currentNext;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public MSerNoCtl getModel() {
		return model;
	}
}
