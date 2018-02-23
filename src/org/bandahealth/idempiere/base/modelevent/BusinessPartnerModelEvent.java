package org.bandahealth.idempiere.base.modelevent;

import java.util.Properties;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.compiere.model.I_AD_Ref_List;
import org.compiere.model.I_AD_Reference;
import org.compiere.model.I_C_BPartner;
import org.compiere.model.I_C_Country;
import org.compiere.model.MBPartner;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MCountry;
import org.compiere.model.MLocation;
import org.compiere.model.MPaymentTerm;
import org.compiere.model.MPriceList;
import org.compiere.model.MUser;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.osgi.service.event.Event;

public class BusinessPartnerModelEvent extends AbstractEventHandler {
	
	private final String DEFAULT_LOCATION_NAME = "Default Location";
	private final String DEFAULT_LOCATION_COUNTRY_CODE = "KE";
	
	private CLogger log = CLogger.getCLogger(BusinessPartnerModelEvent.class);

	@Override
	protected void initialize() {

		registerTableEvent(IEventTopics.PO_BEFORE_NEW, I_C_BPartner.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_NEW, I_C_BPartner.Table_Name);
	}

	@Override
	protected void doHandleEvent(Event event) {

		MBPartner businessPartner = null;
		PO persistantObject = getPO(event);
		if (persistantObject instanceof MBPartner) {
			businessPartner = (MBPartner) persistantObject;
		} else {
			return;
		}
		
		if (event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)) {
			addNeededHiddenData(businessPartner);
		} else if (event.getTopic().equals(IEventTopics.PO_AFTER_NEW)) {
			initializeDependentEntities(businessPartner);
		}
	}

	private void addNeededHiddenData(MBPartner businessPartner) {

		// Set client & org?
		int clientId = businessPartner.getAD_Client_ID();
		int orgId = businessPartner.getAD_Org_ID();
		
		// Set BP Group?
//		businessPartner.setBPGroup(group);
		
		if (businessPartner.isCustomer()) {
			// Set the invoice rule
			I_AD_Reference orderInvoiceReference = querySpecificThenBase(clientId, orgId, Env.getCtx(),
					I_AD_Reference.Table_Name, "name = 'C_Order InvoiceRule'", null);
			I_AD_Ref_List invoiceRule = querySpecificThenBase(clientId, orgId, Env.getCtx(), I_AD_Ref_List.Table_Name,
					"ad_reference_id = "+ orderInvoiceReference.getAD_Reference_ID() + " and name = 'Immediate'", null);
			businessPartner.setInvoiceRule(invoiceRule.getValue());
			
			// Set the invoice schedule
			
			// Set the payment rule
			I_AD_Reference paymentRuleReference = querySpecificThenBase(clientId, orgId, Env.getCtx(), I_AD_Reference.Table_Name,
					"name = '_Payment Rule'", null);
			I_AD_Ref_List paymentRule = querySpecificThenBase(clientId, orgId, Env.getCtx(), I_AD_Ref_List.Table_Name,
					"ad_reference_id = " + paymentRuleReference.getAD_Reference_ID() + " and name = 'Cash'", null);
			businessPartner.setPaymentRule(paymentRule.getValue());
			
			// Set the payment term
			MPaymentTerm paymentTerm = querySpecificThenBase(clientId, orgId, Env.getCtx(), MPaymentTerm.Table_Name,
					"name = 'Immediate'", null);
			businessPartner.setC_PaymentTerm_ID(paymentTerm.getC_PaymentTerm_ID());
			
			// Set the price list
			MPriceList priceList = querySpecificThenBase(clientId, orgId, Env.getCtx(), MPriceList.Table_Name,
					"name = 'Standard' and isactive = 'Y'", null);
			businessPartner.setM_PriceList_ID(priceList.getM_PriceList_ID());
		}
		if (businessPartner.isVendor()) {
			// Set the payment rule
			I_AD_Reference vendorPaymentRuleReference = querySpecificThenBase(clientId, orgId, Env.getCtx(), I_AD_Reference.Table_Name,
					"name = '_Payment Rule'", null);
			I_AD_Ref_List vendorPaymentRule = querySpecificThenBase(clientId, orgId, Env.getCtx(), I_AD_Ref_List.Table_Name,
					"ad_reference_id = " + vendorPaymentRuleReference.getAD_Reference_ID() + " and name = 'Direct Deposit'", null);
			businessPartner.setPaymentRulePO(vendorPaymentRule.getValue());

			// Set the PO payment term
			MPaymentTerm purchasePaymentTerm = querySpecificThenBase(clientId, orgId, Env.getCtx(), MPaymentTerm.Table_Name,
					"name = 'Immediate'", null);
			businessPartner.setPO_PaymentTerm_ID(purchasePaymentTerm.getC_PaymentTerm_ID());
			
			// Set the purchase price list
			MPriceList purchasePriceList = querySpecificThenBase(clientId, orgId, Env.getCtx(), MPriceList.Table_Name,
					"name = 'Purchase' and isactive = 'Y'", null);
			businessPartner.setPO_PriceList_ID(purchasePriceList.getM_PriceList_ID());
		}
	}

	private <T extends PO> T querySpecificThenBase(int clientId, int orgId, Properties ctx, String tableName,
			String whereClause, String trxName) {
		
		String specificClientSpedificOrgWherClause = " and ad_client_id = " + clientId + " and ad_org_id = " + orgId;
		String specificClientBaseOrgWherClause = " and ad_client_id = " + clientId + " and ad_org_id = 0";
		String baseClientBaseOrgWherClause = " and ad_client_id = 0 and ad_org_id = 0";
		
		if (orgId == 0) {
			specificClientSpedificOrgWherClause = " and ad_client_id = " + clientId + " and ad_org_id <> " + orgId;
		}
		
		Query query = new Query(ctx, tableName, whereClause + specificClientSpedificOrgWherClause, trxName);
		if (query.count() > 0) {
			return query.first();
		}
		query = new Query(ctx, tableName, whereClause + specificClientBaseOrgWherClause, trxName);
		if (query.count() > 0) {
			return query.first();
		}
		return (new Query(ctx, tableName, whereClause + baseClientBaseOrgWherClause, trxName)).first();
	}

	private void initializeDependentEntities(MBPartner businessPartner) {
		
		// Add the business partner as the contact
		if (businessPartner.getContacts(true).length == 0) {
			MUser user = new MUser(businessPartner);
			user.setName(businessPartner.getName());
			user.setIsFullBPAccess(false);
			user.setIsActive(true);
			user.setNotificationType(MUser.NOTIFICATIONTYPE_None);
			user.save();
		}
		
		// Add a default location one
		if (businessPartner.getLocations(true).length == 0) {
			MBPartnerLocation businessPartnerLocation = new MBPartnerLocation(businessPartner);

			MCountry country = (new Query(Env.getCtx(), I_C_Country.Table_Name, "countrycode = '" + DEFAULT_LOCATION_COUNTRY_CODE
					+ "'", null)).first();
			
			MLocation location = new MLocation(country, null);
			location.save();
			
			businessPartnerLocation.setC_Location_ID(location.get_ID());
			businessPartnerLocation.setName(DEFAULT_LOCATION_NAME);
			businessPartnerLocation.save();
		}
	}

}
