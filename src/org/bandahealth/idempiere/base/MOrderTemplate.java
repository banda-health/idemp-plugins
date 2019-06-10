package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.bandahealth.idempiere.base.model.MOrder_BH;

public class MOrderTemplate extends BaseModelTemplate<MOrder_BH> {

	private boolean isSoTrx;

	public MOrderTemplate(String transactionName, Properties context, boolean isSoTrx) {
		super(transactionName, context);

		this.isSoTrx = isSoTrx;
	}

	@Override
	protected MOrder_BH createInstance() {
		int orgId = new MOrgTemplate(getTransactionName(), getContext()).getInstance().get_ID();
		int locationId = new MLocationTemplate(getTransactionName(), getContext(), orgId).getInstance().get_ID();
		int bPartnerId = new MBPartnerTemplate(getTransactionName(), getContext(), orgId, null, false, null)
				.getInstance().get_ID();
		int salesRepId = new MUserTemplate(getTransactionName(), getContext(), orgId).getInstance().get_ID();
		int priceListId = new MPriceListTemplate(getTransactionName(), getContext(), orgId).getInstance().get_ID();

		// check bank account
		new MBankAccountTemplate(getTransactionName(), getContext(), orgId).getInstance();

		MOrder_BH order = new MOrder_BH(getContext(), 0, getTransactionName());
		order.setIsSOTrx(isSoTrx);
		order.setAD_Org_ID(orgId);
		order.setM_Warehouse_ID(
				new MWarehouseTemplate(getTransactionName(), getContext(), orgId, locationId).getInstance().get_ID());
		order.setC_BPartner_Location_ID(
				new MBPartnerLocationTemplate(getTransactionName(), getContext(), bPartnerId, locationId, orgId)
						.getInstance().get_ID());
		order.setC_BPartner_ID(bPartnerId);
		order.setSalesRep_ID(salesRepId);
		order.setM_PriceList_ID(priceListId);
		order.saveEx();

		commit();

		return order;
	}

	@Override
	protected MOrder_BH findInstance() {
		return null;
	}
}