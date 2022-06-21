package org.bandahealth.idempiere.base.test;

import java.util.Calendar;
import java.util.Locale;
import java.util.Properties;

import org.compiere.model.MYear;
import org.compiere.model.Query;

public class MYearTemplate extends BaseModelTemplate<MYear> {

	private int calendarId;

	public MYearTemplate(String transactionName, Properties context, int calendarId) {
		super(transactionName, context);

		this.calendarId = calendarId;
	}

	@Override
	protected MYear createInstance() {
		MYear instance = new MYear(getContext(), 0, getTransactionName());
		instance.setC_Calendar_ID(calendarId);
		instance.setFiscalYear(Calendar.getInstance().get(Calendar.YEAR) + "");
		instance.saveEx();

		// create periods.
		instance.createStdPeriods(Locale.getDefault());

		commit();

		return instance;
	}

	@Override
	protected MYear findInstance() {
		return new Query(getContext(), MYear.Table_Name, MYear.COLUMNNAME_C_Calendar_ID + " = ?", getTransactionName())
				.setParameters(calendarId).first();
	}

	@Override
	protected void setFields(MYear instance) {
		if (instance.getC_Year_ID() > 0) {
			new MPeriodTemplate(getTransactionName(), getContext(), instance.getC_Year_ID()).getInstance();
		}
	}
}
