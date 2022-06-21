package org.bandahealth.idempiere.base.test;

import java.util.Calendar;
import java.util.Properties;

import org.compiere.model.MPeriod;
import org.compiere.model.MPeriodControl;
import org.compiere.model.Query;

public class MPeriodTemplate extends BaseModelTemplate<MPeriod> {

	private int yearId;

	public MPeriodTemplate(String transactionName, Properties context, int yearId) {
		super(transactionName, context);

		this.yearId = yearId;
	}

	@Override
	protected MPeriod createInstance() {
		return null;
	}

	@Override
	protected MPeriod findInstance() {
		Calendar calendar = Calendar.getInstance();
		return new Query(getContext(), MPeriod.Table_Name,
				MPeriod.COLUMNNAME_C_Year_ID + " = ? AND " + MPeriod.COLUMNNAME_PeriodNo + " = ?", getTransactionName())
						.setParameters(yearId, (calendar.get(Calendar.MONTH) + 1)).first();
	}

	@Override
	protected void setFields(MPeriod instance) {
		boolean check = false;
		MPeriodControl[] controls = instance.getPeriodControls(true);
		for (MPeriodControl control : controls) {
			if (control.getPeriodAction().equalsIgnoreCase(MPeriodControl.PERIODACTION_NoAction)) {
				check = true;
				control.setPeriodAction(MPeriodControl.PERIODACTION_OpenPeriod);
				control.setPeriodStatus(MPeriodControl.PERIODSTATUS_Open);
				control.saveEx();
			}
		}

		if (check)
			commit();
	}
}
