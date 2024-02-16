package org.bandahealth.idempiere.rest.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.rest.model.FilterTableData;
import org.bandahealth.idempiere.rest.service.db.EntityConfiguration;
import org.compiere.model.MTable;
import org.compiere.model.POInfo;
import org.compiere.util.CLogger;
import org.compiere.util.Env;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

enum FilterArrayJoin {
	AND,
	OR,
}

public class FilterUtil {
	public static final String DEFAULT_WHERE_CLAUSE = "(1=1)";

	private static final List<String> LOGICAL_QUERY_SELECTORS = Arrays.asList("$and", "$not", "$or", "$nor");
	private static final List<String> AGGREGATE_QUERY_SELECTORS = Arrays.asList("$sum", "$count", "$max", "$min");
	private static final String MALFORMED_FILTER_STRING_ERROR = "Filter criteria doesn't meet the standard form.";
	/**
	 * The column names that don't follow the typical pattern of FK mappings ([TABLE_NAME]_ID)
	 * Note: All keys should be lower-case to avoid case mismatches
	 */
	private static final Map<String, String> specialForeignKeyMappings = new HashMap<>() {{
		put("createdby", "ad_user");
		put("updatedby", "ad_user");
		put("bh_from_warehouse", "m_warehouse");
		put("bh_to_warehouse", "m_warehouse");
	}};
	private static final String SPECIFIC_COLUMN_MAPPING_SPECIFIER = "::";
	protected static CLogger logger = CLogger.getCLogger(FilterUtil.class);

	/**
	 * This takes in a filter JSON model generated and converts it into an appropriate WHERE clause to pass to the DB.
	 * The filter JSON roughly follows the structure of the MongoDB API. To read about the MongoDB API, go here:
	 * https://docs.mongodb.com/manual/reference/operator/query/
	 * <p>
	 * The expected JSON, which is an expression, has the following structure (each property is optional):
	 * <pre>
	 * {
	 * 	"$and": [array of expressions],
	 * 	"$not": [array of expressions],
	 * 	"$or": [array of expressions],
	 * 	"$nor": [array of expressions],
	 * 	...any other comparison expression statements
	 * }
	 * </pre>
	 * The comparison expression statements are expected to have the following structure (each property is optional):
	 * <pre>
	 * {
	 * 	"[table mapped by foreign key]": expression -or-
	 * 	"[database column]": filter value (treated as equality comparison) -or-
	 * 	"[database column]": {
	 * 		"$eq": equality comparison filter value
	 * 		"$neq": inequality comparison filter value
	 * 		"$gt": greater than comparison filter value
	 * 		"$gte": greater than or equal to comparison filter value
	 * 		"$lt": less than comparison filter value
	 * 		"$lte": less than or equal to comparison filter value
	 * 		"$in": multiple equality comparison filter value
	 * 		"$nin": multiple inequality comparison filter value
	 * 		"$text": text search filter value
	 * 		"$ntext": text exclusion filter value
	 * 		"$null": column is null filter value
	 * 		"$nnull": column is not null filter value
	 *  }
	 * }
	 * </pre>
	 * Additionally, tables mapped by foreign keys can also leverage aggregate expression functions:
	 * <pre>
	 * {
	 * 	"$sum([database column])": expression
	 * 	"$count([database column])": expression
	 * 	"$max([database column])": expression
	 * 	"$min([database column])": expression
	 * }
	 * </pre>
	 * NOTE: ID columns (i.e. ones that end in _ID) are not allowed to be filtered and will be skipped
	 *
	 * @param tableName           The name of the table to query
	 * @param filterJson          The JSON string received for filtering
	 * @param parameters          An array of parameters to add values to
	 * @param entityConfiguration Entity configuration properties
	 *                            (can boost performance)
	 * @return A where clause based off the filter criteria to use in a DB query
	 */
	public static String getWhereClauseFromFilter(String tableName, String filterJson, List<Object> parameters,
			EntityConfiguration entityConfiguration) {
		return getWhereClauseFromFilter(new FilterTableData(tableName), filterJson, parameters, entityConfiguration);
	}


