package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.adempiere.util.ServerContext;
import org.bandahealth.idempiere.base.model.MBHClientConceptExtra;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.bandahealth.idempiere.graphql.utils.QueryUtil;
import org.compiere.util.Env;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class MBHClientConceptExtraDataLoader extends X_BH_Client_Concept_ExtraDataLoader {
	public static String DATALOADER_BH_Client_Concept_Extra_BY_Concept_Extra_ID =
			"DATALOADER_BH_Client_Concept_Extra_BY_Concept_Extra_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_BH_Client_Concept_Extra_BY_Concept_Extra_ID,
				DataLoader.newMappedDataLoader(getByConceptExtraIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<Integer, MBHClientConceptExtra> getByConceptExtraIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			ModelUtil.getTableAndCheckAccess(batchLoaderEnvironment.getContext(), getTableName());
			if (keys.isEmpty()) {
				return new HashMap<>();
			}
			List<Object> parameters = new ArrayList<>();
			String whereCondition = QueryUtil.getWhereClauseAndSetParametersForSet(keys, parameters);
			ServerContext.setCurrentInstance(batchLoaderEnvironment.getContext());
			Env.setCtx(batchLoaderEnvironment.getContext());
			List<MBHClientConceptExtra> models =
					Repository.getQuery(batchLoaderEnvironment.getContext(), MBHClientConceptExtra.Table_Name, null, true, false,
							MBHClientConceptExtra.Table_Name + "." + MBHClientConceptExtra.COLUMNNAME_BH_Concept_Extra_ID + " IN (" +
									whereCondition + ")",
							parameters).list();
			return models.stream().collect(Collectors.toMap(MBHClientConceptExtra::getBH_Concept_Extra_ID, m -> m));
		});
	}
}
