package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"uomprecision", "a_Asset_Group_ID", "attributeSet", "uomsymbol", "productDownloads",
		"attributeInstance", "mmpolicy", "costingLevel", "costingMethod", "costingRecord", "c_RevenueRecognition",
		"c_SubscriptionType", "c_TaxCategory", "c_UOM", "m_AttributeSet", "m_AttributeSetInstance", "m_FreightCategory",
		"m_Locator", "m_PartType", "m_Product_Category", "r_MailText", "salesRep", "s_ExpenseType", "s_Resource"})
public abstract class ProductMixIn implements POMixIn {
}
