package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.compiere.util.Env;

import java.util.Properties;

@JsonIgnoreProperties(value = {"bh_C_Location", "contacts", "contact", "locations", "location", "bankAccounts",
		"primaryC_BPartner_Location_ID", "primaryC_BPartner_Location", "primaryAD_User_ID", "socreditStatus",
		"creditWatchRatio", "bpgroup", "m_PriceList_ID", "po_PriceList_ID", "m_DiscountSchema_ID", "po_DiscountSchema_ID",
		"c_BP_Group", "c_Dunning", "c_Greeting", "c_InvoiceSchedule", "c_PaymentTerm", "c_TaxGroup", "default1099Box",
		"invoice_PrintFormat", "m_DiscountSchema", "m_PriceList", "po_DiscountSchema", "po_PaymentTerm", "po_PriceList",
		"salesRep"})
public abstract class BusinessPartnerMixIn extends MBPartner_BH implements POMixIn {
	/**
	 * The JsonCreator must match a superclass constructor to be used instead
	 *
	 * @param ctx     Unused
	 * @param id      Pulled from JSON
	 * @param trxName Unused
	 */
	@JsonCreator
	public BusinessPartnerMixIn(@JsonProperty("nonExistentCtx") Properties ctx, @JsonProperty("id") int id,
			@JsonProperty("nonExistentTrxName") String trxName) {
		super(Env.getCtx(), id, null);
	}
}
