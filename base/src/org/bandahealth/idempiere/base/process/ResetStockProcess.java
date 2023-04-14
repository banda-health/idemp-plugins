package org.bandahealth.idempiere.base.process;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;

import org.compiere.model.MStorageOnHand;
import org.compiere.model.Query;
import org.compiere.process.SvrProcess;

/**
 * This process resets negative stocks to zero for a given client
 * 
 * @author andrew
 *
 */
public class ResetStockProcess extends SvrProcess {

	@Override
	protected void prepare() {
	}

	@Override
	protected String doIt() throws Exception {
		long start = System.currentTimeMillis();
		log.log(Level.INFO, "START ResetStockProcess");

		int count = 0;
		String whereClause = MStorageOnHand.COLUMNNAME_QtyOnHand + "< 0";
		List<MStorageOnHand> stocks = new Query(getCtx(), MStorageOnHand.Table_Name, whereClause, get_TrxName())
				.setClient_ID().setOnlyActiveRecords(true).list();
		for (MStorageOnHand stock : stocks) {
			UpdateStock.updateStock(stock, BigDecimal.ONE);
			count++;
		}

		String msg = "STOP ResetStockProcess. Took " + (System.currentTimeMillis() - start) / 1000 / 60
				+ " mins. Processed " + count + " records(s).";
		log.log(Level.INFO, msg);

		return msg;
	}

}