	/**
	 * This takes in a filter JSON model generated and converts it into an appropriate WHERE clause to pass to the DB.
	 * The filter JSON roughly follows the structure of the MongoDB API. To read about the MongoDB API, go here:
	 * https://docs.mongodb.com/manual/reference/operator/query/
	 * <p>
	 * The expected JSON, which is an expression, has the following structure (each property is optional):
	 * <pre>
	 * {
	 * 	"$and": [array of expressions],
	 * 	"$not": [array of expressions],
	 * 	"$or": [array of expressions],
	 * 	"$nor": [array of expressions],
	 * 	...any other comparison expression statements
	 * }
	 * </pre>
	 * The comparison expression statements are expected to have the following structure (each property is optional):
	 * <pre>
	 * {
	 * 	"[table mapped by foreign key]": expression -or-
	 * 	"[database column]": filter value (treated as equality comparison) -or-
	 * 	"[database column]": {
	 * 		"$eq": equality comparison filter value
	 * 		"$neq": inequality comparison filter value
	 * 		"$gt": greater than comparison filter value
	 * 		"$gte": greater than or equal to comparison filter value
	 * 		"$lt": less than comparison filter value
	 * 		"$lte": less than or equal to comparison filter value
	 * 		"$in": multiple equality comparison filter value
	 * 		"$nin": multiple inequality comparison filter value
	 * 		"$text": text search filter value
	 * 		"$ntext": text exclusion filter value
	 * 		"$null": column is null filter value
	 * 		"$nnull": column is not null filter value
	 *  }
	 * }
	 * </pre>
	 * Additionally, tables mapped by foreign keys can also leverage aggregate expression functions:
	 * <pre>
	 * {
	 * 	"$sum([database column])": expression
	 * 	"$count([database column])": expression
	 * 	"$max([database column])": expression
	 * 	"$min([database column])": expression
	 * }
	 * </pre>
	 * NOTE: ID columns (i.e. ones that end in _ID) are not allowed to be filtered and will be skipped
	 *
	 * @param tableData           The information of the table to query
	 * @param filterJson          The JSON string received for filtering
	 * @param parameters          An array of parameters to add values to
	 * @param entityConfiguration Entity configuration properties
	 *                            (can boost performance)
	 * @return A where clause based off the filter criteria to use in a DB query
	 */
	public static String getWhereClauseFromFilter(FilterTableData tableData, String filterJson, List<Object> parameters,
			EntityConfiguration entityConfiguration) {
		if (entityConfiguration == null) {
			throw new AdempiereException("No entity configuration was passed");
		}
		if (StringUtil.isNullOrEmpty(filterJson)) {
			return DEFAULT_WHERE_CLAUSE;
		}
		try {
			// Parse the JSON string
			Map<String, Object> expression = parseJsonString(filterJson);

			// Starting off, we don't want any negation, and the base filter JSON object is an expression
			String whereClause =
					getWhereClauseFromExpression(tableData, expression, parameters, false, entityConfiguration);
			if (whereClause.isEmpty()) {
				return DEFAULT_WHERE_CLAUSE;
			}
			return whereClause;
		} catch (Exception e) {
			throw new AdempiereException(MALFORMED_FILTER_STRING_ERROR);
		}
	}

