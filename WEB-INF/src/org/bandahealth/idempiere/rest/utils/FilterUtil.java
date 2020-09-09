package org.bandahealth.idempiere.rest.utils;

import org.adempiere.exceptions.AdempiereException;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.compiere.model.PO;
import org.compiere.util.CLogger;

public class FilterUtil {
	public static final String DEFAULT_WHERE_CLAUSE = "";

	private static final List<String> LOGICAL_QUERY_SELECTORS = Arrays.asList("$and", "$not", "$or", "$nor");
	protected static CLogger logger = CLogger.getCLogger(FilterUtil.class);

	/**
	 * This takes in a filter JSON model generated and converts it into an appropriate WHERE clause to pass to the DB.
	 * The filter JSON roughly follows the structure of the MongoDB API. To read about the MongoDB API, go here:
	 * https://docs.mongodb.com/manual/reference/operator/query/
	 * <p>
	 * The expected JSON, which is an expression, has the following structure (each property is optional):
	 * {
	 * "$and": [array of expressions],
	 * "$not": [array of expressions],
	 * "$or": [array of expressions],
	 * "$nor": [array of expressions],
	 * ...any other comparison expression statements
	 * }
	 * The comparison expression statements are expected to have the following structure (each property is optional):
	 * {
	 * "[database column]": filter value (treated as equality comparison) -or-
	 * "[database column]": {
	 * "$eq": equality comparison filter value
	 * "$neq": inequality comparison filter value
	 * "$gt": greater than comparison filter value
	 * "$gte": greater than or equal to comparison filter value
	 * "$lt": less than comparison filter value
	 * "$lte": less than or equal to comparison filter value
	 * "$in": multiple equality comparison filter value
	 * "$nin": multiple inequality comparison filter value
	 * "$text": text search filter value
	 * "$ntext": text exclusion filter value
	 * "$null": column is null filter value
	 * "$nnull": column is not null filter value
	 * }
	 * }
	 * NOTE: ID columns (i.e. ones that end in _ID) are not allowed to be filtered and will be skipped
	 *
	 * @param dbModel    The iDempiere DB model for determining field types
	 * @param filterJson The JSON string received for filtering
	 * @param parameters An array of parameters to add values to
	 * @param <T>        An iDempiere model extending from PO
	 * @return A where clause based off the filter criteria to use in a DB query
	 */
	public static <T extends PO> String getWhereClauseFromFilter(
			T dbModel, String filterJson, List<Object> parameters) {
		if (StringUtil.isNullOrEmpty(filterJson)) {
			return DEFAULT_WHERE_CLAUSE;
		}
		try {
			// Parse the JSON string
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, Object> expression = objectMapper.readValue(filterJson, HashMap.class);

			// Starting off, we don't want any negation, and the base filter JSON object is an expression
			return getWhereClauseFromExpression(dbModel, expression, parameters, false);
		} catch (Exception e) {
			throw new AdempiereException("Filter criteria doesn't meet the standard form.");
		}
	}

	/**
	 * This can be called recursively. It handles an expression with logical and comparison query selectors
	 * and calls the appropriate methods to handle these expressions.
	 *
	 * @param dbModel    The iDempiere DB model for determining field types
	 * @param expression The JSON string received for filtering
	 * @param parameters An array of parameters to add values to
	 * @param negate     Whether the logic should be negated
	 * @param <T>        An iDempiere model extending from PO
	 * @return A where clause based off the filter criteria to use in a DB query
	 */
	private static <T extends PO> String getWhereClauseFromExpression(
			T dbModel, Map<String, Object> expression, List<Object> parameters, boolean negate) {
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
			String expressionListWhereClause = null;
			switch (logicalQuerySelector) {
				case "$and":
					expressionListWhereClause = getWhereClauseFromExpressionList(
							dbModel, (List<?>) expression.get(logicalQuerySelector), parameters, FilterArrayJoin.AND, negate);
					break;
				case "$not":
					// $not flips the sign of the negation
					expressionListWhereClause = getWhereClauseFromExpressionList(
							dbModel, (List<?>) expression.get(logicalQuerySelector), parameters, FilterArrayJoin.AND, !negate);
					break;
				case "$or":
					expressionListWhereClause = getWhereClauseFromExpressionList(
							dbModel, (List<?>) expression.get(logicalQuerySelector), parameters, FilterArrayJoin.OR, negate);
					break;
				case "$nor":
					// $nor flips the sign of the negation
					expressionListWhereClause = getWhereClauseFromExpressionList(
							dbModel, (List<?>) expression.get(logicalQuerySelector), parameters, FilterArrayJoin.OR, !negate);
					break;
				default:
					logger.warning("Unknown array filter property: " + logicalQuerySelector + ", skipping...");
					break;
			}
			// If the default where clause was returned for this array property, don't do anything
			if (expressionListWhereClause.equals(DEFAULT_WHERE_CLAUSE)) {
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
					getWhereClauseFromComparisonQuerySelectors(dbModel, comparisonQuerySelectors, parameters, negate);
			// Only add this where clause if something was returned from the db column comparisons
			if (!comparisonsExpressionWhereClause.equals(DEFAULT_WHERE_CLAUSE)) {
				whereClause.append(canPrependSeparator ? separator : "");
				whereClause.append(comparisonsExpressionWhereClause);
			}
		}

		// If we've only added the first statement, just return an empty string
		// (i.e. there was no filter data in the object)
		if (whereClause.length() == 1) {
			return DEFAULT_WHERE_CLAUSE;
		}
		whereClause.append(")");
		return whereClause.toString();
	}

