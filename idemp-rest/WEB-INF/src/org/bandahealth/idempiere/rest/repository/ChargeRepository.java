package org.bandahealth.idempiere.rest.repository;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ChargeRepository extends BaseRepository<MCharge_BH> {

	@Override
	protected MCharge_BH createModelInstance() {
		return new MCharge_BH(Env.getCtx(), 0, null);
	}

	@Override
	public MCharge_BH mapInputModelToModel(MCharge_BH entity) {
		try {
			MCharge_BH charge = getByUuid(entity.getC_Charge_UU());
			if (charge == null) {
				charge = createModelInstance();
			}

			ModelUtil.setPropertyIfPresent(entity.getName(), charge::setName);
			ModelUtil.setPropertyIfPresent(entity.getDescription(), charge::setDescription);

//			if (entity.getAccount() != null) {
//				MElementValue account = accountRepository.getByUuid(entity.getAccount().getC_ElementValue_UU(),
//						idempiereContext);
//				if (account != null) {
			charge.setC_ElementValue_ID(entity.getC_ElementValue_ID());
//				}
//			}

			ModelUtil.setPropertyIfPresent(entity.isActive(), charge::setIsActive);
//			if (entity.getChargeType() != null) {
			charge.setC_ChargeType_ID(entity.getC_ChargeType_ID());
//			}

			return charge;
		} catch (Exception ex) {
			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}

	public MCharge_BH saveExpenseCategory(MCharge_BH charge) {
		MChargeType_BH expenseCategoryChargeType = new Query(Env.getCtx(), MChargeType_BH.Table_Name,
				MChargeType_BH.COLUMNNAME_Name + "=?", null)
				.setParameters(MChargeType_BH.CHARGETYPENAME_DEFAULT_CATEGORY).first();
		if (expenseCategoryChargeType == null) {
			throw new AdempiereException("Expense Category Charge Type not defined for client");
		}
		charge.setC_ChargeType_ID(expenseCategoryChargeType.getC_ChargeType_ID());
		return save(charge);
	}

	@Override
	public String getDefaultJoinClause() {
		return " JOIN " + MChargeType_BH.Table_Name + " ON " + MChargeType_BH.Table_Name + "." +
				MChargeType_BH.COLUMNNAME_C_ChargeType_ID + "=" + MCharge_BH.Table_Name + "." +
				MCharge_BH.COLUMNNAME_C_ChargeType_ID;
	}

	public List<MCharge_BH> getExpenseCategories(String filterJson, String sortJson, Paging pagingInfo) {
		List<Object> parameters = new ArrayList<>() {{
			add(MChargeType_BH.CHARGETYPENAME_DEFAULT_CATEGORY);
		}};

		return get(filterJson, sortJson, pagingInfo, MChargeType_BH.Table_Name + "." +
				MChargeType_BH.COLUMNNAME_Name + "=?", parameters);
	}

	public Paging getExpenseCategoriesPagingInfo(String filterJson, String sortJson, Paging pagingInfo) {
		List<Object> parameters = new ArrayList<>() {{
			add(MChargeType_BH.CHARGETYPENAME_DEFAULT_CATEGORY);
		}};

		return getPagingInfo(filterJson, sortJson, pagingInfo, MChargeType_BH.Table_Name + "." +
				MChargeType_BH.COLUMNNAME_Name + "=?", parameters);
	}
}
