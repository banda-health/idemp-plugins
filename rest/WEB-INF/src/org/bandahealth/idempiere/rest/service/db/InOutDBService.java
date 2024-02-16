package org.bandahealth.idempiere.rest.service.db;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.InOut;
import org.bandahealth.idempiere.rest.model.Order;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InOutDBService extends BaseDBService<InOut, MInOut_BH> {
	@Autowired
	private OrderDBService orderDBService;

	@Override
	public InOut saveEntity(InOut entity) {
		throw new NotImplementedException();
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected InOut createInstanceWithDefaultFields(MInOut_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected InOut createInstanceWithAllFields(MInOut_BH instance) {
		return transformData(Collections.singletonList(instance)).get(0);
	}

	@Override
	protected MInOut_BH getModelInstance() {
		return new MInOut_BH(Env.getCtx(), 0, null);
	}

	@Override
	public List<InOut> transformData(List<MInOut_BH> dbModels) {
		// Get orders
		Map<Integer, MOrder_BH> ordersById = orderDBService.getByIds(dbModels.stream().map(MInOut_BH::getC_Order_ID)
				.filter(orderId -> orderId > 0).collect(Collectors.toSet()));

		dbModels.stream().map(mInOut -> {
			InOut inOut = new InOut(mInOut);

			if (ordersById.containsKey(mInOut.getC_Order_ID())) {
				inOut.setOrder(new Order(ordersById.get(mInOut.getC_Order_ID())));
			}

			return inOut;

		}).collect(Collectors.toList());

		return super.transformData(dbModels);
	}
}
