package org.bandahealth.idempiere.rest.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * A utility for functions associated with DB queries
 */
public class QueryUtil {
	private static final List<String> DISALLOWED_COLUMN_CHARACTERS =
			Arrays.asList("\\", "--", ";", "'", "\"", "?", "=", "!", "^", "&", "$", "#", "@", "`", "~", "DROP", "DELETE",
					"UPDATE", "SELECT", "FROM", "WHERE");

	/**
	 * This generates a parameter list based on a number of items (i.e. for items [1,2,3], this generates a where clause
	 * of "?,?,?" and adds the items to the parameters)
	 *
	 * @param items      The items to add to the parameter list
	 * @param parameters The parameter list
	 * @param <T>        The type of items to add
	 * @return A where clause with the number of question marks, comma-delimited, for the number of parameters
	 */
	public static <T> String getWhereClauseAndSetParametersForSet(Set<T> items, List<Object> parameters) {
		String parameterList = "?,".repeat(items.size());
		parameters.addAll(items);
		return parameterList.substring(0, parameterList.length() - 1);
	}

	/**
	 * Determine if a value that is going to be directly passed into a SQL executor (i.e. without using
	 * DB.prepareStatement to pass it's value in) has invalid characters. This is a crude form of preventing SQL
	 * injection
	 *
	 * @param dbString The DB String to check
	 * @return Whether the string has invalid characters or not
	 */
	public static boolean doesDBStringHaveInvalidCharacters(String dbString) {
		return DISALLOWED_COLUMN_CHARACTERS.stream()
				.anyMatch(aggregate -> dbString.toLowerCase().contains(aggregate.toLowerCase()));
	}

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
	 * Get the table alias provided in the column
	 *
	 * @param dbColumn The dbColumn string to check
	 * @return The table alias on the dbColumn
	 */
	public static String getTableAliasFromColumn(String dbColumn) {
		return dbColumn.substring(0, dbColumn.indexOf("."));
	}
}
