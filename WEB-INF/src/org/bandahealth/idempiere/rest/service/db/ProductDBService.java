package org.bandahealth.idempiere.rest.service.db;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.rest.exceptions.ProductSaveException;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.Product;
import org.bandahealth.idempiere.rest.model.SearchProduct;
import org.bandahealth.idempiere.rest.model.SearchProductAttribute;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MAttributeSetInstance;
import org.compiere.model.MLocator;
import org.compiere.model.MProduct;
import org.compiere.model.MProductCategory;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.MTaxCategory;
import org.compiere.model.MUOM;
import org.compiere.model.MWarehouse;
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

	public BaseListResponse<Product> search(String value, Paging pagingInfo) {
		List<Object> parameters = new ArrayList<>();
		parameters.add(constructSearchValue(value));
		parameters.add(MProduct_BH.PRODUCTTYPE_Item);

		return this.search(this.DEFAULT_SEARCH_CLAUSE + AND_OPARATOR + MProduct_BH.COLUMNNAME_ProductType + " = ?",
				parameters, pagingInfo);
	}

	/**
	 * Auto-complete search.
	 * 
	 * Searches products/services and returns related price, expiry, quantity fields
	 * 
	 * @param searchValue
	 * @return
	 */
	public BaseListResponse<SearchProduct> searchItems(String searchValue) {
		List<SearchProduct> results = new ArrayList<>();

		// maximum of 100 results?
		Paging pagingInfo = new Paging(0, 100);

		// 1. search product/service
		List<Object> parameters = new ArrayList<>();
		parameters.add(constructSearchValue(searchValue));

		Query query = new Query(Env.getCtx(), MProduct_BH.Table_Name, DEFAULT_SEARCH_CLAUSE, null)
				.setOnlyActiveRecords(true).setClient_ID().setParameters(parameters);

		// set total count..
		pagingInfo.setTotalRecordCount(query.count());

		List<MProduct_BH> entities = query.list();

		// 2. retrieve attributes
		for (MProduct_BH entity : entities) {
			SearchProduct result = new SearchProduct();
			result.setUuid(entity.getM_Product_UU());
			result.setName(entity.getName());
			result.setType(entity.getProductType());
			result.setPrice(entity.getBH_SellPrice());

			if (entity.getProductType().equalsIgnoreCase(MProduct_BH.PRODUCTTYPE_Item)) {

				String whereClause = MWarehouse.Table_Name + "." + MWarehouse.COLUMNNAME_M_Warehouse_ID + " = ? AND "
						+ MStorageOnHand.Table_Name + "." + MStorageOnHand.COLUMNNAME_M_Product_ID + " = ?";

				String joinClause = "INNER JOIN " + MStorageOnHand.Table_Name;

				joinClause += " ON " + MAttributeSetInstance.Table_Name + "."
						+ MAttributeSetInstance.COLUMNNAME_M_AttributeSetInstance_ID + " = " + MStorageOnHand.Table_Name
						+ "." + MStorageOnHand.COLUMNNAME_M_AttributeSetInstance_ID;

				joinClause += " AND " + MStorageOnHand.Table_Name + "." + MStorageOnHand.COLUMNNAME_QtyOnHand + " > 0";

				String warehouseId = Env.getContext(Env.getCtx(), Env.M_WAREHOUSE_ID);
				int mWarehouseId = 0;
				if (warehouseId != null) {
					mWarehouseId = Integer.valueOf(warehouseId);
				}

				joinClause += " INNER JOIN " + MLocator.Table_Name + " ON " + MStorageOnHand.Table_Name + "."
						+ MStorageOnHand.COLUMNNAME_M_Locator_ID + " = " + MLocator.Table_Name + "."
						+ MLocator.COLUMNNAME_M_Locator_ID;

				joinClause += " INNER JOIN " + MWarehouse.Table_Name + " ON " + MWarehouse.Table_Name + "."
						+ MWarehouse.COLUMNNAME_M_Warehouse_ID + "=" + MLocator.Table_Name + "."
						+ MLocator.COLUMNNAME_M_Warehouse_ID;

				query = new Query(Env.getCtx(), MAttributeSetInstance.Table_Name, whereClause, null)
						.addJoinClause(joinClause).setParameters(mWarehouseId, entity.get_ID())
						.setOnlyActiveRecords(true);

				query = query.setOrderBy(MAttributeSetInstance.COLUMNNAME_GuaranteeDate + " " + ASCENDING_ORDER);

				List<MAttributeSetInstance> attributeSetInstances = query.list();

				BigDecimal totalQuantity = BigDecimal.ZERO;
				for (MAttributeSetInstance attributeSetInstance : attributeSetInstances) {
					// get expiry date and id
					SearchProductAttribute attribute = new SearchProductAttribute(
							DateUtil.parseDateOnly(attributeSetInstance.getGuaranteeDate()),
							attributeSetInstance.get_ID());

					// get existing quantity
					MStorageOnHand storage = new Query(Env.getCtx(), MStorageOnHand.Table_Name,
							MStorageOnHand.COLUMNNAME_M_AttributeSetInstance_ID + "=?", null)
									.setParameters(attributeSetInstance.get_ID()).setOnlyActiveRecords(true).first();
					if (storage != null) {
						totalQuantity = totalQuantity.add(storage.getQtyOnHand());
						attribute.setExistingQuantity(storage.getQtyOnHand());
					}

					result.addAttribute(attribute);
				}

				result.setTotalQuantity(totalQuantity);
			}

			results.add(result);
		}

		return new BaseListResponse<SearchProduct>(results, pagingInfo);
	}

	@Override
	public Product saveEntity(Product entity) {
		try {
			MProduct_BH product;
			MProduct_BH exists = getEntityByUuidFromDB(entity.getUuid());
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

			if (entity.isHasExpiration() != null) {
				product.setBH_HasExpiration(entity.isHasExpiration());
			}

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

			return createInstanceWithAllFields(getEntityByUuidFromDB(product.getM_Product_UU()));
		} catch (Exception ex) {
			throw new ProductSaveException(ex.getLocalizedMessage());
		}
	}

	@Override
	protected Product createInstanceWithAllFields(MProduct_BH instance) {
		try {
			return new Product(instance.getAD_Client_ID(), instance.getAD_Org_ID(), instance.getM_Product_UU(),
					instance.isActive(), DateUtil.parseDateOnly(instance.getCreated()), instance.getCreatedBy(),
					instance.getName(), instance.getDescription(), instance.getValue(), instance.isStocked(),
					instance.getBH_BuyPrice(), instance.getBH_SellPrice(), instance.getProductType(),
					instance.get_ValueAsInt(COLUMNNAME_REORDER_LEVEL),
					instance.get_ValueAsInt(COLUMNNAME_REORDER_QUANTITY),
					instance.get_ValueAsBoolean(MProduct_BH.COLUMNNAME_BH_HasExpiration));
		} catch (Exception ex) {
			log.severe("Error creating product instance: " + ex);

			throw new RuntimeException(ex.getMessage(), ex);
		}
	}

	@Override
	protected Product createInstanceWithDefaultFields(MProduct_BH product) {
		try {
			return new Product(product.getAD_Client_ID(), product.getAD_Org_ID(), product.getM_Product_UU(),
					product.isActive(), DateUtil.parseDateOnly(product.getCreated()), product.getCreatedBy(),
					product.getName(), product.getDescription(), product.getBH_BuyPrice(), product.getBH_SellPrice());
		} catch (Exception ex) {
			log.severe("Error creating product instance: " + ex);
			throw new RuntimeException(ex.getLocalizedMessage(), ex);
		}
	}

	@Override
	protected Product createInstanceWithSearchFields(MProduct_BH product) {
		try {
			return new Product(product.getM_Product_UU(), product.getName(), product.getBH_BuyPrice(),
					product.get_ValueAsBoolean(MProduct_BH.COLUMNNAME_BH_HasExpiration),
					DateUtil.parseDateOnly(product.getCreated()), product.getBH_SellPrice());
		} catch (Exception ex) {
			log.severe("Error creating product instance: " + ex);
			throw new RuntimeException(ex.getLocalizedMessage(), ex);
		}
	}

	@Override
	protected MProduct_BH getModelInstance() {
		return new MProduct_BH(Env.getCtx(), 0, null);
	}

	public MProduct getProductByID(int id) {
		return MProduct_BH.get(Env.getCtx(), id);
	}
}
