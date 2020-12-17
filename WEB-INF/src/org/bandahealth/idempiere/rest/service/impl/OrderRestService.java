package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.repository.OrderRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Path(IRestConfigs.ORDERS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrderRestService {

	private final OrderRepository orderRepository;

	public OrderRestService() {
		orderRepository = new OrderRepository();
	}

	@GET
	public Map<Integer, MOrder_BH> getByIds(@QueryParam("ids") Set<Integer> ids) {
		return orderRepository.getByIds(ids);
	}

	@GET
	@Path("/sales")
	public List<MOrder_BH> getSalesOrders(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sort") String sort, @QueryParam("filter") String filterJson) {
		return orderRepository.getSalesOrders(filterJson, sort, new Paging(page, size));
	}

	@GET
	@Path("/sales/paginginfo")
	public Paging getPagingInfo(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sort") String sort, @QueryParam("filter") String filterJson) {
		return orderRepository.getSalesOrdersPagingInfo(filterJson, sort, new Paging(page, size));
	}

	@GET
	@Path("/sales/businesspartners")
	public Map<Integer, List<MOrder_BH>> getSalesOrdersByBusinessPartners(@QueryParam("ids") Set<Integer> ids) {
		return orderRepository.getGroupsByIds(MOrder_BH::getC_BPartner_ID, MOrder_BH.COLUMNNAME_C_BPartner_ID, ids);
	}
}
