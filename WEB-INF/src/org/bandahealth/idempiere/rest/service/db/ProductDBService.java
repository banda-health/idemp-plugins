package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.Product;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.util.Env;

/*
 * Carry out all Product DB Operations.
 */
public class ProductDBService extends BaseDBService<Product, MProduct_BH> {

	private static String COLUMNNAME_REORDER_LEVEL = "bh_reorder_level";
	private static String COLUMNNAME_REORDER_QUANTITY = "bh_reorder_quantity";

	public BaseListResponse<Product> getAll(Paging pagingInfo, String sortColumn, String sortOrder) {
		List<Object> parameters = new ArrayList<>();
		parameters.add(MProduct_BH.PRODUCTTYPE_Item);

		return super.getAll(MProduct_BH.COLUMNNAME_ProductType + " = ?", parameters, pagingInfo, sortColumn, sortOrder);
	}

	@Override
	public Product saveEntity(Product entity) {
		MProduct_BH product;
		MProduct_BH exists = getEntityFromDB(entity.getUuid());
		if (exists != null) {
			product = exists;
		} else {
			product = getModelInstance();
			product.setProductType(MProduct_BH.PRODUCTTYPE_Item);
		}

		if (StringUtil.isNotNullAndEmpty(entity.getName())) {
			product.setName(entity.getName());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getDescription())) {
			product.setDescription(entity.getDescription());
		}

		product.setBH_HasExpiration(entity.isHasExpiration());

		if (entity.getReorderLevel() != null) {
			product.set_CustomColumn(COLUMNNAME_REORDER_LEVEL, entity.getReorderLevel());
		}

		if (entity.getReorderQuantity() != null) {
			product.set_CustomColumn(COLUMNNAME_REORDER_QUANTITY, entity.getReorderQuantity());
		}

		if (entity.getBuyPrice() != null) {
			product.setBH_BuyPrice(entity.getBuyPrice());
		}

		if (entity.getSellPrice() != null) {
			product.setBH_SellPrice(entity.getSellPrice());
		}

		product.setIsActive(entity.isIsActive());

		product.saveEx();

		return createInstanceWithAllFields(getEntityFromDB(product.getM_Product_UU()));
	}

	@Override
	protected Product createInstanceWithAllFields(MProduct_BH product) {
		try {
			return new Product(product.getAD_Client_ID(), product.getAD_Org_ID(), product.getM_Product_UU(),
					product.isActive(), DateUtil.parse(product.getCreated()), product.getCreatedBy(), product.getName(),
					product.getDescription(), product.getValue(), product.isStocked(), product.getBH_BuyPrice(),
					product.getBH_SellPrice(), product.getProductType(),
					product.get_ValueAsInt(COLUMNNAME_REORDER_LEVEL),
					product.get_ValueAsInt(COLUMNNAME_REORDER_QUANTITY),
					product.get_ValueAsBoolean(MProduct_BH.COLUMNNAME_BH_HasExpiration));
		} catch (Exception exception) {
			log.severe("Error creating product instance: " + exception);
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
			log.severe("Error creating product instance: " + exception);
			return null;
		}
	}

	@Override
	protected MProduct_BH getModelInstance() {
		return new MProduct_BH(Env.getCtx(), 0, null);
	}
}
