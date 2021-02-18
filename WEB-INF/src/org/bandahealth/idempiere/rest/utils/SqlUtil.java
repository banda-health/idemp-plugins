package org.bandahealth.idempiere.rest.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

import org.adempiere.exceptions.DBException;
import org.bandahealth.idempiere.rest.function.VoidFunction;
import org.compiere.util.CLogger;
import org.compiere.util.DB;

/**
 * Abstract common sql functionality
 *
 * @author andrew
 */
public class SqlUtil {

	private static CLogger log = CLogger.getCLogger(SqlUtil.class);

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
	 * Executes a given query and lets the handler function deal with the result sets
	 *
	 * @param sql             The SQL to execute
	 * @param parameters      The parameters to pass to the SQL to execute
	 * @param transactionName The transaction, if any, to use for the query
	 * @param handler         The function to handle the ResultSet(s) that are returned from the query
	 */
	public static void executeQuery(String sql, List<Object> parameters, String transactionName,
			VoidFunction<ResultSet> handler) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = DB.prepareStatement(sql, transactionName);
			DB.setParameters(preparedStatement, parameters);
			resultSet = preparedStatement.executeQuery();
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
}
