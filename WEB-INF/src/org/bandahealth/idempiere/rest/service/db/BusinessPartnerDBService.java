package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.BusinessPartner;
import org.bandahealth.idempiere.rest.model.Paging;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;

public abstract class BusinessPartnerDBService<T extends BusinessPartner> {

	protected static CLogger log = CLogger.getCLogger(BusinessPartnerDBService.class);

	protected abstract T getInstance();

	private String WHERE_CLAUSE;
	private List<Object> parameters;

	protected abstract T createInstance(MBPartner_BH bpartner);

	public BusinessPartnerDBService() {
	}

	protected void setQueryConditions(String whereClause, List<Object> parameters) {
		this.WHERE_CLAUSE = whereClause;
		this.parameters = parameters;
	}

	public BaseListResponse<T> getAll(Paging pagingInfo) {
		try {
			List<T> results = new ArrayList<>();

			Query query = new Query(Env.getCtx(), MBPartner_BH.Table_Name, WHERE_CLAUSE,
					MBPartner_BH.COLUMNNAME_Name + " IS NOT NULL").setClient_ID().setOnlyActiveRecords(true)
							.setOrderBy(MBPartner_BH.COLUMNNAME_C_BPartner_ID + " DESC");
			if (parameters != null) {
				query = query.setParameters(parameters);
			}

			// get total count without pagination parameters
			pagingInfo.setTotalRecordCount(query.count());

			// set pagination params
			query = query.setPage(pagingInfo.getPageSize(), pagingInfo.getPage());
			List<MBPartner_BH> bpartners = query.list();

			if (!bpartners.isEmpty()) {
				for (MBPartner_BH bpartner : bpartners) {
					if (bpartner != null) {
						results.add(createInstance(bpartner));
					}
				}
			}

			return new BaseListResponse<T>(results, pagingInfo);

		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	public T getBusinessPartner(String uuid) {
		try {
			MBPartner_BH bpartner = new Query(Env.getCtx(), MBPartner_BH.Table_Name,
					MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", null).setOnlyActiveRecords(true).setParameters(uuid)
							.first();

			if (bpartner != null) {
				return createInstance(bpartner);
			}
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}
}
