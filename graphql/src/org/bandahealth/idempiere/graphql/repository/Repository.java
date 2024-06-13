package org.bandahealth.idempiere.graphql.repository;

import graphql.schema.DataFetchingEnvironment;
import org.adempiere.exceptions.AdempiereException;
import org.adempiere.util.ServerContext;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.bandahealth.idempiere.graphql.model.PagingInfo;
import org.bandahealth.idempiere.graphql.utils.FilterUtil;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.bandahealth.idempiere.graphql.utils.QueryUtil;
import org.bandahealth.idempiere.graphql.utils.SortUtil;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Repository {
	private static final ThreadLocal<Boolean> isApplyAccessFilterNeeded = ThreadLocal.withInitial(() -> Boolean.TRUE);
	private static final ThreadLocal<Boolean> isClientIdNeeded = ThreadLocal.withInitial(() -> Boolean.FALSE);

	/**
	 *
	 */
	public static void setApplyAccessFilterNotNeeded() {
		isApplyAccessFilterNeeded.set(Boolean.FALSE);
	}

	public static void clearApplyAccessFilterNotNeeded() {
		isApplyAccessFilterNeeded.set(Boolean.TRUE);
	}

	/**
	 * Make sure the client ID is used when running a query
	 */
	public static void setClientIdNeeded() {
		isClientIdNeeded.set(Boolean.TRUE);
	}

	/**
	 * Ensure that the client ID is not used when running a query
	 */
	public static void clearClientIdNeeded() {
		isClientIdNeeded.set(Boolean.FALSE);
	}

	/**
	 * The default method to create a Query for this entity type.
	 *
	 * @param idempiereContext The context since Env.getCtx() isn't thread-safe
	 * @param tableName        The table name to fetch from
	 * @param transactionName  The transaction to use, if any
	 * @param whereClause      The WHERE clause to add to the query
	 * @param parameters       Any parameters needed for the WHERE clause
	 * @return A query that can be used to fetch data
	 */
	public static Query getQuery(Properties idempiereContext, String tableName, String transactionName,
			boolean fullyQualifiedWhere, boolean isReadWrite, String whereClause, Object... parameters) {
		List<Object> parametersToUse = new ArrayList<>();
		// Handle any that were passed in
		if (parameters != null) {
			Arrays.stream(parameters).forEach(parameter -> {
				if (parameter instanceof List<?>) {
					parametersToUse.addAll((List<?>) parameter);
				} else {
					parametersToUse.add(parameter);
				}
			});
		}
		// Set up the query. Also, we don't want virtual columns because those were used in GO and greatly slow down
		// queries. If they're needed, the query should be written in the resolvers as a column/JOIN
		Query query = new Query(idempiereContext, tableName, whereClause, transactionName).setNoVirtualColumn(true);
		if (isApplyAccessFilterNeeded.get()) {
			query.setApplyAccessFilter(fullyQualifiedWhere, isReadWrite);
		}
		if (isClientIdNeeded.get()) {
			query.setClient_ID();
		}
		if (!parametersToUse.isEmpty()) {
			query.setParameters(parametersToUse);
		}
		return query;
	}

	/**
	 * Get an entity in connection form, only returning what was requested by the API caller
	 *
	 * @param tableName       The table to fetch data from
	 * @param transactionName A transaction name, if any, to use in the query
	 * @param pagingInfo      The pagination data to help in query limiting
	 * @param sort            Any sorting criteria to use in JSON-string form
	 * @param filter          Any filter criteria to use in JSON-string form
	 * @param environment     The data fetching environment passed in to the GraphQL endpoint
	 * @param <T>             A type that extends iDempiere's PO type
	 * @return A connection of data requested
	 */
	public static <T extends PO> Connection<T> get(String tableName, String transactionName, PagingInfo pagingInfo,
			String sort, String filter, DataFetchingEnvironment environment) {
		return get(tableName, transactionName, pagingInfo, sort, filter, null, null, environment);
	}

	/**
	 * Get an entity in connection form, only returning what was requested by the API caller
	 *
	 * @param tableName       The table to fetch data from
	 * @param transactionName A transaction name, if any, to use in the query
	 * @param pagingInfo      The pagination data to help in query limiting
	 * @param sort            Any sorting criteria to use in JSON-string form
	 * @param filter          Any filter criteria to use in JSON-string form
	 * @param whereClause     An additional where clause to add to any filter passed in from outside the API
	 * @param whereClause     Any parameters for the additional where clause
	 * @param environment     The data fetching environment passed in to the GraphQL endpoint
	 * @param <T>             A type that extends iDempiere's PO type
	 * @return A connection of data requested
	 */
	public static <T extends PO> Connection<T> get(String tableName, String transactionName, PagingInfo pagingInfo,
			String sort, String filter, String whereClause, List<Object> parameters, DataFetchingEnvironment environment) {
		Properties idempiereContext = BandaGraphQLContext.getCtx(environment);
		try {
			if (parameters == null) {
				parameters = new ArrayList<>();
			}
			String filterWhereClause =
					FilterUtil.getWhereClauseFromFilter(tableName, filter, parameters, idempiereContext);
			if (StringUtil.isNullOrEmpty(whereClause)) {
				whereClause = filterWhereClause;
			} else {
				whereClause += " AND " + filterWhereClause;
			}
			setCopyOfPropertiesForNestedThreadUsage(idempiereContext);
			Query query =
					getQuery(idempiereContext, tableName, transactionName, true, false, whereClause, parameters);

			String orderBy = SortUtil.getOrderByClauseFromSort(tableName, sort);
			if (orderBy != null) {
				query = query.setOrderBy(orderBy);
			}

			// If the paging info wasn't requested in the payload, don't do an extra DB call to get it
			if (QueryUtil.isTotalCountRequested(environment)) {
				// get total count without pagination parameters
				pagingInfo.setTotalCount(query.count());
			}

			List<T> results = new ArrayList<>();
			// If the results weren't requested in the payload (say a consumer just wants to know the count of entities
			// matching a specified filter), don't do an extra DB call to get them
			if (QueryUtil.areResultsRequested(environment)) {
				//
				// If the total record count is less than what we'd get with our page parameters, reset the page
				if (pagingInfo.getPageSize() < 1) {
					pagingInfo.setPageSize(200);
				}
				// If the total record count is less than what we'd get with our page parameters, reset the page
				int firstRecordNumberOfRequestedPage = (pagingInfo.getPage() * pagingInfo.getPageSize()) + 1;
				if (pagingInfo.getTotalCount() != null && pagingInfo.getTotalCount() < firstRecordNumberOfRequestedPage) {
					pagingInfo.setPage(0);
				}
				//
				// set pagination params
				query = query.setPage(pagingInfo.getPageSize(), pagingInfo.getPage());
				results = query.list();

				// If there are no results, the page is greater than 0, and the total count is NULL (meaning we didn't have
				// this information before making the original query, we need to see if there are any results to return
				// on the first page
				if (results.isEmpty() && pagingInfo.getPage() > 0 && pagingInfo.getTotalCount() == null) {
					// Try the query again
					pagingInfo.setPage(0);
					query = query.setPage(pagingInfo.getPageSize(), pagingInfo.getPage());
					results = query.list();
				}
			}
			return new Connection<>(results, pagingInfo);
		} catch (Exception ex) {
			throw new AdempiereException(ex);
		}
	}

	/**
	 * Get a list of this entity grouped by IDs. This needs a string as it's ID (generated by Model.getModelKey)
	 * because there could be collisions between the table IDs could match the grouping IDs (which are typically
	 * foreign keys).
	 *
	 * @param idempiereContext The context since Env.getCtx() isn't thread-safe
	 * @param tableName        The table name to fetch from
	 * @param transactionName  The transaction to use, if any
	 * @param groupingFunction The grouping function to apply for these entities
	 * @param columnToSearch   The search column to check in
	 * @param ids              The IDs to search by
	 * @return A completable future of entities grouped by an Entity Key
	 */
	public static <T extends PO> CompletableFuture<Map<String, List<T>>> getGroupsByModelKeysCompletableFuture(
			Properties idempiereContext, String tableName, String transactionName, Function<T, Integer> groupingFunction,
			String columnToSearch, Set<String> ids) {
		return CompletableFuture.supplyAsync(
				() -> getGroupsByModelKeys(idempiereContext, tableName, transactionName, groupingFunction, columnToSearch,
						ids));
	}

	/**
	 * Get a list of this entity grouped by IDs. This needs a string as it's ID (generated by Model.getModelKey)
	 * because there could be collisions between the table IDs could match the grouping IDs (which are typically
	 * foreign keys).
	 *
	 * @param idempiereContext The context since Env.getCtx() isn't thread-safe
	 * @param tableName        The table name to fetch from
	 * @param transactionName  The transaction to use, if any
	 * @param groupingFunction The grouping function to apply for these entities
	 * @param columnToSearch   The search column to check in
	 * @param ids              The IDs to search by
	 * @return A completable future of entities grouped by an Entity Key
	 */
	public static <T extends PO> Map<String, List<T>> getGroupsByModelKeys(Properties idempiereContext, String tableName,
			String transactionName, Function<T, Integer> groupingFunction, String columnToSearch, Set<String> ids) {
		String modelName = ModelUtil.getModelFromKey(ids.iterator().next());
		return getGroupsByIds(idempiereContext, tableName, transactionName, groupingFunction, columnToSearch,
				ids.stream().map(ModelUtil::getIdFromKey).collect(Collectors.toSet())).entrySet().stream().collect(
				Collectors.toMap(entrySet -> ModelUtil.getModelKey(modelName, entrySet.getKey()), Map.Entry::getValue));
	}

	/**
	 * Get a list of this entity grouped by IDs
	 *
	 * @param idempiereContext The context since Env.getCtx() isn't thread-safe
	 * @param tableName        The table name to fetch from
	 * @param transactionName  The transaction to use, if any
	 * @param groupingFunction The grouping function to apply for these entities
	 * @param columnToSearch   The search column to check in
	 * @param ids              The IDs to search by
	 * @return Entities grouped by their ID
	 */
	public static <T extends PO> Map<Integer, List<T>> getGroupsByIds(Properties idempiereContext, String tableName,
			String transactionName, Function<T, Integer> groupingFunction, String columnToSearch, Set<Integer> ids) {
		List<Object> parameters = new ArrayList<>();
		String whereCondition = QueryUtil.getWhereClauseAndSetParametersForSet(ids, parameters);
		if (!QueryUtil.doesTableAliasExistOnColumn(columnToSearch)) {
			columnToSearch = tableName + "." + columnToSearch;
		}
		String whereClause = null;
		if (!StringUtil.isNullOrEmpty(whereCondition)) {
			whereClause = columnToSearch + " IN (" + whereCondition + ")";
		}
		setCopyOfPropertiesForNestedThreadUsage(idempiereContext);
		List<T> models =
				getQuery(idempiereContext, tableName, transactionName, true, false, whereClause, parameters).list();
		return models.stream().collect(Collectors.groupingBy(groupingFunction));
	}

	/**
	 * Get an entity by its ID
	 *
	 * @param id               The ID to search by
	 * @param tableName        The table name to fetch from
	 * @param transactionName  The transaction to use, if any
	 * @param idempiereContext The context since Env.getCtx() isn't thread-safe
	 * @return The entity
	 */
	public static <T extends PO> T getById(Properties idempiereContext, String tableName, String transactionName,
			int id) {
		if (isApplyAccessFilterNeeded.get()) {
			ModelUtil.getTableAndCheckAccess(idempiereContext, tableName);
		}
		setCopyOfPropertiesForNestedThreadUsage(idempiereContext);
		return getQuery(idempiereContext, tableName, transactionName, true, false, tableName + "." + tableName + "_ID=?",
				id).setClient_ID(isClientIdNeeded.get()).first();
	}

	/**
	 * Get a list of entities by their IDs
	 *
	 * @param idempiereContext The context since Env.getCtx() isn't thread-safe
	 * @param tableName        The table name to fetch from
	 * @param transactionName  The transaction to use, if any
	 * @param ids              The IDs to search by
	 * @return A map of entities by the ID searched
	 */
	public static <T extends PO> Map<Integer, T> getByIds(Properties idempiereContext, String tableName,
			String transactionName, Set<Integer> ids) {
		if (isApplyAccessFilterNeeded.get()) {
			ModelUtil.getTableAndCheckAccess(idempiereContext, tableName);
		}
		if (ids.isEmpty()) {
			return new HashMap<>();
		}
		List<Object> parameters = new ArrayList<>();
		String whereCondition = QueryUtil.getWhereClauseAndSetParametersForSet(ids, parameters);
		setCopyOfPropertiesForNestedThreadUsage(idempiereContext);
		List<T> models = getQuery(idempiereContext, tableName, transactionName, true, false,
				tableName + "." + tableName + "_ID IN (" + whereCondition + ")", parameters).setClient_ID(
				isClientIdNeeded.get()).list();
		return models.stream().collect(Collectors.toMap(T::get_ID, m -> m));
	}

	/**
	 * Get a list of entities by their IDs, but as a completable future
	 *
	 * @param ids              The IDs to search by
	 * @param idempiereContext The context since Env.getCtx() isn't thread-safe
	 * @return A completable future of a map of entities by their IDs
	 */
	public static <T extends PO> CompletableFuture<Map<Integer, T>> getByIdsCompletableFuture(Properties idempiereContext,
			String tableName, String transactionName, Set<Integer> ids) {
		return CompletableFuture.supplyAsync(() -> getByIds(idempiereContext, tableName, transactionName, ids));
	}

	/**
	 * Get an of entity by its UUID
	 *
	 * @param idempiereContext The context since Env.getCtx() isn't thread-safe
	 * @param tableName        The table name to fetch from
	 * @param transactionName  The transaction to use, if any
	 * @param uuid             The UUID to search by
	 * @return An entity
	 */
	public static <T extends PO> T getByUuid(Properties idempiereContext, String tableName, String transactionName,
			String uuid) {
		if (isApplyAccessFilterNeeded.get()) {
			ModelUtil.getTableAndCheckAccess(idempiereContext, tableName);
		}
		setCopyOfPropertiesForNestedThreadUsage(idempiereContext);
		return getQuery(idempiereContext, tableName, transactionName, true, false, tableName + "." + tableName + "_UU=?",
				uuid).setClient_ID(isClientIdNeeded.get()).first();
	}

	/**
	 * Get a map of entities by their UUIDs
	 *
	 * @param idempiereContext The context since Env.getCtx() isn't thread-safe
	 * @param tableName        The table name to fetch from
	 * @param transactionName  The transaction to use, if any
	 * @param uuids            The UUIDs to search by
	 * @return A list of entities
	 */
	public static <T extends PO> Map<String, T> getByUuids(Properties idempiereContext, String tableName,
			String transactionName, Set<String> uuids) {
		if (isApplyAccessFilterNeeded.get()) {
			ModelUtil.getTableAndCheckAccess(idempiereContext, tableName);
		}
		if (uuids.isEmpty()) {
			return new HashMap<>();
		}
		List<Object> parameters = new ArrayList<>();
		String whereCondition = QueryUtil.getWhereClauseAndSetParametersForSet(uuids, parameters);
		setCopyOfPropertiesForNestedThreadUsage(idempiereContext);
		List<T> models = getQuery(idempiereContext, tableName, transactionName, true, false,
				tableName + "." + tableName + "_UU IN (" + whereCondition + ")", parameters).setClient_ID(
				isClientIdNeeded.get()).list();
		return models.stream().collect(
				Collectors.toMap(model -> model.get_Value(model.get_ColumnIndex(model.getUUIDColumnName())).toString(),
						model -> model));
	}

	/**
	 * Get an of entity by its UUID, but as a completable future
	 *
	 * @param idempiereContext The context since Env.getCtx() isn't thread-safe
	 * @param tableName        The table name to fetch from
	 * @param transactionName  The transaction to use, if any
	 * @param uuids            The UUIDs to search by
	 * @return A completable future of a map of entities by their UUIDs
	 */
	public static <T extends PO> CompletableFuture<Map<String, T>> getByUuidsCompletableFuture(
			Properties idempiereContext, String tableName, String transactionName, Set<String> uuids) {
		return CompletableFuture.supplyAsync(
				() -> getByUuids(idempiereContext, tableName, transactionName, new HashSet<>(uuids)));
	}

	public static void setCopyOfPropertiesForNestedThreadUsage(Properties idempiereContext) {
		// Create a copy of properties in case anything in the model modifies it
		Properties copyOfIdempiereContextForTheThread = new Properties();
		copyOfIdempiereContextForTheThread.putAll(idempiereContext);
		ServerContext.setCurrentInstance(copyOfIdempiereContextForTheThread);
		Env.setCtx(copyOfIdempiereContextForTheThread);
	}
}
