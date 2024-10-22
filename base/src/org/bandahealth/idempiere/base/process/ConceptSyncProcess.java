package org.bandahealth.idempiere.base.process;

import com.fasterxml.jackson.core.type.TypeReference;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHConceptExtra;
import org.bandahealth.idempiere.base.model.MBHConceptMapping;
import org.bandahealth.idempiere.base.model.MBHConceptName;
import org.bandahealth.idempiere.base.model.MBHOclOriginatingSource;
import org.bandahealth.idempiere.base.model.OCLConcept;
import org.bandahealth.idempiere.base.model.OCLConceptExtra;
import org.bandahealth.idempiere.base.model.OCLConceptMapping;
import org.bandahealth.idempiere.base.utils.JsonUtils;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.bandahealth.idempiere.base.utils.StringUtil;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.stream.Collectors;

/**
 * Process that syncs Concepts with OCL
 * <p>
 * TODO: ConceptSyncProcess will be replaced by this class.
 *
 * @author andrew
 */
public class ConceptSyncProcess extends SvrProcess {

	private String source = "BHGO"; // set default source

	private final int LIMIT = 100;
	private final String OCL_BASE_URL = StringUtil.isNullOrEmpty(System.getenv("OCL_BASE_URL"))
			? "https://api.openconceptlab.org"
			: System.getenv("OCL_BASE_URL");
	private String URI_OPTIONS = "?includeRetired=true&includeMappings=true&verbose=true";
	private String BHGO_URI = "/orgs/bandahealth/sources/";
	private final String CONCEPTS_URI = "/concepts/";

	private final HttpClient client = HttpClient.newBuilder().version(Version.HTTP_2).build();
	private Set<String> visitedConcepts;

	@Override
	protected void prepare() {
		ProcessInfoParameter[] parameters = getParameter();

		for (ProcessInfoParameter parameter : parameters) {

			String parameterName = parameter.getParameterName();

			if (parameterName.equalsIgnoreCase("source")) {
				source = parameter.getParameterAsString();
			} else {
				log.log(Level.SEVERE, "Unknown Parameter: " + parameterName);
			}
		}
	}

	/**
	 * How this works: 1. Retrieve paginated list of concepts from OCL 2. Parse the
	 * items and update the DB accordingly i.e add missing concepts or update
	 * existing ones
	 */
	@Override
	protected String doIt() throws Exception {
		log.log(Level.INFO, "ConceptSyncProcess OCL sync");
		long start = System.currentTimeMillis();
		AtomicInteger newRecords = new AtomicInteger(0);
		AtomicInteger updatedRecords = new AtomicInteger(0);
		visitedConcepts = new HashSet<>();

		int conceptCount = getConceptCount();
		if (conceptCount == 0) {
			String response = "Not found any concept on OCL";
			log.log(Level.INFO, response);
		}

		int numberOfPages = conceptCount / LIMIT;
		numberOfPages = conceptCount % LIMIT > 0 ? numberOfPages + 1 : numberOfPages;
		for (int page = 1; page <= numberOfPages; page++) {
			List<OCLConcept> conceptsFromOcl = getConceptsFromOCL(page);
			if (conceptsFromOcl == null) {
				continue;
			}

			// Take advantage of batching to avoid multiple db calls.
			List<Object> parameters = new ArrayList<>();
			Set<String> items = conceptsFromOcl.stream().map(OCLConcept::getUuid).collect(Collectors.toSet());
			String inClause = QueryUtil.getWhereClauseAndSetParametersForSet(items, parameters);
			List<MBHConcept> concepts =
					new Query(getCtx(), MBHConcept.Table_Name, MBHConcept.COLUMNNAME_Ocl_Uuid + " IN ( " + inClause + " )",
							null).setParameters(parameters).list();
			Map<String, MBHConcept> conceptByOclUU =
					concepts.stream().collect(Collectors.toMap(MBHConcept::getOcl_Uuid, concept -> concept));

			conceptsFromOcl.forEach(conceptFromOcl -> {
				try {
					saveConcept(conceptFromOcl, conceptByOclUU.get(conceptFromOcl.getUuid()), newRecords, updatedRecords);
				} catch (Exception ex) {
					log.log(Level.SEVERE, ex.getMessage());
				}
			});
		}

		String successMessage = "SUCCESSFULLY created " + newRecords.get() + ", updated " + updatedRecords.get()
				+ " records in " + (System.currentTimeMillis() - start) / 1000 + " secs";

		log.log(Level.INFO, successMessage);

		return successMessage;
	}

