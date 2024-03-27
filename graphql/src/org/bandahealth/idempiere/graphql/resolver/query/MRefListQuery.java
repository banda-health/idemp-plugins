package org.bandahealth.idempiere.graphql.resolver.query;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.utils.DocumentUtil;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class MRefListQuery extends X_AD_Ref_ListQuery {
	public CompletableFuture<String> DocumentStatusActionMap(DataFetchingEnvironment environment) {
		return CompletableFuture.supplyAsync(
				() -> {
					try {
						// For some reason, Eclipse doesn't like this being in one line (😂), so we separate it here
						Map<String, Map<String, List<String>>> documentStatusActionMap =
								DocumentUtil.getDocumentStatusActionMap(BandaGraphQLContext.getCtx(environment)).entrySet()
										.stream().collect(
												Collectors.toMap(
														documentStatusActionMapEntry -> documentStatusActionMapEntry.getKey().getDocBaseType(),
														documentStatusActionMapEntry -> documentStatusActionMapEntry.getValue().entrySet().stream()
																.collect(Collectors.toMap(refList -> refList.getKey().getValue(),
																		Map.Entry::getValue)),
														(existingStatusActionMap, newStatusActionMap) -> {
															// This is what happens when there's a merge
															newStatusActionMap.forEach((newDocumentStatus, newActionList) -> {
																// If the document status doesn't exist already, so add it and move on
																if (!existingStatusActionMap.containsKey(newDocumentStatus)) {
																	existingStatusActionMap.put(newDocumentStatus, newActionList);
																	return;
																}
																// The document type does exist, so we need to merge action lists
																List<String> existingActionList = existingStatusActionMap.get(newDocumentStatus);
																existingActionList.addAll(newActionList);
																existingStatusActionMap.replace(newDocumentStatus,
																		existingActionList.stream().distinct().collect(Collectors.toList()));
															});
															return existingStatusActionMap;
														}));
						return new ObjectMapper().writeValueAsString(documentStatusActionMap);
					} catch (JsonProcessingException e) {
						throw new RuntimeException(e);
					}
				});
	}
}
