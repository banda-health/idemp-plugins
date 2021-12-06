package org.bandahealth.idempiere.rest.service.db;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.X_BH_Stocktake_v;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.bandahealth.idempiere.rest.exceptions.DuplicateEntitySaveException;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Inventory;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.Product;
import org.bandahealth.idempiere.rest.model.SearchProduct;
import org.bandahealth.idempiere.rest.model.SearchProductAttribute;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MAttributeSetInstance;
import org.compiere.model.MProduct;
import org.compiere.model.MProductCategory;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.MTaxCategory;
import org.compiere.model.MUOM;
import org.compiere.model.MWarehouse;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * Carry out all Product DB Operations.
 */
@Component
public class ProductDBService extends BaseDBService<Product, MProduct_BH> {

	private static final String ERROR_WAREHOUSE_NOT_FOUND = "Warehouse not found";
	private static String COLUMNNAME_REORDER_LEVEL = "bh_reorder_level";
	private static String COLUMNNAME_REORDER_QUANTITY = "bh_reorder_quantity";
	@Autowired
	private AttributeSetInstanceDBService attributeSetInstanceDBService;
	@Autowired
	private InventoryDBService inventoryDbService;
	@Autowired
	private ProductCategoryDBService productCategoryDBService;
	@Autowired
	private InventoryDBService inventoryDBService = new InventoryDBService();
	private Map<String, String> dynamicJoins = new HashMap<>() {
		{
			put(X_BH_Stocktake_v.Table_Name, "LEFT JOIN (" + "SELECT " + MStorageOnHand.COLUMNNAME_M_Product_ID
					+ ",SUM(" + MStorageOnHand.COLUMNNAME_QtyOnHand + ") as quantity FROM " + MStorageOnHand.Table_Name
					+ " GROUP BY " + MStorageOnHand.COLUMNNAME_M_Product_ID + ") AS " + X_BH_Stocktake_v.Table_Name
					+ " ON " + X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_M_Product_ID + "="
					+ MProduct_BH.Table_Name + "." + MProduct_BH.COLUMNNAME_M_Product_ID);
		}
	};

	@Override
	public Map<String, String> getDynamicJoins() {
		return dynamicJoins;
	}

	public BaseListResponse<Product> getAll(Paging pagingInfo, String sortColumn, String sortOrder, String filterJson) {
		List<Object> parameters = new ArrayList<>();
		parameters.add(MProduct_BH.PRODUCTTYPE_Item);

		// Join for product category
		String joinClause = " JOIN " + MProductCategory_BH.Table_Name + " ON " + MProductCategory_BH.Table_Name + "."
				+ MProductCategory_BH.COLUMNNAME_M_Product_Category_ID + "=" + MProduct_BH.Table_Name + "."
				+ MProduct_BH.COLUMNNAME_M_Product_Category_ID;

		return super.getAll(MProduct_BH.COLUMNNAME_ProductType + " = ?", parameters, pagingInfo, sortColumn, sortOrder,
				filterJson, joinClause);
	}

	@Override
	public BaseListResponse<Product> search(String value, Paging pagingInfo, String sortColumn, String sortOrder) {
		List<Object> parameters = new ArrayList<>();
		parameters.add(constructSearchValue(value));
		parameters.add(MProduct_BH.PRODUCTTYPE_Item);

		return this.search(DEFAULT_SEARCH_CLAUSE + AND_OPERATOR + MProduct_BH.COLUMNNAME_ProductType + " = ?",
				parameters, pagingInfo, sortColumn, sortOrder);
	}

	/**
	 * Auto-complete search.
	 * <p>
	 * Searches products/services and returns related price, expiry, quantity fields
	 *
	 * @param searchValue
	 * @return
	 */
	public BaseListResponse<SearchProduct> searchItems(String searchValue) {
		// get available warehouses
		List<MWarehouse> warehouses = Arrays.asList(MWarehouse.getForOrg(Env.getCtx(), Env.getAD_Org_ID(Env.getCtx())));

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

				BaseListResponse<Inventory> inventoryList = inventoryDbService.getProductInventory(pagingInfo,
						entity.get_ID());

				BigDecimal totalQuantity = BigDecimal.ZERO;

				// Get the batched attribute sets
				Map<Integer, MAttributeSetInstance> attributeSetInstancesByIds = attributeSetInstanceDBService.getByIds(
						inventoryList.getResults().stream().map(Inventory::getAttributeSetInstanceId).collect(Collectors.toSet()));

				for (Inventory inventory : inventoryList.getResults()) {
					// exclude expired products
					if (inventory.getShelfLife() < 0) {
						continue;
					}

					// get expiry date and id
					SearchProductAttribute attribute = new SearchProductAttribute(inventory.getExpirationDate(),
							inventory.getAttributeSetInstanceId());
					if (inventory.getAttributeSetInstanceId() > 0) {
						attribute.setAttributeSetInstanceUuid(
								attributeSetInstancesByIds.get(inventory.getAttributeSetInstanceId()).getM_AttributeSetInstance_UU());
					}

					// get quantity
					totalQuantity = totalQuantity.add(BigDecimal.valueOf(inventory.getQuantity()));
					attribute.setExistingQuantity(BigDecimal.valueOf(inventory.getQuantity()));
					// store warehouse
					Optional<MWarehouse> foundWarehouse = warehouses.stream()
							.filter(warehouse -> warehouse.get_ID() == inventory.getWarehouseId()).findFirst();
					if (foundWarehouse.isPresent()) {
						attribute.setWarehouseUuid(foundWarehouse.get().getM_Warehouse_UU());
					}

					result.addAttribute(attribute);
				}

				result.setTotalQuantity(totalQuantity);
			}

