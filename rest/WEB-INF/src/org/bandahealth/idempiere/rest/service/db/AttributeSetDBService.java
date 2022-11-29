package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MSerNoCtl_BH;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.AttributeSet;
import org.bandahealth.idempiere.rest.model.SerialNumberControl;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AttributeSetDBService extends BaseDBService<AttributeSet, MAttributeSet_BH> {
	@Autowired
	private SerialNumberControlDBService serialNumberControlDBService;

	@Override
	public AttributeSet saveEntity(AttributeSet entity) {
		throw new NotImplementedException();
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected AttributeSet createInstanceWithDefaultFields(MAttributeSet_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected AttributeSet createInstanceWithAllFields(MAttributeSet_BH instance) {
		return new AttributeSet(instance);
	}

	@Override
	protected AttributeSet createInstanceWithSearchFields(MAttributeSet_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MAttributeSet_BH getModelInstance() {
		return new MAttributeSet_BH(Env.getCtx(), 0, null);
	}

	@Override
	public List<AttributeSet> transformData(List<MAttributeSet_BH> dbModels) {
		if (dbModels == null || dbModels.isEmpty()) {
			return new ArrayList<>();
		}

		// Get the serial number controls
		Set<Integer> serialNumberControlIds = dbModels.stream().map(MAttributeSet_BH::getM_SerNoCtl_ID)
				.filter(serialNumberControlId -> serialNumberControlId > 0).collect(Collectors.toSet());
		Map<Integer, MSerNoCtl_BH> serialNumberControlsById = serialNumberControlIds.isEmpty() ? new HashMap<>() :
				serialNumberControlDBService.getByIds(serialNumberControlIds);

		return dbModels.stream().map(this::createInstanceWithDefaultFields).peek(attributeSet -> {
			if (serialNumberControlsById.containsKey(attributeSet.getSerialNumberControlId())) {
				attributeSet.setSerialNumberControl(
						new SerialNumberControl(serialNumberControlsById.get(attributeSet.getSerialNumberControlId())));
			}
		}).collect(Collectors.toList());
	}
}
