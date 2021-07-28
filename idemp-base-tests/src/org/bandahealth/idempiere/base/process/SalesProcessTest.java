package org.bandahealth.idempiere.base.process;

import org.bandahealth.idempiere.base.AdempiereTestCase;
import org.bandahealth.idempiere.base.MBPartnerTemplate;
import org.bandahealth.idempiere.base.MOrderLineTemplate;
import org.bandahealth.idempiere.base.MOrderTemplate;
import org.bandahealth.idempiere.base.MPaymentTemplate;
import org.bandahealth.idempiere.base.MPriceListTemplate;
import org.bandahealth.idempiere.base.MProductTemplate;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.compiere.model.MPInstance;
import org.compiere.model.MPriceList;
import org.compiere.model.MProcess;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfo;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.Env;
import org.compiere.util.Trx;

public class SalesProcessTest extends AdempiereTestCase {

	private String PRODUCT_NAME = "Test Process Product";
	private MOrder_BH order;

	public void testProcessRequest() throws Exception {
		int orgId = Env.getAD_Org_ID(getCtx());
		int clientId = Env.getAD_Client_ID(getCtx());

		MPriceList soPriceList = new MPriceListTemplate(getTrxName(), getCtx(), orgId, clientId, true,
				"Test Process Sales Price List").getInstance();

		MPriceList poPriceList = new MPriceListTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()),
				Env.getAD_Client_ID(getCtx()), false, "Test Process Buy Price List").getInstance();

		int bPartnerId = new MBPartnerTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()), null, false,
				"Test Process Patient 1", true, 0, soPriceList.get_ID(), poPriceList.get_ID(), false).getInstance()
						.get_ID();

		order = new MOrderTemplate(getTrxName(), getCtx(), true, Env.getAD_Client_ID(getCtx()), soPriceList.get_ID(),
				bPartnerId).getInstance();

		MProduct_BH product = new MProductTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()), PRODUCT_NAME,
				soPriceList, poPriceList).getInstance();

		MOrderLine_BH orderLine = new MOrderLineTemplate(getTrxName(), getCtx(), order, product.get_ID()).getInstance();
		// orderLine.saveEx();
		new MPaymentTemplate(getTrxName(), getCtx(), order, orderLine.getPriceActual()).getInstance();

		// commit();

		ProcessInfoParameter pi1 = new ProcessInfoParameter("c_order_id", order.get_ID(), "", "", "");

		ProcessInfo pi = new ProcessInfo("", 0, 0, 0);
		pi.setParameter(new ProcessInfoParameter[] { pi1 });

		// Lookup process in the AD, in this case by value
		MProcess pr = new Query(Env.getCtx(), MProcess.Table_Name, MProcess.COLUMNNAME_Classname + "=?", null)
				.setOnlyActiveRecords(true).setParameters("org.bandahealth.idempiere.base.process.SalesProcess").first();

		// Create an instance of the actual process class.
		SalesProcess process = new SalesProcess();

		// Create process instance (mainly for logging/sync purpose)
		MPInstance mpi = new MPInstance(getCtx(), 0, null);
		// mpi.setAD_Process_ID(pr.get_ID());
		mpi.setAD_Process_ID(1000000);
		mpi.setRecord_ID(0);
		mpi.save(getTrxName());

		// Connect the process to the process instance.
		pi.setAD_PInstance_ID(mpi.get_ID());

		log.info("Starting process " + pr.getName());
		process.startProcess(getCtx(), pi, Trx.get(getTrxName(), false));
		
		assertEquals(process.getProcessInfo().getAD_PInstance_ID(), pi.getAD_PInstance_ID());
	}
}
