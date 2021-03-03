package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.BaseMetadata;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.utils.FilterUtil;
import org.bandahealth.idempiere.rest.utils.SortUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MUser;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;


/**
 * Abstract common db service functionality
 *
 * @param <T>
 * @param <S>
 * @author andrew
 */
public abstract class BaseDBService<T extends BaseMetadata, S extends PO> {

	public static final String ASCENDING_ORDER = "ASC";
	public static final String DESCENDING_ORDER = "DESC";
	public static final String LIKE_COMPARATOR = "LIKE";
	public static final String AND_OPERATOR = " AND ";
	public static final String OR_OPERATOR = " OR ";
	public static final String EQUAL_OPERATOR = " = ";

	public static final String ORDERBY_NULLS_LAST = " NULLS LAST";

	public static final String DEFAULT_SEARCH_COLUMN = MUser.COLUMNNAME_Name;
	public static final String DEFAULT_SEARCH_CLAUSE = "LOWER(" + DEFAULT_SEARCH_COLUMN + ") " + LIKE_COMPARATOR + " ? ";
	protected static CLogger log = CLogger.getCLogger(BaseDBService.class);

	public abstract T saveEntity(T entity);

	public abstract Boolean deleteEntity(String entityUuid);

	/**
	 * This should be overridden in inheriting classes.
	 * Structure: Map<TableName, JOIN clause>
	 *
	 * @return A map of table names and their appropriate JOIN clauses
	 */
	public Map<String, String> getDynamicJoins() {
		return new HashMap<>();
	}

	// Default fields used for lists
	protected abstract T createInstanceWithDefaultFields(S instance);

	// All fields
	protected abstract T createInstanceWithAllFields(S instance);

	// Search fields
	protected abstract T createInstanceWithSearchFields(S instance);

	protected abstract S getModelInstance();

	/**
	 * Whether the client ID from the context should be automatically used in any DB queries
	 *
	 * @return Whether the client ID from the iDempiere context will be used
	 */
	protected boolean shouldUseContextClientId() {
		return true;
	}
	
	private boolean checkColumnExists(String columnName) {
		if (getModelInstance() != null) {
			return getModelInstance().get_ColumnIndex(columnName) > -1 || columnName.contains(".");
		}

		return false;
	}

	protected String getOrderBy(String sortColumn, String sortOrder) {
		if (sortColumn != null && !sortColumn.isEmpty() && sortOrder != null) {
			// check if column exists
			if (checkColumnExists(sortColumn)) {
				return sortColumn + " "
						+ (sortOrder.equalsIgnoreCase(DESCENDING_ORDER) ? DESCENDING_ORDER : ASCENDING_ORDER)
						+ ORDERBY_NULLS_LAST;
			}
		} else {
			// every table has the 'created' column
			return checkColumnExists(MUser.COLUMNNAME_Created) ? MUser.COLUMNNAME_Created + " " + DESCENDING_ORDER
					+ ORDERBY_NULLS_LAST : null;
		}

		return null;
	}

	public BaseListResponse<T> search(String valueToSearch, Paging pagingInfo,
																		String sortColumn, String sortOrder) {
		List<Object> parameters = new ArrayList<>();
		parameters.add(constructSearchValue(valueToSearch));
		return this.search(DEFAULT_SEARCH_CLAUSE, parameters, pagingInfo, sortColumn, sortOrder);
	}

	public BaseListResponse<T> search(String whereClause, List<Object> parameters, Paging pagingInfo,
																		String sortColumn, String sortOrder) {
		return this.search(whereClause, parameters, pagingInfo, sortColumn, sortOrder, null);
	}

