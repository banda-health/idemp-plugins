package org.bandahealth.idempiere.base.modelevent;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.compiere.model.MTable;
import org.compiere.model.MUser;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.osgi.service.event.Event;

public class UserModelEvent extends AbstractEventHandler {

	private CLogger log = CLogger.getCLogger(UserModelEvent.class);

	@Override
	protected void initialize() {
		registerTableEvent(IEventTopics.PO_AFTER_NEW, MUser.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_CHANGE, MUser.Table_Name);
	}

	@Override
	protected void doHandleEvent(Event event) {
		MUser user = null;
		PO persistantObject = getPO(event);
		if (persistantObject instanceof MUser) {
			user = (MUser) persistantObject;
		} else {
			return;
		}

		if (event.getTopic().equals(IEventTopics.PO_AFTER_NEW)) {
			afterSaveRequest(user);
		} else if (event.getTopic().equals(IEventTopics.PO_AFTER_CHANGE)) {
			afterChangeRequest(user);
		}
	}

	private void afterChangeRequest(MUser user) {
		updateBusinessPartner(user);
	}

	private void updateBusinessPartner(MUser user) {
		if (user.getC_BPartner_ID() != 0) {
			// Get the business partner this user is assigned to
			MBPartner_BH businessPartner = (MBPartner_BH) MTable.get(Env.getCtx(), MBPartner_BH.Table_Name)
					.getPO(user.getC_BPartner_ID(), user.get_TrxName());

			boolean didUpdateBusinessPartner = false;
			if (user.getBirthday() != null && (businessPartner.getBH_Birthday() == null ||
					user.getBirthday().getTime() != businessPartner.getBH_Birthday().getTime())) {
				didUpdateBusinessPartner = true;
				businessPartner.setBH_Birthday(user.getBirthday());
			}
			if (user.getEMail() != null &&
					(businessPartner.getBH_EMail() == null || !user.getEMail().equals(businessPartner.getBH_EMail()))) {
				didUpdateBusinessPartner = true;
				businessPartner.setBH_EMail(user.getEMail());
			}
			if (user.getPhone() != null &&
					(businessPartner.getBH_Phone() == null || !user.getPhone().equals(businessPartner.getBH_Phone()))) {
				didUpdateBusinessPartner = true;
				businessPartner.setBH_Phone(user.getPhone());
			}

			if (didUpdateBusinessPartner) {
				businessPartner.save();
			}
		}
	}

	private void afterSaveRequest(MUser user) {
		updateBusinessPartner(user);
	}

}
