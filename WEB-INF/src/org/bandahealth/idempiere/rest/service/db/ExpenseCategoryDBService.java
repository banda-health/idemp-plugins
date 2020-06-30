package org.bandahealth.idempiere.rest.service.db;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Expense;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MCharge;
import org.compiere.util.CLogger;
import org.compiere.util.Env;

import java.util.ArrayList;
import java.util.List;

/**
 * Expense (charge) related db operations
 * 
 * @author andrew
 *
 */
public class ExpenseDBService extends BaseDBService<Expense, MCharge> {

	private CLogger log = CLogger.getCLogger(ExpenseDBService.class);

	public ExpenseDBService() {
	}

	@Override
	public Expense saveEntity(Expense entity) {
		try {
			MCharge charge = getEntityByUuidFromDB(entity.getUuid());
			if (charge == null) {
				charge = getModelInstance();
			}

			if (StringUtil.isNotNullAndEmpty(entity.getName())) {
				charge.setName(entity.getName());
			}

			if (entity.getAmount() != null) {
				charge.setChargeAmt(entity.getAmount());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getDescription())) {
				charge.setDescription(entity.getDescription());
			}

			charge.setIsActive(entity.isIsActive());

			charge.saveEx();

			return createInstanceWithAllFields(getEntityByUuidFromDB(charge.getC_Charge_UU()));

		} catch (Exception ex) {
			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}

	public BaseListResponse<Expense> getAll(Paging pagingInfo, String sortColumn, String sortOrder) {
		return super.getAll(null, null, pagingInfo, sortColumn, sortOrder);
	}

	public BaseListResponse<Expense> search(String value, Paging pagingInfo, String sortColumn, String sortOrder) {
		List<Object> parameters = new ArrayList<>();
		parameters.add("%" + value + "%");

		return this.search(this.DEFAULT_SEARCH_CLAUSE, parameters, pagingInfo, sortColumn, sortOrder);
	}

	@Override
	protected Expense createInstanceWithDefaultFields(MCharge expense) {
		try {
			return new Expense(expense.getAD_Client_ID(), expense.getAD_Org_ID(), expense.getC_Charge_UU(),
					expense.isActive(), DateUtil.parseDateOnly(expense.getCreated()), expense.getCreatedBy(),
					expense.getName(), expense.getDescription(), expense.getChargeAmt());
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	@Override
	protected Expense createInstanceWithAllFields(MCharge expense) {
		return createInstanceWithDefaultFields(expense);
	}

	@Override
	protected Expense createInstanceWithSearchFields(MCharge expense) {
		try {
			return new Expense(expense.getC_Charge_UU(), expense.getName(), expense.getChargeAmt(),
					DateUtil.parseDateOnly(expense.getCreated()), expense.getDescription(), expense.isActive());
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	@Override
	protected MCharge getModelInstance() {
		return new MCharge(Env.getCtx(), 0, null);
	}
}
