package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.BusinessPartnerGroup;
import org.bandahealth.idempiere.rest.model.Charge;
import org.bandahealth.idempiere.rest.model.ReferenceList;
import org.bandahealth.idempiere.rest.utils.QueryUtil;
import org.bandahealth.idempiere.rest.utils.SqlUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MRefList;
import org.compiere.model.MTable;
import org.compiere.model.POInfo;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class BusinessPartnerGroupDBService extends BaseDBService<BusinessPartnerGroup, MBPGroup_BH> {
	@Autowired
	private ReferenceListDBService referenceListDBService;

	@Override
	public BusinessPartnerGroup saveEntity(BusinessPartnerGroup entity) {
		throw new NotImplementedException();
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected BusinessPartnerGroup createInstanceWithDefaultFields(MBPGroup_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected BusinessPartnerGroup createInstanceWithAllFields(MBPGroup_BH instance) {
		return new BusinessPartnerGroup(instance);
	}

	@Override
	protected MBPGroup_BH getModelInstance() {
		return new MBPGroup_BH(Env.getCtx(), 0, null);
	}

	@Override
	public List<BusinessPartnerGroup> transformData(List<MBPGroup_BH> dbModels) {
		// Batch call to get reference lists for BP groups
		Map<String, MRefList> subTypeByValue = referenceListDBService
				.getTypes(MReference_BH.NON_PATIENT_PAYER_AD_REFERENCE_UU,
						dbModels.stream().map(MBPGroup_BH::getBH_SubType).collect(Collectors.toSet())).stream()
				.collect(Collectors.toMap(MRefList::getValue, referenceList -> referenceList));

		// Get associated customer receivables account charges
		MTable chargeTable = MTable.get(MTable.getTable_ID(MCharge_BH.Table_Name));
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
		String businessPartnerGroupIdWhereClause = QueryUtil.getWhereClauseAndSetParametersForSet(
				dbModels.stream().map(MBPGroup_BH::get_ID).collect(Collectors.toSet()), parameters);

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

		return dbModels.stream().map(businessPartnerGroup -> {
			BusinessPartnerGroup businessPartnerGroupToReturn = new BusinessPartnerGroup(businessPartnerGroup);

			// Now fill in the child data
			if (!StringUtil.isNullOrEmpty(businessPartnerGroup.getBH_SubType()) &&
					subTypeByValue.containsKey(businessPartnerGroup.getBH_SubType())) {
				businessPartnerGroupToReturn.setSubType(
						new ReferenceList(subTypeByValue.get(businessPartnerGroup.getBH_SubType())));
			}
			if (chargesByAssociatedBusinessPartnerGroupId.containsKey(businessPartnerGroup.get_ID())) {
				businessPartnerGroupToReturn.setAssociatedCustomerReceivablesCharge(
						new Charge(chargesByAssociatedBusinessPartnerGroupId.get(businessPartnerGroup.get_ID())));
			}

			return businessPartnerGroupToReturn;
		}).collect(Collectors.toList());
	}
}
