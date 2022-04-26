package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.rest.model.StorageOnHand;
import org.bandahealth.idempiere.rest.utils.QueryUtil;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class StorageOnHandDBService extends BaseDBService<StorageOnHand, MStorageOnHand> {
	private static final String EXPIRE_WHERE_CLAUSE =
			MAttributeSetInstance_BH.Table_Name + "." + MAttributeSetInstance_BH.COLUMNNAME_GuaranteeDate + " IS NULL OR " +
					MAttributeSetInstance_BH.Table_Name + "." + MAttributeSetInstance_BH.COLUMNNAME_GuaranteeDate +
					" >= now()::date";

	@Override
	public Map<String, String> getDynamicJoins() {
		return new HashMap<>() {{
			put(MAttributeSetInstance_BH.Table_Name,
					" JOIN " + MAttributeSetInstance_BH.Table_Name + " ON " + MAttributeSetInstance_BH.Table_Name + "." +
							MAttributeSetInstance_BH.COLUMNNAME_M_AttributeSetInstance_ID + "=" + MStorageOnHand.Table_Name + "." +
							MStorageOnHand.COLUMNNAME_M_AttributeSetInstance_ID);
			put(MAttributeSet_BH.Table_Name,
					" JOIN " + MAttributeSet_BH.Table_Name + " ON " + MAttributeSet_BH.Table_Name + "." +
							MAttributeSet_BH.COLUMNNAME_M_AttributeSet_ID + "=" + MAttributeSetInstance_BH.Table_Name + "." +
							MAttributeSetInstance_BH.COLUMNNAME_M_AttributeSet_ID);
		}};
	}

	@Override
	public StorageOnHand saveEntity(StorageOnHand entity) {
		throw new UnsupportedOperationException("Not implemented");
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
				MStorageOnHand.COLUMNNAME_M_Product_ID + "=? AND " + MStorageOnHand.COLUMNNAME_M_AttributeSetInstance_ID +
						"=? AND " + MStorageOnHand.COLUMNNAME_M_Locator_ID + "=?", null).setParameters(productId,
				attributeSetInstanceId, locatorId).sum(MStorageOnHand.COLUMNNAME_QtyOnHand);
	}

	/**
	 * Get the quantity on hand for a particular product in all locations and for all ASIs
	 *
	 * @param productId      The ID of the product
	 * @param includeExpired If the product is an expiring one, don't include storage that has expired
	 * @return The sum of the quantities of the storage on hand records
	 */
	public BigDecimal getQuantityOnHand(int productId, boolean includeExpired) {
		String whereClause = MStorageOnHand.Table_Name + "." + MStorageOnHand.COLUMNNAME_M_Product_ID + "=?";
		if (!includeExpired) {
			whereClause += " AND (" + EXPIRE_WHERE_CLAUSE + ")";
		}

		return new Query(Env.getCtx(), MStorageOnHand.Table_Name, whereClause, null).addJoinClause(
						getDynamicJoins().get(MAttributeSetInstance_BH.Table_Name)).setParameters(productId)
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
		String whereClause =
				columnToSearch + " IN (" + whereCondition + ") AND CASE WHEN " + MAttributeSet_BH.Table_Name + "." +
						MAttributeSet_BH.COLUMNNAME_IsGuaranteeDate + "=? THEN " + EXPIRE_WHERE_CLAUSE + " ELSE 1=1 END";
		parameters.add(true);
		List<MStorageOnHand> models = getBaseQuery(this.isClientIdFromTheContextNeededByDefaultForThisEntity(),
				whereClause,
				parameters).addJoinClause(getDynamicJoins().get(MAttributeSetInstance_BH.Table_Name))
				.addJoinClause(getDynamicJoins().get(MAttributeSet_BH.Table_Name)).list();
		Map<Integer, List<MStorageOnHand>> groupedValues =
				getTranslations(models).stream().collect(Collectors.groupingBy(groupingFunction));
		return ids.stream().collect(Collectors.toMap(id -> id, id -> groupedValues.getOrDefault(id, new ArrayList<>())));
	}
}
