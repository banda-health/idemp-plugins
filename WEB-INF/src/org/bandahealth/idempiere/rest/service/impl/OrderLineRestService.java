package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.repository.OrderLineRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Path(IRestConfigs.ORDER_LINES_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrderLineRestService {

	private final OrderLineRepository orderLineRepository;

	public OrderLineRestService() {
		orderLineRepository = new OrderLineRepository();
	}

	@GET
	@Path("/orders")
	public Map<Integer, List<MOrderLine_BH>> getByOrderIds(@QueryParam("ids") Set<Integer> ids) {
		return orderLineRepository.getGroupsByIds(MOrderLine_BH::getC_Order_ID, MOrderLine_BH.COLUMNNAME_C_Order_ID, ids);
	}
}
