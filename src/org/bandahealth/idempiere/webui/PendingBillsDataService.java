package org.bandahealth.idempiere.webui;

import java.util.List;

import org.compiere.model.MOrder;
import org.compiere.model.MQuery;
import org.compiere.model.MWindow;
import org.compiere.model.Query;
import org.compiere.util.Env;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

public class PendingBillsDataService {

	private static Integer MAX_RESULTS_SIZE = 20;

	public static List<MOrder> getBillsInDraftState() {
		List<MOrder> results = new Query(Env.getCtx(), MOrder.Table_Name,
		        "docstatus = 'DR' AND issotrx = 'Y' AND  ad_client_id = " + Env.getCtx().getProperty("#AD_Client_ID"),
		        null).setOnlyActiveRecords(true).setOrderBy(MOrder.COLUMNNAME_DateOrdered + " DESC")
		                .setPageSize(MAX_RESULTS_SIZE).list();
		return results;
	}

	public static int getBillingWindowId() {
		MWindow bhSOWindow = new Query(Env.getCtx(), MWindow.Table_Name,
		        MWindow.COLUMNNAME_Name + " LIKE '%Patient Bill%'", null).setOnlyActiveRecords(true).first();
		int windowId = bhSOWindow.getAD_Window_ID();
		return windowId;
	}

	public static MQuery createQueryForSelectedBill(int documentNumber) {
		MQuery query = new MQuery(MOrder.Table_Name);
		query.addRestriction(MOrder.COLUMNNAME_DocumentNo + "='" + String.valueOf(documentNumber) + "' AND "
		        + MOrder.COLUMNNAME_DocStatus + "='DR'");
		return query;
	}

}
