package org.bandahealth.idempiere.base.modelevent;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.bandahealth.idempiere.base.model.MBHPaymentRef;
import org.bandahealth.idempiere.base.model.MBHPaymentRefBankAccount;
import org.compiere.model.*;
import org.compiere.model.MBankAccount;
import org.compiere.model.MRefList;
import org.compiere.model.MReference;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.osgi.service.event.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

	/**
	 * Since the Reference Lists the Payment References point to are maintained elsewhere, they need
	 * to be synced from time to time. This method takes care of adding, removing, and updating reference
	 * list values so the lists stay in sync.
	 * @param paymentRef
	 */
	public static void synchronizeReferenceListValues(MBHPaymentRef paymentRef) {
		// Get the reference list items for each reference
		List<MRefList> refLists = new Query(
				Env.getCtx(),
				MRefList.Table_Name,
				MRefList.COLUMNNAME_AD_Reference_ID + "=?",
				paymentRef.get_TrxName()
		)
				.setParameters(paymentRef.getAD_Reference_ID())
				.list();
		// Get the default bank account for this org and client
		MBankAccount defaultBankAccount = new Query(
				Env.getCtx(),
				MBankAccount.Table_Name,
				MBankAccount.COLUMNNAME_AD_Client_ID + "=? AND " +
						MBankAccount.COLUMNNAME_AD_Org_ID + "=? AND " +
						MBankAccount.COLUMNNAME_IsDefault + "=?",
				paymentRef.get_TrxName()
		)
				.setOnlyActiveRecords(true)
				.setParameters(
						paymentRef.getAD_Client_ID(),
						paymentRef.getAD_Org_ID(),
						"Y"
				)
				.first();
		// Get the current payment reference values
		List<MBHPaymentRefBankAccount> existingPaymentRefBankAccounts = new Query(
				Env.getCtx(),
				MBHPaymentRefBankAccount.Table_Name,
				MBHPaymentRefBankAccount.COLUMNNAME_BH_PaymentRef_ID + "=?",
				paymentRef.get_TrxName()
		)
				.setParameters(paymentRef.getBH_PaymentRef_ID())
				.list();
		if (defaultBankAccount == null) {
			return;
		}

		// Pluck the reference list ids for easy comparison
		List<Integer> existingPaymentRefBankAccountRefListIds = existingPaymentRefBankAccounts
				.stream()
				.map(MBHPaymentRefBankAccount::getAD_Ref_List_ID)
				.collect(Collectors.toList());
		List<Integer> neededRefListIds = refLists
				.stream()
				.map(MRefList::getAD_Ref_List_ID)
				.collect(Collectors.toList());

		// Get the values to add/remove
		List<MRefList> entitiesToAdd = refLists.stream()
				.filter(refList -> !existingPaymentRefBankAccountRefListIds.contains(refList.getAD_Ref_List_ID()))
				.collect(Collectors.toList());
		List<MBHPaymentRefBankAccount> entitiesToRemove = existingPaymentRefBankAccounts
				.stream()
				.filter(bankAccount -> !neededRefListIds.contains(bankAccount.getAD_Ref_List_ID()))
				.collect(Collectors.toList());
		List<MBHPaymentRefBankAccount> entitiesToUpdate = existingPaymentRefBankAccounts
				.stream()
				.filter(bankAccount -> neededRefListIds.contains(bankAccount.getAD_Ref_List_ID()))
				.collect(Collectors.toList());

		// Add entities we need to add
		for (MRefList refList : entitiesToAdd) {
			MBHPaymentRefBankAccount paymentRefBankAccount = new MBHPaymentRefBankAccount(refList, defaultBankAccount);
			paymentRefBankAccount.setBH_PaymentRef_ID(paymentRef.getBH_PaymentRef_ID());
			paymentRefBankAccount.saveEx();
		}
		// Delete entities we need to remove
		for (MBHPaymentRefBankAccount paymentRefBankAccount : entitiesToRemove) {
			paymentRefBankAccount.deleteEx(true, paymentRef.get_TrxName());
		}
		// Update entities that remain
		Map<Integer, MRefList> refListsById = refLists
				.stream()
				.collect(Collectors.toMap(MRefList::getAD_Ref_List_ID, rl -> rl));
		for (MBHPaymentRefBankAccount paymentRefBankAccount : entitiesToUpdate) {
			MRefList refListToUse = refListsById.get(paymentRefBankAccount.getAD_Ref_List_ID());
			if (refListToUse != null &&
					!refListToUse.getValue().equalsIgnoreCase(paymentRefBankAccount.getBH_PaymentRefList_Value())) {
				paymentRefBankAccount.setBH_PaymentRefList_Value(refListToUse.getValue());
				paymentRefBankAccount.saveEx();
			}
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
		BHPaymentRefModelEvent.synchronizeReferenceListValues(paymentRef);
	}

	private void beforeSaveRequest(MBHPaymentRef paymentRef) {
		updatePaymentRefName(paymentRef);
	}

	private void afterChangeRequest(MBHPaymentRef paymentRef) {
		BHPaymentRefModelEvent.synchronizeReferenceListValues(paymentRef);
	}

	private void beforeDeleteRequest(MBHPaymentRef paymentRef) {
		deleteCurrentPaymentRefBankAccounts(paymentRef);
	}

	/**
	 * Ensure the name assigned to the payment reference matches the actual reference
	 * @param paymentRef
	 */
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

	/**
	 * Remove all children of this payment reference
	 * @param paymentRef
	 */
	private void deleteCurrentPaymentRefBankAccounts(MBHPaymentRef paymentRef) {
		List<MBHPaymentRefBankAccount> paymentRefBankAccounts = new Query(
				Env.getCtx(),
				MBHPaymentRefBankAccount.Table_Name,
				MBHPaymentRefBankAccount.COLUMNNAME_BH_PaymentRef_ID + "=?",
				paymentRef.get_TrxName()
		)
				.setParameters(paymentRef.getBH_PaymentRef_ID())
				.list();

		for (MBHPaymentRefBankAccount paymentRefBankAccount : paymentRefBankAccounts) {
			paymentRefBankAccount.deleteEx(true, paymentRef.get_TrxName());
		}
	}
}
