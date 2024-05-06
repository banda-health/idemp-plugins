package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.bandahealth.idempiere.graphql.utils.QueryUtil;
import org.bandahealth.idempiere.graphql.utils.SqlUtil;
import org.compiere.util.Env;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class MBHVisitDataLoader extends X_BH_VisitDataLoader {
	public static String BH_Visit_COUNT_BY_Patient_ID_DATA_LOADER = "BH_VisitCountByPatientIdDataLoader";
	public static String BH_Visit_LAST_VISIT_DATE_BY_Patient_ID_DATA_LOADER =
			"BH_VisitLastVisitDateByPatientIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(BH_Visit_COUNT_BY_Patient_ID_DATA_LOADER,
				DataLoader.newMappedDataLoader(getCountByPatientIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
		registry.register(BH_Visit_LAST_VISIT_DATE_BY_Patient_ID_DATA_LOADER,
				DataLoader.newMappedDataLoader(getLastVisitDateByPatientIdBatchLoader(),
						getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, Integer> getCountByPatientIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			String modelName = ModelUtil.getModelFromKey(keys.iterator().next());
			Set<Integer> patientIds = keys.stream().map(ModelUtil::getIdFromKey).collect(Collectors.toSet());
			List<Object> parameters = new ArrayList<>();
			String sqlWhere = "WHERE " + MBHVisit.COLUMNNAME_BH_Visit_ID + " IN (SELECT " + MOrder_BH.COLUMNNAME_BH_Visit_ID
					+ " FROM " + MOrder_BH.Table_Name + " WHERE " + MOrder_BH.COLUMNNAME_IsSOTrx + "=? AND "
					+ MOrder_BH.COLUMNNAME_DocStatus + "!=? AND " + MOrder_BH.COLUMNNAME_AD_Client_ID + "=?) AND "
					+ MBHVisit.COLUMNNAME_Patient_ID + " IN (";

			parameters.add("Y");
			parameters.add("VO");
			parameters.add(Env.getAD_Client_ID(batchLoaderEnvironment.getContext()));
			String patientIdInWhereClause = QueryUtil.getWhereClauseAndSetParametersForSet(patientIds, parameters);

			return SqlUtil.getGroupCount(MBHVisit.Table_Name, sqlWhere + patientIdInWhereClause + ")",
							MBHVisit.COLUMNNAME_Patient_ID, parameters, (resultSet -> {
								try {
									return resultSet.getInt(1);
								} catch (SQLException e) {
									e.printStackTrace();
								}
								return 0;
							})).entrySet().stream()
					.collect(Collectors.toMap(entry -> ModelUtil.getModelKey(modelName, entry.getKey()), Map.Entry::getValue));
		});
	}

	private MappedBatchLoaderWithContext<String, Timestamp> getLastVisitDateByPatientIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			String modelName = ModelUtil.getModelFromKey(keys.iterator().next());
			Set<Integer> patientIds = keys.stream().map(ModelUtil::getIdFromKey).collect(Collectors.toSet());

			if (patientIds.isEmpty()) {
				return new HashMap<>();
			}
			List<Object> parameters = new ArrayList<>();
			String whereClause = "WHERE " + MBHVisit.COLUMNNAME_Patient_ID + " IN ("
					+ QueryUtil.getWhereClauseAndSetParametersForSet(patientIds, parameters) + ") AND "
					+ MBHVisit.COLUMNNAME_AD_Client_ID + "=?";
			parameters.add(Env.getAD_Client_ID(batchLoaderEnvironment.getContext()));

			String sql = "SELECT " + MBHVisit.COLUMNNAME_Patient_ID + ", MAX(" + MBHVisit.COLUMNNAME_BH_VisitDate
					+ ") FROM " + MBHVisit.Table_Name + " " + whereClause + " GROUP BY " + MBHVisit.COLUMNNAME_Patient_ID;

			Map<Integer, Timestamp> lastVisitDatesByPatientId = new HashMap<>();
			patientIds.forEach(patientId -> {
				lastVisitDatesByPatientId.put(patientId, null);
			});

			SqlUtil.executeQuery(sql, parameters, null, (resultSet) -> {
				try {
					lastVisitDatesByPatientId.put(resultSet.getInt(1), resultSet.getTimestamp(2));
				} catch (Exception e) {
					log.severe(e.getMessage());
				}
			});

			return lastVisitDatesByPatientId.entrySet().stream().filter(entry -> entry.getValue() != null)
					.collect(Collectors.toMap(entry -> ModelUtil.getModelKey(modelName, entry.getKey()), Map.Entry::getValue));
		});
	}
}
