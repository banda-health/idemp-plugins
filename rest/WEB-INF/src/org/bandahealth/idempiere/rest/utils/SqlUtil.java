package org.bandahealth.idempiere.rest.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.adempiere.exceptions.DBException;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.rest.function.VoidFunction;
import org.compiere.model.MClient;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.regex.Pattern;

/**
 * Abstract common sql functionality
 *
 * @author andrew
 */
public class SqlUtil {

	private static CLogger log = CLogger.getCLogger(SqlUtil.class);
	private static final List<String> WORDS_TO_ESCAPE = Arrays.asList("number", "new", "limit");
	private static final List<String> DISALLOWED_SQL_SELECT_CHARACTERS =
			Arrays.asList("\\", "--", ";", "`", "drop ", "delete ", "insert ");
	// Copied from org.compiere.db.DB_PostgreSQL since that file can't be read here
	private static final String IDEMPIERE_POSTGRESQL_NATIVE_MARKER = "NATIVE_PostgreSQL_KEYWORK";

	public static Integer getCount(String tableName, String whereClause, List<Object> parameters) {
		StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM ")
				.append(tableName)
				.append(" ")
				.append(whereClause);

		Integer count = null;

		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = DB.prepareStatement(sql.toString(), null);
			DB.setParameters(statement, parameters);

			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				count = resultSet.getInt(1);
			}

		} catch (SQLException e) {
			log.log(Level.SEVERE, sql.toString(), e);
			throw new DBException(e, sql.toString());
		} finally {
			DB.close(resultSet, statement);
			resultSet = null;
			statement = null;
		}

		return count;
	}

	/**
	 * Get counts by groups within a data set
	 *
	 * @param tableName        The table to query
	 * @param whereClause      Limit results returned by the query
	 * @param groupingColumn   Name of the column to group by
	 * @param parameters       Any parameters to pass into the query
	 * @param fetchGroupColumn A function to get the correct data and type from the result set
	 * @param <T>              The type of data stored in the grouping column
	 * @return A map of result counts by their grouping column
	 */
	public static <T> Map<T, Integer> getGroupCount(String tableName, String whereClause, String groupingColumn,
			List<Object> parameters, Function<ResultSet, T> fetchGroupColumn) {
		String sql =
				"SELECT " + groupingColumn + ", COUNT(*) FROM " + tableName + " " + whereClause + " GROUP BY " + groupingColumn;

		Map<T, Integer> counts = new HashMap<>();

		executeQuery(sql, parameters, null, (resultSet) -> {
			try {
				counts.put(fetchGroupColumn.apply(resultSet), resultSet.getInt(2));
			} catch (Exception e) {
				log.severe(e.getMessage());
			}
		});

		return counts;
	}

	/**
	 * Executes a given query and lets the handler function deal with the result sets
	 *
	 * @param sql             The SQL to execute
	 * @param parameters      The parameters to pass to the SQL to execute
	 * @param transactionName The transaction, if any, to use for the query
	 * @param handler         The function to handle the ResultSet(s) that are returned from the query
	 */
	public static void executeQuery(String sql, List<Object> parameters, String transactionName,
			VoidFunction<ResultSet> handler) {
		executeQueryWithDynamicColumns(sql, parameters, transactionName, null, handler);
	}

	/**
	 * Executes a given query and lets the handler function deal with the result sets
	 *
	 * @param sql             The SQL to execute
	 * @param parameters      The parameters to pass to the SQL to execute
	 * @param transactionName The transaction, if any, to use for the query
	 * @param handler         The function to handle the ResultSet(s) that are returned from the query
	 */
	public static void executeQueryWithDynamicColumns(String sql, List<Object> parameters, String transactionName,
			List<String> unknownColumnNames, VoidFunction<ResultSet> handler) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = DB.prepareStatement(sql, transactionName);
			DB.setParameters(preparedStatement, parameters);
			resultSet = preparedStatement.executeQuery();
			if (unknownColumnNames != null) {
				ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
				int totalColumnsInQuery = resultSetMetaData.getColumnCount();
				for (int columnIndex = 0; columnIndex < totalColumnsInQuery; columnIndex++) {
					unknownColumnNames.add(resultSetMetaData.getColumnName(columnIndex + 1));
				}
			}
			while (resultSet.next()) {
				handler.apply(resultSet);
			}
		} catch (SQLException e) {
			log.log(Level.SEVERE, sql, e);
			throw new DBException(e, sql);
		} finally {
			DB.close(resultSet, preparedStatement);
			resultSet = null;
			preparedStatement = null;
		}
	}

	/**
	 * On the dashboard, we have user-entered queries that need to be run. This sanitizes and runs them for a given
	 * client.
	 *
	 * @param sql        The SQL to run
	 * @param clientUuid The client to run the SQL for
	 * @return The JSON array of data
	 * @throws JsonProcessingException The typical error that Jackson could throw when processing Java to JSON
	 */
	public static ArrayNode executeDashboardQueryForClient(String sql, String clientUuid) throws JsonProcessingException {
		PO.setCrossTenantSafe();
		MClient clientToGetDataFor =
				new Query(Env.getCtx(), MClient_BH.Table_Name, MClient_BH.COLUMNNAME_AD_Client_UU + "=?", null).setParameters(
						clientUuid).first();
		PO.clearCrossTenantSafe();
		// We don't allow querying for the system client
		if (clientToGetDataFor == null || clientToGetDataFor.get_ID() == 0) {
			return null;
		}
		ObjectMapper mapper = new ObjectMapper();
		sql = mapper.readValue(sql, String.class);
		// Replace the client ID
		sql = sql.replaceAll("\\$P\\{AD_CLIENT_ID\\}", String.valueOf(clientToGetDataFor.get_ID()))
				.replaceAll("\\R", " ").trim();
		// If the query is trying to do anything besides select, don't allow it
		String finalSql = sql.toLowerCase();
		if (DISALLOWED_SQL_SELECT_CHARACTERS.stream().anyMatch(finalSql::contains) ||
				!(finalSql.startsWith("select") || finalSql.startsWith("with")) || !finalSql.contains("from")) {
			return null;
		}
		// Limit the results to 100
		sql += " limit 100";

		sql = sql.replaceAll("date\\(", IDEMPIERE_POSTGRESQL_NATIVE_MARKER + "date(")
				.replaceAll("::date", "::" + IDEMPIERE_POSTGRESQL_NATIVE_MARKER + "date");
		sql =
				WORDS_TO_ESCAPE.stream()
						.map(wordToEscape -> Pattern.compile("(" + wordToEscape + ")", Pattern.CASE_INSENSITIVE))
						.reduce(sql, (currentSql, pattern) -> pattern.matcher(currentSql)
								.replaceAll(IDEMPIERE_POSTGRESQL_NATIVE_MARKER + "$1"), (sql1, sql2) -> sql2);

		ArrayNode data = mapper.createArrayNode();
		List<String> columns = new ArrayList<>();
		executeQueryWithDynamicColumns(sql, new ArrayList<>(), null, columns, resultSet -> {
			try {
				ObjectNode dataRow = mapper.createObjectNode();
				for (int i = 0; i < columns.size(); i++) {
					String column = columns.get(i);
					Object result = resultSet.getObject(i + 1);
					if (result instanceof Short) {
						dataRow.put(column, (Short) result);
					} else if (result instanceof Integer) {
						dataRow.put(column, (Integer) result);
					} else if (result instanceof Long) {
						dataRow.put(column, (Long) result);
					} else if (result instanceof Float) {
						dataRow.put(column, (Float) result);
					} else if (result instanceof Double) {
						dataRow.put(column, (Double) result);
					} else if (result instanceof BigDecimal) {
						dataRow.put(column, (BigDecimal) result);
					} else if (result instanceof BigInteger) {
						dataRow.put(column, (BigInteger) result);
					} else if (result instanceof String) {
						dataRow.put(column, (String) result);
					} else if (result instanceof Boolean) {
						dataRow.put(column, (Boolean) result);
					} else if (result instanceof Date) {
						dataRow.put(column, ((Date) result).getTime());
					} else if (result instanceof Timestamp) {
						dataRow.put(column, ((Timestamp) result).getTime());
					} else if (result instanceof byte[]) {
						dataRow.put(column, (byte[]) result);
					} else {
						dataRow.putNull(column);
					}
				}
				data.add(dataRow);
			} catch (Exception e) {
				log.severe(e.getMessage());
			}
		});
		return data;
	}
}
