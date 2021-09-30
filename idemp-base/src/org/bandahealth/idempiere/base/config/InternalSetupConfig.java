package org.bandahealth.idempiere.base.config;

import java.util.Properties;

import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.utils.QueryConstants;
import org.compiere.model.MAttributeSet;
import org.compiere.model.MInOutLine;
import org.compiere.model.X_M_AttributeSetExclude;

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
		X_M_AttributeSetExclude attributeSetExclude = new X_M_AttributeSetExclude(context, 0, null);
		attributeSetExclude.setAD_Table_ID(MOrderLine_BH.Table_ID);
		attributeSetExclude.setM_AttributeSet_ID(attribSet.getM_AttributeSet_ID());
		attributeSetExclude.setIsSOTrx(true);
		attributeSetExclude.saveEx();

		attributeSetExclude = new X_M_AttributeSetExclude(context, 0, null);
		attributeSetExclude.setAD_Table_ID(MInOutLine.Table_ID);
		attributeSetExclude.setM_AttributeSet_ID(attribSet.getM_AttributeSet_ID());
		attributeSetExclude.setIsSOTrx(true);
		attributeSetExclude.saveEx();
	}
}
