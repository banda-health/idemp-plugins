package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.StockTakeItem;
import org.bandahealth.idempiere.rest.model.Paging;

public class StockTakeDBService {
	
	public BaseListResponse<StockTakeItem> getAll(Paging pagingInfo, String sortColumn, String sortOrder) {
		List<Object> parameters = new ArrayList<>();
		parameters.add("Y");
		return null;
	}

}
