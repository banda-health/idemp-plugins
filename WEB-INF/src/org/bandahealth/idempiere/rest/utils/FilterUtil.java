package org.bandahealth.idempiere.rest.utils;

import org.adempiere.exceptions.AdempiereException;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.compiere.model.PO;
import org.compiere.util.CLogger;

public class FilterUtil {

	protected static CLogger logger = CLogger.getCLogger(FilterUtil.class);

	private static final List<String> comparisonArrayProperties = Arrays.asList("$and", "$not", "$or", "$nor");

	/**
	 * This takes in a filter JSON model generated and converts it into an appropriate WHERE clause to pass to the DB.
	 * The filter JSON follows the structure of the MongoDB API and has a subset of that functionality. To read about
	 * the MongoDB API, go here: https://docs.mongodb.com/manual/reference/operator/query/
	 *
	 * The expected JSON has the following structure (each property is optional):
	 * {
	 *   "$and": [array of database column comparison statements],
	 *   "$not": [array of database column comparison statements],
	 *   "$or": [array of database column comparison statements],
	 *   "$nor": [array of database column comparison statements],
	 *   ...any other comparison statements
	 * }
	 * The database column comparison statements are expected to have the following structure (each property is optional):
	 * {
	 *   "[database column]": filter value (treated as equality comparison) -or-
	 *   "[database column]": {
	 *     "$eq": equality comparison filter value
	 *     "$neq": inequality comparison filter value
	 *     "$gt": greater than comparison filter value
	 *     "$gte": greater than or equal to comparison filter value
	 *     "$lt": less than comparison filter value
	 *     "$lte": less than or equal to comparison filter value
	 *     "$in": multiple equality comparison filter value
	 *     "$nin": multiple inequality comparison filter value
	 *     "$text": text search filter value
	 *     "$ntext": text exclusion filter value
	 *     "$null": column is null filter value
	 *     "$nnull": column is not null filter value
	 *   }
	 * }
	 * NOTE: ID columns are not allowed to be filtered and will be skipped
	 * @param dbModel The iDempiere DB model for determining field types
	 * @param filterJson The JSON string received for filtering
	 * @param parameters An array of parameters to add values to
	 * @param <T> An iDempiere model extending from PO
	 * @return A where clause based off the filter criteria to use in a DB query
	 */
	public static <T extends PO> String getWhereClauseFromFilter(T dbModel, String filterJson, List<Object> parameters) {
		if (StringUtil.isNullOrEmpty(filterJson)) {
			return "";
		}
		// Start the where clause with a true assertion in case there are no filters
		StringBuilder whereClause = new StringBuilder("(");
		try {
			// Parse the JSON string
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, Object> filter = objectMapper.readValue(filterJson, HashMap.class);

			boolean canPrependSeparator = false;
			// First check the arrays of properties ($and, $not, $or, $nor)
			for (String key : filter.keySet()) {
				if (!comparisonArrayProperties.contains(key)) {
					continue;
				}
				whereClause.append(canPrependSeparator ? " AND " : "");
				switch (key) {
					case "$and" -> whereClause.append(getWhereClauseFromDBColumnComparisonsList(
							dbModel, (List<?>) filter.get(key), parameters, FilterArrayJoin.AND, false));
					case "$not" -> whereClause.append(getWhereClauseFromDBColumnComparisonsList(
							dbModel, (List<?>) filter.get(key), parameters, FilterArrayJoin.AND, true));
					case "$or" -> whereClause.append(getWhereClauseFromDBColumnComparisonsList(
							dbModel, (List<?>) filter.get(key), parameters, FilterArrayJoin.OR, false));
					case "$nor" -> whereClause.append(getWhereClauseFromDBColumnComparisonsList(
							dbModel, (List<?>) filter.get(key), parameters, FilterArrayJoin.OR, true));
					default -> logger.warning("Unknown array filter property: " + key + ", skipping...");
				}
				canPrependSeparator = true;
			}
			// Finally, check to see if there were any comparisons passed outside of the array comparisons
			Map<String, Object> filtersOutsideArrayComparisons = filter.entrySet().stream()
					.filter(property -> !comparisonArrayProperties.contains(property.getKey()))
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
			if (filtersOutsideArrayComparisons.keySet().size() > 0) {
				whereClause.append(canPrependSeparator ? " AND " : "");
				whereClause.append(
						getWhereClauseFromDBColumnComparisons(dbModel, filtersOutsideArrayComparisons, parameters, false));
			}
		} catch (Exception e) {
			throw new AdempiereException("Filter criteria doesn't meet the standard form.");
		}
		whereClause.append(")");
		return whereClause.toString();
	}

