package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.DocumentUtil;
import org.compiere.model.PO;

public class MPaymentMutation extends X_C_PaymentMutation {
	public MPayment_BH C_PaymentProcess(String uuid, String documentAction, DataFetchingEnvironment environment) {
		MPayment_BH entity =
				Repository.getByUuid(BandaGraphQLContext.getCtx(environment), MPayment_BH.Table_Name, null, uuid);
		return DocumentUtil.Process(entity, documentAction, entity.getC_DocType_ID(),
				MProcess_BH.PROCESSID_PROCESS_PAYMENT);
	}

	@Override
	protected PO save(PO entity, DataFetchingEnvironment environment) {
		MPayment_BH castEntity = (MPayment_BH) entity;
		MDocType_BH documentTypeTarget;
		if ((documentTypeTarget = Repository.getById(BandaGraphQLContext.getCtx(environment), MDocType_BH.Table_Name, null,
				castEntity.getC_DocType_ID())) == null) {
			throw new AdempiereException("Document Type is required");
		}
		// Override whatever was passed for this property based on the document type target
		castEntity.setIsReceipt(documentTypeTarget.isSOTrx());
		return super.save(entity, environment);
	}
}
