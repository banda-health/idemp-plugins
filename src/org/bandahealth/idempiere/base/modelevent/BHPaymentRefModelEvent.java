package org.bandahealth.idempiere.base.modelevent;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.config.IBHConfig;
import org.bandahealth.idempiere.base.model.MBHPaymentRef;
import org.bandahealth.idempiere.base.model.MBHPaymentRefBankAccount;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.utils.NumberUtils;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.*;
import org.compiere.model.MBankAccount;
import org.compiere.model.MRefList;
import org.compiere.model.MReference;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.osgi.service.event.Event;

import java.util.List;

public class BHPaymentRefModelEvent extends AbstractEventHandler {

	private CLogger log = CLogger.getCLogger(BHPaymentRefModelEvent.class);

	@Override
	protected void initialize() {

		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MBHPaymentRef.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_NEW, MBHPaymentRef.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_CHANGE, MBHPaymentRef.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_CHANGE, MBHPaymentRef.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_DELETE, MBHPaymentRef.Table_Name);
	}

	@Override
	protected void doHandleEvent(Event event) {
		MBHPaymentRef paymentRef = null;
		PO persistantObject = getPO(event);
		if (persistantObject instanceof MBHPaymentRef) {
			paymentRef = (MBHPaymentRef) persistantObject;
		} else {
			return;
		}

		if (event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)) {
			beforeSaveRequest(paymentRef);
		} else if (event.getTopic().equals(IEventTopics.PO_AFTER_NEW)) {
			afterSaveRequest(paymentRef);
		} else if (event.getTopic().equals(IEventTopics.PO_BEFORE_CHANGE)) {
			beforeChangeRequest(paymentRef);
		} else if (event.getTopic().equals(IEventTopics.PO_AFTER_CHANGE)) {
			afterChangeRequest(paymentRef);
		} else if (event.getTopic().equals(IEventTopics.PO_BEFORE_DELETE)) {
			beforeDeleteRequest(paymentRef);
		}
	}

	private void beforeChangeRequest(MBHPaymentRef paymentRef) {
		MBHPaymentRef oldDBPaymentRef = new Query(
				Env.getCtx(),
				MBHPaymentRef.Table_Name,
				MBHPaymentRef.COLUMNNAME_BH_PaymentRef_ID + "=?",
				null
		)
				.setParameters(paymentRef.getBH_PaymentRef_ID())
				.first();
		if (oldDBPaymentRef == null || oldDBPaymentRef.getAD_Reference_ID() != paymentRef.getAD_Reference_ID()) {
			updatePaymentRefName(paymentRef);
		}
	}

	private void afterSaveRequest(MBHPaymentRef paymentRef) {
		createPaymentRefBankAccounts(paymentRef);
	}

	private void beforeSaveRequest(MBHPaymentRef paymentRef) {
		updatePaymentRefName(paymentRef);
	}

	private void afterChangeRequest(MBHPaymentRef paymentRef) {
		MBHPaymentRef oldDBPaymentRef = new Query(
				Env.getCtx(),
				MBHPaymentRef.Table_Name,
				MBHPaymentRef.COLUMNNAME_BH_PaymentRef_ID + "=?",
				null
		)
				.setParameters(paymentRef.getBH_PaymentRef_ID())
				.first();
		if (oldDBPaymentRef == null || oldDBPaymentRef.getAD_Reference_ID() != paymentRef.getAD_Reference_ID()) {
			deleteCurrentPaymentRefBankAccounts(paymentRef);
			createPaymentRefBankAccounts(paymentRef);
		}
	}

	private void beforeDeleteRequest(MBHPaymentRef paymentRef) {
		deleteCurrentPaymentRefBankAccounts(paymentRef);
	}

	private void updatePaymentRefName(MBHPaymentRef paymentRef) {
		// Set the name of this to be the reference name
		MReference reference = new Query(
				Env.getCtx(),
				MReference.Table_Name,
				MReference.COLUMNNAME_AD_Reference_ID + "=?",
				null
		)
				.setParameters(paymentRef.getAD_Reference_ID())
				.first();
		if (reference == null) {
			return;
		}
		paymentRef.setName(reference.getName());
	}

	private void createPaymentRefBankAccounts(MBHPaymentRef paymentRef) {
		// Get the reference list items for each reference
		List<MRefList> refLists = new Query(
				Env.getCtx(),
				MRefList.Table_Name,
				MRefList.COLUMNNAME_AD_Reference_ID + "=?",
				paymentRef.get_TrxName()
		)
				.setParameters(paymentRef.getAD_Reference_ID())
				.list();
		if (refLists == null) {
			return;
		}
		// Get the default bank account for this org and client
		MBankAccount defaultBankAccount = new Query(
				Env.getCtx(),
				MBankAccount.Table_Name,
				MBankAccount.COLUMNNAME_AD_Client_ID + "=? AND " +
						MBankAccount.COLUMNNAME_AD_Org_ID + "=? AND " +
						MBankAccount.COLUMNNAME_IsDefault + "=?",
				null
		)
				.setOnlyActiveRecords(true)
				.setParameters(
						paymentRef.getAD_Client_ID(),
						paymentRef.getAD_Org_ID(),
						"Y"
				)
				.first();
		if (defaultBankAccount == null) {
			return;
		}
		for (MRefList refList : refLists) {
			MBHPaymentRefBankAccount paymentRefBankAccount = new MBHPaymentRefBankAccount(refList, defaultBankAccount);
			paymentRefBankAccount.setBH_PaymentRef_ID(paymentRef.getBH_PaymentRef_ID());
			paymentRefBankAccount.saveEx();
		}
	}

	private void deleteCurrentPaymentRefBankAccounts(MBHPaymentRef paymentRef) {
		List<MBHPaymentRefBankAccount> paymentRefBankAccounts = new Query(
				Env.getCtx(),
				MBHPaymentRefBankAccount.Table_Name,
				MBHPaymentRefBankAccount.COLUMNNAME_BH_PaymentRef_ID + "=?",
				paymentRef.get_TrxName()
		)
				.setParameters(paymentRef.getBH_PaymentRef_ID())
				.list();
		if (paymentRefBankAccounts == null) {
			return;
		}
		for (MBHPaymentRefBankAccount paymentRefBankAccount : paymentRefBankAccounts) {
			paymentRefBankAccount.deleteEx(true, paymentRef.get_TrxName());
		}
	}
}
