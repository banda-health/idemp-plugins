package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.repository.BusinessPartnerRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Path(IRestConfigs.BUSINESS_PARTNERS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BusinessPartnerRestService {

	private final BusinessPartnerRepository businessPartnerRepository;

	public BusinessPartnerRestService() {
		businessPartnerRepository = new BusinessPartnerRepository();
	}

	@GET
	public Map<Integer, MBPartner_BH> get(@QueryParam("ids") Set<Integer> ids) {
		return businessPartnerRepository.getByIds(ids);
	}

	@GET
	@Path("/customers")
	public List<MBPartner_BH> getCustomers(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sort") String sort, @QueryParam("filter") String filterJson) {
		return businessPartnerRepository.getCustomers(filterJson, sort, new Paging(page, size));
	}

	@GET
	@Path("/customers/paginginfo")
	public Paging getCustomersPagingInfo(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sort") String sort, @QueryParam("filter") String filterJson) {
		return businessPartnerRepository.getCustomersPagingInfo(filterJson, sort, new Paging(page, size));
	}

	@GET
	@Path("/vendors")
	public List<MBPartner_BH> getVendors(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sort") String sort, @QueryParam("filter") String filterJson) {
		return businessPartnerRepository.getVendors(filterJson, sort, new Paging(page, size));
	}

	@GET
	@Path("/vendors/paginginfo")
	public Paging getVendorsPagingInfo(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sort") String sort, @QueryParam("filter") String filterJson) {
		return businessPartnerRepository.getVendorsPagingInfo(filterJson, sort, new Paging(page, size));
	}
}
