package org.bandahealth.idempiere.graphql.resolver.query;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.DashboardDiagnosisUsage;
import org.bandahealth.idempiere.graphql.model.DashboardGeneralData;
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
}
