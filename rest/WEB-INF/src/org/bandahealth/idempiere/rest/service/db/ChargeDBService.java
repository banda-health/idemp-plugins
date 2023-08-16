package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.rest.model.Account;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Charge;
import org.bandahealth.idempiere.rest.model.ChargeType;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MElementValue;
import org.compiere.model.Query;
import org.compiere.model.X_C_Charge_Acct;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ChargeDBService extends BaseDBService<Charge, MCharge_BH> {
	@Autowired
	private AccountDBService accountDBService;
	@Autowired
	private ChargeTypeDBService chargeTypeDBService;
	@Autowired
	private ChargeAccountDBService chargeAccountDBService;
	@Autowired
	private ValidCombinationDBService validCombinationDBService;

	@Override
	public Charge saveEntity(Charge entity) {
		// Save to the DB
		MCharge_BH charge = getEntityByUuidFromDB(entity.getUuid());
		if (charge == null) {
			charge = getModelInstance();
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				charge.setC_Charge_UU(entity.getUuid());
			}
		}

		ModelUtil.setPropertyIfPresent(entity.getName(), charge::setName);
		ModelUtil.setPropertyIfPresent(entity.getDescription(), charge::setDescription);

		if (entity.getAccount() != null) {
			MElementValue account = accountDBService.getEntityByUuidFromDB(entity.getAccount().getUuid());
			if (account != null) {
				X_C_Charge_Acct chargeAccount =
						new Query(Env.getCtx(), X_C_Charge_Acct.Table_Name, X_C_Charge_Acct.COLUMNNAME_C_Charge_ID + "=?",
								null).setParameters(charge.getC_Charge_ID()).first();
				chargeAccount.setCh_Expense_Acct(
						MAccount.get(Env.getCtx(), Env.getAD_Client_ID(Env.getCtx()), 0, chargeAccount.getC_AcctSchema_ID(),
										account.getC_ElementValue_ID(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null)
								.getC_ValidCombination_ID());
				chargeAccount.saveEx();
			}
		}

		charge.setIsActive(entity.getIsActive());

		if (entity.getChargeType() != null) {
			MChargeType_BH chargeType = chargeTypeDBService.getEntityByUuidFromDB(entity.getChargeType().getUuid());
			if (chargeType != null) {
				charge.setC_ChargeType_ID(chargeType.getC_ChargeType_ID());
			}
		}

		charge.saveEx();
		entity.setId(charge.getC_Charge_ID());

		return transformData(Collections.singletonList(getEntityByUuidFromDB(charge.getC_Charge_UU()))).get(0);
	}

	@Override
	public Charge getEntity(String uuid) {
		return transformData(Collections.singletonList(getEntityByUuidFromDB(uuid))).get(0);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected Charge createInstanceWithDefaultFields(MCharge_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Charge createInstanceWithAllFields(MCharge_BH instance) {
		return transformData(Collections.singletonList(instance)).get(0);
	}

	@Override
	protected MCharge_BH getModelInstance() {
		return new MCharge_BH(Env.getCtx(), 0, null);
	}

	@Override
	public List<Charge> transformData(List<MCharge_BH> dbModels) {
		// Batch call to get accounts
		Map<Integer, X_C_Charge_Acct> chargeAccountsByChargeId =
				chargeAccountDBService.getGroupsByIds(X_C_Charge_Acct::getC_Charge_ID, X_C_Charge_Acct.COLUMNNAME_C_Charge_ID,
						dbModels.stream().map(MCharge_BH::getC_Charge_ID).collect(Collectors.toSet())).entrySet().stream().collect(
						Collectors.toMap(Map.Entry::getKey,
								chargeAccountListForCharge -> chargeAccountListForCharge.getValue().get(0)));
		Map<Integer, MAccount> validCombinationsByValidCombinationId = validCombinationDBService.getByIds(
				chargeAccountsByChargeId.values().stream().map(X_C_Charge_Acct::getCh_Expense_Acct)
						.collect(Collectors.toSet()));

		Map<Integer, MElementValue> accountsById = accountDBService.getByIds(
				validCombinationsByValidCombinationId.values().stream().map(MAccount::getAccount_ID)
						.collect(Collectors.toSet()));

		// Batch call to get charge types
		Map<Integer, MChargeType_BH> chargeTypesById =
				chargeTypeDBService.getByIds(dbModels.stream().map(MCharge_BH::getC_ChargeType_ID).collect(Collectors.toSet()));

		return dbModels.stream().map(charge -> {
			Charge chargeToReturn = new Charge(charge);

			// Now fill in the child data
			if (chargeTypesById.containsKey(charge.getC_ChargeType_ID())) {
				chargeToReturn.setChargeType(new ChargeType(chargeTypesById.get(charge.getC_ChargeType_ID())));
			}
			chargeToReturn.setAccount(new Account(accountsById.get(validCombinationsByValidCombinationId.get(
					chargeAccountsByChargeId.get(charge.getC_Charge_ID()).getCh_Expense_Acct()).getAccount_ID())));

			return chargeToReturn;
		}).collect(Collectors.toList());
	}
}
