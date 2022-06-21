package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.bandahealth.idempiere.base.utils.QueryConstants;
import org.compiere.model.MAttributeSet;
import org.compiere.model.Query;

public class MAttributeSetTemplate extends BaseModelTemplate<MAttributeSet> {

	public MAttributeSetTemplate(String transactionName, Properties context) {
		super(transactionName, context);
	}

	@Override
	protected MAttributeSet createInstance() {
		MAttributeSet bandaAttrSet = new MAttributeSet(getContext(), 0, getTransactionName());
		bandaAttrSet.setName("With Expiry");
		bandaAttrSet.setIsGuaranteeDate(true);
		bandaAttrSet.saveEx();

		commit();

		return bandaAttrSet;
	}

	@Override
	protected MAttributeSet findInstance() {
		String whereClause = MAttributeSet.COLUMNNAME_IsGuaranteeDate + "= 'Y' AND lower("
				+ MAttributeSet.COLUMNNAME_Name + ") = 'with expiry'";

		return new Query(getContext(), MAttributeSet.Table_Name, whereClause, getTransactionName())
				.setOnlyActiveRecords(true).setClient_ID(true).first();
	}

	@Override
	protected void setFields(MAttributeSet instance) {
	}

}
