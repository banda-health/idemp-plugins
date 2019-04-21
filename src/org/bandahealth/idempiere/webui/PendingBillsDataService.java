package org.bandahealth.idempiere.webui;

import java.util.List;

import org.compiere.model.MOrder;
import org.compiere.model.Query;
import org.compiere.util.Env;

public class PendingBillsDataService {
	
	private static Integer MAX_RESULTS_SIZE = 20;

	public static List<MOrder> getBillsInDraftState() {
		List<MOrder> results = new Query(Env.getCtx(), MOrder.Table_Name,
		        "docstatus = 'DR' AND issotrx = 'Y' AND  ad_client_id = " + Env.getCtx().getProperty("#AD_Client_ID"),
		        null).setOnlyActiveRecords(true).setOrderBy(MOrder.COLUMNNAME_DateOrdered + " DESC")
		                .setPageSize(MAX_RESULTS_SIZE).list();
		return results;
	}
	
	
}
