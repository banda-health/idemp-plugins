package org.bandahealth.idempiere.base.modelevent;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.bandahealth.idempiere.base.config.BHConfigLoader;
import org.bandahealth.idempiere.base.config.IBHConfig;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.I_C_BPartner;
import org.compiere.model.I_C_Country;
import org.compiere.model.MBPartner;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MCountry;
import org.compiere.model.MLocation;
import org.compiere.model.MOrder;
import org.compiere.model.MPaymentTerm;
import org.compiere.model.MPriceList;
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
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, I_C_BPartner.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_NEW, I_C_BPartner.Table_Name);
		// load bandahealth configs
		// BHConfigLoader.getInstance(); -- Application not yet started
	}

	@Override
	protected void doHandleEvent(Event event) {
		BHConfigLoader.getInstance();

		MBPartner businessPartner = null;
		PO persistantObject = getPO(event);
		if (persistantObject instanceof MBPartner) {
			businessPartner = (MBPartner) persistantObject;
		} else {
			return;
		}

		if (event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)) {
			beforeSaveRequest(businessPartner);
		} else if (event.getTopic().equals(IEventTopics.PO_AFTER_NEW)) {
			afterSaveRequest(businessPartner);
		}
	}

	private void beforeSaveRequest(MBPartner businessPartner) {

		// Set client & org?
		int clientId = businessPartner.getAD_Client_ID();
		int orgId = businessPartner.getAD_Org_ID();

		// Set BP Group?
		// businessPartner.setBPGroup(group);

		if (businessPartner.isCustomer()) {
			// Set the invoice rule
			businessPartner.setInvoiceRule(MOrder.INVOICERULE_Immediate);

			// Set the invoice schedule

			// Set the payment rule
			businessPartner.setPaymentRule(MOrder.PAYMENTRULE_Cash);

			// Set the payment term
			MPaymentTerm paymentTerm = QueryUtil.queryTableByOrgAndClient(clientId, orgId, Env.getCtx(),
					MPaymentTerm.Table_Name, MPaymentTerm.COLUMNNAME_Name + " = 'Immediate'", null);
			businessPartner.setC_PaymentTerm_ID(paymentTerm.getC_PaymentTerm_ID());

			// Set the price list
			int priceListId = businessPartner.getBPGroup().getM_PriceList_ID();
			if (priceListId == 0) {
				priceListId = QueryUtil.queryTableByOrgAndClient(clientId, orgId, Env.getCtx(),
						MPriceList.Table_Name, "name = 'Standard' and isactive = 'Y'", null).get_ID();
			}
			businessPartner.setM_PriceList_ID(priceListId);
		}
		if (businessPartner.isVendor()) {
			// Set the payment rule
			businessPartner.setPaymentRulePO(MOrder.PAYMENTRULE_DirectDeposit);

			// Set the PO payment term
			MPaymentTerm purchasePaymentTerm = QueryUtil.queryTableByOrgAndClient(clientId, orgId, Env.getCtx(),
					MPaymentTerm.Table_Name, "name = 'Immediate'", null);
			businessPartner.setPO_PaymentTerm_ID(purchasePaymentTerm.getC_PaymentTerm_ID());

			// Set the purchase price list
			MPriceList purchasePriceList = QueryUtil.queryTableByOrgAndClient(clientId, orgId, Env.getCtx(),
					MPriceList.Table_Name, "name = 'Purchase' and isactive = 'Y'", null);
			businessPartner.setPO_PriceList_ID(purchasePriceList.getM_PriceList_ID());
		}
	}

	private void afterSaveRequest(MBPartner businessPartner) {

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

			MCountry country = (new Query(Env.getCtx(), I_C_Country.Table_Name, I_C_Country.COLUMNNAME_CountryCode
					+ " = '" + IBHConfig.DEFAULT_LOCATION_COUNTRY_CODE + "'", null)).first();

			MLocation location = new MLocation(country, null);
			location.save();

			businessPartnerLocation.setC_Location_ID(location.get_ID());
			businessPartnerLocation.setName(IBHConfig.DEFAULT_LOCATION_NAME);
			businessPartnerLocation.save();
		}
	}

}
