package org.bandahealth.idempiere.rest.utils;

import java.util.Map;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MUser;
import org.compiere.model.PO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortUtil {
	private static final String MALFORMED_SORT_STRING_ERROR = "Sort criteria doesn't meet the standard form.";

	/**
	 * Check to see if the table alias already exists on the column (aka Table_Name.ColumnName vs just ColumnName)
	 *
	 * @param dbColumn The dbColumn string to check
	 * @return Whether a table alias is present on the dbColumn
	 */
	public static boolean doesTableAliasExistOnColumn(String dbColumn) {
		return dbColumn.contains(".");
	}

	/**
	 * Get the table join entry from the alias column
	 * @param sortColumn column name to use as key 
	 * @param joinClause A map of join columns provided	 
	 * @param joinColumns A map of join columns provided
	 * @return a string representing the join clause. 
	 */
	public static String getJoinClauseFromAlias(String sortColumn, String joinClause,  Map<String, String> joinColumns) {
		String tableName = sortColumn.substring(0, sortColumn.indexOf("."));
		String alias = tableName + ".";
		//Do not add JOIN if it is already added. 
		if (joinClause != null && joinClause.toLowerCase().contains(alias))
			return null;
		return joinColumns.get(tableName.toString());
		
	}
	
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
	 * [
	 * database-column
	 * -OR-
	 * [database-column]
	 * -OR-
	 * [database-column, sort-direction]
	 * ]
	 * </p>
	 *
	 * @param dbModel  The iDempiere DB model for determining field types
	 * @param sortJson The JSON string received for sorting
	 * @param <T>      An iDempiere model extending from PO
	 * @return An ORDER BY clause based off the sort criteria to use in a DB query
	 */
	public static <T extends PO> String getOrderByClauseFromSort(String tableName, String sortJson) {
		String DEFAULT_ORDER_BY = tableName + "." + MUser.COLUMNNAME_Created + " DESC NULLS LAST";
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
				if (QueryUtil.doesDBStringHaveInvalidCharacters(sortColumn) ||
						QueryUtil.doesDBStringHaveInvalidCharacters(sortDirection)) {
					return null;
				}
				if (!QueryUtil.doesTableAliasExistOnColumn(sortColumn)) {
					sortColumn = tableName + "." + sortColumn;
				}
				return sortColumn + " " + sortDirection + " NULLS LAST";
			}).filter(sortCriteria -> !StringUtil.isNullOrEmpty(sortCriteria)).collect(Collectors.joining(","));
			return orderBy.isEmpty() ? DEFAULT_ORDER_BY : orderBy;
		} catch (Exception e) {
			throw new AdempiereException(MALFORMED_SORT_STRING_ERROR);
		}
	}
}
