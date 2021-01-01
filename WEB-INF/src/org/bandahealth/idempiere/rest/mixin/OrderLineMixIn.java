package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.compiere.util.Env;

import java.util.Properties;

@JsonIgnoreProperties(value = {"parent", "productPricing", "charge", "tax", "precision", "product", "name", "base",
		"c_Activity", "c_BPartner", "c_BPartner_Location", "c_Campaign", "c_Charge", "c_Currency", "c_Order", "c_Project",
		"c_ProjectPhase", "c_ProjectTask", "c_Tax", "c_UOM", "link_OrderLine", "m_AttributeSetInstance", "m_Product",
		"m_Promotion", "m_Shipper", "m_Warehouse", "pp_Cost_Collector", "ref_OrderLine", "user1", "user2"})
public abstract class OrderLineMixIn extends MOrderLine_BH implements POMixIn {
	/**
	 * The JsonCreator must match a superclass constructor to be used instead
	 *
	 * @param ctx     Unused
	 * @param id      Pulled from JSON
	 * @param trxName Unused
	 */
	@JsonCreator
	public OrderLineMixIn(@JsonProperty("nonExistentCtx") Properties ctx, @JsonProperty("id") int id,
			@JsonProperty("nonExistentTrxName") String trxName) {
		super(Env.getCtx(), id, null);
	}
}
