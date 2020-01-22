package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Paging;
import org.compiere.util.Env;
import org.bandahealth.idempiere.rest.model.Service;
import org.bandahealth.idempiere.rest.utils.DateUtil;

/*
 * All Service DB Operations
 */
public class ServiceDBService extends BaseDBService<Service, MProduct_BH> {

	// retrieve a list of paginated services.
	public BaseListResponse<Service> getAll(Paging pagingInfo, String sortColumn, String sortOrder) {
		List<Object> parameters = new ArrayList<>();
		parameters.add(MProduct_BH.PRODUCTTYPE_Service);

		return super.getAll(MProduct_BH.COLUMNNAME_ProductType + " = ?", parameters, pagingInfo, sortColumn, sortOrder);
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
		return null;
	}

	@Override
	protected MProduct_BH getModelInstance() {
		return new MProduct_BH(Env.getCtx(), 0, null);
	}
}
