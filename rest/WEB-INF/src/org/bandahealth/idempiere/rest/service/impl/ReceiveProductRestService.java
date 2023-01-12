package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.ReceiveProduct;
import org.bandahealth.idempiere.rest.service.DocumentRestService;
import org.bandahealth.idempiere.rest.service.db.ReceiveProductDBService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Expense Receive Product REST functionality
 *
 * @author andrew
 */
@Path(IRestConfigs.RECEIVE_PRODUCTS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReceiveProductRestService extends DocumentRestService<ReceiveProduct, MOrder_BH, ReceiveProductDBService> {

	@Autowired
	private ReceiveProductDBService dbService;

	@Override
	protected ReceiveProductDBService getDBService() {
		return dbService;
	}
}
