package org.bandahealth.idempiere.graphql.resolver.query;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.DashboardFinancialGeneralMetric;
import org.bandahealth.idempiere.graphql.model.DashboardFinancialHistorical;
import org.bandahealth.idempiere.graphql.model.DashboardFinancialOpenBalance;
import org.bandahealth.idempiere.graphql.model.DashboardFinancialSource;
import org.bandahealth.idempiere.graphql.model.DashboardFinancialType;
import org.bandahealth.idempiere.graphql.model.DashboardFinancialVisitCharge;
import org.bandahealth.idempiere.graphql.utils.SqlUtil;
import org.compiere.util.Env;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;

public class DashboardFinancialQuery implements GraphQLQueryResolver {

	public DashboardFinancialGeneralMetric DashboardFinancialGeneralMetricsGet(Timestamp BeginDate, Timestamp EndDate,
			DataFetchingEnvironment environment) {
		String query = "SELECT * FROM bh_dashboard_get_financial_general_metrics(?, ?::timestamp, ?::timestamp)";
		List<Object> parameters = List.of(Env.getAD_Client_ID(BandaGraphQLContext.getCtx(environment)), BeginDate,
				EndDate);
		List<DashboardFinancialGeneralMetric> results = new ArrayList<>();
		SqlUtil.executeQuery(query, parameters, null, resultSet -> {
			DashboardFinancialGeneralMetric dashboardFinancialGeneralMetrics = new DashboardFinancialGeneralMetric();
			//
			try {
				dashboardFinancialGeneralMetrics.setRevenueSales(resultSet.getBigDecimal(1));
				dashboardFinancialGeneralMetrics.setTotalExpenses(resultSet.getBigDecimal(2));
				dashboardFinancialGeneralMetrics.setNetProfit(resultSet.getBigDecimal(3));
				dashboardFinancialGeneralMetrics.setTotalOwed(resultSet.getBigDecimal(4));
				dashboardFinancialGeneralMetrics.setInventoryValue(resultSet.getBigDecimal(5));
				dashboardFinancialGeneralMetrics.setTotalCharges(resultSet.getBigDecimal(6));
				dashboardFinancialGeneralMetrics.setCostOfGoodsSold(resultSet.getBigDecimal(7));
				dashboardFinancialGeneralMetrics.setGrossProfit(resultSet.getBigDecimal(8));
				dashboardFinancialGeneralMetrics.setGrossProfitMargin(resultSet.getBigDecimal(9));
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			//
			results.add(dashboardFinancialGeneralMetrics);
		});
		return results.get(0);
	}

	public List<DashboardFinancialHistorical> DashboardFinancialHistoricalGet(Timestamp BeginDate, Timestamp EndDate,
			DataFetchingEnvironment environment) {
		String query = "SELECT * FROM bh_dashboard_get_financial_historical(?, ?::timestamp, ?::timestamp)";
		List<Object> parameters = List.of(Env.getAD_Client_ID(BandaGraphQLContext.getCtx(environment)), BeginDate,
				EndDate);
		List<DashboardFinancialHistorical> results = new ArrayList<>();
		SqlUtil.executeQuery(query, parameters, null, resultSet -> {
			DashboardFinancialHistorical dashboardHistorical = new DashboardFinancialHistorical();
			//
			try {
				dashboardHistorical.setBucketValue(resultSet.getTimestamp(1));
				dashboardHistorical.setTotalIncome(resultSet.getBigDecimal(2));
				dashboardHistorical.setTotalExpenses(resultSet.getBigDecimal(3));
				dashboardHistorical.setNetProfit(resultSet.getBigDecimal(4));
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			//
			results.add(dashboardHistorical);
		});
		return results;
	}

	public List<DashboardFinancialOpenBalance> DashboardFinancialOpenBalancesGet(Timestamp BeginDate, Timestamp EndDate,
			String type, DataFetchingEnvironment environment) {
		String query = "SELECT * FROM bh_dashboard_get_financial_open_balances(?, ?::timestamp, ?::timestamp) WHERE type = ?";
		List<Object> parameters = List.of(Env.getAD_Client_ID(BandaGraphQLContext.getCtx(environment)), BeginDate,
				EndDate, type);
		List<DashboardFinancialOpenBalance> results = new ArrayList<>();
		SqlUtil.executeQuery(query, parameters, null, resultSet -> {
			DashboardFinancialOpenBalance entity = new DashboardFinancialOpenBalance();
			//
			try {
				entity.setName(resultSet.getString(1));
				entity.setTotalOpenBalance(resultSet.getBigDecimal(2));
				entity.setType(resultSet.getString(3));
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			//
			results.add(entity);
		});
		return results;
	}

	public List<DashboardFinancialSource> DashboardFinancialSourcesGet(Timestamp BeginDate, Timestamp EndDate,
			DataFetchingEnvironment environment) {
		String query = "SELECT * FROM bh_dashboard_get_financial_sources(?, ?::timestamp, ?::timestamp)";
		List<Object> parameters = List.of(Env.getAD_Client_ID(BandaGraphQLContext.getCtx(environment)), BeginDate,
				EndDate);
		List<DashboardFinancialSource> results = new ArrayList<>();
		SqlUtil.executeQuery(query, parameters, null, resultSet -> {
			DashboardFinancialSource entity = new DashboardFinancialSource();
			//
			try {
				entity.setSource(resultSet.getString(1));
				entity.setFrequency(resultSet.getInt(2));
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			//
			results.add(entity);
		});
		return results;
	}

	public List<DashboardFinancialType> DashboardFinancialTypesGet(Timestamp BeginDate, Timestamp EndDate, String type,
			DataFetchingEnvironment environment) {
		String query = "SELECT * FROM bh_dashboard_get_financial_types(?, ?::timestamp, ?::timestamp) WHERE type = ?";
		List<Object> parameters = List.of(Env.getAD_Client_ID(BandaGraphQLContext.getCtx(environment)), BeginDate,
				EndDate, type);
		List<DashboardFinancialType> results = new ArrayList<>();
		SqlUtil.executeQuery(query, parameters, null, resultSet -> {
			DashboardFinancialType entity = new DashboardFinancialType();
			//
			try {
				entity.setName(resultSet.getString(1));
				entity.setFrequency(resultSet.getInt(2));
				entity.setType(resultSet.getString(3));
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			//
			results.add(entity);
		});
		return results;
	}

	public List<DashboardFinancialVisitCharge> DashboardFinancialVisitChargesGet(Timestamp BeginDate, Timestamp EndDate,
			DataFetchingEnvironment environment) {
		String query = "SELECT * FROM bh_dashboard_get_financial_visit_charges(?, ?::timestamp, ?::timestamp)";
		List<Object> parameters = List.of(Env.getAD_Client_ID(BandaGraphQLContext.getCtx(environment)), BeginDate,
				EndDate);
		List<DashboardFinancialVisitCharge> results = new ArrayList<>();
		SqlUtil.executeQuery(query, parameters, null, resultSet -> {
			DashboardFinancialVisitCharge entity = new DashboardFinancialVisitCharge();
			//
			try {
				entity.setBucketValue(resultSet.getTimestamp(1));
				entity.setPatientVisits(resultSet.getInt(2));
				entity.setAvgChargePatient(resultSet.getInt(3));
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			//
			results.add(entity);
		});
		return results;
	}
}
