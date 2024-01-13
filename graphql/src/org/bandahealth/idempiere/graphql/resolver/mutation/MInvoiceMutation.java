package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.DocumentUtil;
import org.compiere.model.PO;

public class MInvoiceMutation extends X_C_InvoiceMutation {
	public MInvoice_BH C_InvoiceProcess(String uuid, String documentAction, DataFetchingEnvironment environment) {
		MInvoice_BH entity =
				Repository.getByUuid(BandaGraphQLContext.getCtx(environment), MInvoice_BH.Table_Name, null, uuid);
		return DocumentUtil.Process(entity, documentAction, entity.getC_DocType_ID(),
				MProcess_BH.PROCESSID_PROCESS_INVOICE);
	}

	@Override
	protected PO save(PO entity, DataFetchingEnvironment environment) {
		MInvoice_BH castEntity = (MInvoice_BH) entity;
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
