package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"taxProviders", "shipments", "lines", "taxes", "invoices", "c_PaymentTerm",
		"c_BPartner_Location", "c_DocTypeTarget", "dropShip_BPartner", "m_PriceList", "c_ConversionType", "c_BPartner",
		"c_CashPlanLine", "salesRep", "ad_User", "bill_BPartner", "bill_Location", "bill_User", "c_Activity", "c_Campaign",
		"c_CashLine", "c_Charge", "c_ConversionType", "c_Currency", "c_DocType", "c_Opportunity", "c_OrderSource",
		"c_Payment", "c_POS", "c_Project", "dropShip_Location", "dropShip_User", "link_Order", "m_FreightCategory",
		"m_Shipper", "m_Warehouse", "quotationOrder", "ref_Order", "salesRep", "user1", "user2", "c_Invoice_ID",
		"summary", "doc_User_ID", "currencyISO", "c_POS_ID", "pay_BPartner_ID", "link_Order_ID", "ref_Order_ID",
		"bill_User_ID", "user2_ID", "user1_ID", "selfService", "copyFrom", "payScheduleValid", "printed", "freightAmt",
		"m_Shipper_ID", "c_CashPlanLine_ID", "bill_Location_ID", "bill_BPartner_ID", "quotationOrder_ID",
		"dropShip_User_ID", "dropShip_BPartner_ID", "m_FreightCategory_ID", "dropShip_Location_ID", "salesRep_ID",
		"sendEMail", "ad_OrgTrx_ID", "c_Campaign_ID", "c_Charge_ID", "chargeAmt", "taxIncluded", "c_ConversionType_ID"})
public abstract class OrderMixIn extends POMixIn {
}
