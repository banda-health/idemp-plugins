package org.bandahealth.idempiere.base;

import java.math.BigDecimal;
import java.util.Properties;

import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.compiere.model.MPriceList;
import org.compiere.model.MProductCategory;
import org.compiere.model.MTaxCategory;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.model.X_I_Product;

public class MProductTemplate extends BaseModelTemplate<MProduct_BH> {

	private int orgId;
	private String name;
	private MPriceList soPriceList;
	private MPriceList poPriceList;

	public MProductTemplate(String transactionName, Properties context, int orgId, String name, MPriceList soPriceList,
			MPriceList poPriceList) {
		super(transactionName, context);

		this.orgId = orgId;
		this.name = name;
		this.soPriceList = soPriceList;
		this.poPriceList = poPriceList;
	}

	@Override
	protected MProduct_BH createInstance() {
		MProduct_BH product = new MProduct_BH(getContext(), 0, getTransactionName());
		product.setName(name);
		product.setValue(name);

		// set uom - unit of measure
		MUOM uom = new Query(getContext(), MUOM.Table_Name, "name = 'Each'", getTransactionName()).first();
		if (uom == null) {
			uom = new MUOM(getContext(), 0, getTransactionName());
			uom.setName("Each");
			uom.setAD_Org_ID(orgId);
			uom.saveEx();
		}

		product.setC_UOM_ID(uom.get_ID());

		product.setProductType(X_I_Product.PRODUCTTYPE_Item);

		// product category
		MProductCategory category = new Query(getContext(), MProductCategory.Table_Name, "name = 'Test Category'",
				getTransactionName()).first();
		if (category == null) {
			category = new MProductCategory(getContext(), 0, getTransactionName());
			category.setName("Test Category");
			category.setAD_Org_ID(orgId);
			category.saveEx();
		}

		product.setM_Product_Category_ID(category.get_ID());

		// tax category
		MTaxCategory taxCategory = new Query(getContext(), MTaxCategory.Table_Name, "name = 'Test Tax Category'",
				getTransactionName()).first();
		if (taxCategory == null) {
			taxCategory = new MTaxCategory(getContext(), 0, getTransactionName());
			taxCategory.setName("Test Tax Category");
			taxCategory.setAD_Org_ID(orgId);
			taxCategory.saveEx();
		}

		product.setC_TaxCategory_ID(taxCategory.get_ID());

		// set buying price
		if (poPriceList != null) {
			product.setBH_BuyPrice(new BigDecimal(10));
		}

		// set selling price
		if (soPriceList != null) {
			product.setBH_SellPrice(new BigDecimal(20));
		}

		product.saveEx();

		commit();

		setFields(product);

		return product;
	}

	@Override
	protected void setFields(MProduct_BH product) {
		// set buying price
		if (poPriceList != null) {
			int priceVersion = new MPriceListVersionTemplate(getTransactionName(), getContext(), poPriceList.get_ID(),
					poPriceList.getName() + " Version").getInstance().get_ID();

			new MProductPriceTemplate(getTransactionName(), getContext(), product.get_ID(), new BigDecimal(10),
					priceVersion).getInstance();
		}

		// set selling price
		if (soPriceList != null) {
			int priceVersion = new MPriceListVersionTemplate(getTransactionName(), getContext(), soPriceList.get_ID(),
					soPriceList.getName() + " Version").getInstance().get_ID();

			new MProductPriceTemplate(getTransactionName(), getContext(), product.get_ID(), new BigDecimal(20),
					priceVersion).getInstance();
		}
	}

	@Override
	protected MProduct_BH findInstance() {
		return new Query(getContext(), MProduct_BH.Table_Name, "name = ?", getTransactionName()).setParameters(name)
				.first();
	}
}