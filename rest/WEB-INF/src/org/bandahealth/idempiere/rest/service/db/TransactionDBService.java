package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.InOutLine;
import org.bandahealth.idempiere.rest.model.Transaction;
import org.compiere.model.MInOutLine;
import org.compiere.model.MTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TransactionDBService extends BaseDBService<Transaction, MTransaction> {
	@Autowired
	private InOutDBService inOutDBService;
	@Autowired
	private InOutLineDBService inOutLineDBService;
	@Autowired
	private OrderDBService orderDBService;

	@Override
	public Transaction saveEntity(Transaction entity) {
		throw new NotImplementedException();
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected Transaction createInstanceWithDefaultFields(MTransaction instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Transaction createInstanceWithAllFields(MTransaction instance) {
		return transformData(Collections.singletonList(instance)).get(0);
	}

	@Override
	protected MTransaction getModelInstance() {
		return null;
	}

	@Override
	public List<Transaction> transformData(List<MTransaction> dbModels) {
		// At this point, we won't link to inventory records, so we'll just ignore them

		// Get in-out lines
		Set<Integer> inOutLineIds =
				dbModels.stream().map(MTransaction::getM_InOutLine_ID).filter(inOutLineId -> inOutLineId > 0)
						.collect(Collectors.toSet());
		Map<Integer, MInOutLine> inOutLinesById =
				inOutLineIds.isEmpty() ? new HashMap<>() : inOutLineDBService.getByIds(inOutLineIds);

		// Get in-outs
		Set<Integer> inOutIds =
				inOutLinesById.values().stream().map(MInOutLine::getM_InOut_ID).filter(inOutId -> inOutId > 0)
						.collect(Collectors.toSet());
		Map<Integer, MInOut_BH> inOutsById =
				inOutIds.isEmpty() ? new HashMap<>() : inOutDBService.getByIds(inOutIds);

		// Get orders
		Set<Integer> orderIds =
				inOutsById.values().stream().map(MInOut_BH::getC_Order_ID).filter(orderId -> orderId > 0)
						.collect(Collectors.toSet());
		Map<Integer, MOrder_BH> ordersById =
				inOutIds.isEmpty() ? new HashMap<>() : orderDBService.getByIds(orderIds);
		return super.transformData(dbModels);
	}
}
