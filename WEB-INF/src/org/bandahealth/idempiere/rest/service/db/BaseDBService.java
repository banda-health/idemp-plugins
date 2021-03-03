package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.rest.function.VoidFunction;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.BaseMetadata;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.utils.FilterUtil;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.bandahealth.idempiere.rest.utils.QueryUtil;
import org.bandahealth.idempiere.rest.utils.SortUtil;
import org.bandahealth.idempiere.rest.utils.SqlUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MLanguage;
import org.compiere.model.MUser;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Language;


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
	 * Given a list of models, apply translations for them, if there are any needed
	 *
	 * @param models The models to translate
	 * @return The models with translated properties, if any
	 */
	protected List<S> getTranslations(List<S> models) {
		// Get columns to translate and their associated setter functions
		Map<String, Function<S, VoidFunction<String>>> columnsToTranslate = getColumnsToTranslate();
		// Only translate if we need to translate and there are columns to translate
		if (!Language.isBaseLanguage(Env.getAD_Language(Env.getCtx())) && columnsToTranslate.size() > 0 &&
				!models.isEmpty()) {
			S modelInstance = getModelInstance();
			// If anything errors, just skip translations
			try {
				Map<Integer, S> modelsById = models.stream().collect(Collectors.toMap(S::get_ID, v -> v));
				String idColumnName = modelInstance.get_TableName() + "_ID";
				String translationTableName = modelInstance.get_TableName() + "_Trl";

				// Setup translation fetching SQL
				List<Object> translationParameters = new ArrayList<>();
				String translationWhereClause =
						QueryUtil.getWhereClauseAndSetParametersForSet(modelsById.keySet(), translationParameters);

				// Ensure that the columns are ordered appropriately for the fetch and set
				AtomicInteger index = new AtomicInteger(2);
				Map<Integer, String> indexedColumnNames = columnsToTranslate.keySet().stream().collect(
						Collectors.toMap(columnToTranslate -> index.getAndIncrement(), columnToTranslate -> columnToTranslate));

				// Construct the SQL
				StringBuilder sql = new StringBuilder("SELECT ").append(idColumnName);
				// To ensure proper ordering of columns, increment up them (we start at 1 since result set fetching is
				// 1-indexed, not 0-indexed)
				for (int i = 1; i <= columnsToTranslate.size(); i++) {
					sql.append(",");
					sql.append(indexedColumnNames.get(i + 1)); // Since the first column is the ID column
				}
				sql.append(" FROM ").append(translationTableName).append(" WHERE ").append(idColumnName).append(" IN(")
						.append(translationWhereClause).append(") AND ").append(MLanguage.COLUMNNAME_AD_Language).append("=?");
				translationParameters.add(Env.getLanguage(Env.getCtx()).getAD_Language());

				// Fetch translations
				SqlUtil.executeQuery(sql.toString(), translationParameters, null, resultSet -> {
					try {
						// The first property passed in above was the entity ID, so use it to get the entity we're updating
						S modelToTranslate = modelsById.get(resultSet.getInt(1));
						indexedColumnNames.forEach((columnIndex, columnName) -> {
							try {
								ModelUtil.setPropertyIfPresent(resultSet.getString(columnIndex),
										columnsToTranslate.get(columnName).apply(modelToTranslate));
							} catch (Exception ex) {
								log.severe("Error processing record translations for table " + modelInstance.get_TableName() + ":" +
										ex.getMessage());
							}
						});
					} catch (Exception ex) {
						log.severe("Error processing record translations for table " + modelInstance.get_TableName() + ":" +
								ex.getMessage());
					}
				});
			} catch (Exception ex) {
				log.severe("Error processing translations for table " + modelInstance.get_TableName() + ":" + ex.getMessage());
			}
		}
		return models;
	}

	/**
	 * Get a list of columns that need translation, along with setter functions for values in each column
	 *
	 * @return A map of column names and an appropriate function to call to pass in a model to translate and to get a
	 * setter function
	 */
	protected Map<String, Function<S, VoidFunction<String>>> getColumnsToTranslate() {
		return new HashMap<>();
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

			Query query = new Query(Env.getCtx(), getModelInstance().get_TableName(), whereClause, null)
					.setClient_ID();

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
				if (joinString != null) {
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
			List<S> entities = getTranslations(query.list());

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
			if (entity != null) {
				entity = getTranslations(Collections.singletonList(entity)).get(0);
			}
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
			if (entity != null) {
				entity = getTranslations(Collections.singletonList(entity)).get(0);
			}
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
