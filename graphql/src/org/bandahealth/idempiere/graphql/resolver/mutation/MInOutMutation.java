package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.input.I_M_InOutInput;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.DocumentUtil;

public class MInOutMutation extends X_M_InOutMutation {

	public MInOut_BH M_InOutProcess(String UU, String DocumentAction, DataFetchingEnvironment environment) {
		MInOut_BH entity = Repository.getByUuid(BandaGraphQLContext.getCtx(environment), MInOut_BH.Table_Name, null, UU);
		return DocumentUtil.Process(entity, DocumentAction, entity.getC_DocType_ID(),
				MProcess_BH.PROCESSID_PROCESS_SHIPMENT);
	}

	@Override
	public MInOut_BH M_InOutSave(I_M_InOutInput Entity, DataFetchingEnvironment environment) {
		MDocType_BH documentTypeTarget;
		if ((documentTypeTarget = Repository.getById(BandaGraphQLContext.getCtx(environment), MDocType_BH.Table_Name, null,
				Entity.getC_DocType_ID())) == null) {
			throw new AdempiereException("Document Type is required");
		}
		// Override whatever was passed for this property based on the document type target
		Entity.setIsSOTrx(documentTypeTarget.isSOTrx());
		return super.M_InOutSave(Entity, environment);
	}
}