	/**
	 * Save concepts and child entities (mappings, extras)
	 *
	 * @return The saved concept
	 */
	private MBHConcept saveConcept(OCLConcept conceptFromOcl, MBHConcept concept, AtomicInteger newRecords,
			AtomicInteger updatedRecords) {
		if (conceptFromOcl == null || visitedConcepts.contains(conceptFromOcl.getUuid())) {
			// If there is no new concept to save or we already visited this concept, return
			// the concept that was passed in to be updated if there was one
			return concept;
		}

		if (concept == null) {
			concept = new MBHConcept(getCtx(), 0, null);
			concept.setOcl_Uuid(conceptFromOcl.getUuid());
			newRecords.incrementAndGet();
		} else {
			updatedRecords.incrementAndGet();
		}

		concept.setIsActive(!conceptFromOcl.isRetired());
		concept.setBH_Data_Type(conceptFromOcl.getDatatype());
		concept.setbh_concept_class(conceptFromOcl.getConceptClass());
		concept.setBH_Concept_Type(conceptFromOcl.getType());
		concept.setBH_Display_Locale(conceptFromOcl.getDisplayLocale());
		concept.setBH_Display_Name(conceptFromOcl.getDisplayName());
		concept.setBH_ExternalID(conceptFromOcl.getExternalId());
		concept.setBH_OclID(conceptFromOcl.getId());
		concept.setBH_Owner(conceptFromOcl.getOwner());
		concept.setBH_Source(conceptFromOcl.getSource());
		concept.setURL(conceptFromOcl.getUrl());

		concept.saveEx();

		visitedConcepts.add(conceptFromOcl.getUuid());

		final int conceptID = concept.getBH_Concept_ID();

		// check ocl originating source
		MBHOclOriginatingSource foundSource = new Query(getCtx(), MBHOclOriginatingSource.Table_Name,
				MBHOclOriginatingSource.COLUMNNAME_BH_Concept_ID + "=? AND "
						+ MBHOclOriginatingSource.COLUMNNAME_BH_Ocl_Source + "=?",
				null).setParameters(conceptID, source).first();

		// create ocl originating source if one doesn't exist
		if (foundSource == null) {
			foundSource = new MBHOclOriginatingSource(getCtx(), 0, null);
			foundSource.setBH_Concept_ID(conceptID);
			foundSource.setBH_Ocl_Source(source);
			foundSource.saveEx();
		}

		// check existing extras
		List<MBHConceptExtra> conceptExtras = new Query(getCtx(), MBHConceptExtra.Table_Name,
				MBHConceptExtra.COLUMNNAME_BH_Concept_ID + "=? ", null).setParameters(conceptID).list();

		// save extras
		conceptFromOcl.getExtras().forEach((conceptExtraFromOcl) -> {
			// search extra in db list
			MBHConceptExtra foundConceptExtra = conceptExtras.stream()
					.filter(filterConceptExtra -> conceptExtraFromOcl.getKey().equalsIgnoreCase(filterConceptExtra.getBH_Key()))
					.findFirst().orElse(null);

			if (foundConceptExtra == null) {
				// new record
				foundConceptExtra = new MBHConceptExtra(getCtx(), 0, null);
				foundConceptExtra.setBH_Concept_ID(conceptID);
				newRecords.incrementAndGet();
			} else {
				updatedRecords.incrementAndGet();
			}

			foundConceptExtra.setBH_Key(conceptExtraFromOcl.getKey());
			foundConceptExtra.setBH_Value(conceptExtraFromOcl.getValue());
			foundConceptExtra.setIsActive(!conceptFromOcl.isRetired());
			foundConceptExtra.saveEx();
		});

		// Deactivate extras that are no longer used
		Set<String> currentOclConceptExtraKeys =
				conceptFromOcl.getExtras().stream().map(OCLConceptExtra::getKey).collect(Collectors.toSet());
		conceptExtras.stream()
				.filter(conceptExtra -> !currentOclConceptExtraKeys.contains(conceptExtra.getBH_Key()))
				.forEach(conceptMappingExtra -> {
					updatedRecords.incrementAndGet();
					conceptMappingExtra.setIsActive(false);
					conceptMappingExtra.saveEx();
				});

		// get concept names
		List<MBHConceptName> conceptNames = new Query(getCtx(), MBHConceptName.Table_Name,
				MBHConceptName.COLUMNNAME_BH_Concept_ID + "=?", null).setParameters(conceptID).list();
		Map<String, MBHConceptName> conceptNamesByOclUU =
				conceptNames.stream().collect(Collectors.toMap(MBHConceptName::getOcl_Uuid, conceptName -> conceptName));
		conceptFromOcl.getNames().forEach((oclConceptName) -> {
			// search name in db list
			MBHConceptName foundConceptName = conceptNamesByOclUU.get(oclConceptName.getUuid());

			if (foundConceptName == null) {
				// new record
				foundConceptName = new MBHConceptName(getCtx(), 0, null);
				foundConceptName.setOcl_Uuid(oclConceptName.getUuid());
				foundConceptName.setBH_Concept_ID(conceptID);
				newRecords.incrementAndGet();
			} else {
				updatedRecords.incrementAndGet();
			}

			foundConceptName.setBH_Concept_Locale(oclConceptName.getLocale());
			foundConceptName.setName(oclConceptName.getName());
			foundConceptName.setBH_Concept_Type(oclConceptName.getType());
			foundConceptName.setBH_Concept_Name_Type(oclConceptName.getNameType());
			foundConceptName.setBH_Concept_Locale_Preferred(oclConceptName.isLocalePreferred());
			foundConceptName.saveEx();
		});

		// save mappings
		downloadChildMappings(concept, conceptFromOcl, newRecords, updatedRecords);

		return concept;
	}

