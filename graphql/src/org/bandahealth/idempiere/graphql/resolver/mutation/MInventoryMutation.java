package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInventory_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.DocumentUtil;

public class MInventoryMutation extends X_M_InventoryMutation {
	public MInventory_BH M_InventoryProcess(String uuid, String documentAction, DataFetchingEnvironment environment) {
		MInventory_BH entity =
				Repository.getByUuid(BandaGraphQLContext.getCtx(environment), MInventory_BH.Table_Name, null, uuid);
		return DocumentUtil.Process(entity, documentAction, entity.getC_DocType_ID(),
				MProcess_BH.PROCESSID_PROCESS_INVENTORY_COUNT);
	}
}
