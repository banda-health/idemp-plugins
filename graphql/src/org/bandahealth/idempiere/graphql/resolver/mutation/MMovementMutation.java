package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.DocumentUtil;

public class MMovementMutation extends X_M_MovementMutation {
	public MMovement_BH M_MovementProcess(String uuid, String documentAction, DataFetchingEnvironment environment) {
		MMovement_BH entity =
				Repository.getByUuid(BandaGraphQLContext.getCtx(environment), MMovement_BH.Table_Name, null, uuid);
		return DocumentUtil.Process(entity, documentAction, entity.getC_DocType_ID(),
				MProcess_BH.PROCESSID_PROCESS_MOVEMENTS);
	}
}
