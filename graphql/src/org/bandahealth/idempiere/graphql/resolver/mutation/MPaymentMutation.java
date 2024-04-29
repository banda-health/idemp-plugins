package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.input.I_C_PaymentInput;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.DocumentUtil;
import org.compiere.model.PO;

public class MPaymentMutation extends X_C_PaymentMutation {
	public MPayment_BH C_PaymentProcess(String UU, String DocumentAction, DataFetchingEnvironment environment) {
		MPayment_BH entity =
				Repository.getByUuid(BandaGraphQLContext.getCtx(environment), MPayment_BH.Table_Name, null, UU);
		return DocumentUtil.Process(entity, DocumentAction, entity.getC_DocType_ID(),
				MProcess_BH.PROCESSID_PROCESS_PAYMENT);
	}

	@Override
	public MPayment_BH C_PaymentSave(I_C_PaymentInput Input, DataFetchingEnvironment environment) {
		MDocType_BH documentTypeTarget;
		if ((documentTypeTarget = Repository.getById(BandaGraphQLContext.getCtx(environment), MDocType_BH.Table_Name, null,
				Input.getC_DocType_ID())) == null) {
			throw new AdempiereException("Document Type is required");
		}
		// Override whatever was passed for this property based on the document type target
		Input.setIsReceipt(documentTypeTarget.isSOTrx());
		return super.C_PaymentSave(Input, environment);
	}
}
