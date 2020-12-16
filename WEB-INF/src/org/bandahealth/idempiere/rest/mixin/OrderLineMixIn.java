package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"parent", "productPricing", "charge", "tax", "precision", "product", "name", "base",
		"c_Activity", "c_BPartner", "c_BPartner_Location", "c_Campaign", "c_Charge", "c_Currency", "c_Order", "c_Project",
		"c_ProjectPhase", "c_ProjectTask", "c_Tax", "c_UOM", "link_OrderLine", "m_AttributeSetInstance", "m_Product",
		"m_Promotion", "m_Shipper", "m_Warehouse", "pp_Cost_Collector", "ref_OrderLine", "user1", "user2"})
public abstract class OrderLineMixIn extends POMixIn {
}
