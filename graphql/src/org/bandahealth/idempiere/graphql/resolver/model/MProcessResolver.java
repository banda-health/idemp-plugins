package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MMenu_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.MMenuDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MProcessParaDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MProcessPara;
import org.compiere.model.MRole;
import org.compiere.util.Env;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class MProcessResolver extends X_AD_ProcessResolver {
	public CompletableFuture<List<MProcessPara>> AD_Process_ParaList(MProcess_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MProcessPara>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MProcessParaDataLoader.DATALOADER_AD_Process_Para_BY_AD_Process_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_Process_ID()));
	}

	public CompletableFuture<Boolean> NeedsManualInput(MProcess_BH entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MMenu_BH>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MMenuDataLoader.AD_Menu_BY_AD_MENU_PARENT_UUID_DATA_LOADER);
		return dataLoader.load(MMenu_BH.MENUUUID_GREENLIGHT_REPORT_DROPDOWN).thenApply(menus -> {
			Set<Integer> processIdsFromProcessButtons =
					menus.stream().map(MMenu_BH::getAD_Process_ID).collect(Collectors.toSet());
			MRole usersRole = MRole.get(BandaGraphQLContext.getCtx(environment),
					Env.getAD_Role_ID(BandaGraphQLContext.getCtx(environment)));
			return usersRole.getProcessAccess(entity.getAD_Process_ID()) != null &&
					processIdsFromProcessButtons.contains(entity.getAD_Process_ID());
		});
	}
}