	private CompletableFuture<HttpResponse<String>> makeRequest(String source, int page, int limit,
			boolean includeSort) {
		String url = constructUrl(source, page, limit, includeSort);
		HttpRequest request = HttpRequest.newBuilder(URI.create(url)).header("Content-Type", "application/json")
				.build();

		return client.sendAsync(request, BodyHandlers.ofString());
	}

	/**
	 * Get a list of concepts from OCL
	 */
	private List<OCLConcept> getConceptsFromOCL(int page) {
		CompletableFuture<HttpResponse<String>> response = makeRequest(null, page, LIMIT, true);
		List<OCLConcept> oclConcepts;
		try {
			oclConcepts = JsonUtils.convertFromJsonToList(response.get().body(), new TypeReference<>() {
			});
		} catch (InterruptedException | ExecutionException | IOException e) {
			log.log(Level.SEVERE, "Error getting concepts: ", e);
			return null;
		}

		response.join();

		return oclConcepts;
	}

	/**
	 * Get a concept from OCL
	 */
	private OCLConcept getConceptFromOCL(String source) {
		// To get the latest version of an individual concept, use the "Versions" URL,
		// and limit the results to 1
		CompletableFuture<HttpResponse<String>> response = makeRequest(source + "versions/", 0, 1, false);
		OCLConcept oclConcept;
		try {
			oclConcept = JsonUtils.convertFromJsonToList(response.get().body(), new TypeReference<List<OCLConcept>>() {
			}).get(0);
		} catch (InterruptedException | ExecutionException | IOException | IndexOutOfBoundsException e) {
			log.log(Level.SEVERE, "Error getting concept: ", e);
			return null;
		}

		response.join();

		return oclConcept;
	}

