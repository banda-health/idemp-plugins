package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.DocumentType;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class DocumentTypeDBService extends BaseDBService<DocumentType, MDocType_BH> {
	@Override
	public DocumentType saveEntity(DocumentType entity) {
		throw new NotImplementedException();
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected DocumentType createInstanceWithDefaultFields(MDocType_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected DocumentType createInstanceWithAllFields(MDocType_BH instance) {
		return new DocumentType(instance);
	}

	@Override
	protected DocumentType createInstanceWithSearchFields(MDocType_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MDocType_BH getModelInstance() {
		return new MDocType_BH(Env.getCtx(), 0, null);
	}
}
