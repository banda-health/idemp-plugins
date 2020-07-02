package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

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

	public static final String ASCENDING_ORDER = "ASC";
	public static final String DESCENDING_ORDER = "DESC";
	public static final String LIKE_COMPARATOR = "LIKE";
	public static final String AND_OPERATOR = " AND ";
	public static final String OR_OPERATOR = " OR ";

	public static final String ORDERBY_NULLS_LAST = " NULLS LAST";

	public static final String DEFAULT_SEARCH_COLUMN = MUser.COLUMNNAME_Name;
	public static final String DEFAULT_SEARCH_CLAUSE = "LOWER(" + DEFAULT_SEARCH_COLUMN + ") " + LIKE_COMPARATOR + " ? ";

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
	 * @param whereClause
	 * @param parameters
	 * @param pagingInfo
	 * @param sortColumn
	 * @param sortOrder
	 * @param joinClause Use to specify a linked table so joining can occur
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