	/**
	 * OCL's pagination no-longer works correctly leading to an infinite loop. Make
	 * an initial request to fetch `num_found` to use in pagination.
	 *
	 * @return count
	 */
	private int getConceptCount() {
		int count = 0;
		CompletableFuture<HttpResponse<String>> response = makeRequest(null, 1, 1, true);
		try {
			HttpHeaders headers = response.get().headers();
			Optional<String> numFound = headers.firstValue("num_found");
			if (numFound.isPresent()) {
				count = Integer.parseInt(numFound.get());
			}
		} catch (InterruptedException | ExecutionException e) {
			log.log(Level.SEVERE, "Error fetching count: ", e);
		}

		return count;
	}

	/**
	 * Fetch any child mapped concepts
	 */
	private void downloadChildMappings(MBHConcept parentConcept, OCLConcept oclConcept, AtomicInteger newRecords,
			AtomicInteger updatedRecords) {
		List<OCLConceptMapping> mappings = oclConcept.getMappings();
		if (mappings.isEmpty()) {
			return;
		}

		// Take advantage of batching to avoid multiple db calls.
		List<Object> parameters = new ArrayList<>();
		String inClause = QueryUtil.getWhereClauseAndSetParametersForSet(
				mappings.stream().map(OCLConceptMapping::getUuid).collect(Collectors.toSet()), parameters);
		//
		List<MBHConceptMapping> conceptMappings = new Query(getCtx(), MBHConceptMapping.Table_Name,
				MBHConceptMapping.COLUMNNAME_Ocl_Uuid + " IN ( " + inClause + " )", null).setParameters(parameters).list();
		Map<String, MBHConceptMapping> conceptMappingByOclUU = conceptMappings.stream()
				.collect(Collectors.toMap(MBHConceptMapping::getOcl_Uuid, conceptMapping -> conceptMapping));

		// save every mapping and check underlying concepts (filtering out BROADER-THAN mappings)
		mappings.stream().filter(conceptMappingFromOcl -> !MBHConceptMapping.BROADER_THAN_MAP_TYPE.equalsIgnoreCase(
				conceptMappingFromOcl.getMapType())).forEach((conceptMappingFromOcl) -> {
			//
			MBHConceptMapping foundConceptMapping = conceptMappingByOclUU.get(conceptMappingFromOcl.getUuid());

			if (foundConceptMapping == null) {
				// new record
				foundConceptMapping = new MBHConceptMapping(getCtx(), 0, null);
				foundConceptMapping.setOcl_Uuid(conceptMappingFromOcl.getUuid());
				foundConceptMapping.setBH_Concept_ID(parentConcept.get_ID());
				newRecords.incrementAndGet();
			} else {
				updatedRecords.incrementAndGet();
			}

			foundConceptMapping.setBH_ExternalID(conceptMappingFromOcl.getExternalId());
			foundConceptMapping.setIsActive(!conceptMappingFromOcl.isRetired());
			foundConceptMapping.setBH_Source(conceptMappingFromOcl.getSource());
			foundConceptMapping.setBH_Map_Type(conceptMappingFromOcl.getMapType());
			foundConceptMapping.setBH_Owner(conceptMappingFromOcl.getOwner());
			foundConceptMapping.setBH_OclID(conceptMappingFromOcl.getId());
			foundConceptMapping.setBH_To_Concept_Code(conceptMappingFromOcl.getToConceptCode());
			foundConceptMapping.setBH_To_Concept_Name_Resolved(conceptMappingFromOcl.getToConceptNameResolved());
			foundConceptMapping.setBH_To_Concept_Name(conceptMappingFromOcl.getToConceptName());
			foundConceptMapping.setBH_To_Source_Name(conceptMappingFromOcl.getToSourceName());
			foundConceptMapping.setBH_To_Concept_Url(conceptMappingFromOcl.getToConceptUrl());
			foundConceptMapping.setBH_From_Concept_Code(conceptMappingFromOcl.getFromConceptCode());
			foundConceptMapping.setBH_From_Concept_Name_Resolved(conceptMappingFromOcl.getFromConceptNameResolved());
			foundConceptMapping.setBH_From_Concept_Name(conceptMappingFromOcl.getFromConceptName());
			foundConceptMapping.setBH_From_Concept_Url(conceptMappingFromOcl.getFromConceptUrl());

			foundConceptMapping.saveEx();

			// check existing extras
			final int conceptMappingID = foundConceptMapping.get_ID();

			List<MBHConceptExtra> mConceptMappingExtras = new Query(getCtx(), MBHConceptExtra.Table_Name,
					MBHConceptExtra.COLUMNNAME_BH_Concept_Mapping_ID + "=? ", null).setParameters(conceptMappingID)
					.list();

			// get extras
			conceptMappingFromOcl.getExtras().forEach((extra) -> {
				// search extra in db list
				MBHConceptExtra foundConceptExtra = mConceptMappingExtras.stream()
						.filter(filterConceptExtra -> extra.getKey().equals(filterConceptExtra.getBH_Key()))
						.findFirst().orElse(null);

				if (foundConceptExtra == null) {
					// new record
					foundConceptExtra = new MBHConceptExtra(getCtx(), 0, null);
					foundConceptExtra.setBH_Concept_Mapping_ID(conceptMappingID);
					newRecords.incrementAndGet();
				} else {
					updatedRecords.incrementAndGet();
				}

				foundConceptExtra.setBH_Key(extra.getKey());
				foundConceptExtra.setBH_Value(extra.getValue());
				foundConceptExtra.setIsActive(!conceptMappingFromOcl.isRetired());
				foundConceptExtra.saveEx();
			});

			// Deactivate extras that are no longer used
			Set<String> currentOclConceptExtraKeys =
					conceptMappingFromOcl.getExtras().stream().map(OCLConceptExtra::getKey).collect(Collectors.toSet());
			mConceptMappingExtras.stream()
					.filter(conceptMappingExtra -> !currentOclConceptExtraKeys.contains(conceptMappingExtra.getBH_Key()))
					.forEach(conceptMappingExtra -> {
						updatedRecords.incrementAndGet();
						conceptMappingExtra.setIsActive(false);
						conceptMappingExtra.saveEx();
					});

			String mappingUrl = conceptMappingFromOcl.getToConceptUrl();

			// some concepts are mapped to themselves leading to an infinite loop.
			if (mappingUrl != null && !"null".equals(mappingUrl)) {
				if (!oclConcept.getUrl().equals(mappingUrl)) {
					// get the child concept
					OCLConcept childOclConcept = getConceptFromOCL(mappingUrl);
					MBHConcept foundChildConcept = null;
					if (childOclConcept != null) {
						foundChildConcept = new Query(getCtx(), MBHConcept.Table_Name, MBHConcept.COLUMNNAME_Ocl_Uuid + "=?",
								null).setParameters(childOclConcept.getUuid()).first();
					}

					MBHConcept savedChildConcept = saveConcept(childOclConcept, foundChildConcept, newRecords, updatedRecords);

					// after populating and saving the child concept, link it to the "TO" end of this mapping
					foundConceptMapping.setTo_BH_Concept_ID(savedChildConcept == null ? 0 : savedChildConcept.get_ID());
					foundConceptMapping.saveEx();
				} else {
					foundConceptMapping.setTo_BH_Concept_ID(parentConcept.get_ID());
					foundConceptMapping.saveEx();
				}
			}
		});
	}

	private String constructUrl(String source, int page, int limit, boolean includeSort) {
		return OCL_BASE_URL +
				(source != null ? source : BHGO_URI + this.source + CONCEPTS_URI) +
				URI_OPTIONS +
				(includeSort ? "&sortAsc=name" : "") +
				(limit > 0 ? "&limit=" + limit : "") +
				(page > 0 ? "&page=" + page : "");
	}
}
