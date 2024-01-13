package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MRole;
import org.compiere.model.MWindow;
import org.compiere.util.Env;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class MWindowDataLoader extends X_AD_WindowDataLoader {
	@Override
	protected MappedBatchLoaderWithContext<Integer, MWindow> getByIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			MRole usersRole =
					new MRole(batchLoaderEnvironment.getContext(), Env.getAD_Role_ID(batchLoaderEnvironment.getContext()), null);
			Set<Integer> accessibleKeys = keys.stream().filter(usersRole::getWindowAccess).collect(Collectors.toSet());
			return Repository.getByIds(batchLoaderEnvironment.getContext(), getTableName(), null, accessibleKeys);
		});
	}
}
