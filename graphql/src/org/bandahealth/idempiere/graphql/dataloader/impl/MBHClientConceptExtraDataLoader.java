package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHClientConceptExtra;
import org.bandahealth.idempiere.base.model.MBHConceptExtra;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.QueryUtil;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class MBHClientConceptExtraDataLoader extends X_BH_Client_Concept_ExtraDataLoader {
	public static String DATALOADER_BH_Client_Concept_Extra_By_Concept_ID = "DATALOADER_BH_Client_Concept_Extra_By_Concept_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_BH_Client_Concept_Extra_By_Concept_ID,
				DataLoader.newMappedDataLoader(getByConceptIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<Integer, List<MBHClientConceptExtra>> getByConceptIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			List<Object> parameters = new ArrayList<>();
			String whereCondition = QueryUtil.getWhereClauseAndSetParametersForSet(keys, parameters);

			Repository.setCopyOfPropertiesForNestedThreadUsage(batchLoaderEnvironment.getContext());

			List<MBHClientConceptExtra> models = Repository
					.getQuery(batchLoaderEnvironment.getContext(), getTableName(), null, true, false,
							MBHConceptExtra.Table_Name + "." + MBHConceptExtra.COLUMNNAME_BH_Concept_ID + " IN ("
									+ whereCondition + ")",
							parameters)
					.addJoinClause("JOIN " + MBHConceptExtra.Table_Name + " ON " + MBHConceptExtra.Table_Name + "."
							+ MBHConceptExtra.COLUMNNAME_BH_Concept_Extra_ID + " = " + MBHClientConceptExtra.Table_Name
							+ "." + MBHClientConceptExtra.COLUMNNAME_BH_Concept_Extra_ID)
					.list();

			return models.stream().collect(Collectors
					.groupingBy(clientConceptExtra -> clientConceptExtra.getBH_Concept_Extra().getBH_Concept_ID()));
		});
	}
}
