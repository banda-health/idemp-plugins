package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.bandahealth.idempiere.base.model.MOrder_BH;

public class MOrderTemplate extends BaseModelTemplate<MOrder_BH> {

	private boolean isSoTrx;
	private int docTypeId;
	private int clientId;
	private int priceListId;
	private int bPartnerId;

	public MOrderTemplate(String transactionName, Properties context, boolean isSoTrx, int clientId, int priceListId,
			int bPartnerId) {
		super(transactionName, context);

		this.isSoTrx = isSoTrx;
		this.clientId = clientId;
		this.priceListId = priceListId;
		this.bPartnerId = bPartnerId;
	}

	@Override
	protected MOrder_BH createInstance() {
		int orgId = new MOrgTemplate(getTransactionName(), getContext()).getInstance().get_ID();
		int locationId = new MLocationTemplate(getTransactionName(), getContext(), orgId).getInstance().get_ID();
		int salesRepId = new MUserTemplate(getTransactionName(), getContext(), orgId, 0, null,
				"test@businesspartner.com", "123456", null).getInstance().get_ID();

		if (!isSoTrx) {
			docTypeId = new MDocTypeTemplate(getTransactionName(), getContext(), clientId, "'Purchase Order'")
					.findInstance().get_ID();
		} else {
			docTypeId = new MDocTypeTemplate(getTransactionName(), getContext(), clientId, "'POS Order'").findInstance()
					.get_ID();
		}

		// check morginfo
		new MOrgInfoTemplate(getTransactionName(), getContext(), orgId).getInstance();

		// check bank account
		new MBankAccountTemplate(getTransactionName(), getContext(), orgId, clientId).getInstance();

		MOrder_BH order = new MOrder_BH(getContext(), 0, getTransactionName());
		order.setIsSOTrx(isSoTrx);
		order.setC_DocType_ID(docTypeId);
		order.setC_DocTypeTarget_ID();
		order.setAD_Org_ID(orgId);
		order.setM_Warehouse_ID(
				new MWarehouseTemplate(getTransactionName(), getContext(), orgId, locationId).getInstance().get_ID());
		order.setC_BPartner_Location_ID(
				new MBPartnerLocationTemplate(getTransactionName(), getContext(), bPartnerId, locationId, orgId)
						.getInstance().get_ID());
		order.setC_BPartner_ID(bPartnerId);
		order.setSalesRep_ID(salesRepId);
		order.setM_PriceList_ID(priceListId);
		order.setDocAction(MOrder_BH.DOCACTION_Complete);
		order.saveEx();

		//commit();

		return order;
	}

	@Override
	protected MOrder_BH findInstance() {
		return null;
	}

	@Override
	protected void setFields(MOrder_BH instance) {

	}

}