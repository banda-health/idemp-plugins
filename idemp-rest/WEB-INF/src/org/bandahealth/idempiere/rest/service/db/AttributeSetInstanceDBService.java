package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.rest.model.AttributeSetInstance;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.compiere.model.MRefList;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AttributeSetInstanceDBService extends BaseDBService<AttributeSetInstance, MAttributeSetInstance_BH> {
	@Autowired
	private ReferenceListDBService referenceListDBService;

	@Override
	public AttributeSetInstance saveEntity(AttributeSetInstance entity) {
		// We'll only allow updating the guarantee date
		MAttributeSetInstance_BH attributeSetInstance = getEntityByIdFromDB(entity.getAttributeSetInstanceId());
		if (attributeSetInstance == null) {
			attributeSetInstance = getModelInstance();
			attributeSetInstance.setM_AttributeSetInstance_UU(entity.getUuid());
		}

		attributeSetInstance.setGuaranteeDate(entity.getGuaranteeDate());
		attributeSetInstance.setDescription(DateUtil.parseDateOnly(entity.getGuaranteeDate()));

		if (entity.getUpdateReason().getUuid() != null) {
			MRefList updateReason = referenceListDBService.getEntityByUuidFromDB(entity.getUpdateReason().getUuid());
			if (updateReason != null) {
				attributeSetInstance.setbh_update_reason(updateReason.getValue());
			}
		}

		attributeSetInstance.saveEx();

		return createInstanceWithAllFields(getEntityByUuidFromDB(attributeSetInstance.getM_AttributeSetInstance_UU()));
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected AttributeSetInstance createInstanceWithDefaultFields(MAttributeSetInstance_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected AttributeSetInstance createInstanceWithAllFields(MAttributeSetInstance_BH instance) {
		return new AttributeSetInstance(instance);
	}

	@Override
	protected AttributeSetInstance createInstanceWithSearchFields(MAttributeSetInstance_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MAttributeSetInstance_BH getModelInstance() {
		return new MAttributeSetInstance_BH(Env.getCtx(), 0, null);
	}
}
