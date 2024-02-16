package org.bandahealth.idempiere.rest.model;

import org.compiere.model.MTable;
import org.compiere.model.POInfo;
import org.compiere.util.Env;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class is used by the {@link org.bandahealth.idempiere.rest.utils.FilterUtil} to help get the table name and
 * the associated data with it. You can also pass in your own custom mappings when using with a function.
 */
public class FilterTableData {
	private final String tableOrFunctionName;
	private Map<String, Class<?>> columnsAndClasses;
	private POInfo poInfo;

	/**
	 * Build the object and expect it to get POInfo from iDempiere
	 *
	 * @param iDempiereTableName The table to get data for
	 */
	public FilterTableData(String iDempiereTableName) {
		this.tableOrFunctionName = iDempiereTableName;
		tryToSetTableInfo();
	}

	/**
	 * Build the object and pass in custom columns and associated classes to use instead of anything inside iDempiere
	 *
	 * @param tableOrFunctionName The table or function name we'll be using
	 * @param columnsAndClasses   The column and associated class map
	 */
	public FilterTableData(String tableOrFunctionName, Map<String, Class<?>> columnsAndClasses) {
		this.tableOrFunctionName = tableOrFunctionName;
		this.columnsAndClasses = columnsAndClasses.entrySet().stream()
				.collect(Collectors.toMap(entry -> entry.getKey().toLowerCase(), Map.Entry::getValue));
	}

	/**
	 * Get the table or function name that was passed in
	 *
	 * @return The table or function name
	 */
	public String getTableOrFunctionName() {
		return tableOrFunctionName;
	}

	/**
	 * Check whether the specified column exists on this table or function
	 *
	 * @param columnName The column to check
	 * @return Whether the specified column exists on this table or function
	 */
	public boolean doesTableHaveColumn(String columnName) {
		// If no columns have been defined, get the column information from the POInfo
		if (columnsAndClasses == null) {
			tryToSetTableInfo();
			return poInfo != null && poInfo.getColumnIndex(columnName) > -1;
		}
		return columnsAndClasses.containsKey(columnName.toLowerCase());
	}

	/**
	 * Get the class associated with this column name, if any
	 *
	 * @param columnName The column name to get a class for
	 * @return An associated class or null if the column isn't found
	 */
	public Class<?> getColumnClass(String columnName) {
		if (columnsAndClasses == null) {
			tryToSetTableInfo();
			return poInfo == null ? null : poInfo.getColumnClass(poInfo.getColumnIndex(columnName));
		}
		return columnsAndClasses.get(columnName.toLowerCase());
	}

	/**
	 * This method should be called only if columnsAndClasses is not set. It tries to get POInfo otherwise and set it
	 * if it's not already been set (that way the info is kind of cached).
	 */
	private void tryToSetTableInfo() {
		if (poInfo == null) {
			try {
				// Get the information from the DB - both of these pieces are cached by iDempiere to limit DB trips
				MTable table = MTable.get(Env.getCtx(), tableOrFunctionName);
				if (table != null) {
					poInfo = POInfo.getPOInfo(Env.getCtx(), table.getAD_Table_ID());
				}
			} catch (Exception ignored) {
			}
		}
	}

	public POInfo getPoInfo() {
		return poInfo;
	}
}
