package org.bandahealth.idempiere.base.test;

import java.util.Properties;

import org.compiere.model.MOrgInfo;
import org.compiere.model.Query;

public class MOrgInfoTemplate extends BaseModelTemplate<MOrgInfo> {

	private int orgId;

	public MOrgInfoTemplate(String transactionName, Properties context, int orgId) {
		super(transactionName, context);

		this.orgId = orgId;
	}

	@Override
	protected MOrgInfo createInstance() {
		return null;
	}

	@Override
	protected MOrgInfo findInstance() {
		return new Query(getContext(), MOrgInfo.Table_Name, MOrgInfo.COLUMNNAME_AD_Org_ID + " = ?",
				getTransactionName()).setParameters(orgId).first();
	}

	@Override
	protected void setFields(MOrgInfo instance) {
		// check calendar.
		if (instance.getC_Calendar_ID() == 0) {
			instance.setC_Calendar_ID(new MCalendarTemplate(getTransactionName(), getContext()).getInstance().get_ID());
			instance.saveEx();

			commit();
		}

		// check myear
		if (instance.getC_Calendar_ID() > 0) {
			new MYearTemplate(getTransactionName(), getContext(), instance.getC_Calendar_ID()).getInstance();
		}
	}

}
