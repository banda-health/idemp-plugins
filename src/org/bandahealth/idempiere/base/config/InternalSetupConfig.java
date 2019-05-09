package org.bandahealth.idempiere.base.config;

import java.util.Properties;

import org.bandahealth.idempiere.base.utils.QueryConstants;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.MAttributeSet;

public class InternalSetupConfig {

	public static void configureNewProductAttribSet(Properties context) {
		MAttributeSet attribSet = new MAttributeSet(context, null, null);
		attribSet.setName(QueryConstants.BANDAHEALTH_PRODUCT_ATTRIBUTE_SET);
		attribSet.setIsGuaranteeDate(true);
		attribSet.setIsLot(false);
		attribSet.setIsSerNo(false);
		attribSet.setUseGuaranteeDateForMPolicy(true);
		attribSet.saveEx();
	}
}
