package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.bandahealth.idempiere.base.utils.QueryConstants;
import org.compiere.model.MAttributeSet;
import org.compiere.model.Query;

public class MAttributeSetTemplate extends BaseTemplate<MAttributeSet> {

	private String trxName;
	private Properties ctx;

	public MAttributeSetTemplate(String trxName, Properties ctx) {
		this.trxName = trxName;
		this.ctx = ctx;
	}

	@Override
	public MAttributeSet getInstance(int... args) {
		String whereClause = MAttributeSet.COLUMNNAME_IsGuaranteeDate + "= 'Y' AND lower("
				+ MAttributeSet.COLUMNNAME_Name + ") = '"
				+ QueryConstants.BANDAHEALTH_PRODUCT_ATTRIBUTE_SET.toLowerCase() + "'";

		MAttributeSet bandaAttrSet = new Query(getCtx(), MAttributeSet.Table_Name, whereClause, getTrxName())
				.setOnlyActiveRecords(true).setClient_ID(true).first();

		if (bandaAttrSet == null) {
			bandaAttrSet = new MAttributeSet(getCtx(), 0, getTrxName());
			bandaAttrSet.setName(QueryConstants.BANDAHEALTH_PRODUCT_ATTRIBUTE_SET);
			bandaAttrSet.setIsGuaranteeDate(true);
			bandaAttrSet.saveEx();

			commit();
		}

		return bandaAttrSet;
	}

	@Override
	protected String getTrxName() {
		return trxName;
	}

	@Override
	protected Properties getCtx() {
		return ctx;
	}
}
