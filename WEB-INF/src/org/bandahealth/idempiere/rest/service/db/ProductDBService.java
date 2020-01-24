package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.Product;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MProductCategory;
import org.compiere.model.MTaxCategory;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
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
		try {
			MProduct_BH product;
			MProduct_BH exists = getEntityFromDB(entity.getUuid());
			if (exists != null) {
				product = exists;
			} else {
				product = getModelInstance();
				product.setProductType(MProduct_BH.PRODUCTTYPE_Item);

				// set default uom (unit of measure).
				MUOM uom = new Query(Env.getCtx(), MUOM.Table_Name, MUOM.COLUMNNAME_Name + "=?", null)
						.setParameters("Each").first();
				if (uom != null) {
					product.setC_UOM_ID(uom.get_ID());
				}

				// set product category.
				MProductCategory productCategory = new Query(Env.getCtx(), MProductCategory.Table_Name,
						MProductCategory.COLUMNNAME_Name + "=?", null).setParameters("Standard").setClient_ID().first();
				if (productCategory != null) {
					product.setM_Product_Category_ID(productCategory.get_ID());
				}

				// set tax category
				MTaxCategory taxCategory = new Query(Env.getCtx(), MTaxCategory.Table_Name,
						MTaxCategory.COLUMNNAME_Name + "=?", null).setParameters("Standard").setClient_ID().first();
				if (taxCategory != null) {
					product.setC_TaxCategory_ID(taxCategory.get_ID());
				}
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
		} catch (Exception ex) {
			throw new AdempiereException(ex.getLocalizedMessage());
		}
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
		} catch (Exception ex) {
			log.severe("Error creating product instance: " + ex);
			
			throw new RuntimeException(ex.getMessage(), ex);
		}
	}

	@Override
	protected Product createInstanceWithDefaultFields(MProduct_BH product) {
		try {
			return new Product(product.getAD_Client_ID(), product.getAD_Org_ID(), product.getM_Product_UU(),
					product.isActive(), DateUtil.parse(product.getCreated()), product.getCreatedBy(), product.getName(),
					product.getDescription(), product.getBH_BuyPrice(), product.getBH_SellPrice());
		} catch (Exception ex) {
			log.severe("Error creating product instance: " + ex);
			throw new RuntimeException(ex.getLocalizedMessage(), ex);
		}
	}

	@Override
	protected MProduct_BH getModelInstance() {
		return new MProduct_BH(Env.getCtx(), 0, null);
	}
}
