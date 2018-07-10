package org.bandahealth.idempiere.base.modelevent;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.config.BHConfigLoader;
import org.bandahealth.idempiere.base.config.IBHConfig;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MCountry;
import org.compiere.model.MLocation;
import org.compiere.model.MOrder;
import org.compiere.model.MPaymentTerm;
import org.compiere.model.MPriceList;
import org.compiere.model.MProduct;
import org.compiere.model.MUser;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.osgi.service.event.Event;

public class BusinessPartnerModelEvent extends AbstractEventHandler {

	private CLogger log = CLogger.getCLogger(BusinessPartnerModelEvent.class);

	@Override
	protected void initialize() {

		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MBPartner_BH.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_NEW, MBPartner_BH.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_CHANGE, MBPartner_BH.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_CHANGE, MBPartner_BH.Table_Name);
		// load bandahealth configs
		// BHConfigLoader.getInstance(); -- Application not yet started
	}

	@Override
	protected void doHandleEvent(Event event) {
		BHConfigLoader.getInstance();

		MBPartner_BH businessPartner = null;
		PO persistantObject = getPO(event);
		if (persistantObject instanceof MBPartner_BH) {
			businessPartner = (MBPartner_BH) persistantObject;
		} else {
			return;
		}

		if (event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)) {
			beforeSaveRequest(businessPartner);
		} else if (event.getTopic().equals(IEventTopics.PO_AFTER_NEW)) {
			afterSaveRequest(businessPartner);
		} else if (event.getTopic().equals(IEventTopics.PO_BEFORE_CHANGE)) {
			beforeChangeRequest(businessPartner);
		} else if (event.getTopic().equals(IEventTopics.PO_AFTER_CHANGE)) {
			afterChangeRequest(businessPartner);
		}
	}

	private void afterChangeRequest(MBPartner_BH businessPartner) {
		MUser[] users = businessPartner.getContacts(true);
		for (MUser user : users) {
			updateUserFields(businessPartner, user);
			user.save();
		}

		MBPartnerLocation[] locations = businessPartner.getLocations(true);
		for (MBPartnerLocation location : locations) {
			location.setC_Location_ID(businessPartner.getBH_C_Location_ID());
			location.save();
		}
	}

	private void beforeChangeRequest(MBPartner_BH businessPartner) {
		translateToMaskedFields(businessPartner);
	}

	private void beforeSaveRequest(MBPartner_BH businessPartner) {

		// Set client & org?
		int clientId = businessPartner.getAD_Client_ID();
		int orgId = businessPartner.getAD_Org_ID();
		translateToMaskedFields(businessPartner);

		// Set BP Group?
		// businessPartner.setBPGroup(group);

		if (businessPartner.isCustomer()) {
			// Set the invoice rule
			businessPartner.setInvoiceRule(MOrder.INVOICERULE_Immediate);

			// Set the invoice schedule?

			// Set the payment rule
			businessPartner.setPaymentRule(MOrder.PAYMENTRULE_Cash);

			// Set the payment term
			MPaymentTerm paymentTerm = QueryUtil.queryTableByOrgAndClient(clientId, orgId, Env.getCtx(),
					MPaymentTerm.Table_Name, MPaymentTerm.COLUMNNAME_Name + " = 'Immediate'", null);
			businessPartner.setC_PaymentTerm_ID(paymentTerm.getC_PaymentTerm_ID());

			// Set the price list
			// First check to see if any pricing list has been defaulted for the BP Group
			int priceListId = businessPartner.getBPGroup().getM_PriceList_ID();
			if (priceListId == 0) {
				String whereClause = MPriceList.COLUMNNAME_IsDefault + " ='Y' AND "
						+ MPriceList.COLUMNNAME_IsSOPriceList + "='Y' AND " + MPriceList.COLUMNNAME_AD_Org_ID + "="
						+ Env.getAD_Org_ID(Env.getCtx());
				// Get the default sales price list
				priceListId = QueryUtil
						.getQueryByOrgAndClient(clientId, orgId, Env.getCtx(), MPriceList.Table_Name, whereClause, null)
						.setOnlyActiveRecords(true).firstId();
			}
			businessPartner.setM_PriceList_ID(priceListId);
		}
		if (businessPartner.isVendor()) {
			// Set the payment rule
			businessPartner.setPaymentRulePO(MOrder.PAYMENTRULE_DirectDeposit);

			// Set the PO payment term
			MPaymentTerm purchasePaymentTerm = QueryUtil.queryTableByOrgAndClient(clientId, orgId, Env.getCtx(),
					MPaymentTerm.Table_Name, "name = 'Immediate'", null);
			if (purchasePaymentTerm == null) {
				throw new RuntimeException(
						"Could not find in table '" + MPaymentTerm.Table_Name + "'" + " record with name 'Immediate'");
			}
			businessPartner.setPO_PaymentTerm_ID(purchasePaymentTerm.getC_PaymentTerm_ID());

			//Get the default purchase price list for vendors
			String defaultPurchasePList = MPriceList.COLUMNNAME_IsDefault + " ='Y' AND "
					+ MPriceList.COLUMNNAME_IsSOPriceList + "='N' AND " + MPriceList.COLUMNNAME_AD_Org_ID + "="
					+ Env.getAD_Org_ID(Env.getCtx());
			
			MPriceList purchasePriceList = QueryUtil.getQueryByOrgAndClient(clientId, orgId, Env.getCtx(),
					MPriceList.Table_Name, defaultPurchasePList, null)
					.setOnlyActiveRecords(true)
					.first();
			if (purchasePriceList == null) {
				throw new AdempiereException(
						"Could not find a default purchase price list in table '" + MPriceList.Table_Name + "'");
			}
			businessPartner.setPO_PriceList_ID(purchasePriceList.getM_PriceList_ID());
		}
	}

	private void translateToMaskedFields(MBPartner_BH businessPartner) {

		businessPartner.setIsCustomer(businessPartner.isBH_IsPatient());
		businessPartner.set_ValueOfColumn(MBPartner_BH.COLUMNNAME_BH_ApproximateYears, null);
	}

	private void afterSaveRequest(MBPartner_BH businessPartner) {

		// Add the business partner as the contact
		MUser user = new MUser(businessPartner);
		updateUserFields(businessPartner, user);
		user.save();

		// Add a the location or a default location if no location given (address)
		MBPartnerLocation businessPartnerLocation = new MBPartnerLocation(businessPartner);
		if (businessPartner.getBH_C_Location_ID() == 0) {
			MCountry country = (new Query(Env.getCtx(), MCountry.Table_Name,
					MCountry.COLUMNNAME_CountryCode + " = '" + IBHConfig.DEFAULT_LOCATION_COUNTRY_CODE + "'", null))
							.first();
			MLocation location = new MLocation(country, null);
			location.save();

			businessPartnerLocation.setC_Location_ID(location.get_ID());
		} else {
			businessPartnerLocation.setC_Location_ID(businessPartner.getBH_C_Location_ID());
		}

		businessPartnerLocation.setName(IBHConfig.DEFAULT_LOCATION_NAME);
		businessPartnerLocation.save();
	}

	private void updateUserFields(MBPartner_BH businessPartner, MUser user) {
		user.setName(businessPartner.getName());
		user.setIsFullBPAccess(false);
		user.setIsActive(true);
		user.setNotificationType(MUser.NOTIFICATIONTYPE_None);
		user.setBirthday(businessPartner.getBH_Birthday());
		user.setEMail(businessPartner.getBH_EMail());
		user.setPhone(businessPartner.getBH_Phone());
	}

}
