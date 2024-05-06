package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.adempiere.util.ServerContext;
import org.bandahealth.idempiere.base.model.MOrgInfo_BH;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.bandahealth.idempiere.graphql.utils.QueryUtil;
import org.compiere.util.Env;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class MOrgInfoDataLoader extends X_AD_OrgInfoDataLoader {
	@Override
	protected MappedBatchLoaderWithContext<Integer, MOrgInfo_BH> getByIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			ModelUtil.getTableAndCheckAccess(batchLoaderEnvironment.getContext(), MOrgInfo_BH.Table_Name);
			if (keys.isEmpty()) {
				return new HashMap<>();
			}
			List<Object> parameters = new ArrayList<>();
			String whereCondition = QueryUtil.getWhereClauseAndSetParametersForSet(keys, parameters);
			ServerContext.setCurrentInstance(batchLoaderEnvironment.getContext());
			Env.setCtx(batchLoaderEnvironment.getContext());
			List<MOrgInfo_BH> models =
					Repository.getQuery(batchLoaderEnvironment.getContext(), MOrgInfo_BH.Table_Name, null, true, false,
							MOrgInfo_BH.Table_Name + "." + MOrgInfo_BH.COLUMNNAME_AD_Org_ID + " IN (" + whereCondition + ")",
							parameters).list();
			return models.stream().collect(Collectors.toMap(MOrgInfo_BH::get_ID, m -> m));
		});
	}
}
