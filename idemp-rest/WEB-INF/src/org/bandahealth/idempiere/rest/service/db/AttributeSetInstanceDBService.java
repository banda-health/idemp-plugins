package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.rest.model.AttributeSetInstance;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.compiere.model.MAttributeSetInstance;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class AttributeSetInstanceDBService extends BaseDBService<AttributeSetInstance, MAttributeSetInstance> {
	@Override
	public AttributeSetInstance saveEntity(AttributeSetInstance entity) {
		// We'll only allow updating the guarantee date
		MAttributeSetInstance attributeSetInstance = getEntityByUuidFromDB(entity.getUuid());
		if (attributeSetInstance == null) {
			attributeSetInstance = getModelInstance();
			attributeSetInstance.setM_AttributeSetInstance_UU(entity.getUuid());
		}

		attributeSetInstance.setGuaranteeDate(entity.getGuaranteeDate());
		attributeSetInstance.setDescription(DateUtil.parseDateOnly(entity.getGuaranteeDate()));

		attributeSetInstance.saveEx();

		return createInstanceWithAllFields(getEntityByUuidFromDB(attributeSetInstance.getM_AttributeSetInstance_UU()));
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected AttributeSetInstance createInstanceWithDefaultFields(MAttributeSetInstance instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected AttributeSetInstance createInstanceWithAllFields(MAttributeSetInstance instance) {
		return new AttributeSetInstance(instance);
	}

	@Override
	protected AttributeSetInstance createInstanceWithSearchFields(MAttributeSetInstance instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MAttributeSetInstance getModelInstance() {
		return new MAttributeSetInstance(Env.getCtx(), 0, null);
	}
}
