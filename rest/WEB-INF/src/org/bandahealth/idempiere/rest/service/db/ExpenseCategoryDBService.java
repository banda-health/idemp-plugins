package org.bandahealth.idempiere.rest.service.db;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.ExpenseCategory;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MElementValue;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Expense Category (charge) related db operations
 *
 * @author andrew
 */
@Component
public class ExpenseCategoryDBService extends BaseDBService<ExpenseCategory, MCharge_BH> {

	private CLogger log = CLogger.getCLogger(ExpenseCategoryDBService.class);
	@Autowired
	private AccountDBService accountDBService;

	@Override
	public ExpenseCategory saveEntity(ExpenseCategory entity) {
		try {
			MCharge_BH charge = getEntityByUuidFromDB(entity.getUuid());
			if (charge == null) {
				charge = getModelInstance();
				if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
					charge.setC_Charge_UU(entity.getUuid());
				}
			}

			if (StringUtil.isNotNullAndEmpty(entity.getName())) {
				charge.setName(entity.getName());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getDescription())) {
				charge.setDescription(entity.getDescription());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getAccountUuid())) {
				MElementValue account = accountDBService.getEntityByUuidFromDB(entity.getAccountUuid());
				if (account != null) {
					charge.setC_ElementValue_ID(account.getC_ElementValue_ID());
				}
			}

			charge.setIsActive(entity.getIsActive());

			MChargeType_BH expenseCategoryChargeType = new Query(
					Env.getCtx(),
					MChargeType_BH.Table_Name,
					MChargeType_BH.COLUMNNAME_Name + "=?",
					null
			)
					.setParameters(MChargeType_BH.CHARGETYPENAME_DEFAULT_EXPENSE_CATEGORY)
					.setClient_ID()
					.first();
			if (expenseCategoryChargeType == null) {
				throw new AdempiereException("Expense Category Charge Type not defined for client");
			}
			charge.setC_ChargeType_ID(expenseCategoryChargeType.getC_ChargeType_ID());

			charge.saveEx();

			return createInstanceWithAllFields(getEntityByUuidFromDB(charge.getC_Charge_UU()));

		} catch (Exception ex) {
			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}

	public BaseListResponse<ExpenseCategory> getAll(Paging pagingInfo, String sortJson, String filterJson) {
		String whereClause = MChargeType_BH.Table_Name + "." + MChargeType_BH.COLUMNNAME_Name + "=?";
		List<Object> parameters = new ArrayList<>() {{
			add(MChargeType_BH.CHARGETYPENAME_DEFAULT_EXPENSE_CATEGORY);
		}};
		String joinClause = "JOIN " + MChargeType_BH.Table_Name + " ON " + MChargeType_BH.Table_Name + "." +
				MChargeType_BH.COLUMNNAME_C_ChargeType_ID + "=" + MCharge_BH.Table_Name + "." +
				MCharge_BH.COLUMNNAME_C_ChargeType_ID;
		return super.getAll(whereClause, parameters, pagingInfo, sortJson, filterJson, joinClause);
	}

	public BaseListResponse<ExpenseCategory> search(String value, Paging pagingInfo, String sortColumn,
			String sortOrder) {
		List<Object> parameters = new ArrayList<>();
		parameters.add(constructSearchValue(value));
		parameters.add(MChargeType_BH.CHARGETYPENAME_DEFAULT_EXPENSE_CATEGORY);
		String whereClause =
				DEFAULT_SEARCH_CLAUSE + " " + MChargeType_BH.Table_Name + "." + MChargeType_BH.COLUMNNAME_Name + "=?";
		String joinClause = "JOIN " + MChargeType_BH.Table_Name + " ON " + MChargeType_BH.Table_Name + "." +
				MChargeType_BH.COLUMNNAME_C_ChargeType_ID + "=" + MCharge_BH.Table_Name + "." +
				MCharge_BH.COLUMNNAME_C_ChargeType_ID;

		return this.search(whereClause, parameters, pagingInfo, sortColumn, sortOrder, joinClause);
	}

	@Override
	protected ExpenseCategory createInstanceWithDefaultFields(MCharge_BH expense) {
		try {
			MElementValue account = accountDBService.getEntityByIdFromDB(expense.getC_ElementValue_ID());
			return new ExpenseCategory(expense.getAD_Client_ID(), expense.getAD_Org_ID(), expense.getC_Charge_UU(),
					expense.isActive(), DateUtil.parseDateOnly(expense.getCreated()), expense.getCreatedBy(),
					expense.getName(), expense.getDescription(), expense.isBH_Locked(), account.getC_ElementValue_UU());
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	@Override
	protected ExpenseCategory createInstanceWithAllFields(MCharge_BH expense) {
		return createInstanceWithDefaultFields(expense);
	}

	@Override
	protected ExpenseCategory createInstanceWithSearchFields(MCharge_BH expense) {
		try {
			MElementValue account = accountDBService.getEntityByIdFromDB(expense.getC_ElementValue_ID());
			return new ExpenseCategory(expense.getC_Charge_UU(), expense.getName(), expense.isBH_Locked(),
					DateUtil.parseDateOnly(expense.getCreated()), expense.getDescription(), expense.isActive(),
					account.getC_ElementValue_UU());
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	@Override
	protected MCharge_BH getModelInstance() {
		return new MCharge_BH(Env.getCtx(), 0, null);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		// TODO Auto-generated method stub
		return null;
	}
}