			// If a product has no quantity, don't return it in the list
			if (result.getTotalQuantity() != null && result.getTotalQuantity().compareTo(BigDecimal.ZERO) > 0
					|| !entity.getProductType().equalsIgnoreCase(MProduct_BH.PRODUCTTYPE_Item)) {
				results.add(result);
			}
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
				if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
					product.setM_Product_UU(entity.getUuid());
				}

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

			if (entity.getProductCategoryUuid() != null) {
				MProductCategory_BH productCategory = productCategoryDBService
						.getEntityByUuidFromDB(entity.getProductCategoryUuid());
				if (productCategory != null) {
					product.setM_Product_Category_ID(productCategory.getM_Product_Category_ID());
				}
			}

			// calculate price margin
			if (entity.getBuyPrice() != null && entity.getSellPrice() != null) {
				product.setBH_PriceMargin(entity.getSellPrice().subtract(entity.getBuyPrice()));
			}

			product.setIsActive(entity.getIsActive());

			product.saveEx();

			// update inventory only for a new products with inventory
			if (exists == null && entity.getStorageOnHandList() != null
					&& entity.getStorageOnHandList().stream()
					.anyMatch(storageOnHand -> storageOnHand.getQuantityOnHand() != null
							&& storageOnHand.getQuantityOnHand().compareTo(BigDecimal.ZERO) > 0)) {
				Map<MProduct_BH, List<MStorageOnHand>> inventoryByProduct = new HashMap<>();
				// If it has expiration, cycle through the list and add the values
				if (product.isBH_HasExpiration()) {
					// Get the expiration date attribute set instance ids
					Map<Timestamp, Integer> expirationDatesByAttributeSetInstanceId = QueryUtil
							.createExpirationDateAttributeInstances(entity.getStorageOnHandList().stream()
									.map(storageOnHand -> storageOnHand.getAttributeSetInstance().getGuaranteeDate())
									.collect(Collectors.toSet()), null, Env.getCtx());
					inventoryByProduct.put(product, entity.getStorageOnHandList().stream().map(storageOnHand -> {
						MStorageOnHand storageOnHandToSave = new MStorageOnHand(Env.getCtx(), 0, null);
						storageOnHandToSave.setQtyOnHand(storageOnHand.getQuantityOnHand());
						storageOnHandToSave.setM_AttributeSetInstance_ID(expirationDatesByAttributeSetInstanceId
								.get(storageOnHand.getAttributeSetInstance().getGuaranteeDate()));
						return storageOnHandToSave;
					}).collect(Collectors.toList()));
				} else {
					// Otherwise, just add the first
					MStorageOnHand storageOnHand = new MStorageOnHand(Env.getCtx(), 0, null);
					storageOnHand.setQtyOnHand(entity.getStorageOnHandList().get(0).getQuantityOnHand());
					inventoryByProduct.put(product, Collections.singletonList(storageOnHand));
				}
				inventoryDBService.initializeStock(inventoryByProduct);
			}

			return createInstanceWithAllFields(getEntityByUuidFromDB(product.getM_Product_UU()));
		} catch (Exception ex) {
			if (ex.getMessage().contains("Require unique data")) {
				throw new DuplicateEntitySaveException(ex.getLocalizedMessage());
			} else {
				throw new AdempiereException(ex.getLocalizedMessage());
			}

		}
	}

	@Override
	protected Product createInstanceWithAllFields(MProduct_BH instance) {
		try {
			MProductCategory_BH productCategory = productCategoryDBService
					.getEntityByIdFromDB(instance.getM_Product_Category_ID());
			return new Product(instance.getAD_Client_ID(), instance.getAD_Org_ID(), instance.getM_Product_UU(),
					instance.isActive(), DateUtil.parseDateOnly(instance.getCreated()), instance.getCreatedBy(),
					instance.getName(), instance.getDescription(), instance.getValue(), instance.isStocked(),
					instance.getBH_BuyPrice(), instance.getBH_SellPrice(), instance.getProductType(),
					instance.get_ValueAsInt(COLUMNNAME_REORDER_LEVEL),
					instance.get_ValueAsInt(COLUMNNAME_REORDER_QUANTITY),
					instance.get_ValueAsBoolean(MProduct_BH.COLUMNNAME_BH_HasExpiration), instance.getBH_PriceMargin(),
					productCategory.getM_Product_Category_UU(),
					inventoryDbService.getProductInventoryCount(instance.getM_Product_ID()));
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
					product.getName(), product.getDescription(), product.getBH_BuyPrice(), product.getBH_SellPrice(),
					product.getBH_PriceMargin(), product.isBH_HasExpiration());
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
					DateUtil.parseDateOnly(product.getCreated()), product.getBH_SellPrice(), product.isActive(),
					product.getBH_PriceMargin());
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

	@Override
	public Boolean deleteEntity(String entityUuid) {
		// TODO Auto-generated method stub
		return null;
	}
}
