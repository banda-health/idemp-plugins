package org.bandahealth.idempiere.base;

import java.math.BigDecimal;
import java.util.Properties;

import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.compiere.model.MProductCategory;
import org.compiere.model.MTaxCategory;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.model.X_I_Product;

public class MProductTemplate extends BaseModelTemplate<MProduct_BH> {

	private int orgId;

	public MProductTemplate(String transactionName, Properties context, int orgId) {
		super(transactionName, context);

		this.orgId = orgId;
	}

	@Override
	protected MProduct_BH createInstance() {
		MProduct_BH product = new MProduct_BH(getContext(), 0, getTransactionName());
		product.setName("Test Product");

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

		product.setBH_BuyPrice(new BigDecimal(10));
		product.setBH_SellPrice(new BigDecimal(20));

		product.saveEx();

		commit();

		return product;
	}

	@Override
	protected MProduct_BH findInstance() {
		return new Query(getContext(), MProduct_BH.Table_Name, "name = 'Test Product'", getTransactionName()).first();
	}
}