package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.bandahealth.idempiere.base.model.MOrder_BH;

public class MOrderTemplate extends BaseTemplate<MOrder_BH> {

	private String trxName;
	private Properties ctx;
	private boolean isSoTrx;

	public MOrderTemplate(String trxName, Properties ctx, boolean isSoTrx) {
		this.trxName = trxName;
		this.ctx = ctx;
		this.isSoTrx = isSoTrx;
	}

	@Override
	public MOrder_BH getInstance(int... args) {
		int orgId = new MOrgTemplate(trxName, ctx).getInstance().get_ID();
		int locationId = new MLocationTemplate(trxName, ctx).getInstance(orgId).get_ID();
		int bPartnerId = new MBPartnerTemplate(trxName, ctx).getInstance(orgId).get_ID();
		int salesRepId = new MUserTemplate(trxName, ctx).getInstance(orgId).get_ID();
		int priceListId = new MPriceListTemplate(trxName, ctx).getInstance(orgId).get_ID();

		// check bank account
		new MBankAccountTemplate(trxName, ctx).getInstance(orgId);

		MOrder_BH order = new MOrder_BH(ctx, 0, trxName);
		order.setIsSOTrx(isSoTrx);
		order.setAD_Org_ID(orgId);
		order.setM_Warehouse_ID(new MWarehouseTemplate(trxName, ctx).getInstance(orgId, locationId).get_ID());
		order.setC_BPartner_Location_ID(
				new MBPartnerLocationTemplate(trxName, ctx).getInstance(bPartnerId, locationId, orgId).get_ID());
		order.setC_BPartner_ID(bPartnerId);
		order.setSalesRep_ID(salesRepId);
		order.setM_PriceList_ID(priceListId);
		order.saveEx();

		return order;
	}

	@Override
	protected String getTrxName() {
		return trxName;
	}

	@Override
	protected Properties getCtx() {
		return ctx;
	}
}
