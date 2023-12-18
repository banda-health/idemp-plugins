package org.bandahealth.idempiere.rest.service.db;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.InOut;
import org.bandahealth.idempiere.rest.model.InOutLine;
import org.compiere.model.MInOutLine;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InOutLineDBService extends BaseDBService<InOutLine, MInOutLine> {
	@Autowired
	private InOutDBService inOutDBService;

	@Override
	public InOutLine saveEntity(InOutLine entity) {
		throw new NotImplementedException();
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected InOutLine createInstanceWithDefaultFields(MInOutLine instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected InOutLine createInstanceWithAllFields(MInOutLine instance) {
		return transformData(Collections.singletonList(instance)).get(0);
	}

	@Override
	protected MInOutLine getModelInstance() {
		return new MInOutLine(Env.getCtx(), 0, null);
	}

	@Override
	public List<InOutLine> transformData(List<MInOutLine> dbModels) {
		// Get in-outs
		Map<Integer, MInOut_BH> inOutsById = inOutDBService.getByIds(dbModels.stream().map(MInOutLine::getM_InOut_ID)
				.filter(inOutId -> inOutId > 0).collect(Collectors.toSet()));

		dbModels.stream().map(mInOutLine -> {
			InOutLine inOutLine = new InOutLine(mInOutLine);

			if (inOutsById.containsKey(mInOutLine.getM_InOut_ID())) {
				inOutLine.setInOut(new InOut(inOutsById.get(mInOutLine.getM_InOut_ID())));
			}

			return inOutLine;

		}).collect(Collectors.toList());

		return super.transformData(dbModels);
	}
}