	/**
	 * This creates the appropriate subclauses when arrays of comparisons were passed in
	 * @param dbModel The iDempiere DB model for determining field types
	 * @param dbColumnComparisonsList The array of comparisons to parse
	 * @param parameters An array of parameters to add values to
	 * @param arrayJoin The type of join to use (i.e. AND/OR)
	 * @param negate Whether the logic should be negated
	 * @param <T> An iDempiere model extending from PO
	 * @return A where clause based off the array of comparisons to use in a DB query
	 */
	private static <T extends PO> String getWhereClauseFromDBColumnComparisonsList(
			T dbModel, List<?> dbColumnComparisonsList, List<Object> parameters, FilterArrayJoin arrayJoin, boolean negate) {
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
		for (Object dbColumnComparison : dbColumnComparisonsList) {
			whereClause.append(canPrependSeparator ? separator : "").append(
					getWhereClauseFromDBColumnComparisons(dbModel, (Map<String, Object>) dbColumnComparison, parameters, negate));
			canPrependSeparator = true;
		}
		return whereClause.append(")").toString();
	}

	/**
	 * Generate the where clauses from object properties. This is where logical operators are evaluated based on the
	 * filter information passed in.
	 * @param dbModel The iDempiere DB model for determining field types
	 * @param dbColumnComparisons The comparisons to parse for the DB columns
	 * @param parameters An array of parameters to add values to
	 * @param negate Whether the logic should be negated
	 * @param <T> An iDempiere model extending from PO
	 * @return The where clause generated from the comparisons
	 */
	private static <T extends PO> String getWhereClauseFromDBColumnComparisons(
			T dbModel, Map<String, Object> dbColumnComparisons, List<Object> parameters, boolean negate) {
		StringBuilder whereClause = new StringBuilder("(");
		boolean canPrependSeparator = false;
		String separator = negate ? " OR " : " AND ";
		// The keys of the comparison object are DB column names
		for (String dbColumnName : dbColumnComparisons.keySet()) {
			// We won't allow filtering of DB IDs
			if (dbColumnName.toLowerCase().endsWith("_id")) {
				continue;
			}
			Object comparisons = dbColumnComparisons.get(dbColumnName);

			// Try to see if this property should be a date
			boolean dbColumnIsDateType = false;
			Timestamp startDate = new Timestamp(Calendar.getInstance().getTimeInMillis());
			Timestamp endDate = new Timestamp(Calendar.getInstance().getTimeInMillis());
			try {
				Object columnValue = dbModel.get_Value(dbColumnName);
				dbColumnIsDateType = columnValue instanceof Timestamp;
				if (dbColumnIsDateType) {
					startDate = DateUtil.getTimestamp(comparisons.toString());
					endDate = DateUtil.getTheNextDay(startDate);
				}
			} catch (Exception ignored) {
			}

			// If this isn't a hashmap for this property, assume it's an $eq
			if (!(comparisons instanceof HashMap)) {
				Object filterValue = comparisons;
				handleEqualsAssignment(dbColumnName, whereClause, parameters, separator, negate, canPrependSeparator, filterValue,
						dbColumnIsDateType, startDate, endDate);
				canPrependSeparator = true;
				continue;
			}
			Map<String, Object> comparisonMap = (Map<String, Object>) comparisons;
			for (String comparison : comparisonMap.keySet()) {
				whereClause.append(canPrependSeparator ? separator : "");
				Object filterValue = comparisonMap.get(comparison);
				if (dbColumnIsDateType) {
					startDate = DateUtil.getTimestamp(filterValue.toString());
					endDate = DateUtil.getTheNextDay(startDate);
				}
				List<?> listOperatorValues;
				String parameterClause;
				switch (comparison) {
					case "$eq":
						handleEqualsAssignment(dbColumnName, whereClause, parameters, separator, negate, canPrependSeparator,
								filterValue, dbColumnIsDateType, startDate, endDate);
						break;
					case "$neq":
						if (dbColumnIsDateType) {
							whereClause.append(canPrependSeparator ? separator : "").append(dbColumnName)
									.append(negate ? " " : " NOT ").append("BETWEEN ? AND ?");
							parameters.add(startDate);
							parameters.add(endDate);
						} else {
							whereClause.append(dbColumnName).append(negate ? "" : "!").append("=?");
							parameters.add(filterValue);
						}
						break;
					case "$gt":
						whereClause.append(dbColumnName).append(negate ? "<=" : ">").append("?");
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
						whereClause.append(dbColumnName).append(negate ? ">" : "<=").append("?");
						parameters.add(filterValue);
						break;
					case "$in":
						listOperatorValues = (List<?>) filterValue;
						parameterClause = "?,".repeat(listOperatorValues.size());
						whereClause.append(dbColumnName).append(negate ? " NOT " : " ").append("IN (")
								.append(parameterClause.substring(0, parameterClause.length() - 1)).append(")");
						parameters.addAll(listOperatorValues);
						break;
					case "$nin":
						listOperatorValues = (List<?>) filterValue;
						parameterClause = "?,".repeat(listOperatorValues.size());
						whereClause.append(dbColumnName).append(negate ? " " : " NOT ").append("IN (")
								.append(parameterClause.substring(0, parameterClause.length() - 1)).append(")");
						parameters.addAll(listOperatorValues);
						break;
					case "$text":
						whereClause.append("LOWER(").append(dbColumnName).append(")").append(negate ? " NOT " : " ").append("LIKE '%")
								.append(filterValue).append("%'");
						break;
					case "$ntext":
						whereClause.append("LOWER(").append(dbColumnName).append(")").append(negate ? " " : " NOT ").append("LIKE '%")
								.append(filterValue).append("%'");
						break;
					case "$null":
						whereClause.append(dbColumnName).append(" IS").append(negate ? " NOT " : " ").append("NULL");
						break;
					case "$nnull":
						whereClause.append(dbColumnName).append(" IS").append(negate ? " " : " NOT ").append("NULL");
						break;
					default:
						logger.warning("Unknown comparison: " + comparison + ", skipping...");
						break;
				}
				canPrependSeparator = true;
			}
		}
		return whereClause.append(")").toString();
	}

