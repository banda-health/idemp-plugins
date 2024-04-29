package org.bandahealth.idempiere.base.modelevent;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.MPaymentTerm;
import org.compiere.model.MPriceList;
import org.compiere.model.MUser;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.osgi.service.event.Event;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BusinessPartnerModelEvent extends AbstractEventHandler {

	private CLogger log = CLogger.getCLogger(BusinessPartnerModelEvent.class);
	private final Set<String> businessPartnerUuidsWeAreUpdating = new HashSet<>();

	@Override
	protected void initialize() {
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MBPartner_BH.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_NEW, MBPartner_BH.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_CHANGE, MBPartner_BH.Table_Name);
	}

	@Override
	protected void doHandleEvent(Event event) {
		MBPartner_BH businessPartner = null;
		PO persistantObject = getPO(event);
		if (persistantObject instanceof MBPartner_BH) {
			businessPartner = (MBPartner_BH) persistantObject;
		} else {
			return;
		}
		if (businessPartnerUuidsWeAreUpdating.contains(businessPartner.getC_BPartner_UU())) {
			return;
		}
		if (businessPartner.getClass().toString().contains("graphql.model")) {
			return;
		}

		businessPartnerUuidsWeAreUpdating.add(businessPartner.getC_BPartner_UU());
		try {
			switch (event.getTopic()) {
				case IEventTopics.PO_BEFORE_NEW -> beforeSaveRequest(businessPartner);
				case IEventTopics.PO_AFTER_NEW -> afterSaveRequest(businessPartner);
				case IEventTopics.PO_AFTER_CHANGE -> afterChangeRequest(businessPartner);
			}
		} finally {
			businessPartnerUuidsWeAreUpdating.remove(businessPartner.getC_BPartner_UU());
		}
	}

	private void afterChangeRequest(MBPartner_BH businessPartner) {
		MUser[] users = businessPartner.getContacts(true);
		for (MUser user : users) {
			updateUserFields(businessPartner, user);
			user.save();
		}
	}

	private void beforeSaveRequest(MBPartner_BH businessPartner) {

		// Set client & org?
		int clientId = businessPartner.getAD_Client_ID();
		int orgId = businessPartner.getAD_Org_ID();

		// Set BP Group?
		// businessPartner.setBPGroup(group);

		if (businessPartner.isCustomer()) {
			if (businessPartner.getInvoiceRule() == null) {
				// Set the invoice rule
				businessPartner.setInvoiceRule(MBPartner_BH.INVOICERULE_Immediate);
			}

			// Set the invoice schedule?

			if (businessPartner.getPaymentRule() == null) {
				// Set the payment rule
				businessPartner.setPaymentRule(MBPartner_BH.PAYMENTRULE_OnCredit);
			}
			if (businessPartner.getSOCreditStatus() == null) {
				businessPartner.setSOCreditStatus(MBPartner_BH.SOCREDITSTATUS_NoCreditCheck);
			}

			if (businessPartner.getC_PaymentTerm_ID() < 1) {
				// Set the payment term
				MPaymentTerm paymentTerm =
						QueryUtil.queryTableByOrgAndClient(clientId, orgId, Env.getCtx(), MPaymentTerm.Table_Name,
								MPaymentTerm.COLUMNNAME_Name + " = 'Immediate'", businessPartner.get_TrxName());
				businessPartner.setC_PaymentTerm_ID(paymentTerm.getC_PaymentTerm_ID());
			}

			if (businessPartner.getM_PriceList_ID() < 1) {
				// Set the price list
				// First check to see if any pricing list has been defaulted for the BP Group
				int priceListId = businessPartner.getBPGroup().getM_PriceList_ID();
				if (priceListId == 0) {
					List<Object> parameters = new ArrayList<>(List.of("Y", "Y"));
					priceListId = new Query(businessPartner.getCtx(), MPriceList.Table_Name,
							MPriceList.COLUMNNAME_IsDefault + "=? AND " + MPriceList.COLUMNNAME_IsSOPriceList + "=?",
							businessPartner.get_TrxName()).setParameters(parameters).setOnlyActiveRecords(true).setClient_ID().first()
							.get_ID();
				}
				businessPartner.setM_PriceList_ID(priceListId);
			}

			// check unique patient id
			if (businessPartner.getBPGroup().getName().equals(MBPGroup_BH.NAME_Patients)) {
				generatePatientID(businessPartner);
			} else {
				businessPartner.setBH_PatientID(null);
			}
		}
		if (businessPartner.isVendor()) {
			if (businessPartner.getPaymentRulePO() == null) {
				// Set the payment rule
				businessPartner.setPaymentRulePO(MBPartner_BH.PAYMENTRULE_DirectDeposit);
			}

			if (businessPartner.getPO_PaymentTerm_ID() < 1) {
				// Set the PO payment term
				MPaymentTerm purchasePaymentTerm = QueryUtil.queryTableByOrgAndClient(clientId, orgId, Env.getCtx(),
						MPaymentTerm.Table_Name, "name = 'Immediate'", businessPartner.get_TrxName());
				if (purchasePaymentTerm == null) {
					throw new RuntimeException(
							"Could not find in table '" + MPaymentTerm.Table_Name + "'" + " record with name 'Immediate'");
				}
				businessPartner.setPO_PaymentTerm_ID(purchasePaymentTerm.getC_PaymentTerm_ID());
			}

			if (businessPartner.getPO_PriceList_ID() < 1) {
				// Get the default purchase price list for vendors
				MPriceList purchasePriceList = new Query(Env.getCtx(), MPriceList.Table_Name,
						MPriceList.COLUMNNAME_IsDefault + "=? AND " + MPriceList.COLUMNNAME_IsSOPriceList + "=?",
						businessPartner.get_TrxName()).setParameters(true, false).setOnlyActiveRecords(true).setClient_ID()
						.setOrderBy(MPriceList.COLUMNNAME_Created + " DESC").first();
				if (purchasePriceList == null) {
					throw new AdempiereException(
							"Could not find a default purchase price list in table '" + MPriceList.Table_Name + "'");
				}
				businessPartner.setPO_PriceList_ID(purchasePriceList.getM_PriceList_ID());
			}
		}
	}

	private void afterSaveRequest(MBPartner_BH businessPartner) {
		// Add the business partner as the contact
		MUser user = new MUser(businessPartner);
		updateUserFields(businessPartner, user);
		user.save();
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

	/**
	 * Generate a unique patient id if the current one is not null
	 *
	 * @param patient
	 */
	private void generatePatientID(MBPartner_BH patient) {
		if (patient.getBH_PatientID() != null && !patient.getBH_PatientID().isEmpty()) {
			return;
		}

		Object generatedPatientId = QueryUtil.generateNextBHPatientId(patient);
		patient.setBH_PatientID(String.valueOf(generatedPatientId));
	}
}
