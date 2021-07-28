package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.repository.OrderLineRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

	@POST
	@Path("/orders/{orderId}")
	public List<MOrderLine_BH> saveByOrder(@PathParam("orderId") int orderId, List<MOrderLine_BH> orderLines) {
		List<MOrderLine_BH> savedOrderLines = new ArrayList<>();
		// persist product/service/charge order lines
		if (orderLines != null && !orderLines.isEmpty()) {
			for (MOrderLine_BH orderLine : orderLines) {
				orderLine.setC_Order_ID(orderId);
				MOrderLine_BH savedOrderLine = orderLineRepository.save(orderLine);
				savedOrderLines.add(savedOrderLine);
			}
		}

		// delete order lines not in request
		orderLineRepository.deleteByOrder(orderId,
				savedOrderLines.stream().map(MOrderLine_BH::getC_OrderLine_UU).collect(Collectors.toList()));

		return savedOrderLines;
	}
}
