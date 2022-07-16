package org.bandahealth.idempiere.base.test;

import com.chuboe.test.populate.ChuBoePopulateVO;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MInventory_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.compiere.model.MBPartner;
import org.compiere.model.MInvoice;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MPayment;
import org.compiere.model.MPriceList;
import org.compiere.model.MProduct;
import org.compiere.model.Query;

import java.io.File;

public class BandaValueObjectWrapper extends ChuBoePopulateVO {
	private MOrderLine_BH orderLine;
	private MOrder_BH order;
	private MPayment_BH payment;
	private MInvoice_BH invoice;
	private MBPartner_BH businessPartner;
	private MProduct_BH product;
	private Boolean areRefreshing = false;
	private File report;
	private MInventory_BH inventory;
	private MInventoryLine_BH inventoryLine;

	public MInventory_BH getInventory() {
		return inventory;
	}

	public void setInventory(MInventory_BH inventory) {
		this.inventory = inventory;
	}

	public MInventoryLine_BH getInventoryLine() {
		return inventoryLine;
	}

	public void setInventoryLine(MInventoryLine_BH inventoryLine) {
		this.inventoryLine = inventoryLine;
	}

	public MOrderLine_BH getOrderLineBH() {
		if (orderLine == null) {
			if (getOrderLine() != null) {
				orderLine = new Query(getCtx(), MOrderLine_BH.Table_Name, MOrderLine_BH.COLUMNNAME_C_OrderLine_ID + "=?",
						get_trxName()).setParameters(getOrderLine().get_ID()).first();
			}
		}
		return orderLine;
	}

	public MOrder_BH getOrderBH() {
		if (order == null) {
			if (getOrder() != null) {
				order = new Query(getCtx(), MOrder_BH.Table_Name, MOrder_BH.COLUMNNAME_C_Order_ID + "=?",
						get_trxName()).setParameters(getOrder().get_ID()).first();
			}
		}
		return order;
	}

	public MPayment_BH getPaymentBH() {
		if (payment == null) {
			if (getPayment() != null) {
				payment = new Query(getCtx(), MPayment_BH.Table_Name, MPayment_BH.COLUMNNAME_C_Payment_ID + "=?",
						get_trxName()).setParameters(getPayment().get_ID()).first();
			}
		}
		return payment;
	}

	public MInvoice_BH getInvoiceBH() {
		if (invoice == null) {
			if (getInvoice() != null) {
				invoice = new Query(getCtx(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Invoice_ID + "=?",
						get_trxName()).setParameters(getInvoice().get_ID()).first();
			}
		}
		return invoice;
	}

	public MBPartner_BH getBusinessPartnerBH() {
		if (businessPartner == null) {
			if (getBP() != null) {
				businessPartner = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_ID + "=?",
						get_trxName()).setParameters(getBP().get_ID()).first();
			}
		}
		return businessPartner;
	}

	public MProduct_BH getProductBH() {
		if (product == null) {
			if (getProduct() != null) {
				product = new Query(getCtx(), MProduct_BH.Table_Name, MProduct_BH.COLUMNNAME_M_Product_ID + "=?",
						get_trxName()).setParameters(getProduct().get_ID()).first();
			}
		}
		return product;
	}

	@Override
	public void setPriceListSO(MPriceList m_priceListSO) {
		super.setPriceListSO(m_priceListSO);
	}

	@Override
	public void setPriceListPO(MPriceList m_priceListPO) {
		super.setPriceListPO(m_priceListPO);
	}

	@Override
	public void setOrder(MOrder m_po) {
		super.setOrder(m_po);
		if (!areRefreshing) {
			order = null;
			getOrderBH();
		}
	}

	@Override
	public void setOrderLine(MOrderLine m_poLine) {
		super.setOrderLine(m_poLine);
		if (!areRefreshing) {
			orderLine = null;
			getOrderLineBH();
		}
	}

	@Override
	public void setPayment(MPayment m_payment) {
		super.setPayment(m_payment);
		if (!areRefreshing) {
			payment = null;
			getPaymentBH();
		}
	}

	@Override
	public void setInvoice(MInvoice m_vi) {
		super.setInvoice(m_vi);
		if (!areRefreshing) {
			invoice = null;
			getInvoiceBH();
		}
	}

	@Override
	public void setBP(MBPartner m_bp) {
		super.setBP(m_bp);
		if (!areRefreshing) {
			businessPartner = null;
			getBusinessPartnerBH();
		}
	}

	@Override
	public void setProduct(MProduct m_product) {
		super.setProduct(m_product);
		if (!areRefreshing) {
			product = null;
			getProductBH();
		}
	}

	/**
	 * A method to refresh a few properties on the value object.
	 */
	public void refresh() {
		areRefreshing = true;

		if (getOrder() != null) {
			order = new Query(getCtx(), MOrder_BH.Table_Name, MOrder_BH.COLUMNNAME_C_Order_ID + "=?",
					get_trxName()).setParameters(getOrder().get_ID()).first();
			setOrder(order);
		}
		if (getOrderLine() != null) {
			orderLine = new Query(getCtx(), MOrderLine_BH.Table_Name, MOrderLine_BH.COLUMNNAME_C_OrderLine_ID + "=?",
					get_trxName()).setParameters(getOrderLine().get_ID()).first();
			setOrderLine(orderLine);
		}
		if (getPayment() != null) {
			payment = new Query(getCtx(), MPayment_BH.Table_Name, MPayment_BH.COLUMNNAME_C_Payment_ID + "=?",
					get_trxName()).setParameters(getPayment().get_ID()).first();
			setPayment(payment);
		}
		if (getInvoice() != null) {
			invoice = new Query(getCtx(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Invoice_ID + "=?",
					get_trxName()).setParameters(getInvoice().get_ID()).first();
			setInvoice(invoice);
		}
		if (getBP() != null) {
			businessPartner = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_ID + "=?",
					get_trxName()).setParameters(getBP().get_ID()).first();
			setBP(businessPartner);
		}
		if (getProduct() != null) {
			product = new Query(getCtx(), MProduct_BH.Table_Name, MProduct_BH.COLUMNNAME_M_Product_ID + "=?",
					get_trxName()).setParameters(getProduct().get_ID()).first();
			setProduct(product);
		}

		areRefreshing = false;
	}

	public File getReport() {
		return report;
	}

	public void setReport(File report) {
		this.report = report;
	}
}
