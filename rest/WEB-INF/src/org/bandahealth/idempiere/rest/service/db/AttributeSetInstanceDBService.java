package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.AttributeSetInstance;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Paging;
import org.compiere.model.MRefList;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AttributeSetInstanceDBService extends BaseDBService<AttributeSetInstance, MAttributeSetInstance_BH> {
	@Autowired
	private ReferenceListDBService referenceListDBService;
	@Autowired
	private AttributeSetDBService attributeSetDBService;

	@Override
	public AttributeSetInstance saveEntity(AttributeSetInstance entity) {
		MAttributeSetInstance_BH attributeSetInstance = getEntityByUuidFromDB(entity.getUuid());
		// We'll do the following things for a new entity only
		if (attributeSetInstance == null) {
			attributeSetInstance = getModelInstance();
			attributeSetInstance.setM_AttributeSetInstance_UU(entity.getUuid());

			// Set the correction attribute set, if one was provided
			if (entity.getAttributeSet() != null) {
				MAttributeSet_BH attributeSet = attributeSetDBService.getEntityByUuidFromDB(entity.getAttributeSet().getUuid());
				if (attributeSet != null) {
					attributeSetInstance.setM_AttributeSet_ID(attributeSet.get_ID());
				}
			}

			// Set the serial number
			attributeSetInstance.setSerNo(entity.getSerialNumber());
		}

		// We'll only allow updating the guarantee date and update reason on an existing ASI
		attributeSetInstance.setGuaranteeDate(entity.getGuaranteeDate());

		if (entity.getUpdateReason() != null && entity.getUpdateReason().getUuid() != null) {
			MRefList updateReason = referenceListDBService.getEntityByUuidFromDB(entity.getUpdateReason().getUuid());
			if (updateReason != null) {
				attributeSetInstance.setbh_update_reason(updateReason.getValue());
			}
		}

		// Automatically update the description by the ASI's own logic
		attributeSetInstance.setDescription();
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

	@Override
	public BaseListResponse<AttributeSetInstance> getAll(Paging pagingInfo, String sortJson, String filterJson) {
		throw new NotImplementedException();
	}
}
