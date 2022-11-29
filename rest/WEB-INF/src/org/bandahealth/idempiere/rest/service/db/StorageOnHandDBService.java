package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.rest.model.AttributeSetInstance;
import org.bandahealth.idempiere.rest.model.Locator;
import org.bandahealth.idempiere.rest.model.Product;
import org.bandahealth.idempiere.rest.model.ProductCostCalculation;
import org.bandahealth.idempiere.rest.model.StorageOnHand;
import org.bandahealth.idempiere.rest.utils.QueryUtil;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class StorageOnHandDBService extends BaseDBService<StorageOnHand, MStorageOnHand> {

	private static final String EXPIRE_WHERE_CLAUSE = MAttributeSetInstance_BH.Table_Name + "."
			+ MAttributeSetInstance_BH.COLUMNNAME_GuaranteeDate + " IS NULL OR " + MAttributeSetInstance_BH.Table_Name
			+ "." + MAttributeSetInstance_BH.COLUMNNAME_GuaranteeDate + " >= now()::date";
	@Autowired
	private ProductDBService productDBService;
	@Autowired
	private LocatorDBService locatorDBService;
	@Autowired
	private AttributeSetInstanceDBService attributeSetInstanceDBService;

	@Override
	public Map<String, String> getDynamicJoins() {
		// LinkedCaseInsensitiveMap is needed for case insensitive keys. Allows the sort/filter object to have case
		// insensitive tables..
		return new LinkedCaseInsensitiveMap<>() {
			{
				put(MAttributeSetInstance_BH.Table_Name,
						" JOIN " + MAttributeSetInstance_BH.Table_Name + " ON " + MAttributeSetInstance_BH.Table_Name
								+ "." + MAttributeSetInstance_BH.COLUMNNAME_M_AttributeSetInstance_ID + "="
								+ MStorageOnHand.Table_Name + "."
								+ MStorageOnHand.COLUMNNAME_M_AttributeSetInstance_ID);
				put(MAttributeSet_BH.Table_Name,
						" JOIN " + MAttributeSet_BH.Table_Name + " ON " + MAttributeSet_BH.Table_Name + "."
								+ MAttributeSet_BH.COLUMNNAME_M_AttributeSet_ID + "="
								+ MAttributeSetInstance_BH.Table_Name + "."
								+ MAttributeSetInstance_BH.COLUMNNAME_M_AttributeSet_ID);
				put(MProduct_BH.Table_Name,
						" JOIN " + MProduct_BH.Table_Name + " ON " + MProduct_BH.Table_Name + "."
								+ MProduct_BH.COLUMNNAME_M_Product_ID + "="
								+ MStorageOnHand.Table_Name + "."
								+ MStorageOnHand.COLUMNNAME_M_Product_ID);
			}
		};
	}

	@Override
	public List<StorageOnHand> transformData(List<MStorageOnHand> dbModels) {
		if (dbModels == null || dbModels.isEmpty()) {
			return new ArrayList<>();
		}

		Set<Integer> productIds = dbModels.stream().map(MStorageOnHand::getM_Product_ID).collect(Collectors.toSet());
		Set<Integer> attributeSetInstanceIds = dbModels.stream().map(MStorageOnHand::getM_AttributeSetInstance_ID)
				.collect(Collectors.toSet());
		Set<Integer> locatorIds = dbModels.stream().map(MStorageOnHand::getM_Locator_ID).collect(Collectors.toSet());

		Map<Integer, Locator> locatorsById = locatorDBService
				.transformData(new ArrayList<>(locatorDBService.getByIds(locatorIds).values())).stream()
				.collect(Collectors.toMap(Locator::getId, locator -> locator));
		Map<Integer, MAttributeSetInstance_BH> attributeSetInstancesByIds = attributeSetInstanceDBService
				.getByIds(attributeSetInstanceIds);
		Map<Integer, Product> productsById = productDBService
				.transformData(new ArrayList<>(productDBService.getByIds(productIds).values())).stream()
				.collect(Collectors.toMap(Product::getId, product -> product));

		// fetch prices by product and asi
		Map<Integer, List<ProductCostCalculation>> costsByProductIdAndAttributeSetInstanceId =
				productDBService.getProductCosts(productIds, attributeSetInstanceIds).stream()
						.collect(Collectors.groupingBy(ProductCostCalculation::getProductId));

		return dbModels.stream().map(model -> {
			StorageOnHand storageOnHand = createInstanceWithAllFields(model);

			if (locatorsById.containsKey(storageOnHand.getLocatorId())) {
				storageOnHand.setLocator(locatorsById.get(storageOnHand.getLocatorId()));
			}
			if (attributeSetInstancesByIds.containsKey(storageOnHand.getAttributeSetInstanceId())) {
				AttributeSetInstance attributeSetInstance =
						new AttributeSetInstance(attributeSetInstancesByIds.get(storageOnHand.getAttributeSetInstanceId()));

				if (costsByProductIdAndAttributeSetInstanceId.containsKey(storageOnHand.getProductId())) {
					costsByProductIdAndAttributeSetInstanceId.get(storageOnHand.getProductId()).stream().filter(
							productCostCalculation -> Objects.equals(productCostCalculation.getAttributeSetInstanceId(),
									attributeSetInstance.getId())).findFirst().ifPresent(productCostCalculation -> {
						attributeSetInstance.setPurchasePrice(productCostCalculation.getPurchasePrice());
						attributeSetInstance.setPurchaseDate(productCostCalculation.getPurchaseDate());
					});
				}

				storageOnHand.setAttributeSetInstance(attributeSetInstance);
			}

			if (productsById.containsKey(storageOnHand.getProductId())) {
				storageOnHand.setProduct(productsById.get(storageOnHand.getProductId()));
			}

			return storageOnHand;
		}).collect(Collectors.toList());
	}

	@Override
	public StorageOnHand saveEntity(StorageOnHand entity) {
		MStorageOnHand storage = getEntityByUuidFromDB(entity.getUuid());
		if (storage == null) {
			throw new UnsupportedOperationException("Not implemented");
		}

		storage.setQtyOnHand(entity.getQuantityOnHand());
		storage.saveEx();

		return transformData(Collections.singletonList(getEntityByUuidFromDB(storage.getM_StorageOnHand_UU()))).get(0);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected StorageOnHand createInstanceWithDefaultFields(MStorageOnHand instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected StorageOnHand createInstanceWithAllFields(MStorageOnHand instance) {
		return new StorageOnHand(instance);
	}

	@Override
	protected StorageOnHand createInstanceWithSearchFields(MStorageOnHand instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MStorageOnHand getModelInstance() {
		return new MStorageOnHand(Env.getCtx(), 0, null);
	}

	/**
	 * Get the quantity on hand for a particular product/ASI/locator set
	 *
	 * @param productId              The ID of the product
	 * @param attributeSetInstanceId The ID of the attribute set instance
	 * @param locatorId              The ID of the locator
	 * @return The sum of the quantities of the storage on hand records
	 */
	public BigDecimal getQuantityOnHand(int productId, int attributeSetInstanceId, int locatorId) {
		return new Query(Env.getCtx(), MStorageOnHand.Table_Name,
				MStorageOnHand.COLUMNNAME_M_Product_ID + "=? AND " + MStorageOnHand.COLUMNNAME_M_AttributeSetInstance_ID
						+ "=? AND " + MStorageOnHand.COLUMNNAME_M_Locator_ID + "=?",
				null).setParameters(productId, attributeSetInstanceId, locatorId)
				.sum(MStorageOnHand.COLUMNNAME_QtyOnHand);
	}

	/**
	 * Get the quantity on hand for a particular product in all locations and for
	 * all ASIs
	 *
	 * @param productId      The ID of the product
	 * @param includeExpired If the product is an expiring one, don't include
	 *                       storage that has expired
	 * @return The sum of the quantities of the storage on hand records
	 */
	public BigDecimal getQuantityOnHand(int productId, boolean includeExpired) {
		String whereClause = MStorageOnHand.Table_Name + "." + MStorageOnHand.COLUMNNAME_M_Product_ID + "=?";
		if (!includeExpired) {
			whereClause += " AND (" + EXPIRE_WHERE_CLAUSE + ")";
		}

		// Make sure the Junk Lot isn't included
		whereClause +=
				" AND " + MStorageOnHand.Table_Name + "." + MStorageOnHand.COLUMNNAME_M_AttributeSetInstance_ID + "!=?";

		return new Query(Env.getCtx(), MStorageOnHand.Table_Name, whereClause, null).addJoinClause(
						getDynamicJoins().get(MAttributeSetInstance_BH.Table_Name))
				.setParameters(productId, MAttributeSetInstance_BH.ATTRIBUTESETINSTANCEID_JUNK_LOT)
				.sum(MStorageOnHand.COLUMNNAME_QtyOnHand);
	}

	public Map<Integer, List<MStorageOnHand>> getNonExpiredGroupsByIds(
			Function<MStorageOnHand, Integer> groupingFunction, String columnToSearch, Set<Integer> ids) {
		if (ids.isEmpty()) {
			return new HashMap<>();
		}
		List<Object> parameters = new ArrayList<>();
		String whereCondition = QueryUtil.getWhereClauseAndSetParametersForSet(ids, parameters);
		if (!QueryUtil.doesTableAliasExistOnColumn(columnToSearch)) {
			columnToSearch = getModelInstance().get_TableName() + "." + columnToSearch;
		}
		String whereClause = columnToSearch + " IN (" + whereCondition + ") AND CASE WHEN "
				+ MAttributeSet_BH.Table_Name + "." + MAttributeSet_BH.COLUMNNAME_IsGuaranteeDate + "=? THEN "
				+ EXPIRE_WHERE_CLAUSE + " ELSE 1=1 END";
		parameters.add(true);
		List<MStorageOnHand> models = getBaseQuery(this.isClientIdFromTheContextNeededByDefaultForThisEntity(),
				whereClause, parameters).addJoinClause(getDynamicJoins().get(MAttributeSetInstance_BH.Table_Name))
				.addJoinClause(getDynamicJoins().get(MAttributeSet_BH.Table_Name)).list();
		Map<Integer, List<MStorageOnHand>> groupedValues = getTranslations(models).stream()
				.collect(Collectors.groupingBy(groupingFunction));
		return ids.stream()
				.collect(Collectors.toMap(id -> id, id -> groupedValues.getOrDefault(id, new ArrayList<>())));
	}
}
