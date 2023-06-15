package org.bandahealth.idempiere.rest.service.db;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MSerNoCtl_BH;
import org.bandahealth.idempiere.base.model.X_BH_Stocktake_v;
import org.bandahealth.idempiere.base.process.InitializeStock;
import org.bandahealth.idempiere.rest.exceptions.DuplicateEntitySaveException;
import org.bandahealth.idempiere.rest.model.AttributeSet;
import org.bandahealth.idempiere.rest.model.AttributeSetInstance;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Locator;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.Product;
import org.bandahealth.idempiere.rest.model.ProductCostCalculation;
import org.bandahealth.idempiere.rest.model.SerialNumberControl;
import org.bandahealth.idempiere.rest.model.StorageOnHand;
import org.bandahealth.idempiere.rest.model.Warehouse;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.QueryUtil;
import org.bandahealth.idempiere.rest.utils.SqlUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MLocator;
import org.compiere.model.MProduct;
import org.compiere.model.MProductCategory;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.MTaxCategory;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
	private ProductCategoryDBService productCategoryDBService;
	@Autowired
	private AttributeSetDBService attributeSetDBService;
	@Autowired
	private SerialNumberControlDBService serialNumberControlDBService;
	@Autowired
	private LocatorDBService locatorDBService;
	@Autowired
	private StorageOnHandDBService storageOnHandDBService;

	@Override
	public Map<String, String> getDynamicJoins() {
		return new HashMap<>() {
			{
				put(X_BH_Stocktake_v.Table_Name, "LEFT JOIN (" + "SELECT " + MStorageOnHand.COLUMNNAME_M_Product_ID
						+ ",SUM(" + MStorageOnHand.COLUMNNAME_QtyOnHand + ") as quantity FROM " + MStorageOnHand.Table_Name
						+ " GROUP BY " + MStorageOnHand.COLUMNNAME_M_Product_ID + ") AS " + X_BH_Stocktake_v.Table_Name
						+ " ON " + X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_M_Product_ID + "="
						+ MProduct_BH.Table_Name + "." + MProduct_BH.COLUMNNAME_M_Product_ID);
				put("product_costs",
						"LEFT JOIN (SELECT m_product_id, m_attributesetinstance_id, purchase_price, purchase_date, row_number() " +
								"OVER (PARTITION BY m_product_id ORDER BY purchase_date DESC) as row_num FROM get_product_costs(" +
								Env.getAD_Client_ID(Env.getCtx()) + ")) product_costs " + "ON product_costs." +
								MProduct_BH.COLUMNNAME_M_Product_ID + "=" + MProduct_BH.Table_Name + "." +
								MProduct_BH.COLUMNNAME_M_Product_ID + " AND product_costs.row_num = 1");
			}
		};
	}

	public BaseListResponse<Product> getAll(Paging pagingInfo, String sortJson, String filterJson) {
		List<Object> parameters = new ArrayList<>();
		parameters.add(MProduct_BH.PRODUCTTYPE_Item);

		// Join for product category
		String joinClause = " JOIN " + MProductCategory_BH.Table_Name + " ON " + MProductCategory_BH.Table_Name + "."
				+ MProductCategory_BH.COLUMNNAME_M_Product_Category_ID + "=" + MProduct_BH.Table_Name + "."
				+ MProduct_BH.COLUMNNAME_M_Product_Category_ID;

		return super.getAll(MProduct_BH.COLUMNNAME_ProductType + " = ?", parameters, pagingInfo, sortJson,
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
	public BaseListResponse<Product> searchItems(String searchValue) {
		List<Object> parameters = new ArrayList<>();
		parameters.add(constructSearchValue(searchValue));

		BaseListResponse<Product> response = super.getAll(DEFAULT_SEARCH_CLAUSE, parameters, new Paging(0, 100), null,
				null);

		// Get products that will have storage
		Set<Integer> productIdsWithStorage =
				response.getResults().stream().filter(Product::getIsStocked).map(Product::getId).collect(Collectors.toSet());

		Map<Integer, List<StorageOnHand>> storageOnHandByProductId = productIdsWithStorage.isEmpty() ? new HashMap<>() :
				storageOnHandDBService.transformData(
								storageOnHandDBService.getNonExpiredGroupsByIds(MStorageOnHand::getM_Product_ID,
												MStorageOnHand.COLUMNNAME_M_Product_ID, productIdsWithStorage).values().stream()
										.flatMap(Collection::stream).collect(Collectors.toList())).stream()
						// Go ahead and remove quantities that are zero - we don't need them
						.filter(storageOnHand -> storageOnHand.getQuantityOnHand().compareTo(BigDecimal.ZERO) != 0)
						.collect(Collectors.groupingBy(StorageOnHand::getProductId));

		List<Product> entities = new ArrayList<>();

		// 2. retrieve storage on hand
		for (Product entity : response.getResults()) {
			entity.setStorageOnHandList(
					storageOnHandByProductId.containsKey(entity.getId()) ? storageOnHandByProductId.get(entity.getId()) :
							new ArrayList<>());

			// If the product has an attribute set, clear out any SOH lines that don't have an ASI
			// (this happens when someone oversells inventory - an SOH record gets created with ASI 0 to hold the overage)
			if (entity.getAttributeSetId() > 0) {
				entity.setStorageOnHandList(entity.getStorageOnHandList().stream()
						.filter(storageOnHand -> storageOnHand.getAttributeSetInstanceId() > 0).collect(Collectors.toList()));
			}

			// If a product has no quantity, don't return it in the list
			if (entity.getStorageOnHandList().stream().map(StorageOnHand::getQuantityOnHand)
					.reduce(BigDecimal.ZERO, BigDecimal::add).compareTo(BigDecimal.ZERO) > 0
					|| !entity.getType().equalsIgnoreCase(MProduct_BH.PRODUCTTYPE_Item)) {
				entities.add(entity);
			}
		}

		response.setResults(entities);

		return response;
	}

	@Override
	public Product saveEntity(Product entity) {
		try {
			MProduct_BH product;
			MProduct_BH exists = getEntityByUuidFromDB(entity.getUuid());
			boolean isProductNew = true;
			if (exists != null) {
				product = exists;
				isProductNew = false;
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

				// Buy price can only be set when a product gets created
				if (entity.getBuyPrice() != null) {
					product.setBH_BuyPrice(entity.getBuyPrice());
				}
			}

			if (StringUtil.isNotNullAndEmpty(entity.getName())) {
				product.setName(entity.getName());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getDescription())) {
				product.setDescription(entity.getDescription());
			}

			if (entity.getReorderLevel() != null) {
				product.set_CustomColumn(COLUMNNAME_REORDER_LEVEL, entity.getReorderLevel());
			}

			if (entity.getReorderQuantity() != null) {
				product.set_CustomColumn(COLUMNNAME_REORDER_QUANTITY, entity.getReorderQuantity());
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
			MAttributeSet_BH attributeSet = null;
			if (entity.getAttributeSet() != null) {
				attributeSet = attributeSetDBService.getEntityByUuidFromDB(entity.getAttributeSet().getUuid());
				if (attributeSet != null) {
					product.setM_AttributeSet_ID(attributeSet.get_ID());
					entity.getAttributeSet().setId(attributeSet.get_ID());
				}
			}

			product.saveEx();

			// update inventory only for a new products with inventory
			if (isProductNew && entity.getStorageOnHandList() != null
					&& entity.getStorageOnHandList().stream()
					.anyMatch(storageOnHand -> storageOnHand.getQuantityOnHand() != null
							&& storageOnHand.getQuantityOnHand().compareTo(BigDecimal.ZERO) > 0)) {
				Map<MProduct_BH, List<MStorageOnHand>> inventoryByProduct = new HashMap<>();
				List<StorageOnHand> storageWithQuantities = entity.getStorageOnHandList().stream().filter(
						storageOnHand -> storageOnHand.getQuantityOnHand() != null &&
								storageOnHand.getQuantityOnHand().compareTo(BigDecimal.ZERO) > 0).collect(Collectors.toList());

				// Save the ASIs
				storageWithQuantities.forEach(storageOnHand -> {
					AttributeSetInstance attributeSetInstance =
							attributeSetInstanceDBService.saveEntity(storageOnHand.getAttributeSetInstance());
					storageOnHand.setAttributeSetInstance(attributeSetInstance);
				});

				// Get the locator information
				Set<String> locatorUuids = storageWithQuantities.stream().map(StorageOnHand::getLocator).map(Locator::getUuid)
						.collect(Collectors.toSet());
				Map<String, MLocator> locatorsByUuid =
						locatorUuids.isEmpty() ? new HashMap<>() : locatorDBService.getByUuids(locatorUuids);

				// Convert StorageOnHand to MStorageOnHand
				inventoryByProduct.put(product, storageWithQuantities.stream().map(storageOnHand -> {
					// NB: This model is NOT intended to be saved to the DB, but is a DTO only!
					MStorageOnHand model = new MStorageOnHand(Env.getCtx(), 0, null);
					model.setQtyOnHand(storageOnHand.getQuantityOnHand());
					model.setM_Product_ID(product.getM_Product_ID());
					if (storageOnHand.getLocator() != null && locatorsByUuid.containsKey(storageOnHand.getLocator().getUuid())) {
						model.setM_Locator_ID(locatorsByUuid.get(storageOnHand.getLocator().getUuid()).getM_Locator_ID());
					}
					if (storageOnHand.getAttributeSetInstance() != null) {
						model.setM_AttributeSetInstance_ID(storageOnHand.getAttributeSetInstance().getId());
					}
					model.setDateMaterialPolicy(new Timestamp(System.currentTimeMillis()));
					return model;
				}).collect(Collectors.toList()));

				// Get the warehouse to use
				Integer warehouseIdToUse = locatorsByUuid.values().stream().map(Locator::new).map(Locator::getWarehouse)
						.filter(Warehouse::isDefaultWarehouse).map(Warehouse::getId).findFirst().orElse(0);
				InitializeStock.createInitialStock(inventoryByProduct, Env.getCtx(), null, false, warehouseIdToUse);
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
			Product product = batchChildDataCalls(Collections.singletonList(
					new Product(instance.getAD_Client_ID(), instance.getAD_Org_ID(), instance.getM_Product_UU(),
							instance.isActive(), DateUtil.parseDateOnly(instance.getCreated()), instance.getCreatedBy(),
							instance.getName(), instance.getDescription(), instance.getValue(), instance.getBH_SellPrice(),
							instance.get_ValueAsInt(COLUMNNAME_REORDER_LEVEL), instance.get_ValueAsInt(COLUMNNAME_REORDER_QUANTITY),
							productCategory.getM_Product_Category_UU(), instance))).get(0);
			product.setTotalQuantity(storageOnHandDBService.getQuantityOnHand(product.getId(), false));
			return product;
		} catch (Exception ex) {
			log.severe("Error creating product instance: " + ex);

			throw new RuntimeException(ex.getMessage(), ex);
		}
	}

	@Override
	protected Product createInstanceWithDefaultFields(MProduct_BH product) {
		try {
			return new Product(product.getAD_Client_ID(), product.getAD_Org_ID(), product.getM_Product_UU(),
					product.isActive(), DateUtil.parseDateOnly(product.getCreated()), product.getCreatedBy(), product.getName(),
					product.getDescription(), product.getBH_SellPrice(), product);
		} catch (Exception ex) {
			log.severe("Error creating product instance: " + ex);
			throw new RuntimeException(ex.getLocalizedMessage(), ex);
		}
	}

	@Override
	protected Product createInstanceWithSearchFields(MProduct_BH product) {
		try {
			return new Product(product.getM_Product_UU(), product.getName(), DateUtil.parseDateOnly(product.getCreated()),
					product.getBH_SellPrice(), product.isActive(), product);
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

	public List<Product> batchChildDataCalls(List<Product> models) {
		// Get the attribute sets
		Set<Integer> attributeSetIds =
				models.stream().map(Product::getAttributeSetId).filter(attributeSetId -> attributeSetId > 0)
						.collect(Collectors.toSet());
		Map<Integer, MAttributeSet_BH> attributeSetsById =
				attributeSetIds.isEmpty() ? new HashMap<>() : attributeSetDBService.getByIds(attributeSetIds);

		Set<Integer> productIds = models.stream().map(Product::getId).collect(Collectors.toSet());
		List<ProductCostCalculation> productCostCalculations = getProductCosts(productIds, null);
		Map<Integer, ProductCostCalculation> mostRecentPurchasesByProductId =
				productCostCalculations.stream().collect(Collectors.groupingBy(ProductCostCalculation::getProductId)).entrySet()
						.stream().collect(Collectors.toMap(Map.Entry::getKey,
								productCostCalculationsForProduct -> productCostCalculationsForProduct.getValue().stream()
										// For over-sells, the guarantee date and buy price is null, so remove those
										.filter(productCostCalculation -> productCostCalculation.getPurchaseDate() != null &&
												productCostCalculation.getPurchasePrice() != null)
										.max(Comparator.comparing(ProductCostCalculation::getPurchaseDate))
										.orElse(new ProductCostCalculation())));

		// Get the serial number controls
		Set<Integer> serialNumberControlIds =
				attributeSetsById.values().stream().map(MAttributeSet_BH::getM_SerNoCtl_ID).collect(Collectors.toSet());
		Map<Integer, MSerNoCtl_BH> serialNumberControlsById = serialNumberControlIds.isEmpty() ? new HashMap<>() :
				serialNumberControlDBService.getByIds(serialNumberControlIds);
		return models.stream().peek(product -> {
			if (attributeSetsById.containsKey(product.getAttributeSetId())) {
				product.setAttributeSet(new AttributeSet(attributeSetsById.get(product.getAttributeSetId())));
				if (serialNumberControlsById.containsKey(product.getAttributeSet().getSerialNumberControlId())) {
					product.getAttributeSet().setSerialNumberControl(new SerialNumberControl(
							serialNumberControlsById.get(product.getAttributeSet().getSerialNumberControlId())));
				}
			}
			if (mostRecentPurchasesByProductId.containsKey(product.getId())) {
				product.setBuyPrice(mostRecentPurchasesByProductId.get(product.getId()).getPurchasePrice());
			}
		}).collect(Collectors.toList());
	}

	@Override
	public List<Product> transformData(List<MProduct_BH> dbModels) {
		List<Product> products = super.transformData(dbModels);
		return batchChildDataCalls(products);
	}

	/**
	 * Gets the costs associated with a product
	 *
	 * @param productIds              The products ids to get the costs for
	 * @param attributeSetInstanceIds The attribute set instance ids to get the costs for
	 * @return A map of product ids, each of which holds a map of attribute set instance ids to their costs
	 */
	public List<ProductCostCalculation> getProductCosts(Set<Integer> productIds, Set<Integer> attributeSetInstanceIds) {
		if (productIds == null) {
			productIds = new HashSet<>();
		}
		if (attributeSetInstanceIds == null) {
			attributeSetInstanceIds = new HashSet<>();
		}
		List<Object> parameters = new ArrayList<>();
		StringBuilder costSql = new StringBuilder(
				"SELECT m_product_id, m_attributesetinstance_id, purchase_price, purchase_date FROM get_product_costs(?)");
		parameters.add(Env.getAD_Client_ID(Env.getCtx()));
		if (!productIds.isEmpty() || !attributeSetInstanceIds.isEmpty()) {
			costSql.append(" WHERE ");
			if (!productIds.isEmpty()) {
				String productWhereClause =
						QueryUtil.getWhereClauseAndSetParametersForSet(productIds, parameters);
				costSql.append("m_product_id IN (").append(productWhereClause).append(")");
				if (!attributeSetInstanceIds.isEmpty()) {
					costSql.append(" AND ");
				}
			}
			if (!attributeSetInstanceIds.isEmpty()) {
				String attributeSetInstanceWhereClause =
						QueryUtil.getWhereClauseAndSetParametersForSet(attributeSetInstanceIds, parameters);
				costSql.append("m_attributesetinstance_id IN (").append(attributeSetInstanceWhereClause).append(")");
			}
		}
		List<ProductCostCalculation> productCostCalculations = new ArrayList<>();
		SqlUtil.executeQuery(costSql.toString(), parameters, null, data -> {
			try {
				int productId = data.getInt(1);
				int attributeSetInstanceId = data.getInt(2);
				BigDecimal purchasePrice = data.getBigDecimal(3);
				Timestamp purchaseDate = data.getTimestamp(4);
				productCostCalculations.add(
						new ProductCostCalculation(productId, attributeSetInstanceId, purchasePrice, purchaseDate));
			} catch (Exception e) {
				logger.severe(e.getMessage());
			}
		});
		return productCostCalculations;
	}
}
