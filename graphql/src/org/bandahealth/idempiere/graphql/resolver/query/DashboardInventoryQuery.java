package org.bandahealth.idempiere.graphql.resolver.query;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.DashboardInventoryGeneralMetrics;
import org.bandahealth.idempiere.graphql.model.DashboardInventoryHistoricalChargeEarning;
import org.bandahealth.idempiere.graphql.model.DashboardInventoryHistoricalValue;
import org.bandahealth.idempiere.graphql.model.DashboardInventoryTopSellerEarner;
import org.bandahealth.idempiere.graphql.utils.SqlUtil;
import org.compiere.util.Env;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;

public class DashboardInventoryQuery implements GraphQLQueryResolver {

	public DashboardInventoryGeneralMetrics DashboardInventoryGeneralMetricsGet(Timestamp BeginDate, Timestamp EndDate,
			DataFetchingEnvironment environment) {
		String query = "SELECT * FROM bh_dashboard_get_inventory_general_metrics(?, ?::timestamp, ?::timestamp)";
		List<Object> parameters = List.of(Env.getAD_Client_ID(BandaGraphQLContext.getCtx(environment)), BeginDate,
				EndDate);
		List<DashboardInventoryGeneralMetrics> results = new ArrayList<>();
		SqlUtil.executeQuery(query, parameters, null, resultSet -> {
			DashboardInventoryGeneralMetrics entity = new DashboardInventoryGeneralMetrics();
			//
			try {
				entity.setInventoryTurnoverRate(resultSet.getBigDecimal(1));
				entity.setDaysOnHand(resultSet.getBigDecimal(2));
				entity.setSalesToStockRatio(resultSet.getBigDecimal(3));
				entity.setGrossMargin(resultSet.getBigDecimal(4));
				entity.setReturnOnInvestment(resultSet.getBigDecimal(5));
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			//
			results.add(entity);
		});
		return results.get(0);
	}

	public List<DashboardInventoryHistoricalChargeEarning> DashboardInventoryHistoricalChargeEarningGet(
			Timestamp BeginDate, Timestamp EndDate, DataFetchingEnvironment environment) {
		String query = "SELECT * FROM bh_dashboard_get_inventory_historical_charge_earnings(?, ?::timestamp, ?::timestamp)";
		List<Object> parameters = List.of(Env.getAD_Client_ID(BandaGraphQLContext.getCtx(environment)), BeginDate,
				EndDate);
		List<DashboardInventoryHistoricalChargeEarning> results = new ArrayList<>();
		SqlUtil.executeQuery(query, parameters, null, resultSet -> {
			DashboardInventoryHistoricalChargeEarning entity = new DashboardInventoryHistoricalChargeEarning();
			//
			try {
				entity.setBucketValue(resultSet.getTimestamp(1));
				entity.setCharges(resultSet.getBigDecimal(2));
				entity.setMargins(resultSet.getBigDecimal(3));
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			//
			results.add(entity);
		});
		return results;
	}

	public List<DashboardInventoryHistoricalValue> DashboardInventoryHistoricalValueGet(Timestamp BeginDate,
			Timestamp EndDate, DataFetchingEnvironment environment) {
		String query = "SELECT * FROM bh_dashboard_get_inventory_historical_value(?, ?::timestamp, ?::timestamp)";
		List<Object> parameters = List.of(Env.getAD_Client_ID(BandaGraphQLContext.getCtx(environment)), BeginDate,
				EndDate);
		List<DashboardInventoryHistoricalValue> results = new ArrayList<>();
		SqlUtil.executeQuery(query, parameters, null, resultSet -> {
			DashboardInventoryHistoricalValue entity = new DashboardInventoryHistoricalValue();
			//
			try {
				entity.setBucketValue(resultSet.getTimestamp(1));
				entity.setInventoryValue(resultSet.getBigDecimal(2));
				entity.setInventoryReceived(resultSet.getBigDecimal(3));
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			//
			results.add(entity);
		});
		return results;
	}

	public List<DashboardInventoryTopSellerEarner> DashboardInventoryTopSellerEarnerGet(Timestamp BeginDate,
			Timestamp EndDate, DataFetchingEnvironment environment) {
		String query = "SELECT * FROM bh_dashboard_get_inventory_top_sellers_earners(?, ?::timestamp, ?::timestamp)";
		List<Object> parameters = List.of(Env.getAD_Client_ID(BandaGraphQLContext.getCtx(environment)), BeginDate,
				EndDate);
		List<DashboardInventoryTopSellerEarner> results = new ArrayList<>();
		SqlUtil.executeQuery(query, parameters, null, resultSet -> {
			DashboardInventoryTopSellerEarner entity = new DashboardInventoryTopSellerEarner();
			//
			try {
				entity.setName(resultSet.getString(1));
				entity.setQuantitySold(resultSet.getBigDecimal(2));
				entity.setValueGoodsSold(resultSet.getBigDecimal(2));
				entity.setIncomeGenerated(resultSet.getBigDecimal(2));
				entity.setMarginEarned(resultSet.getBigDecimal(2));
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			//
			results.add(entity);
		});
		return results;
	}
}
