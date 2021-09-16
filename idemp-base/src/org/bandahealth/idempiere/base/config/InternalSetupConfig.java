package org.bandahealth.idempiere.base.config;

import java.util.Properties;

import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.utils.QueryConstants;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.MAttributeSet;
import org.compiere.model.MAttributeSetExclude;
import org.compiere.model.MInOutLine;

public class InternalSetupConfig {

	public static void configureNewProductAttribSet(Properties context) {
		MAttributeSet attribSet = new MAttributeSet(context, 0, null);
		attribSet.setName(QueryConstants.BANDAHEALTH_PRODUCT_ATTRIBUTE_SET);
		attribSet.setIsGuaranteeDate(true);
		attribSet.setIsLot(false);
		attribSet.setIsSerNo(false);
		attribSet.setUseGuaranteeDateForMPolicy(true);
		attribSet.saveEx();

		// Add exclusions so that ASIs aren't required on purchase/sales orders
		MAttributeSetExclude attributeSetExclude = new MAttributeSetExclude(context, 0, null);
		attributeSetExclude.setAD_Table_ID(MOrderLine_BH.Table_ID);
		attributeSetExclude.setM_AttributeSet_ID(attribSet.getM_AttributeSet_ID());
		attributeSetExclude.setIsSOTrx(true);
		attributeSetExclude.saveEx();

		attributeSetExclude = new MAttributeSetExclude(context, 0, null);
		attributeSetExclude.setAD_Table_ID(MInOutLine.Table_ID);
		attributeSetExclude.setM_AttributeSet_ID(attribSet.getM_AttributeSet_ID());
		attributeSetExclude.setIsSOTrx(true);
		attributeSetExclude.saveEx();
	}
}
