package org.bandahealth.idempiere.rest.utils;

import java.util.Map;

public class SortUtil {

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

}
