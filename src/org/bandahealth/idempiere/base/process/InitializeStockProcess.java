package org.bandahealth.idempiere.base.process;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;

import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.Query;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;

public class InitializeStockProcess extends SvrProcess {

	@Override
	protected void prepare() {
	}

	@Override
	protected String doIt() throws Exception {
		long start = System.currentTimeMillis();
		log.log(Level.INFO, "START InitializeStockProcess");

		int count = 0;
		String whereClause = MProduct_BH.Table_Name + "." + MProduct_BH.COLUMNNAME_M_Product_ID + " NOT IN (SELECT "
				+ MStorageOnHand.Table_Name + "." + MStorageOnHand.COLUMNNAME_M_Product_ID + " FROM "
				+ MStorageOnHand.Table_Name + ")";
		List<MProduct_BH> products = new Query(Env.getCtx(), MProduct_BH.Table_Name, whereClause, get_TrxName())
				.setClient_ID().list();
		for (MProduct_BH product : products) {
			InitializeStock.createInitialStock(product, BigDecimal.ONE, Env.getCtx(), get_TrxName());
			count++;
		}

		String msg = "STOP InitializeStockProcess. Took " + (System.currentTimeMillis() - start) / 1000 / 60
				+ " mins. Processed " + count + " product(s).";
		log.log(Level.INFO, msg);

		return msg;
	}

}
