package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.repository.ChargeRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Path(IRestConfigs.CHARGES_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ChargeRestService {

	private final ChargeRepository chargeRepository;

	public ChargeRestService() {
		chargeRepository = new ChargeRepository();
	}

	@GET
	public Map<Integer, MCharge_BH> get(@QueryParam("ids") Set<Integer> ids) {
		return chargeRepository.getByIds(ids);
	}

	@GET
	@Path("/expensecategories")
	public List<MCharge_BH> getSalesOrders(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sort") String sort, @QueryParam("filter") String filterJson) {
		return chargeRepository.getExpenseCategories(filterJson, sort, new Paging(page, size));
	}

	@GET
	@Path("/expensecategories/paginginfo")
	public Paging getPagingInfo(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sort") String sort, @QueryParam("filter") String filterJson) {
		return chargeRepository.getExpenseCategoriesPagingInfo(filterJson, sort, new Paging(page, size));
	}

	@GET
	@Path("/{uuid}")
	public MCharge_BH getByUuid(@PathParam("uuid") String uuid) {
		return chargeRepository.getByUuid(uuid);
	}
}
