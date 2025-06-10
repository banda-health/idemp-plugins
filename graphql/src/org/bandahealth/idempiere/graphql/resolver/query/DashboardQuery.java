package org.bandahealth.idempiere.graphql.resolver.query;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.DashboardDiagnosisUsage;
import org.bandahealth.idempiere.graphql.model.DashboardFinancialChargeType;
import org.bandahealth.idempiere.graphql.model.DashboardFinancialGeneralMetric;
import org.bandahealth.idempiere.graphql.model.DashboardFinancialHistorical;
import org.bandahealth.idempiere.graphql.model.DashboardFinancialOpenBalance;
import org.bandahealth.idempiere.graphql.model.DashboardFinancialSource;
import org.bandahealth.idempiere.graphql.model.DashboardFinancialType;
import org.bandahealth.idempiere.graphql.model.DashboardFinancialVisitCharge;
import org.bandahealth.idempiere.graphql.model.DashboardGeneralData;
import org.bandahealth.idempiere.graphql.model.DashboardInventoryGeneralMetrics;
import org.bandahealth.idempiere.graphql.model.DashboardInventoryHistoricalChargeEarning;
import org.bandahealth.idempiere.graphql.model.DashboardInventoryHistoricalValue;
import org.bandahealth.idempiere.graphql.model.DashboardInventoryTopSellerEarner;
import org.bandahealth.idempiere.graphql.model.DashboardLabUsage;
import org.bandahealth.idempiere.graphql.model.DashboardProductUsage;
import org.bandahealth.idempiere.graphql.model.DashboardVisitHistoryStat;
import org.bandahealth.idempiere.graphql.utils.SqlUtil;
import org.compiere.model.MUser;
import org.compiere.util.Env;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DashboardQuery implements GraphQLQueryResolver {
	public String DashboardData(String UU, String SqlQuery, DataFetchingEnvironment environment) {
		MUser currentUser;
		if ((currentUser = MUser_BH.get(BandaGraphQLContext.getCtx(environment))) == null ||
				!currentUser.isAdministrator()) {
			return null;
		}
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.writeValueAsString(
					SqlUtil.executeDashboardQueryForClient(BandaGraphQLContext.getCtx(environment), SqlQuery, UU));
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	public DashboardGeneralData DashboardGeneralDataGet(Timestamp BeginDate, Timestamp EndDate,
			DataFetchingEnvironment environment) {
		String query = "SELECT * FROM bh_dashboard_get_general_data(?, ?::timestamp, ?::timestamp)";
		List<Object> parameters = List.of(Env.getAD_Client_ID(BandaGraphQLContext.getCtx(environment)), BeginDate,
				EndDate);
		List<DashboardGeneralData> results = new ArrayList<>();
		SqlUtil.executeQuery(query, parameters, null, resultSet -> {
			DashboardGeneralData dashboardGeneralData = new DashboardGeneralData();
			//
			try {
				dashboardGeneralData.setTotalPatientsServed(resultSet.getInt(1));
				dashboardGeneralData.setNewPatientsRegistered(resultSet.getInt(2));
				dashboardGeneralData.setAverageNumberOfProductsDelivered(resultSet.getBigDecimal(3));
				dashboardGeneralData.setAverageChargePerPatient(resultSet.getBigDecimal(4));
				dashboardGeneralData.setAverageProductTurnover(resultSet.getBigDecimal(5));
				dashboardGeneralData.setPercentVitalsTracked(resultSet.getBigDecimal(6));
				dashboardGeneralData.setPercentDiagnosesCoded(resultSet.getBigDecimal(7));
				dashboardGeneralData.setPercentNotes(resultSet.getBigDecimal(8));
				dashboardGeneralData.setPercentCompletedLabs(resultSet.getBigDecimal(9));
				dashboardGeneralData.setPercentVisitsCompleted(resultSet.getBigDecimal(10));
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			//
			results.add(dashboardGeneralData);
		});
		return results.get(0);
	}

	public List<DashboardDiagnosisUsage> DashboardDiagnosisUsageGet(Timestamp BeginDate, Timestamp EndDate,
			DataFetchingEnvironment environment) {
		String query = "SELECT * FROM bh_dashboard_get_diagnosis_usage(?, ?::timestamp, ?::timestamp)";
		List<Object> parameters = List.of(Env.getAD_Client_ID(BandaGraphQLContext.getCtx(environment)), BeginDate,
				EndDate);
		List<DashboardDiagnosisUsage> results = new ArrayList<>();
		SqlUtil.executeQuery(query, parameters, null, resultSet -> {
			DashboardDiagnosisUsage dashboardDiagnosisUsage = new DashboardDiagnosisUsage();
			//
			try {
				dashboardDiagnosisUsage.setConceptId(resultSet.getInt(1));
				dashboardDiagnosisUsage.setBH_Uncoded_Diagnosis(resultSet.getString(2));
				dashboardDiagnosisUsage.setCurrent(resultSet.getBigDecimal(3));
				dashboardDiagnosisUsage.setPrevious(resultSet.getBigDecimal(4));
				dashboardDiagnosisUsage.setCurrentTotal(resultSet.getBigDecimal(5));
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			//
			results.add(dashboardDiagnosisUsage);
		});
		return results;
	}

	public List<DashboardProductUsage> DashboardProductUsageGet(Timestamp BeginDate, Timestamp EndDate,
			DataFetchingEnvironment environment) {
		String query = "SELECT * FROM bh_dashboard_get_product_usage(?, ?::timestamp, ?::timestamp)";
		List<Object> parameters = List.of(Env.getAD_Client_ID(BandaGraphQLContext.getCtx(environment)), BeginDate,
				EndDate);
		List<DashboardProductUsage> results = new ArrayList<>();
		SqlUtil.executeQuery(query, parameters, null, resultSet -> {
			DashboardProductUsage dashboardProductUsage = new DashboardProductUsage();
			//
			try {
				dashboardProductUsage.setProductId(resultSet.getInt(1));
				dashboardProductUsage.setName(resultSet.getString(2));
				dashboardProductUsage.setCurrent(resultSet.getBigDecimal(3));
				dashboardProductUsage.setPrevious(resultSet.getBigDecimal(4));
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			//
			results.add(dashboardProductUsage);
		});
		return results;
	}

	public List<DashboardLabUsage> DashboardLabUsageGet(Timestamp BeginDate, Timestamp EndDate,
			DataFetchingEnvironment environment) {
		String query = "SELECT * FROM bh_dashboard_get_lab_usage(?, ?::timestamp, ?::timestamp)";
		List<Object> parameters = List.of(Env.getAD_Client_ID(BandaGraphQLContext.getCtx(environment)), BeginDate,
				EndDate);
		List<DashboardLabUsage> results = new ArrayList<>();
		SqlUtil.executeQuery(query, parameters, null, resultSet -> {
			DashboardLabUsage dashboardLabUsage = new DashboardLabUsage();
			//
			try {
				dashboardLabUsage.setConceptId(resultSet.getInt(1));
				dashboardLabUsage.setName(resultSet.getString(2));
				dashboardLabUsage.setCurrent(resultSet.getBigDecimal(3));
				dashboardLabUsage.setPrevious(resultSet.getBigDecimal(4));
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			//
			results.add(dashboardLabUsage);
		});
		return results;
	}

	public List<DashboardVisitHistoryStat> DashboardVisitHistoryStatGet(Timestamp BeginDate, Timestamp EndDate,
			DataFetchingEnvironment environment) {
		String query = "SELECT * FROM bh_dashboard_get_visit_history_stats(?, ?::timestamp, ?::timestamp)";
		List<Object> parameters = List.of(Env.getAD_Client_ID(BandaGraphQLContext.getCtx(environment)), BeginDate,
				EndDate);
		List<DashboardVisitHistoryStat> results = new ArrayList<>();
		SqlUtil.executeQuery(query, parameters, null, resultSet -> {
			DashboardVisitHistoryStat dashboardVisitHistoryStat = new DashboardVisitHistoryStat();
			//
			try {
				dashboardVisitHistoryStat.setBucketValue(resultSet.getTimestamp(1));
				dashboardVisitHistoryStat.setReferenceListId(resultSet.getInt(2));
				dashboardVisitHistoryStat.setAlternateVisitType(resultSet.getString(3));
				dashboardVisitHistoryStat.setFrequency(resultSet.getInt(4));
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			//
			results.add(dashboardVisitHistoryStat);
		});
		return results;
	}

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
				entity.setValueGoodsSold(resultSet.getBigDecimal(3));
				entity.setIncomeGenerated(resultSet.getBigDecimal(4));
				entity.setMarginEarned(resultSet.getBigDecimal(5));
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			//
			results.add(entity);
		});
		return results;
	}
	
	public List<DashboardFinancialChargeType> DashboardFinancialChargeTypeGet(Timestamp BeginDate,
			Timestamp EndDate, String type, DataFetchingEnvironment environment) {
		String query = "SELECT * FROM bh_dashboard_get_financial_charge_type(?, ?::timestamp, ?::timestamp) WHERE type = ?";
		List<Object> parameters = List.of(Env.getAD_Client_ID(BandaGraphQLContext.getCtx(environment)), BeginDate,
				EndDate, type);
		List<DashboardFinancialChargeType> results = new ArrayList<>();
		SqlUtil.executeQuery(query, parameters, null, resultSet -> {
			DashboardFinancialChargeType entity = new DashboardFinancialChargeType();
			//
			try {
				entity.setName(resultSet.getString(1));
				entity.setFrequency(resultSet.getBigDecimal(2));
				entity.setType(resultSet.getString(3));
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			//
			results.add(entity);
		});
		return results;
	}
}
