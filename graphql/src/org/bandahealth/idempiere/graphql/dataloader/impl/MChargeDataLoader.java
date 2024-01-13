package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.bandahealth.idempiere.graphql.utils.QueryUtil;
import org.bandahealth.idempiere.graphql.utils.SqlUtil;
import org.compiere.model.MTable;
import org.compiere.model.POInfo;
import org.compiere.util.Env;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class MChargeDataLoader extends X_C_ChargeDataLoader {
	public static String C_Charge_ASSOCIATED_CUSTOMER_RECEIVABLE_BY_BPARTNER_ID_DATA_LOADER =
			"C_ChargeAssociatedCustomerReceivablesByBPartnerIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(C_Charge_ASSOCIATED_CUSTOMER_RECEIVABLE_BY_BPARTNER_ID_DATA_LOADER,
				DataLoader.newMappedDataLoader(getAssociatedCustomerReceivablesByBusinessPartnerIdBatchLoader(),
						getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, MCharge_BH> getAssociatedCustomerReceivablesByBusinessPartnerIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			String modelName = ModelUtil.getModelFromKey(keys.iterator().next());
			Set<Integer> businessPartnerGroupIds = keys.stream().map(ModelUtil::getIdFromKey).collect(Collectors.toSet());

			MTable chargeTable = MTable.get(Env.getCtx(), MTable.getTable_ID(MCharge_BH.Table_Name));
			POInfo chargePO = POInfo.getPOInfo(Env.getCtx(), chargeTable.getAD_Table_ID(), null);
			String chargeSql = chargePO.buildSelect(true, true).toString().replaceAll(" FROM " + MCharge_BH.Table_Name, "");
			chargeSql += ",bpg.c_bp_group_id " +
					" FROM" +
					"   c_bp_group bpg" +
					"     JOIN c_bp_group_acct bpga" +
					"   	  ON bpg.c_bp_group_id = bpga.c_bp_group_id" +
					"     JOIN c_validcombination vc_bp" +
					"  	   ON bpga.c_receivable_acct = vc_bp.c_validcombination_id" +
					"     JOIN c_elementvalue ev_bp" +
					"   	  ON vc_bp.account_id = ev_bp.c_elementvalue_id" +
					"     JOIN c_elementvalue ev_c" +
					"   	  ON ev_bp.value = ev_c.value AND ev_bp.ad_client_id = ev_c.ad_client_id" +
					"     JOIN c_validcombination vc_c" +
					"  	   ON ev_c.c_elementvalue_id = vc_c.account_id" +
					"     JOIN c_charge_acct ca" +
					"  	   ON vc_c.c_validcombination_id = ca.ch_expense_acct" +
					"     JOIN c_charge" +
					"   	  ON ca.c_charge_id = c_charge.c_charge_id" +
					"     JOIN c_chargetype ct" +
					"   	  ON ct.c_chargetype_id = c_charge.c_chargetype_id" +
					" WHERE bpg.ad_client_id=?" +
					"   AND ct.name=?" +
					"   AND c_charge.isactive=?";
			List<Object> parameters =
					new ArrayList<>(
							List.of(Env.getAD_Client_ID(Env.getCtx()), MChargeType_BH.CHARGETYPENAME_NON_PATIENT_PAYMENT, "Y"));
			String businessPartnerGroupIdWhereClause =
					QueryUtil.getWhereClauseAndSetParametersForSet(businessPartnerGroupIds, parameters);

			Map<Integer, MCharge_BH> chargesByAssociatedBusinessPartnerGroupId = new HashMap<>();
			SqlUtil.executeQuery(chargeSql + " AND bpg.c_bp_group_id IN (" + businessPartnerGroupIdWhereClause + ")",
					parameters, null, resultSet -> {
						try {
							MCharge_BH charge = (MCharge_BH) chargeTable.getPO(resultSet, null);
							int businessPartnerGroupId = resultSet.getInt(chargePO.getColumnCount() + 1);
							chargesByAssociatedBusinessPartnerGroupId.put(businessPartnerGroupId, charge);
						} catch (SQLException ex) {
							log.severe("Error fetching associated charges");
						}
					});

			return chargesByAssociatedBusinessPartnerGroupId.entrySet().stream()
					.collect(Collectors.toMap(entry -> ModelUtil.getModelKey(modelName, entry.getKey()), Map.Entry::getValue));
		});
	}
}