	/**
	 * Search all with the inclusion of a join clause for joined cases of sorting
	 *
	 * @param whereClause
	 * @param parameters
	 * @param pagingInfo
	 * @param sortColumn
	 * @param sortOrder
	 * @param joinClause  Use to specify a linked table so joining can occur
	 * @return
	 */
	public BaseListResponse<T> search(String whereClause, List<Object> parameters, Paging pagingInfo,
																		String sortColumn, String sortOrder, String joinClause) {
		try {
			List<T> results = new ArrayList<>();

			Query query = new Query(Env.getCtx(), getModelInstance().get_TableName(), whereClause, null).setClient_ID();

			if (joinClause != null) {
				query.addJoinClause(joinClause);
			}

			String orderBy = getOrderBy(sortColumn, sortOrder);
			if (orderBy != null) {
				query = query.setOrderBy(orderBy);
			}

			if (parameters != null) {
				query = query.setParameters(parameters);
			}

			// get total count without pagination parameters
			pagingInfo.setTotalRecordCount(query.count());

			// set pagination params
			query = query.setPage(pagingInfo.getPageSize(), pagingInfo.getPage());

			List<S> entities = query.list();

			if (!entities.isEmpty()) {
				for (S entity : entities) {
					if (entity != null) {
						results.add(createInstanceWithSearchFields(entity));
					}
				}
			}

			return new BaseListResponse<T>(results, pagingInfo);

		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	public BaseListResponse<T> getAll(String whereClause, List<Object> parameters, Paging pagingInfo, String sortColumn,
																		String sortOrder, String filterJson) {
		return this.getAll(whereClause, parameters, pagingInfo, sortColumn, sortOrder, filterJson, null);
	}

	/**
	 * Get all with the inclusion of a join clause for joined cases of sorting
	 *
	 * @param whereClause
	 * @param parameters
	 * @param pagingInfo
	 * @param sortColumn
	 * @param sortOrder
	 * @param joinClause  Use to specify a linked table so joining can occur
	 * @return
	 */
	public BaseListResponse<T> getAll(String whereClause, List<Object> parameters, Paging pagingInfo, String sortColumn,
																		String sortOrder, String filterJson, String joinClause) {
		try {
			List<T> results = new ArrayList<>();
			if (parameters == null) {
				parameters = new ArrayList<>();
			}

			String filterWhereClause = FilterUtil.getWhereClauseFromFilter(getModelInstance(), filterJson, parameters);
			if (StringUtil.isNullOrEmpty(whereClause)) {
				whereClause = filterWhereClause;
			} else {
				whereClause += " AND " + filterWhereClause;
			}

			Query query = new Query(Env.getCtx(), getModelInstance().get_TableName(), whereClause, null);
			// If we should use the client ID in the context, add it
			if (shouldUseContextClientId()) {
				query.setClient_ID();
			}

			StringBuilder dynamicJoinClause = new StringBuilder();
			if (!getDynamicJoins().isEmpty()) {
				String passedInJoinClause = (joinClause == null ? "" : joinClause).toLowerCase();
				List<String> neededJoinTables = FilterUtil.getTablesNeedingJoins(filterJson);
				for (String tableNeedingJoin : neededJoinTables) {
					// If this table was already specified in a JOIN, we don't need to dynamically add it
					if (passedInJoinClause.contains(tableNeedingJoin + ".")) {
						continue;
					}
					// Find the needed JOIN clause
					boolean foundMatchForTable = false;
					for (String dynamicTableJoinName : getDynamicJoins().keySet()) {
						if (dynamicTableJoinName.equalsIgnoreCase(tableNeedingJoin)) {
							dynamicJoinClause.append(" ").append(getDynamicJoins().get(dynamicTableJoinName));
							foundMatchForTable = true;
						}
					}
					// If no JOIN clause is specified in the dynamic JOIN, we need to let the user know
					if (!foundMatchForTable) {
						throw new AdempiereException(tableNeedingJoin
								+ " was specified in the filter, but no dynamic JOIN clause provided");
					}
				}
			}
			if (joinClause != null) {
				dynamicJoinClause.append(" ").append(joinClause);
			}

			if (!dynamicJoinClause.toString().trim().isEmpty()) {
				query.addJoinClause(dynamicJoinClause.toString().trim());
			} 
			if (SortUtil.doesTableAliasExistOnColumn(sortColumn)) {
				String joinString = SortUtil.getJoinClauseFromAlias(sortColumn, joinClause, getDynamicJoins());
				if(joinString != null) {
					query.addJoinClause(joinString);
				}
			}

			String orderBy = getOrderBy(sortColumn, sortOrder);
			if (orderBy != null) {
				query = query.setOrderBy(orderBy);
			}

			if (parameters.size() > 0) {
				query = query.setParameters(parameters);
			}

			// get total count without pagination parameters
			pagingInfo.setTotalRecordCount(query.count());

			// set pagination params
			query = query.setPage(pagingInfo.getPageSize(), pagingInfo.getPage());
			List<S> entities = query.list();

			if (!entities.isEmpty()) {
				for (S entity : entities) {
					if (entity != null) {
						results.add(createInstanceWithDefaultFields(entity));
					}
				}
			}

			return new BaseListResponse<T>(results, pagingInfo);

		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	/**
	 * Retrieve a REST entity from the DB with a given UUID
	 *
	 * @param uuid
	 * @return
	 */
	public T getEntity(String uuid) {
		try {
			S entity = getEntityByUuidFromDB(uuid);

			if (entity != null) {
				return createInstanceWithAllFields(entity);
			}
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	/**
	 * Retrieve entity from DB given uuid
	 *
	 * @param uuid
	 * @return
	 */
	public S getEntityByUuidFromDB(String uuid) {
		try {
			// construct uuid column name
			String columnUuid = getModelInstance().get_TableName() + "_uu";
			if (!checkColumnExists(columnUuid)) {
				log.severe("Uuid column not found: " + columnUuid);
				return null;
			}

			S entity = new Query(Env.getCtx(), getModelInstance().get_TableName(), columnUuid + "=?", null)
					.setParameters(uuid).first();
			return entity;
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	/**
	 * Retrieve entity from db given id
	 *
	 * @param id
	 * @return
	 */
	public S getEntityByIdFromDB(int id) {
		try {
			// construct id column name
			String columnId = getModelInstance().get_TableName() + "_id";
			if (!checkColumnExists(columnId)) {
				log.severe("Id column not found: " + columnId);
				return null;
			}

			S entity = new Query(Env.getCtx(), getModelInstance().get_TableName(), columnId + "=?", null)
					.setParameters(id).first();
			return entity;
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	public String constructSearchValue(String value) {
		String searchValue;
		if (value == null) {
			searchValue = "";
		} else {
			searchValue = "%" + value.toLowerCase() + "%";
		}

		return searchValue;
	}
}
