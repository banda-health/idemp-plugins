package org.bandahealth.idempiere.rest.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

import org.adempiere.exceptions.DBException;
import org.compiere.model.MTable;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;

/**
 * Abstract common sql functionality
 * 
 * @author andrew
 *
 */
public class SqlUtil {

	private static CLogger log = CLogger.getCLogger(SqlUtil.class);

	public static Integer getCount(String tableName, String whereClause, List<Object> parameters) {
		StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM ").append(tableName).append(" ")
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
	 * get IDS for given PO instance
	 * 
	 * @param <T>
	 * @param transactionName
	 * @return
	 */
	public <T extends PO> List<T> getResultIDs(T instance, String transactionName) {
		String tableName = instance.get_TableName();

		String sql = "SELECT " + tableName + "_ID FROM " + tableName + " WHERE isActive = ? AND AD_Client_ID = ?";

		Object[] parameters = new Object[2];
		parameters[0] = true;
		parameters[1] = Env.getAD_Client_ID(Env.getCtx());

		return getResults(MTable.get(Env.getCtx(), tableName), sql, parameters, transactionName);
	}

	/**
	 * Get Results given query
	 * 
	 * @param <T>
	 * @param sql
	 * @param table
	 * @param transactionName
	 * @param parameters
	 * @return
	 */
	public <T extends PO> List<T> getResults(MTable table, String sql, Object[] parameters, String transactionName) {
		List<T> list = new ArrayList<>();

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = DB.prepareStatement(sql, transactionName);
			DB.setParameters(preparedStatement, parameters);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				list.add((T) table.getPO(resultSet, transactionName));
			}
		} catch (SQLException e) {
			log.log(Level.SEVERE, sql, e);
			throw new DBException(e, sql);
		} finally {
			DB.close(resultSet, preparedStatement);
			resultSet = null;
			preparedStatement = null;
		}
		return list;
	}
}
