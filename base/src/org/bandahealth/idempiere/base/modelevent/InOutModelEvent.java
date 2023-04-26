package org.bandahealth.idempiere.base.modelevent;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.compiere.model.MInOut;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.osgi.service.event.Event;

public class InOutModelEvent extends AbstractEventHandler {

	private CLogger log = CLogger.getCLogger(InOutModelEvent.class);

	@Override
	protected void initialize() {
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MInOut_BH.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_CHANGE, MInOut_BH.Table_Name);
	}

	@Override
	protected void doHandleEvent(Event event) {
		MInOut_BH inOut = null;
		MInOut inOutFromCode = null;
		PO persistentObject = getPO(event);
		if (persistentObject instanceof MInOut_BH) {
			inOut = (MInOut_BH) persistentObject;
		} else if (persistentObject instanceof MInOut) {
			inOutFromCode = (MInOut) persistentObject;
		} else {
			return;
		}

		if (event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)) {
			setVisitIdFromOrder(inOut == null ? inOutFromCode : inOut);
		} else if (event.getTopic().equals(IEventTopics.PO_BEFORE_CHANGE)) {
			setVisitIdFromOrder(inOut == null ? inOutFromCode : inOut);
		}
	}

	/**
	 * Takes care of setting the visit ID from the order
	 */
	private void setVisitIdFromOrder(MInOut inOut) {
		if (inOut.getC_Order_ID() > 0) {
			inOut.set_ValueOfColumn(MInOut_BH.COLUMNNAME_BH_Visit_ID,
					DB.getSQLValueEx(inOut.get_TrxName(), "SELECT bh_visit_id FROM c_order WHERE c_order_id = ?",
							inOut.getC_Order_ID()));
		}
	}
}
