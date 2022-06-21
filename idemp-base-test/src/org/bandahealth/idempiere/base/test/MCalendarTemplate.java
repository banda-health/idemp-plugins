package org.bandahealth.idempiere.base.test;

import java.util.Properties;

import org.compiere.model.MCalendar;
import org.compiere.model.Query;

public class MCalendarTemplate extends BaseModelTemplate<MCalendar> {

	private String CALENDAR_NAME = "Test Calendar";

	public MCalendarTemplate(String transactionName, Properties context) {
		super(transactionName, context);
	}

	@Override
	protected MCalendar createInstance() {
		MCalendar instance = new MCalendar(getContext(), 0, getTransactionName());
		instance.setName(CALENDAR_NAME);
		instance.saveEx();

		commit();

		return instance;
	}

	@Override
	protected MCalendar findInstance() {
		return new Query(getContext(), MCalendar.Table_Name, "name = ?", getTransactionName())
				.setParameters(CALENDAR_NAME).first();
	}

	@Override
	protected void setFields(MCalendar instance) {
	}
}
