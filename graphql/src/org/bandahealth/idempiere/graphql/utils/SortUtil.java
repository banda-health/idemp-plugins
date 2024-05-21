package org.bandahealth.idempiere.graphql.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.bandahealth.idempiere.graphql.utils.SqlUtil.IDEMPIERE_POSTGRESQL_NATIVE_MARKER;

public class SortUtil {
	private static final String MALFORMED_SORT_STRING_ERROR = "Sort criteria doesn't meet the standard form.";
	private static final List<String> EXPRESSION_FUNCTIONS = Arrays.asList("$date", "$time");

	/**
	 * Parse the sort string into an object
	 *
	 * @param sortJson The JSON string received for filtering
	 * @return The sorting expressions
	 * @throws IOException
	 */
	private static List<Object> parseJsonString(String sortJson) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(sortJson, ArrayList.class);
	}

	/**
	 * This takes in a sort JSON model generated and converts it into an appropriate ORDER BY clause to pass to the DB.
	 * <p>
	 * The expected JSON has the following structure (any of the following patterns can be combined in any order)
	 * <pre>
	 * [
	 *   database-column-or-expression-function
	 *   -OR-
	 *   [database-column-or-expression-function]
	 *   -OR-
	 *   [database-column-or-expression-function, sort-direction]
	 * ]
	 * </pre>
	 * The following expression functions can be leveraged on columns:
	 * <pre>
	 * {
	 * 	$date([database column])
	 * 	$time([database column])
	 * }
	 * </pre>
	 * </p>
	 *
	 * @param tableName The iDempiere table name for determining field types
	 * @param sortJson  The JSON string received for sorting
	 * @return An ORDER BY clause based off the sort criteria to use in a DB query
	 */
	public static String getOrderByClauseFromSort(String tableName, String sortJson) {
		String DEFAULT_ORDER_BY = tableName + "." + MUser.COLUMNNAME_Created + " DESC NULLS LAST";
		if (sortJson == null) {
			return DEFAULT_ORDER_BY;
		}
		try {
			// Parse the JSON string
			List<Object> listOfSortCriteria = parseJsonString(sortJson);
			if (listOfSortCriteria.isEmpty()) {
				return DEFAULT_ORDER_BY;
			}

			String orderBy = listOfSortCriteria.stream().map(sortCriteria -> {
				// If this is null or an empty array, skip
				if (sortCriteria == null || sortCriteria instanceof List<?> && ((List<?>) sortCriteria).isEmpty()) {
					return null;
				}
				String sortColumn;
				String sortDirection;
				// If this is just a string, add and sort by ASC
				if (sortCriteria instanceof String) {
					sortColumn = (String) sortCriteria;
					sortDirection = "ASC";
				} else {
					List<String> sortCriteriaColumnAndDirection = (List<String>) sortCriteria;
					sortColumn = sortCriteriaColumnAndDirection.get(0);
					sortDirection = "ASC";
					// If only one argument was specified,
					if (sortCriteriaColumnAndDirection.size() == 2) {
						sortDirection = sortCriteriaColumnAndDirection.get(1);
					}
				}
				// Check to see the sort column starts with any of the expression functions
				String finalSortColumn = sortColumn;
				String expressionFunctionToUse = "";
				if (EXPRESSION_FUNCTIONS.stream()
						.anyMatch(expressionFunction -> finalSortColumn.toLowerCase().startsWith(expressionFunction + "("))) {
					String[] splitColumn = sortColumn.split("\\(");
					expressionFunctionToUse = IDEMPIERE_POSTGRESQL_NATIVE_MARKER + splitColumn[0].replaceAll("\\$", "");
					sortColumn = splitColumn[1].replaceAll("\\)", "");
				}
				if (QueryUtil.doesDBStringHaveInvalidCharacters(sortColumn) ||
						QueryUtil.doesDBStringHaveInvalidCharacters(sortDirection)) {
					return null;
				}
				if (!QueryUtil.doesTableAliasExistOnColumn(sortColumn)) {
					sortColumn = tableName + "." + sortColumn;
				}
				if (!StringUtil.isNullOrEmpty(expressionFunctionToUse)) {
					sortColumn = expressionFunctionToUse + "(" + sortColumn + ")";
				}
				return sortColumn + " " + sortDirection + " NULLS LAST";
			}).filter(sortCriteria -> !StringUtil.isNullOrEmpty(sortCriteria)).collect(Collectors.joining(","));
			return orderBy.isEmpty() ? DEFAULT_ORDER_BY : orderBy;
		} catch (Exception e) {
			throw new AdempiereException(MALFORMED_SORT_STRING_ERROR);
		}
	}

	/**
	 * Parse through the field names and return a list of aliases.
	 *
	 * @param sortJson
	 * @return
	 */
	public static Set<String> getTablesNeedingJoins(String sortJson) {
		if (StringUtil.isNullOrEmpty(sortJson)) {
			return new HashSet<>();
		}
		try {
			List<Object> listOfSortCriteria = parseJsonString(sortJson);
			// Make sure to return the distinct list without duplicates
			return listOfSortCriteria.stream().flatMap(sortCriteria -> {
				// If this is null or an empty array, skip
				if (sortCriteria == null || sortCriteria instanceof List<?> && ((List<?>) sortCriteria).isEmpty()) {
					return null;
				}
				String sortColumn =
						sortCriteria instanceof String ? (String) sortCriteria : ((List<String>) sortCriteria).get(0);
				String finalSortColumn = sortColumn;
				if (EXPRESSION_FUNCTIONS.stream()
						.anyMatch(expressionFunction -> finalSortColumn.toLowerCase().startsWith(expressionFunction + "("))) {
					String[] splitColumn = sortColumn.split("\\(");
					sortColumn = splitColumn[1].replaceAll("\\)", "");
				}
				// First, split by the column delimiter
				String[] sortColumnSplits = sortColumn.split("\\.");
				if (sortColumnSplits.length == 0) {
					return null;
				}
				List<String> tablesNeedingJoins = new ArrayList<>();
				// We don't care about the last value, since that could never be a table name, so length - 1
				for (int i = 0; i < sortColumnSplits.length - 1; i++) {
					// Remove any operators that are still there
					String[] subSortCriteria = sortColumnSplits[i].split("[\\s\\.\\-\\+/\\*\\(\\)]+");
					// If we've split this string, the last value would be our table alias (since it would've been before
					// the "." from the statement after it
					tablesNeedingJoins.add(subSortCriteria[subSortCriteria.length - 1]);
				}
				return tablesNeedingJoins.stream();
			}).filter(alias -> !StringUtil.isNullOrEmpty(alias)).collect(Collectors.toSet());
		} catch (Exception e) {
			throw new AdempiereException(MALFORMED_SORT_STRING_ERROR);
		}
	}
}
