package org.bandahealth.idempiere.base.process;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHConceptExtra;
import org.bandahealth.idempiere.base.model.MBHConceptMapping;
import org.bandahealth.idempiere.base.model.OCLConcept;
import org.bandahealth.idempiere.base.model.OCLConceptMapping;
import org.bandahealth.idempiere.base.utils.JsonUtils;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.bandahealth.idempiere.base.utils.StringUtil;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;

import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Process that syncs Concepts with OCL
 * 
 * TODO: ConceptSyncProcess will be replaced by this class.
 *
 * @author andrew
 */
public class ConceptSyncProcess extends SvrProcess {

	private String source = "BHGO"; // set default source

	private final int LIMIT = 100;
	private String OCL_BASE_URL = StringUtil.isNullOrEmpty(System.getenv("OCL_BASE_URL"))
			? "https://api.openconceptlab.org"
			: System.getenv("OCL_BASE_URL");
	private String URI_OPTIONS = "?includeRetired=true&includeMappings=true&sortAsc=name&verbose=true";
	private String BHGO_URI = "/orgs/bandahealth/sources/";
	private final String CONCEPTS_URI = "/concepts/";

	private final HttpClient client = HttpClient.newBuilder().version(Version.HTTP_2).build();

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

		int conceptCount = getConceptCount();
		if (conceptCount == 0) {
			String response = "Not found any concept on OCL";
			log.log(Level.INFO, response);
		}

		int numberOfPages = conceptCount / LIMIT;
		numberOfPages = conceptCount % LIMIT > 0 ? numberOfPages + 1 : numberOfPages;

		List<Integer> pages = Stream.iterate(1, page -> page + 1).limit(numberOfPages).collect(Collectors.toList());
		pages.forEach((page) -> {
			List<OCLConcept> concepts = getConceptsFromOCL(null, page);

			// Take advantage of batching to avoid multiple db calls.
			List<Object> parameters = new ArrayList<Object>();

			Set<String> items = concepts.stream().map(OCLConcept::getExternalId).collect(Collectors.toSet());
			String inClause = QueryUtil.getWhereClauseAndSetParametersForSet(items, parameters);

			List<MBHConcept> mConcepts = new Query(getCtx(), MBHConcept.Table_Name,
					MBHConcept.COLUMNNAME_BH_Concept_UU + " IN ( " + inClause + " )", null).setParameters(parameters)
							.list();

			concepts.forEach(concept -> {
				try {
					// search for concept in db list
					MBHConcept foundConcept = mConcepts.stream()
							.filter(filterConcept -> concept.getExternalId().equals(filterConcept.getBH_Concept_UU()))
							.findFirst().orElse(null);

					saveConcept(concept, foundConcept, newRecords, updatedRecords);

				} catch (Exception ex) {
					log.log(Level.SEVERE, ex.getMessage());
				}
			});
		});

		// Update all client IDs to be for the system client in case it wasn't run for
		// as the system client
		DB.executeUpdate("UPDATE " + MBHConcept.Table_Name + " SET ad_client_id = 0 WHERE ad_client_id != 0",
				get_TrxName());
		DB.executeUpdate("UPDATE " + MBHConceptMapping.Table_Name + " SET ad_client_id = 0 WHERE ad_client_id != 0",
				get_TrxName());

		String successMessage = "SUCCESSFULLY created " + newRecords.get() + ", updated " + updatedRecords.get()
				+ " records in " + (System.currentTimeMillis() - start) / 1000 + " secs";

		log.log(Level.INFO, successMessage);

