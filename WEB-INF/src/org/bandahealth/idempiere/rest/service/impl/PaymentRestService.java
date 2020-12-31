package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.Payment;
import org.bandahealth.idempiere.rest.repository.OrderRepository;
import org.bandahealth.idempiere.rest.repository.PaymentRepository;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.PaymentDBService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Path(IRestConfigs.PAYMENTS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PaymentRestService extends BaseEntityRestService<Payment> {

	private final OrderRepository orderRepository;
	private final PaymentRepository paymentRepository;
	private PaymentDBService dbService;

	public PaymentRestService() {
		dbService = new PaymentDBService();
		orderRepository = new OrderRepository();
		paymentRepository = new PaymentRepository();
	}

	@POST
	@Path(IRestConfigs.ROOT_PATH)
	@Override
	public BaseListResponse<Payment> getAll(
			@QueryParam("page") int page, @QueryParam("size") int size, @QueryParam("sortColumn") String sortColumn,
			@QueryParam("sortOrder") String sortOrder, @QueryParam("filter") String filterJson) {
		return dbService.getAll(getPagingInfo(page, size), sortColumn, sortOrder, filterJson);
	}

	@POST
	@Path(IRestConfigs.PAYMENT_PATH)
	@Override
	public Payment getEntity(@PathParam("uuid") String uuid) {
		return dbService.getEntity(uuid);
	}

	@POST
	@Path(IRestConfigs.SAVE_PATH)
	@Override
	public Payment saveEntity(Payment entity) {
		return dbService.saveEntity(entity);
	}

	@POST
	@Path(IRestConfigs.ENTITY_PROCESS_PATH)
	public Payment processPayment(@PathParam("uuid") String uuid) {
		return dbService.processPayment(uuid);
	}

	@POST
	@Path(IRestConfigs.ENTITY_SAVE_AND_PROCESS_PATH)
	public Payment saveAndProcessVisit(Payment entity) {
		return dbService.saveAndProcessPayment(entity);
	}

	@POST
	@Path(IRestConfigs.SEARCH_PATH)
	@Override
	public BaseListResponse<Payment> search(@QueryParam("value") String value, @QueryParam("page") int page,
			@QueryParam("size") int size, @QueryParam("sortColumn") String sortColumn,
			@QueryParam("sortOrder") String sortOrder) {
		return dbService.search(value, getPagingInfo(page, size), sortColumn, sortOrder);
	}

	@GET
	@Path("/servicedebts")
	public List<MPayment_BH> getServiceDebts(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sort") String sort, @QueryParam("filter") String filterJson) {
		return paymentRepository.getServiceDebtPayments(filterJson, sort, getPagingInfo(page, size));
	}

	@GET
	@Path("/servicedebts/paginginfo")
	public Paging getServiceDebtsPagingInfo(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sort") String sort, @QueryParam("filter") String filterJson) {
		return paymentRepository.getServiceDebtPaymentsPagingInfo(filterJson, sort, getPagingInfo(page, size));
	}

	@GET
	@Path("/orders")
	public Map<Integer, List<MPayment_BH>> getByOrderIds(@QueryParam("ids") Set<Integer> ids) {
		return paymentRepository.getByOrderIds(ids);
	}

	@GET
	@Path("/businesspartners")
	public Map<Integer, List<MPayment_BH>> getByBusinessPartnerIds(@QueryParam("ids") Set<Integer> ids) {
		return paymentRepository.getGroupsByIds(MPayment_BH::getC_BPartner_ID, MPayment_BH.COLUMNNAME_C_BPartner_ID, ids);
	}

	@POST
	@Path("/orders/{orderId}")
	public List<MPayment_BH> saveByOrder(int orderId, List<MPayment_BH> payments) {
		MOrder_BH order = orderRepository.getById(orderId);
		List<MPayment_BH> savedPaymentes = new ArrayList<>();
		for (MPayment_BH payment : payments) {
			payment.setC_Order_ID(orderId);
			if (order.getC_BPartner_ID() > 0) {
				payment.setC_BPartner_ID(order.getC_BPartner_ID());
			}
			savedPaymentes.add(paymentRepository.save(payment));
		}

		// delete payment lines not in request
		paymentRepository.deleteByOrder(orderId,
				savedPaymentes.stream().map(MPayment_BH::getC_Payment_UU).collect(Collectors.toList()));

		return savedPaymentes;
	}
}
