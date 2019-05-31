package org.bandahealth.idempiere.base;

import java.math.BigDecimal;
import java.util.Properties;

import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.compiere.model.MProductCategory;
import org.compiere.model.MTaxCategory;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.model.X_I_Product;

public class MProductTemplate extends BaseTemplate<MProduct_BH> {

	private String trxName;
	private Properties ctx;

	public MProductTemplate(String trxName, Properties ctx) {
		this.trxName = trxName;
		this.ctx = ctx;
	}

	@Override
	public MProduct_BH getInstance(int... args) {
		int orgId = args[0];
		MProduct_BH product = new Query(getCtx(), MProduct_BH.Table_Name, "name = 'Test Product'", getTrxName())
				.first();
		if (product == null) {
			product = new MProduct_BH(getCtx(), 0, getTrxName());
			product.setName("Test Product");

			// set uom - unit of measure
			MUOM uom = new Query(getCtx(), MUOM.Table_Name, "name = 'Each'", getTrxName()).first();
			if (uom == null) {
				uom = new MUOM(getCtx(), 0, getTrxName());
				uom.setName("Each");
				uom.setAD_Org_ID(orgId);
				uom.saveEx();
			}

			product.setC_UOM_ID(uom.get_ID());

			product.setProductType(X_I_Product.PRODUCTTYPE_Item);

			// product category
			MProductCategory category = new Query(getCtx(), MProductCategory.Table_Name, "name = 'Test Category'",
					getTrxName()).first();
			if (category == null) {
				category = new MProductCategory(getCtx(), 0, getTrxName());
				category.setName("Test Category");
				category.setAD_Org_ID(orgId);
				category.saveEx();
			}

			product.setM_Product_Category_ID(category.get_ID());

			// tax category
			MTaxCategory taxCategory = new Query(getCtx(), MTaxCategory.Table_Name, "name = 'Test Tax Category'",
					getTrxName()).first();
			if (taxCategory == null) {
				taxCategory = new MTaxCategory(getCtx(), 0, getTrxName());
				taxCategory.setName("Test Tax Category");
				taxCategory.setAD_Org_ID(orgId);
				taxCategory.saveEx();
			}

			product.setC_TaxCategory_ID(taxCategory.get_ID());

			product.setBH_BuyPrice(new BigDecimal(10));
			product.setBH_SellPrice(new BigDecimal(20));

			product.saveEx();

			commit();
		}

		return product;
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