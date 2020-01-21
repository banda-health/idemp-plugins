package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Paging;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.bandahealth.idempiere.rest.model.Service;
import org.bandahealth.idempiere.rest.utils.DateUtil;

/*
 * All Service DB Operations
 */
public class ServiceDBService extends BaseDBService<Service, MProduct_BH> {

	private CLogger log = CLogger.getCLogger(ServiceDBService.class);

	public ServiceDBService() {
	}

	// retrieve a list of paginated services.
	public BaseListResponse<Service> getAll(Paging pagingInfo, String sortColumn, String sortOrder) {
		try {
			List<Service> results = new ArrayList<>();

			String whereClause = MProduct_BH.COLUMNNAME_ProductType + " = ?";

			Query query = new Query(Env.getCtx(), MProduct_BH.Table_Name, whereClause,
					MProduct_BH.COLUMNNAME_Name + " IS NOT NULL").setClient_ID().setOnlyActiveRecords(true)
							.setParameters("S");

			String orderBy = getOrderBy(sortColumn, sortOrder);
			if (orderBy != null) {
				query = query.setOrderBy(orderBy);
			}

			// get total count without pagination parameters
			pagingInfo.setTotalRecordCount(query.count());

			// set pagination params
			query = query.setPage(pagingInfo.getPageSize(), pagingInfo.getPage());
			List<MProduct_BH> services = query.list();

			if (!services.isEmpty()) {
				for (MProduct_BH service : services) {
					if (service != null) {
						results.add(createInstanceWithDefaultFields(service));
					}
				}
			}

			return new BaseListResponse<Service>(results, pagingInfo);

		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	public Service getEntity(String uuid) {
		String whereClause = MProduct_BH.COLUMNNAME_ProductType + " = ? AND " + MProduct_BH.COLUMNNAME_M_Product_UU
				+ " = ?";

		MProduct_BH entity = new Query(Env.getCtx(), MProduct_BH.Table_Name, whereClause,
				MProduct_BH.COLUMNNAME_Name + " IS NOT NULL").setClient_ID().setOnlyActiveRecords(true)
						.setParameters("S", uuid).first();

		return createInstanceWithAllFields(entity);
	}

	@Override
	protected Service createInstanceWithDefaultFields(MProduct_BH service) {
		try {
			return new Service(service.getAD_Client_ID(), service.getAD_Org_ID(), service.getM_Product_UU(),
					service.isActive(), DateUtil.parse(service.getCreated()), service.getCreatedBy(), service.getName(),
					service.getDescription(), service.getBH_SellPrice());
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	@Override
	protected Service createInstanceWithAllFields(MProduct_BH instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected MProduct_BH getModelInstance() {
		return new MProduct_BH(Env.getCtx(), 0, null);
	}
}
