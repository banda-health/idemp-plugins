package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"bh_C_Location", "contacts", "contact", "locations", "location", "bankAccounts",
		"primaryC_BPartner_Location_ID", "primaryC_BPartner_Location", "primaryAD_User_ID", "socreditStatus",
		"creditWatchRatio", "bpgroup", "m_PriceList_ID", "po_PriceList_ID", "m_DiscountSchema_ID", "po_DiscountSchema_ID",
		"c_BP_Group", "c_Dunning", "c_Greeting", "c_InvoiceSchedule", "c_PaymentTerm", "c_TaxGroup", "default1099Box",
		"invoice_PrintFormat", "m_DiscountSchema", "m_PriceList", "po_DiscountSchema", "po_PaymentTerm", "po_PriceList",
		"salesRep"})
public abstract class BusinessPartnerMixIn implements POMixIn {
}