		return successMessage;
	}

	/**
	 * Save concepts and child entities (mappings, extras)
	 * 
	 * @param concept
	 * @param mConcept
	 * @param newRecords
	 * @param updatedRecords
	 */
	private void saveConcept(OCLConcept concept, MBHConcept mConcept, AtomicInteger newRecords,
			AtomicInteger updatedRecords) {
		if (concept == null) {
			return;
		}

		// search for concept in db list
		if (mConcept == null) {
			mConcept = new Query(getCtx(), MBHConcept.Table_Name, MBHConcept.COLUMNNAME_BH_OclID + " =?", null)
					.setParameters(concept.getId()).first();

			if (mConcept == null) {
				mConcept = new MBHConcept(getCtx(), 0, null);
				newRecords.incrementAndGet();
			} else {
				updatedRecords.incrementAndGet();
			}
		} else {
			updatedRecords.incrementAndGet();
		}

		mConcept.setIsActive(!concept.isRetired());
		mConcept.setBH_Data_Type(concept.getDatatype());
		mConcept.setbh_concept_class(concept.getConceptClass());
		mConcept.setBH_Concept_Type(concept.getType());
		mConcept.setBH_Display_Locale(concept.getDisplayLocale());
		mConcept.setBH_Display_Name(concept.getDisplayName());
		mConcept.setBH_ExternalID(concept.getExternalId());
		mConcept.setBH_OclID(concept.getId());
		mConcept.setBH_Owner(concept.getOwner());
		mConcept.setBH_Source(concept.getSource());
		mConcept.setURL(concept.getUrl());
		mConcept.saveEx();

		final int conceptID = mConcept.getBH_Concept_ID();

		// check existing extras
		List<MBHConceptExtra> mConceptExtras = new Query(getCtx(), MBHConceptExtra.Table_Name,
				MBHConceptExtra.COLUMNNAME_BH_Concept_ID + " =? ", null).setParameters(conceptID).list();

		// save extras
		concept.getExtras().forEach((extra) -> {
			// search extra in db list
			MBHConceptExtra foundConceptExtra = mConceptExtras.stream()
					.filter(filterConceptExtra -> extra.getKey().equals(filterConceptExtra.getBH_Key())).findFirst()
					.orElse(null);

			if (foundConceptExtra == null) {
				// new record
				foundConceptExtra = new MBHConceptExtra(getCtx(), 0, null);
				foundConceptExtra.setBH_Concept_ID(conceptID);
			}

			foundConceptExtra.setBH_Key(extra.getKey());
			foundConceptExtra.setBH_Value(extra.getValue());
			foundConceptExtra.saveEx();
		});

		downloadChildMappings(mConcept, concept, newRecords, updatedRecords);
	}

	private CompletableFuture<HttpResponse<String>> makeRequest(String source, int page) {
		String url = constructUrl(source, page, source == null ? LIMIT : 0);
		HttpRequest request = HttpRequest.newBuilder(URI.create(url)).header("Content-Type", "application/json")
				.build();

		return client.sendAsync(request, BodyHandlers.ofString());
	}

	/**
	 * Get a list of concepts from OCL
	 *
	 * @param source
	 * @param page
	 * @return
	 */
	private List<OCLConcept> getConceptsFromOCL(String source, int page) {
		CompletableFuture<HttpResponse<String>> response = makeRequest(source, page);
		List<OCLConcept> oclConcepts = new ArrayList<OCLConcept>();
		try {
			oclConcepts = JsonUtils.convertFromJsonToList(response.get().body(), new TypeReference<List<OCLConcept>>() {
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
	 *
	 * @param source
	 * @return
	 */
	private OCLConcept getConceptFromOCL(String source) {
		CompletableFuture<HttpResponse<String>> response = makeRequest(source, 0);
		OCLConcept oclConcept = new OCLConcept();
		try {
			oclConcept = JsonUtils.covertFromJsonToObject(response.get().body(), OCLConcept.class);
		} catch (InterruptedException | ExecutionException | IOException e) {
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
		CompletableFuture<HttpResponse<String>> response = makeRequest(null, 1);
		try {
			HttpHeaders headers = response.get().headers();
			Optional<String> numFound = headers.firstValue("num_found");
			if (numFound.isPresent()) {
				count = Integer.valueOf(numFound.get());
			}
		} catch (InterruptedException | ExecutionException e) {
			log.log(Level.SEVERE, "Error fetching count: ", e);
		}

		return count;
	}

	/**
	 * Fetch any child mapped concepts
	 *
	 * @param parentConcept
	 * @param ConceptMapping
	 */
	private void downloadChildMappings(MBHConcept parentConcept, OCLConcept oclConcept, AtomicInteger newRecords,
			AtomicInteger updatedRecords) {
		List<OCLConceptMapping> mappings = oclConcept.getMappings();
		if (mappings.isEmpty()) {
			return;
		}

		// Take advantage of batching to avoid multiple db calls.
		List<Object> parameters = new ArrayList<Object>();

		String inClause = QueryUtil.getWhereClauseAndSetParametersForSet(
				mappings.stream().map(OCLConceptMapping::getId).collect(Collectors.toSet()), parameters);

		List<MBHConceptMapping> mConceptMappings = new Query(getCtx(), MBHConceptMapping.Table_Name,
				MBHConceptMapping.COLUMNNAME_BH_OclID + " IN ( " + inClause + " )", null).setParameters(parameters)
						.list();

		// save every mapping and check underlying concepts
		mappings.forEach((mapping) -> {
			// search mapping in db list
			MBHConceptMapping foundConceptMapping = mConceptMappings.stream().filter(
					filterConceptMapping -> mapping.getId().equals(filterConceptMapping.getBH_OclID()))
					.findFirst().orElse(null);

			if (foundConceptMapping == null) {
				// new record
				foundConceptMapping = new MBHConceptMapping(getCtx(), 0, null);
			}

			if (mapping.getExternalId() != null && !mapping.getExternalId().isEmpty()
					&& !"null".equals(mapping.getExternalId())) {
				foundConceptMapping.setBH_ExternalID(mapping.getExternalId());
			}
			foundConceptMapping.setIsActive(mapping.isRetired());
			foundConceptMapping.setBH_Concept_ID(parentConcept.get_ID());
			foundConceptMapping.setBH_Source(mapping.getToSourceOwner());
			foundConceptMapping.setBH_Map_Type(mapping.getMapType());
			foundConceptMapping.setBH_Owner(mapping.getOwner());
			foundConceptMapping.setBH_OclID(mapping.getId());
			foundConceptMapping.setBH_To_Concept_Code(mapping.getToConceptCode());
			foundConceptMapping.setBH_To_Concept_Name_Resolved(mapping.getToConceptNameResolved());
			foundConceptMapping.setBH_To_Concept_Name(mapping.getToConceptName());
			foundConceptMapping.setBH_To_Source_Name(mapping.getToSourceName());
			foundConceptMapping.setBH_To_Concept_Url(mapping.getToConceptUrl());
			foundConceptMapping.setBH_From_Concept_Code(mapping.getFromConceptCode());
			foundConceptMapping.setBH_From_Concept_Name_Resolved(mapping.getFromConceptNameResolved());
			foundConceptMapping.setBH_From_Concept_Name(mapping.getFromConceptName());
			foundConceptMapping.setBH_From_Concept_Url(mapping.getFromConceptUrl());

			foundConceptMapping.saveEx();

			String mappingUrl = mapping.getToConceptUrl();
			// some concepts are mapped to themselves leading to an infinite loop.
			if (mappingUrl != null && !"null".equals(mappingUrl) && !oclConcept.getUrl().equals(mappingUrl)) {
				// check mappings
				saveConcept(getConceptFromOCL(mappingUrl), null, newRecords, updatedRecords);
				return; // we're only going one level down i.e. traverse only the child nodes.
			}
		});
	}

	private String constructUrl(String source, int page, int limit) {
		StringBuilder url = new StringBuilder();
		url.append(OCL_BASE_URL);
		url.append(source != null ? source : BHGO_URI + this.source + CONCEPTS_URI);
		url.append(URI_OPTIONS);
		url.append(limit > 0 ? "&limit=" + limit : "");
		url.append(page > 0 ? "&page=" + page : "");

		return url.toString();
	}
}
