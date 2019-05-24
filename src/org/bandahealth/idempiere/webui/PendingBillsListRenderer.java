package org.bandahealth.idempiere.webui;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.compiere.model.MBPartner;
import org.compiere.model.MOrder;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

public class PendingBillsListRenderer implements ListitemRenderer<MOrder>  {

	@Override
	public void render(Listitem item, MOrder order, int index) throws Exception {
		String patientId = MBPartner.COLUMNNAME_C_BPartner_ID + "= " + String.valueOf(order.getC_BPartner_ID());
		MBPartner patient = new Query(Env.getCtx(), MBPartner.Table_Name, patientId, null)
				.setOnlyActiveRecords(true).first();
		NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "KE"));
		item.setValue(order.getDocumentNo());
		createListCell(item, patient.getName());
		createListCell(item, formatter.format(order.getGrandTotal()));
		createListCell(item, new SimpleDateFormat("dd-MMM").format(order.getCreated()));
		item.setSclass("bh-draft-so-list");
		
	}
	
	private void createListCell(Listitem listItem, String value) {
		Listcell listcell = new Listcell();
		Label label = new Label(value);
		label.setParent(listcell);
		listcell.setParent(listItem);
	}
}
