package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.compiere.util.Env;

import java.util.Properties;

@JsonIgnoreProperties(value = {"uomprecision", "a_Asset_Group_ID", "attributeSet", "uomsymbol", "productDownloads",
		"attributeInstance", "mmpolicy", "costingLevel", "costingMethod", "costingRecord", "c_RevenueRecognition",
		"c_SubscriptionType", "c_TaxCategory", "c_UOM", "m_AttributeSet", "m_AttributeSetInstance", "m_FreightCategory",
		"m_Locator", "m_PartType", "m_Product_Category", "r_MailText", "salesRep", "s_ExpenseType", "s_Resource",
		"resource"})
public abstract class ProductMixIn extends MProduct_BH implements POMixIn {
	/**
	 * The JsonCreator must match a superclass constructor to be used instead
	 *
	 * @param ctx     Unused
	 * @param id      Pulled from JSON
	 * @param trxName Unused
	 */
	@JsonCreator
	public ProductMixIn(@JsonProperty("nonExistentCtx") Properties ctx, @JsonProperty("id") int id,
			@JsonProperty("nonExistentTrxName") String trxName) {
		super(Env.getCtx(), id, null);
	}
}