	/**
	 * This creates the appropriate subclauses for the logical query selectors
	 *
	 * @param dbModel        The iDempiere DB model for determining field types
	 * @param expresionsList The array of comparisons to parse
	 * @param parameters     An array of parameters to add values to
	 * @param arrayJoin      The type of join to use (i.e. AND/OR)
	 * @param negate         Whether the logic should be negated
	 * @param <T>            An iDempiere model extending from PO
	 * @return A where clause based off the array of comparisons to use in a DB query
	 */
	private static <T extends PO> String getWhereClauseFromExpressionList(
			T dbModel, List<?> expresionsList, List<Object> parameters, FilterArrayJoin arrayJoin, boolean negate) {
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
					getWhereClauseFromExpression(dbModel, (Map<String, Object>) expression, parameters, negate);
			if (!expressionWhereClause.equals(DEFAULT_WHERE_CLAUSE)) {
				whereClause.append(canPrependSeparator ? separator : "").append(expressionWhereClause);
				canPrependSeparator = true;
			}
		}
		// If we've only added the first statement, just return an empty string
		// (i.e. there was no filter data in the object)
		if (whereClause.length() == 1) {
			return DEFAULT_WHERE_CLAUSE;
		}
		return whereClause.append(")").toString();
	}

	/**
	 * Generate the where clauses from comparison query selectors.
	 *
	 * @param dbModel                  The iDempiere DB model for determining field types
	 * @param comparisonQuerySelectors The comparisons to parse for the DB columns
	 * @param parameters               An array of parameters to add values to
	 * @param negate                   Whether the logic should be negated
	 * @param <T>                      An iDempiere model extending from PO
	 * @return The where clause generated from the comparisons
	 */
	private static <T extends PO> String getWhereClauseFromComparisonQuerySelectors(
			T dbModel, Map<String, Object> comparisonQuerySelectors, List<Object> parameters, boolean negate) {
		StringBuilder whereClause = new StringBuilder("(");
		boolean canPrependSeparator = false;
		String separator = negate ? " OR " : " AND ";
		// The keys of the comparison object are DB column names
		for (String dbColumnName : comparisonQuerySelectors.keySet()) {
			// We won't allow filtering of DB IDs
			if (dbColumnName.toLowerCase().endsWith("_id")) {
				continue;
			}
			Object comparisons = comparisonQuerySelectors.get(dbColumnName);

			// Try to see if this property should be a date
			boolean dbColumnIsDateType = false;
			try {
				Object columnValue = dbModel.get_Value(dbColumnName);
				dbColumnIsDateType = columnValue instanceof Timestamp;
			} catch (Exception ignored) {
			}

			// If this isn't a hashmap for this property, assume it's an $eq
			if (!(comparisons instanceof HashMap)) {
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
				whereClause.append(canPrependSeparator ? separator : "");
				Object filterValue = comparisonMap.get(comparison);
				// If this is a date, go ahead and convert the value to be as such
				if (dbColumnIsDateType) {
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
			return DEFAULT_WHERE_CLAUSE;
		}
		return whereClause.append(")").toString();
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

	enum FilterArrayJoin {
		AND,
		OR,
	}
}
