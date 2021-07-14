package org.bandahealth.idempiere.base.modelevent;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAcctSchemaDefault;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.model.X_C_Charge_Acct;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.osgi.service.event.Event;

public class ChargeModelEvent extends AbstractEventHandler {

	private CLogger log = CLogger.getCLogger(ChargeModelEvent.class);

	@Override
	protected void initialize() {

		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MCharge_BH.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_NEW, MCharge_BH.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_CHANGE, MCharge_BH.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_CHANGE, MCharge_BH.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_DELETE, MCharge_BH.Table_Name);
	}

	@Override
	protected void doHandleEvent(Event event) {
		MCharge_BH charge = null;
		PO persistentObject = getPO(event);
		if (persistentObject instanceof MCharge_BH) {
			charge = (MCharge_BH) persistentObject;
		} else {
			return;
		}

		if (event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)) {
			beforeSaveRequest(charge);
		} else if (event.getTopic().equals(IEventTopics.PO_AFTER_NEW)) {
			afterSaveRequest(charge);
		} else if (event.getTopic().equals(IEventTopics.PO_BEFORE_CHANGE)) {
			beforeChangeRequest(charge);
		} else if (event.getTopic().equals(IEventTopics.PO_AFTER_CHANGE)) {
			afterChangeRequest(charge);
		} else if (event.getTopic().equals(IEventTopics.PO_BEFORE_DELETE)) {
			beforeDeleteRequest(charge);
		}
	}

	private void beforeChangeRequest(MCharge_BH charge) {
	}

	private void afterChangeRequest(MCharge_BH charge) {
		updateChargeAccount(charge);
	}

	private void beforeSaveRequest(MCharge_BH charge) {
	}

	private void afterSaveRequest(MCharge_BH charge) {
		updateChargeAccount(charge);
	}

	private void beforeDeleteRequest(MCharge_BH charge) {
		String chargeTrx = charge.get_TrxName();
		// Delete the combination this charge was using, if it's not the default
		// Get the current mapped chargeAccount
		X_C_Charge_Acct existingMappedChargeAccount = (X_C_Charge_Acct) new Query(
				Env.getCtx(),
				X_C_Charge_Acct.Table_Name,
				X_C_Charge_Acct.COLUMNNAME_C_Charge_ID + " = " + charge.getC_Charge_ID(),
				chargeTrx
		)
				.first();
		if (existingMappedChargeAccount == null) {
			return;
		}
		// Get the combination now assigned to the charge
		MAccount existingChargeCombination = new MAccount(
				Env.getCtx(),
				existingMappedChargeAccount.getCh_Expense_Acct(),
				chargeTrx
		);
		MAcctSchemaDefault acctSchemaDefault =
				MAcctSchemaDefault.get(Env.getCtx(), existingChargeCombination.getC_AcctSchema_ID());
		boolean isCurrentCombinationDefault =
				acctSchemaDefault.getCh_Expense_Acct() == existingChargeCombination.getC_ValidCombination_ID();
		if (!isCurrentCombinationDefault) {
			existingChargeCombination.delete(false, chargeTrx);
		}
	}

	private void updateChargeAccount(MCharge_BH charge) {
		String chargeTrx = charge.get_TrxName();
		// Get the current mapped chargeAccount
		X_C_Charge_Acct existingMappedChargeAccount = (X_C_Charge_Acct) new Query(
				Env.getCtx(),
				X_C_Charge_Acct.Table_Name,
				X_C_Charge_Acct.COLUMNNAME_C_Charge_ID + " = " + charge.getC_Charge_ID(),
				chargeTrx
		)
				.first();
		if (existingMappedChargeAccount == null) {
			return;
		}
		// If this is coming through the charge screen (or another screen) where no account is directly selected,
		// the account ID will be null. Return, if this is the case
		if (!charge.hasC_ElementValue_ID()) {
			// Set the value of c_elementvalue_id to be default
			charge.setC_ElementValue_ID(existingMappedChargeAccount.getCh_Expense_A().getAccount_ID());
			charge.save();
			return;
		}

		// Get the combination now assigned to the charge (this will exist if existingMappedChargeAccount does)
		MAccount existingChargeCombination = new MAccount(
				Env.getCtx(),
				existingMappedChargeAccount.getCh_Expense_Acct(),
				chargeTrx
		);
		// This default schema is created when a client is made and will always be there
		MAcctSchemaDefault acctSchemaDefault =
				MAcctSchemaDefault.get(Env.getCtx(), existingChargeCombination.getC_AcctSchema_ID());
		boolean isExistingCombinationDefault =
				acctSchemaDefault.getCh_Expense_Acct() == existingChargeCombination.getC_ValidCombination_ID();
		boolean isDesiredCombinationDefault =
				charge.getC_ElementValue_ID() == acctSchemaDefault.getCh_Expense_A().getAccount_ID();

		// If what we want is what we have, we're done
		if (isExistingCombinationDefault && isDesiredCombinationDefault) {
			return;
		}

		// If the current combination is default, we need a new one
		if (isExistingCombinationDefault) {
			// So create a new combination...
			MAccount newChargeCombination = new MAccount(Env.getCtx(), 0, null);
			newChargeCombination.set_ValueOfColumn(MAccount.COLUMNNAME_AD_Client_ID, charge.getAD_Client_ID());
			newChargeCombination.setAccount_ID(existingMappedChargeAccount.getCh_Expense_A().getAccount_ID());
			newChargeCombination.setAccount_ID(charge.getC_ElementValue_ID());

			// Get the current account schema
			MAcctSchema accountSchema = (MAcctSchema) new Query(
					Env.getCtx(),
					MAcctSchema.Table_Name,
					MAcctSchema.COLUMNNAME_AD_Client_ID + " = " + charge.getAD_Client_ID(),
					chargeTrx
			)
					.first();
			newChargeCombination.setC_AcctSchema_ID(accountSchema.getC_AcctSchema_ID());
			newChargeCombination.setValueDescription();
			newChargeCombination.save();

			existingChargeCombination = newChargeCombination;
		}

		if (isDesiredCombinationDefault) {
			// This means that what they want is default, but they have a created combination, so delete what they have
			// and update accordingly
			existingChargeCombination.delete(false, chargeTrx);
			existingMappedChargeAccount.setCh_Expense_Acct(acctSchemaDefault.getCh_Expense_Acct());
		} else {
			existingMappedChargeAccount.setCh_Expense_Acct(existingChargeCombination.getC_ValidCombination_ID());
		}
		existingMappedChargeAccount.save();
	}
}
