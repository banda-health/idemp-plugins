package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Expense;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.compiere.model.MCharge;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;

public class ExpenseDBService extends BaseDBService<Expense, MCharge> {

	private CLogger log = CLogger.getCLogger(ExpenseDBService.class);

	public ExpenseDBService() {
	}

	@Override
	public Expense saveEntity(Expense entity) {
		return null;
	}

	// retrieve a list of paginated expenses.
	public BaseListResponse<Expense> getAll(Paging pagingInfo, String sortColumn, String sortOrder) {
		try {
			List<Expense> results = new ArrayList<>();

			Query query = new Query(Env.getCtx(), MCharge.Table_Name, null, MCharge.COLUMNNAME_Name + " IS NOT NULL")
					.setClient_ID().setOnlyActiveRecords(true);

			String orderBy = getOrderBy(sortColumn, sortOrder);
			if (orderBy != null) {
				query = query.setOrderBy(orderBy);
			}

			// get total count without pagination parameters
			pagingInfo.setTotalRecordCount(query.count());

			// set pagination params
			query = query.setPage(pagingInfo.getPageSize(), pagingInfo.getPage());
			List<MCharge> expenses = query.list();

			if (!expenses.isEmpty()) {
				for (MCharge expense : expenses) {
					if (expense != null) {
						results.add(createInstanceWithDefaultFields(expense));
					}
				}
			}

			return new BaseListResponse<Expense>(results, pagingInfo);

		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	public Expense getEntity(String uuid) {
		String whereClause = MCharge.COLUMNNAME_C_Charge_UU + " = ?";

		MCharge entity = new Query(Env.getCtx(), MCharge.Table_Name, whereClause,
				MCharge.COLUMNNAME_Name + " IS NOT NULL").setClient_ID().setOnlyActiveRecords(true)
						.setParameters("S", uuid).first();

		return createInstanceWithAllFields(entity);
	}

	@Override
	protected Expense createInstanceWithDefaultFields(MCharge expense) {
		try {
			return new Expense(expense.getAD_Client_ID(), expense.getAD_Org_ID(), expense.getC_Charge_UU(),
					expense.isActive(), DateUtil.parse(expense.getCreated()), expense.getCreatedBy(), expense.getName(),
					expense.getDescription(), expense.getChargeAmt());
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
	protected MCharge getModelInstance() {
		return new MCharge(Env.getCtx(), 0, null);
	}
}
