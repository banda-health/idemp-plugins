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

	public final String ASCENDING_ORDER = "ASC";
	public final String DESCENDING_ORDER = "DESC";
	public final String LIKE_COMPARATOR = "LIKE";
	public final String AND_OPARATOR = " AND ";
	public final String OR_OPARATOR = " OR ";

	public final String DEFAULT_SEARCH_CLAUSE = "LOWER(" + MUser.COLUMNNAME_Name + ") " + LIKE_COMPARATOR + " ? ";

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
						+ (sortOrder.equalsIgnoreCase(DESCENDING_ORDER) ? DESCENDING_ORDER : ASCENDING_ORDER);
			}
		} else {
			// every table has the 'created' column
			return checkColumnExists(MUser.COLUMNNAME_Created) ? MUser.COLUMNNAME_Created + " " + DESCENDING_ORDER
					: null;
		}

		return null;
	}

	public BaseListResponse<T> search(String whereClause, List<Object> parameters, Paging pagingInfo) {
		try {
			List<T> results = new ArrayList<>();

			Query query = new Query(Env.getCtx(), getModelInstance().get_TableName(), whereClause, null).setClient_ID()
					.setOnlyActiveRecords(true);

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
		try {
			List<T> results = new ArrayList<>();

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
			S entity = getEntityFromDB(uuid);

			if (entity != null) {
				return createInstanceWithAllFields(entity);
			}
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	public S getEntityFromDB(String uuid) {
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
