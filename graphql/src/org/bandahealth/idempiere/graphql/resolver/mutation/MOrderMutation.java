package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.DocumentUtil;
import org.compiere.model.PO;

public class MOrderMutation extends X_C_OrderMutation {
	public MOrder_BH C_OrderProcess(String uuid, String documentAction, DataFetchingEnvironment environment) {
		MOrder_BH entity =
				Repository.getByUuid(BandaGraphQLContext.getCtx(environment), MOrder_BH.Table_Name, null, uuid);
		return DocumentUtil.Process(entity, documentAction, entity.getC_DocType_ID(),
				MProcess_BH.PROCESSID_PROCESS_ORDERS);
	}

	@Override
	protected PO save(PO entity, DataFetchingEnvironment environment) {
		MOrder_BH castEntity = (MOrder_BH) entity;
		MDocType_BH documentTypeTarget;
		if ((documentTypeTarget = Repository.getById(BandaGraphQLContext.getCtx(environment), MDocType_BH.Table_Name, null,
				castEntity.getC_DocTypeTarget_ID())) == null) {
			throw new AdempiereException("Document Type is required");
		}
		// Override whatever was passed for this property based on the document type target
		castEntity.setIsSOTrx(documentTypeTarget.isSOTrx());
		return super.save(entity, environment);
	}
}
