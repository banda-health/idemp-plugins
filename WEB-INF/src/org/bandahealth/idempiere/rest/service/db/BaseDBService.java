package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.bandahealth.idempiere.base.model.MColumn_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.BaseMetadata;
import org.bandahealth.idempiere.rest.model.Paging;
import org.compiere.model.MUser;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;

/**
 * Abstract common db service functionality
 * 
 * @author andrew
 *
 * @param <T>
 * @param <S>
 */
public abstract class BaseDBService<T extends BaseMetadata, S extends PO> {

	public final String ASCENDING_ORDER = "ASC";
	public final String DESCENDING_ORDER = "DESC";
	public final String LIKE_COMPARATOR = "LIKE";
	public final String AND_OPARATOR = " AND ";
	public final String OR_OPARATOR = " OR ";

	public final String DEFAULT_SEARCH_COLUMN = MUser.COLUMNNAME_Name;
	public final String DEFAULT_SEARCH_CLAUSE = "LOWER(" + DEFAULT_SEARCH_COLUMN + ") " + LIKE_COMPARATOR + " ? ";

	/**
	 * Get the fields that can be searched for the entity, T
	 * @param ignoreDefaultSearchColumn whether the default search column should be ignored or not
	 * @return A list of column names that are configured to be searchable
	 */
	protected List<String> getSearchableColumns(boolean ignoreDefaultSearchColumn) {
		return getSearchableColumns(ignoreDefaultSearchColumn, getModelInstance().get_Table_ID());
	}

	/**
	 * Get the fields that can be searched for pertaining to the entity with a specific table ID
	 * @param ignoreDefaultSearchColumn whether the default search column should be ignored or not
	 * @param tableId The ID of the table pertaining to the desired entity
	 * @return A list of column names that are configured to be searchable
	 */
	protected List<String> getSearchableColumns(boolean ignoreDefaultSearchColumn, int tableId) {
		List<MColumn_BH> searchableColumnsToReturn = new Query(
				Env.getCtx(),
				MColumn_BH.Table_Name,
				MColumn_BH.COLUMNNAME_AD_Table_ID + "=? AND " + MColumn_BH.COLUMNNAME_BH_RestSearchable + "=?",
				getModelInstance().get_TrxName()
		)
				.setOnlyActiveRecords(true)
				.setParameters(tableId, "Y")
				.list();

		List<String> searchableColumns = new ArrayList<String>();
		if (!ignoreDefaultSearchColumn) {
			searchableColumns.add(DEFAULT_SEARCH_COLUMN);
		}
		if (searchableColumnsToReturn == null) {
			return searchableColumns;
		}
		searchableColumns.addAll(
				searchableColumnsToReturn.stream()
						.map(MColumn_BH::getColumnName)
						.collect(Collectors.toList())
		);
		return searchableColumns;
	}

	public abstract T saveEntity(T entity);

	// Default fields used for lists
	protected abstract T createInstanceWithDefaultFields(S instance);

	// All fields
	protected abstract T createInstanceWithAllFields(S instance);

	// Search fields
	protected abstract T createInstanceWithSearchFields(S instance);

	protected abstract S getModelInstance();

	protected static CLogger log = CLogger.getCLogger(BaseDBService.class);

	private boolean checkColumnExists(String columnName) {
		if (getModelInstance() != null) {
			return getModelInstance().get_ColumnIndex(columnName) > -1;
		}

		return false;
	}

	protected String getOrderBy(String sortColumn, String sortOrder) {
		if (sortColumn != null && !sortColumn.isEmpty() && sortOrder != null) {
			// check if column exists
			if (checkColumnExists(sortColumn) || sortColumn.contains(".")) {
				return sortColumn + " "
						+ (sortOrder.equalsIgnoreCase(DESCENDING_ORDER) ? DESCENDING_ORDER : ASCENDING_ORDER)
						+ " NULLS LAST";
			}
		} else {
			// every table has the 'created' column
			return checkColumnExists(MUser.COLUMNNAME_Created) ? MUser.COLUMNNAME_Created + " " + DESCENDING_ORDER
					+ " NULLS LAST" : null;
		}

		return null;
	}

	/**
	 * Gets the entity by searching for it
	 * @param searchValue The value received via the REST API without transformation
	 * @param pagingInfo An iDempiere paging object
	 * @param sortColumn The column to sort on
	 * @param sortOrder The sort order for the column
	 * @return A list of entity T using all search fields, including the default
	 */
	public BaseListResponse<T> search(String searchValue, Paging pagingInfo, String sortColumn, String sortOrder) {
		return search(null, constructSearchValue(searchValue),
				getSearchableColumns(false), null, pagingInfo, sortColumn, sortOrder);
	}

	public BaseListResponse<T> search(String baseWhereClause, String searchValue, List<String> fieldsToSearch,
																		List<Object> parameters, Paging pagingInfo, String sortColumn,
																		String sortOrder) {
		try {
			List<T> results = new ArrayList<>();

			String whereClause = baseWhereClause;
			if (whereClause == null) {
				whereClause = "";
			}

			if (searchValue != null && !searchValue.isEmpty() && fieldsToSearch != null && fieldsToSearch.size() > 0) {
				if (parameters == null) {
					parameters = new ArrayList<Object>();
				}
				StringBuilder searchableFieldsWhereClause = new StringBuilder();
				searchableFieldsWhereClause.append(whereClause).append(AND_OPARATOR).append("(");

				List<String> searchableFieldClauses = new ArrayList<String>();
				List<Object> finalParameters = parameters;
				fieldsToSearch.forEach(fieldToSearch -> {
					searchableFieldClauses.add("LOWER(CAST(" + fieldToSearch + " AS VARCHAR)) " + LIKE_COMPARATOR + " ?");
					finalParameters.add(searchValue);
				});

				searchableFieldsWhereClause.append(String.join(OR_OPARATOR, searchableFieldClauses)).append(")");
				whereClause = searchableFieldsWhereClause.toString();

				parameters = finalParameters;
			}

			Query query = new Query(Env.getCtx(), getModelInstance().get_TableName(), whereClause, null).setClient_ID()
					.setOnlyActiveRecords(true);

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
			String sortOrder) {
		return this.getAll(whereClause, parameters, pagingInfo, sortColumn, sortOrder, null);
	}

	/**
	 * Get all with the inclusion of a join clause for joined cases of sorting
	 * @param whereClause
	 * @param parameters
	 * @param pagingInfo
	 * @param sortColumn
	 * @param sortOrder
	 * @param joinClause Use to specify a linked table so joining can occur
	 * @return
	 */
	public BaseListResponse<T> getAll(String whereClause, List<Object> parameters, Paging pagingInfo, String sortColumn,
			String sortOrder, String joinClause) {
		try {
			List<T> results = new ArrayList<>();

			Query query = new Query(Env.getCtx(), getModelInstance().get_TableName(), whereClause, null).setClient_ID()
					.setOnlyActiveRecords(true);

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