	/**
	 * To avoid duplicating $eq logic, it was moved to this function. This function adds the appropriate information
	 * to the where clause and the parameters based on the filter information passed in.
	 * @param property The property to filter on
	 * @param whereClause The current where clause
	 * @param parameters The current parameter list
	 * @param separator The separator to use between subclauses in the where clause
	 * @param negate Whether the operation should be negated
	 * @param canPrependSeparator Whether the subclause is preceded by a subclause and the separator should be prepended
	 * @param filterValue The value to filter by
	 * @param dbColumnIsDateType Whether the model property is a date (used to write the subclause appropriately)
	 * @param startDate A Timestamp version of the value parameter
	 * @param endDate An end date to search between (since date equalities are actually BETWEENs)
	 */
	private static void handleEqualsAssignment(
			String property, StringBuilder whereClause, List<Object> parameters, String separator, boolean negate,
			boolean canPrependSeparator, Object filterValue, boolean dbColumnIsDateType, Timestamp startDate,
			Timestamp endDate) {
		if (dbColumnIsDateType) {
			whereClause.append(canPrependSeparator ? separator : "").append(property)
					.append(negate ? " NOT " : " ").append("BETWEEN ? AND ?");
			parameters.add(startDate);
			parameters.add(endDate);
		} else {
			whereClause.append(canPrependSeparator ? separator : "").append(property)
					.append(negate ? "!" : "").append("=?");
			parameters.add(filterValue);
		}
	}

	enum FilterArrayJoin {
		AND,
		OR,
	}
}
