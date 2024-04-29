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
		registerTableEvent(IEventTopics.PO_BEFORE_CHANGE, MCharge_BH.Table_Name);
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
		if (charge.getClass().toString().contains("graphql.model")) {
			return;
		}

		switch (event.getTopic()) {
			case IEventTopics.PO_BEFORE_NEW -> beforeSaveRequest(charge);
			case IEventTopics.PO_BEFORE_CHANGE -> beforeChangeRequest(charge);
			case IEventTopics.PO_BEFORE_DELETE -> beforeDeleteRequest(charge);
		}
	}

	private void beforeChangeRequest(MCharge_BH charge) {
	}

	private void beforeSaveRequest(MCharge_BH charge) {
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
}
