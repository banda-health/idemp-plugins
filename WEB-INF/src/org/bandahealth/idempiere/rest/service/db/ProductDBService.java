package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.Product;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.compiere.util.Env;

/*
 * Carry out all Product DB Operations.
 */
public class ProductDBService extends BaseDBService<Product, MProduct_BH> {

	public ProductDBService() {
	}

	@Override
	protected Product createInstanceWithAllFields(MProduct_BH product) {
		try {
			return new Product(product.getAD_Client_ID(), product.getAD_Org_ID(), product.getM_Product_UU(),
					product.isActive(), DateUtil.parse(product.getCreated()), product.getCreatedBy(), product.getName(),
					product.getDescription(), product.getValue(), product.isStocked(), product.getBH_BuyPrice(),
					product.getBH_SellPrice(), product.getProductType(), product.get_ValueAsInt("bh_reorder_level"),
					product.get_ValueAsInt("bh_reorder_quantity"));
		} catch (Exception exception) {
			log.severe("Error creating product: " + exception);
			return null;
		}
	}

	@Override
	protected Product createInstanceWithDefaultFields(MProduct_BH product) {
		try {
			return new Product(product.getAD_Client_ID(), product.getAD_Org_ID(), product.getM_Product_UU(),
					product.isActive(), DateUtil.parse(product.getCreated()), product.getCreatedBy(), product.getName(),
					product.getDescription());
		} catch (Exception exception) {
			log.severe("Error creating product: " + exception);
			return null;
		}
	}

	public BaseListResponse<Product> getAll(Paging pagingInfo, String sortColumn, String sortOrder) {
		return super.getAll(null, null, pagingInfo, sortColumn, sortOrder);
	}

	@Override
	protected MProduct_BH getModelInstance() {
		return new MProduct_BH(Env.getCtx(), 0, null);
	}

}