	/**
	 * Parse the filter string into an object
	 *
	 * @param filterJson The JSON string received for filtering
	 * @return The filter expressions
	 * @throws JsonProcessingException
	 * @throws JsonMappingException
	 */
	private static Map<String, Object> parseJsonString(String filterJson) throws JsonMappingException,
			JsonProcessingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(filterJson, HashMap.class);
	}

	/**
	 * This can be called recursively. It handles an expression with logical and comparison query selectors
	 * and calls the appropriate methods to handle these expressions.
	 *
	 * @param tableData           The information of the table to query
	 * @param expression          The JSON string received for filtering
	 * @param parameters          An array of parameters to add values to
	 * @param negate              Whether the logic should be negated
	 * @param entityConfiguration Entity configuration properties
	 *                            (can boost performance)
	 * @return A where clause based off the filter criteria to use in a DB query
	 */
	private static String getWhereClauseFromExpression(FilterTableData tableData, Map<String, Object> expression,
			List<Object> parameters, boolean negate, EntityConfiguration entityConfiguration) {
		StringBuilder whereClause = new StringBuilder("(");

		boolean canPrependSeparator = false;
		// Query selectors in an expression are always joined via AND
		String separator = " AND ";
		// First check the arrays of properties ($and, $not, $or, $nor)
		for (String logicalQuerySelector : expression.keySet()) {
			if (!LOGICAL_QUERY_SELECTORS.contains(logicalQuerySelector)) {
				continue;
			}
			whereClause.append(canPrependSeparator ? separator : "");
			String expressionListWhereClause = "";
			switch (logicalQuerySelector) {
				case "$and":
					expressionListWhereClause = getWhereClauseFromExpressionList(
							tableData, (List<?>) expression.get(logicalQuerySelector), parameters, FilterArrayJoin.AND, negate,
							entityConfiguration);
					break;
				case "$not":
					// $not flips the sign of the negation
					expressionListWhereClause = getWhereClauseFromExpressionList(
							tableData, (List<?>) expression.get(logicalQuerySelector), parameters, FilterArrayJoin.AND, !negate,
							entityConfiguration);
					break;
				case "$or":
					expressionListWhereClause = getWhereClauseFromExpressionList(
							tableData, (List<?>) expression.get(logicalQuerySelector), parameters, FilterArrayJoin.OR, negate,
							entityConfiguration);
					break;
				case "$nor":
					// $nor flips the sign of the negation
					expressionListWhereClause = getWhereClauseFromExpressionList(
							tableData, (List<?>) expression.get(logicalQuerySelector), parameters, FilterArrayJoin.OR, !negate,
							entityConfiguration);
					break;
				default:
					logger.warning("Unknown array filter property: " + logicalQuerySelector + ", skipping...");
					break;
			}
			// If an empty where clause was returned for this array property, don't do anything
			if (expressionListWhereClause.isEmpty()) {
				continue;
			}
			whereClause.append(expressionListWhereClause);
			canPrependSeparator = true;
		}
		// Finally, check to see if there were any comparisons passed outside of the array comparisons
		Map<String, Object> comparisonQuerySelectors = expression.entrySet().stream()
				.filter(property -> !LOGICAL_QUERY_SELECTORS.contains(property.getKey()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		if (comparisonQuerySelectors.keySet().size() > 0) {
			String comparisonsExpressionWhereClause =
					getWhereClauseFromComparisonQuerySelectors(tableData, comparisonQuerySelectors, parameters, negate,
							entityConfiguration);
			// Only add this where clause if something was returned from the db column comparisons
			if (!comparisonsExpressionWhereClause.isEmpty()) {
				whereClause.append(canPrependSeparator ? separator : "");
				whereClause.append(comparisonsExpressionWhereClause);
			}
		}

		// If we've only added the first statement, just return an empty string
		// (i.e. there was no filter data in the object)
		if (whereClause.length() == 1) {
			return "";
		}
		whereClause.append(")");
		return whereClause.toString();
	}

	/**
	 * This creates the appropriate subclauses for the logical query selectors
	 *
	 * @param tableData      The information of the table to query
	 * @param expresionsList The array of comparisons to parse
	 * @param parameters     An array of parameters to add values to
	 * @param arrayJoin      The type of join to use (i.e. AND/OR)
	 * @param negate         Whether the logic should be negated
	 * @return A where clause based off the array of comparisons to use in a DB query
	 */
	private static String getWhereClauseFromExpressionList(FilterTableData tableData, List<?> expresionsList,
			List<Object> parameters, FilterArrayJoin arrayJoin, boolean negate, EntityConfiguration entityConfiguration) {
		StringBuilder whereClause = new StringBuilder("(");
		boolean canPrependSeparator = false;
		String separator;
		// The arrays are typically joined via AND conditions. However, logic negations changes the condition
		// (i.e. A&B negates to !A|!B and A|B negates to !A&!B)
		if (arrayJoin == FilterArrayJoin.AND) {
			separator = negate ? " OR " : " AND ";
		} else {
			separator = negate ? " AND " : " OR ";
		}
		// For each of the comparisons, create an appropriate where subclause
		for (Object expression : expresionsList) {
			String expressionWhereClause =
					getWhereClauseFromExpression(tableData, (Map<String, Object>) expression, parameters, negate,
							entityConfiguration);
			if (!expressionWhereClause.isEmpty()) {
				whereClause.append(canPrependSeparator ? separator : "").append(expressionWhereClause);
				canPrependSeparator = true;
			}
		}
		// If we've only added the first statement, just return an empty string
		// (i.e. there was no filter data in the object)
		if (whereClause.length() == 1) {
			return "";
		}
		return whereClause.append(")").toString();
	}

	/**
	 * Generate the where clauses from comparison query selectors.
	 *
	 * @param tableData                The information of the table to query
	 * @param comparisonQuerySelectors The comparisons to parse for the DB columns
	 * @param parameters               An array of parameters to add values to
	 * @param negate                   Whether the logic should be negated
	 * @return The where clause generated from the comparisons
	 */
	private static String getWhereClauseFromComparisonQuerySelectors(FilterTableData tableData,
			Map<String, Object> comparisonQuerySelectors, List<Object> parameters, boolean negate,
			EntityConfiguration entityConfiguration) {
		StringBuilder whereClause = new StringBuilder("(");
		boolean canPrependSeparator = false;
		String separator = negate ? " OR " : " AND ";
		// The keys of the comparison object are DB column names
		for (String dbColumnName : comparisonQuerySelectors.keySet()) {
			boolean isFilteringOnIdColumn = dbColumnName.toLowerCase().endsWith("_id");
			Object comparisons = comparisonQuerySelectors.get(dbColumnName);

			// If the column doesn't exist on this table as specified (or it does, but it's supposed to be mapped to another
			// table), we need to follow a different workflow
			if (!tableData.doesTableHaveColumn(dbColumnName) ||
					specialForeignKeyMappings.containsKey(dbColumnName.toLowerCase())) {
				String subWhereClause =
						getForeignTableSubQueryWhereClause(tableData, dbColumnName, (Map<String, Object>) comparisons, parameters,
								negate, entityConfiguration);
				if (!subWhereClause.isEmpty()) {
					whereClause.append(canPrependSeparator ? separator : "").append(subWhereClause);
					canPrependSeparator = true;
				}
				continue;
			}

			// Try to see if this property should be a date
			boolean dbColumnIsDateType = false;
			if (tableData.doesTableHaveColumn(dbColumnName)) {
				dbColumnIsDateType = tableData.getColumnClass(dbColumnName) == Timestamp.class;
			}
			// As a last precaution, check if the name has "date" in it (and it's not an ID column)
			else if (dbColumnName.toLowerCase().contains("date") && !isFilteringOnIdColumn) {
				dbColumnIsDateType = true;
			}

			// Alias the column name (in case there are any joins outside this clause)
			dbColumnName = tableData.getTableOrFunctionName() + "." + dbColumnName;

			// If this isn't a hashmap for this property, assume it's an $eq
			if (!(comparisons instanceof HashMap)) {
				// However, if it's an ID, we're done
				if (isFilteringOnIdColumn) {
					continue;
				}
				// If this is a date, go ahead and convert the value to be as such
				if (dbColumnIsDateType) {
					comparisons = DateUtil.getTimestamp(comparisons.toString());
				}
				handleEqualityComparison(dbColumnName, whereClause, parameters, separator, negate, canPrependSeparator,
						comparisons, dbColumnIsDateType);
				canPrependSeparator = true;
				continue;
			}
			Map<String, Object> comparisonMap = (Map<String, Object>) comparisons;
			for (String comparison : comparisonMap.keySet()) {
				// We're only going to allow filtering on an ID if it's a $null comparison
				if (isFilteringOnIdColumn && !comparison.equals("$null")) {
					continue;
				}
				whereClause.append(canPrependSeparator ? separator : "");
				Object filterValue = comparisonMap.get(comparison);
				// If this is a date, go ahead and convert the value to be as such
				// (but not if this is a $null or $nnull comparison where the filter
				// value isn't used)
				if (dbColumnIsDateType && !comparison.equals("$null") && !comparison.equals("$nnull")) {
					filterValue = DateUtil.getTimestamp(filterValue.toString());
				}
				List<?> listOperatorValues;
				String parameterClause;
				switch (comparison) {
					case "$eq":
						// We don't want to prepend a separator because that logic is already handled above
						handleEqualityComparison(dbColumnName, whereClause, parameters, separator, negate,
								false, filterValue, dbColumnIsDateType);
						break;
					case "$neq":
						// We don't want to prepend a separator because that logic is already handled above
						handleEqualityComparison(dbColumnName, whereClause, parameters, separator, !negate,
								false, filterValue, dbColumnIsDateType);
						break;
					case "$gt":
						whereClause.append(dbColumnName);
						// For dates, we have to be careful of time zones, so adjust the logic
						if (dbColumnIsDateType) {
							// Increase the day value so all times for the date are excluded
							filterValue = DateUtil.getTheNextDay((Timestamp) filterValue);
							whereClause.append(negate ? "<" : ">=").append("?");
						} else {
							whereClause.append(negate ? "<=" : ">").append("?");
						}
						parameters.add(filterValue);
						break;
					case "$gte":
						whereClause.append(dbColumnName).append(negate ? "<" : ">=").append("?");
						parameters.add(filterValue);
						break;
					case "$lt":
						whereClause.append(dbColumnName).append(negate ? ">=" : "<").append("?");
						parameters.add(filterValue);
						break;
					case "$lte":
						whereClause.append(dbColumnName);
						// For dates, we have to be careful of time zones, so adjust the logic
						if (dbColumnIsDateType) {
							// Increase the day value so all times for the date are included
							filterValue = DateUtil.getTheNextDay((Timestamp) filterValue);
							whereClause.append(negate ? ">=" : "<").append("?");
						} else {
							whereClause.append(negate ? ">" : "<=").append("?");
						}
						parameters.add(filterValue);
						break;
					case "$in":
						listOperatorValues = (List<?>) filterValue;
						parameterClause = "?,".repeat(listOperatorValues.size());
						whereClause.append(dbColumnName).append(negate ? " NOT " : " ").append("IN (")
								.append(parameterClause, 0, parameterClause.length() - 1).append(")");
						parameters.addAll(listOperatorValues);
						break;
					case "$nin":
						listOperatorValues = (List<?>) filterValue;
						parameterClause = "?,".repeat(listOperatorValues.size());
						whereClause.append(dbColumnName).append(negate ? " " : " NOT ").append("IN (")
								.append(parameterClause, 0, parameterClause.length() - 1).append(")");
						parameters.addAll(listOperatorValues);
						break;
					case "$text":
						whereClause.append("LOWER(").append(dbColumnName).append(")").append(negate ? " NOT " : " ")
								.append("LIKE '%").append(filterValue.toString().toLowerCase()).append("%'");
						break;
					case "$ntext":
						whereClause.append("LOWER(").append(dbColumnName).append(")").append(negate ? " " : " NOT ")
								.append("LIKE '%").append(filterValue.toString().toLowerCase()).append("%'");
						break;
					case "$null":
						whereClause.append(dbColumnName).append(" IS").append(negate ? " NOT " : " ").append("NULL");
						break;
					case "$nnull":
						whereClause.append(dbColumnName).append(" IS").append(negate ? " " : " NOT ").append("NULL");
						break;
					default:
						logger.warning("Unknown comparison: " + comparison + ", skipping...");
						continue;
				}
				canPrependSeparator = true;
			}
		}
		// If we've only added the first statement, just return an empty string
		// (i.e. there was no filter data in the object)
		if (whereClause.length() == 1) {
			return "";
		}
		return whereClause.append(")").toString();
	}

	/**
	 * Try to construct a sub query by connecting the filter criteria to a foreign table and filtering based on that
	 *
	 * @param tableData                The information of the current table being search
	 * @param dbColumnName             The column that wasn't found on the original table
	 * @param comparisonQuerySelectors Any comparisons that are meant to apply to this column
	 * @param parameters               An array of parameters to add values to
	 * @param negate                   Whether the logic should be negated
	 * @param entityConfiguration      Entity configuration properties
	 *                                 (can boost performance)
	 * @return The constructed where clause if values matched, or an empty string if nothing found matching
	 */
	private static String getForeignTableSubQueryWhereClause(FilterTableData tableData,
			String dbColumnName, Map<String, Object> comparisonQuerySelectors, List<Object> parameters, boolean negate,
			EntityConfiguration entityConfiguration) {
		StringBuilder whereClause = new StringBuilder();

		String foreignTableName = dbColumnName;
		String remainingDBColumnName = null;
		String specificColumnToMapOn = null;
		boolean shouldUseContextClientId = entityConfiguration.isShouldUseContextClientId();
		boolean shouldFetchFromSystemClient = entityConfiguration.isShouldFetchFromSystemClient();

		// If this is an aliased value, get the alias
		if (doesTableAliasExistOnColumn(dbColumnName)) {
			foreignTableName = dbColumnName.split("\\.")[0];
			// There may be subsequent aliases, so only remove the first one (i.e. c_orderline.m_product.m_storageonhand)
			remainingDBColumnName = dbColumnName.replaceFirst(foreignTableName + "\\.", "");
		}

		// If a specific column was passed in, get it
		if (foreignTableName.contains(SPECIFIC_COLUMN_MAPPING_SPECIFIER)) {
			foreignTableName = dbColumnName.split(SPECIFIC_COLUMN_MAPPING_SPECIFIER)[0];
			// There "should" only be one column specification, so we'll use it
			specificColumnToMapOn = dbColumnName.split(SPECIFIC_COLUMN_MAPPING_SPECIFIER)[1];
			// If there's still an "alias", we need to set that as the remaining DB column name
			if (doesTableAliasExistOnColumn(specificColumnToMapOn)) {
				String unchangedSpecificColumnToMapOn = specificColumnToMapOn;
				specificColumnToMapOn = unchangedSpecificColumnToMapOn.split("\\.")[0];
				// There may be subsequent aliases, so only remove the first one (i.e. c_orderline.m_product.m_storageonhand)
				remainingDBColumnName = unchangedSpecificColumnToMapOn.replaceFirst(specificColumnToMapOn + "\\.", "");
			}
		}

		// Ensure foreign table is lower case
		foreignTableName = foreignTableName.toLowerCase();
		// This should remain null unless we're doing a mapping and no specific column was given
		String originalForeignTableName = null;
		if (specialForeignKeyMappings.containsKey(foreignTableName) && StringUtil.isNullOrEmpty(specificColumnToMapOn)) {
			originalForeignTableName = foreignTableName;
			foreignTableName = specialForeignKeyMappings.get(foreignTableName);
		}

		// If the foreign table equals the current table we're on and there was no special mapping, just remove it and
		// start restart the construction
		if (foreignTableName.equalsIgnoreCase(tableData.getTableOrFunctionName()) && originalForeignTableName == null) {
			// Reconstruct the comparison using the new "key"
			String finalRemainingDBColumnName = remainingDBColumnName;
			Map<String, Object> adjustedComparisons = new HashMap<>() {
				{
					put(finalRemainingDBColumnName, comparisonQuerySelectors);
				}
			};
			String subWhereClause =
					getWhereClauseFromExpression(tableData, adjustedComparisons, parameters, negate, entityConfiguration);
			if (!subWhereClause.isEmpty()) {
				whereClause.append(subWhereClause);
			}
		} else {
			TableMapping tableMapping =
					getIdColumnNamesBetweenTables(tableData, foreignTableName, originalForeignTableName, specificColumnToMapOn);
			if (!tableMapping.wasMatchFound) {
				// No idea what this column is, so log it as an issue and skip
				logger.warning(
						"Column name " + dbColumnName + " does not exist on table " + tableData.getTableOrFunctionName());
			} else {
				String idColumn = tableMapping.sourceColumnName;
				String foreignIdColumn = tableMapping.foreignColumnName;
				// We have a match! Begin constructing the sub-query
				whereClause.append(tableData.getTableOrFunctionName()).append(".").append(idColumn).append(negate ? " NOT" :
						"").append(" IN " + "(SELECT ").append(foreignIdColumn).append(" FROM ");
				// Sub-clauses should never be negated (i.e. so we don't have not in (... not in (... not in (...))) but
				// instead of not in (... in (... in (...))))
				negate = false;
				// If we have an aggregate on the comparisons, this will need to be a sub-table with an alias
				Map<String, Object> aggregateComparisons = comparisonQuerySelectors.entrySet().stream().filter(
								comparisonQuerySelector -> AGGREGATE_QUERY_SELECTORS.stream().anyMatch(
										aggregateQuerySelector -> comparisonQuerySelector.getKey().startsWith(aggregateQuerySelector)))
						.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
				boolean doesTableNeedAggregation = aggregateComparisons.size() > 0;
				if (doesTableNeedAggregation) {
					whereClause.append("(");
					for (String aggregateFunction : aggregateComparisons.keySet()) {
						String aggregateColumnName = aggregateFunction.split("\\(")[1].replace(")", "");
						whereClause.append("SELECT ").append(idColumn).append(", ").append(aggregateFunction.replace("$", ""))
								.append(" as ").append(aggregateColumnName);
						// Add the client id to be returned, if it's required
						if (shouldUseContextClientId || shouldFetchFromSystemClient) {
							whereClause.append(",ad_client_id");
						}
						whereClause.append(" FROM ").append(foreignTableName).append(" WHERE (");
						if (comparisonQuerySelectors.get(aggregateFunction) == null ||
								((Map<String, Object>) comparisonQuerySelectors.get(aggregateFunction)).isEmpty()) {
							whereClause.append(DEFAULT_WHERE_CLAUSE);
						} else {
							String subWhereClause = getWhereClauseFromExpression(new FilterTableData(foreignTableName),
									(Map<String, Object>) comparisonQuerySelectors.get(aggregateFunction), parameters, false,
									entityConfiguration);
							if (subWhereClause.isEmpty()) {
								whereClause.append(DEFAULT_WHERE_CLAUSE);
							} else {
								whereClause.append(subWhereClause);
							}
						}
						// Add the client check, if it's required
						if (shouldUseContextClientId || shouldFetchFromSystemClient) {
							whereClause.append(") AND (ad_client_id");
							if (shouldUseContextClientId && shouldFetchFromSystemClient) {
								whereClause.append(" IN (?,?)");
								parameters.add(Env.getAD_Client_ID(Env.getCtx()));
								parameters.add(MClient_BH.CLIENTID_SYSTEM);
							} else {
								whereClause.append("=?");
								if (shouldUseContextClientId) {
									parameters.add(Env.getAD_Client_ID(Env.getCtx()));
								} else {
									parameters.add(MClient_BH.CLIENTID_SYSTEM);
								}
							}
						}
						// Append the group by clause, since it's an aggregate
						whereClause.append(") GROUP BY ").append(idColumn);
						// Add the client to the group by, if it's required
						if (shouldUseContextClientId || shouldFetchFromSystemClient) {
							whereClause.append(",ad_client_id");
						}
					}
					whereClause.append(") ");
				}
				whereClause.append(foreignTableName).append(" WHERE (");
				// Adjust the comparison string, if need be
				Map<String, Object> adjustedComparisons = comparisonQuerySelectors;
				if (remainingDBColumnName != null) {
					String finalRemainingDBColumnName = remainingDBColumnName;
					adjustedComparisons = new HashMap<>() {
						{
							put(finalRemainingDBColumnName, comparisonQuerySelectors);
						}
					};
				}
				// Continue the operation, but use the foreign table from this point forward
				String subWhereClause =
						getWhereClauseFromExpression(new FilterTableData(foreignTableName), adjustedComparisons, parameters,
								negate,
								entityConfiguration);
				if (subWhereClause.isEmpty()) {
					whereClause.append(DEFAULT_WHERE_CLAUSE);
				} else {
					whereClause.append(subWhereClause);
				}
				// Add the client check, if it's required
				if (shouldUseContextClientId || shouldFetchFromSystemClient) {
					whereClause.append(") AND (ad_client_id");
					if (shouldUseContextClientId && shouldFetchFromSystemClient) {
						whereClause.append(" IN (?,?)");
						parameters.add(Env.getAD_Client_ID(Env.getCtx()));
						parameters.add(MClient_BH.CLIENTID_SYSTEM);
					} else {
						whereClause.append("=?");
						if (shouldUseContextClientId) {
							parameters.add(Env.getAD_Client_ID(Env.getCtx()));
						} else {
							parameters.add(MClient_BH.CLIENTID_SYSTEM);
						}
					}
				}

				whereClause.append("))");
			}
		}
		return whereClause.toString();
	}

	/**
	 * To avoid duplicating $eq logic, it was moved to this function. This function adds the appropriate information
	 * to the where clause and the parameters based on the filter information passed in.
	 *
	 * @param property            The property to filter on
	 * @param whereClause         The current where clause
	 * @param parameters          The current parameter list
	 * @param separator           The separator to use between subclauses in the where clause
	 * @param negate              Whether the operation should be negated
	 * @param canPrependSeparator Whether the subclause is preceded by a subclause and the separator should be prepended
	 * @param filterValue         The value to filter by
	 * @param dbColumnIsDateType  Whether the model property is a date (used to write the subclause appropriately)
	 */
	private static void handleEqualityComparison(
			String property, StringBuilder whereClause, List<Object> parameters, String separator, boolean negate,
			boolean canPrependSeparator, Object filterValue, boolean dbColumnIsDateType) {
		if (dbColumnIsDateType) {
			Timestamp startDate = (Timestamp) filterValue;
			Timestamp endDate = DateUtil.getTheNextDay(startDate);
			whereClause.append(canPrependSeparator ? separator : "").append("(").append(property)
					.append(negate ? "<" : ">=").append("?").append(negate ? " OR " : " AND ").append(property)
					.append(negate ? ">=" : "<").append("?)");
			parameters.add(startDate);
			parameters.add(endDate);
		} else {
			whereClause.append(canPrependSeparator ? separator : "").append(property)
					.append(negate ? "!" : "").append("=?");
			parameters.add(filterValue);
		}
	}

	/**
	 * Check to see if the table alias already exists on the column (aka Table_Name.ColumnName vs just ColumnName)
	 *
	 * @param dbColumn The dbColumn string to check
	 * @return Whether a table alias is present on the dbColumn
	 */
	private static boolean doesTableAliasExistOnColumn(String dbColumn) {
		return dbColumn.contains(".");
	}

	/**
	 * This does all the specific mapping of trying to transform the requested column into the appropriate tables and
	 * ID mappings between those tables
	 *
	 * @param tableData                The information of the table to query
	 * @param mappedForeignTableName   The name of the mapped table
	 * @param unmappedForeignTableName The original string that was passed in to map to (may contain column
	 *                                 specifications). Should be null if it wasn't mapped.
	 * @param specifiedColumnMapping   A specific column to map on, if any. Should be null if none provided
	 * @return An object containing the matches, if any were found
	 */
	private static TableMapping getIdColumnNamesBetweenTables(FilterTableData tableData, String mappedForeignTableName,
			String unmappedForeignTableName, String specifiedColumnMapping) {
		TableMapping tableMapping = new TableMapping();
		// If the mapped and unmapped are the same, there's an error somewhere and we shouldn't do anything (because the
		// unmapped should remain null unless there has been a mapping, in which case they'd be different)
		if (unmappedForeignTableName != null && unmappedForeignTableName.equalsIgnoreCase(mappedForeignTableName)) {
			return tableMapping;
		}

		FilterTableData foreignTableData = new FilterTableData(mappedForeignTableName);
		if (foreignTableData.getPoInfo() == null) {
			return tableMapping;
		}

		// Initialize the ID columns (though we have to check some other things first)
		String tableIdColumn = tableData.getTableOrFunctionName() + "_id";
		String foreignTableIdColumn = mappedForeignTableName + "_id";

		// If we're doing a mapping, we need to check some stuff before we get to the "simplest" case
		if (unmappedForeignTableName != null) {
			// We'll start by seeing if original foreign table specified exists as-is on the source table
			// (i.e. c_invoice.createdby -> createdby should be mapped to ad_user [via column ad_user_id, which would be
			// assigned already above] and use createdby on the c_invoice table)
			if (tableData.doesTableHaveColumn(unmappedForeignTableName)) {
				tableMapping.sourceColumnName = unmappedForeignTableName;

				// Now we need to confirm the foreign table column
				if (foreignTableData.doesTableHaveColumn(foreignTableIdColumn)) {
					tableMapping.wasMatchFound = true;
					tableMapping.foreignColumnName = foreignTableIdColumn;
				}

				return tableMapping;
			}
			// There could be a case where a table self-references itself, such as the reversal_id column from c_payment, so
			// try some new checks
			tableIdColumn = unmappedForeignTableName + "_id";
			if (tableData.doesTableHaveColumn(tableIdColumn)) {
				tableMapping.sourceColumnName = tableIdColumn;

				// Now find which column exists on the foreign table
				if (foreignTableData.doesTableHaveColumn(foreignTableIdColumn)) {
					tableMapping.wasMatchFound = true;
					tableMapping.foreignColumnName = foreignTableIdColumn;
				}
				// Not sure what others to check, at the moment

				return tableMapping;
			}
		}

		// If we were passed a specific column mapping, try it
		if (specifiedColumnMapping != null) {
			// Check if that exists on the foreign table
			// Otherwise, see if it's on the current table and the other table has the foreign ID column
			// TODO: Support specifying both start and end columns instead of one or the other
			if (foreignTableData.doesTableHaveColumn(specifiedColumnMapping)) {
				tableMapping.foreignColumnName = specifiedColumnMapping;
				// We'll assume it joins off this table's ID column, if it has one
				if (tableData.doesTableHaveColumn(tableIdColumn)) {
					tableMapping.wasMatchFound = true;
					tableMapping.sourceColumnName = tableIdColumn;
				}

				return tableMapping;
			} else if (tableData.doesTableHaveColumn(specifiedColumnMapping)) {
				tableMapping.sourceColumnName = specifiedColumnMapping;
				// We'll assume it joins to the foreign table's ID column, if it has one
				if (foreignTableData.doesTableHaveColumn(foreignTableIdColumn)) {
					tableMapping.wasMatchFound = true;
					tableMapping.foreignColumnName = foreignTableIdColumn;
				}

				return tableMapping;
			}
		}

		// The simplest form is that either table name, appended with "_id", exists on both tables
		if (tableData.doesTableHaveColumn(tableIdColumn) && foreignTableData.doesTableHaveColumn(tableIdColumn)) {
			tableMapping.wasMatchFound = true;
			tableMapping.sourceColumnName = tableIdColumn;
			tableMapping.foreignColumnName = tableIdColumn;
			return tableMapping;
		} else if (tableData.doesTableHaveColumn(foreignTableIdColumn) &&
				foreignTableData.doesTableHaveColumn(foreignTableIdColumn)) {
			tableMapping.wasMatchFound = true;
			tableMapping.sourceColumnName = foreignTableIdColumn;
			tableMapping.foreignColumnName = foreignTableIdColumn;
			return tableMapping;
		}

		// If we get here, we didn't find any matches
		return new TableMapping();
	}

	static class TableMapping {
		boolean wasMatchFound = false;
		String sourceColumnName;
		String foreignColumnName;
	}
}
