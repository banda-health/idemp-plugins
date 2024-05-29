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

import org.bandahealth.idempiere.base.model.MBHCodedDiagnosis;
import org.bandahealth.idempiere.base.model.MBHCodedDiagnosisMapping;
import org.bandahealth.idempiere.base.model.OCLConcept;
import org.bandahealth.idempiere.base.model.OCLConceptExtra;
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
 * Process that syncs CodedDiagnosis (concepts) with OCL
 *
 * @author andrew
 */
public class CodedDiagnosisSyncProcess extends SvrProcess {

	private String source = "BHGO"; // set default source

	private final int LIMIT = 100;
	private String OCL_BASE_URL =
			StringUtil.isNullOrEmpty(System.getenv("OCL_BASE_URL")) ? "https://api.openconceptlab.org" :
					System.getenv("OCL_BASE_URL");
	private String URI_OPTIONS = "?includeRetired=true&includeMappings=true&sortAsc=name&verbose=true";
	private String BHGO_URI = "/orgs/bandahealth/sources/";
	private final String CIEL = "CIEL";
	private final String ICD_10_WHO = "ICD-10-WHO";
	private final String MOH_705A_LESSTHAN5 = "MOH-705A-LESSTHAN5";
	private final String MOH_705B_GREATERTHAN5 = "MOH-705B-GREATERTHAN5";
	private final String INDEX_TERMS = "index_terms";
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
	 * How this works: 1. Retrieve paginated list of coded diagnosis from OCL 2.
	 * Parse the items and update the DB accordingly i.e add missing concepts or
	 * update existing ones
	 */
	@Override
	protected String doIt() throws Exception {
		log.log(Level.INFO, "CodedDiagnosisSyncProcess sync OCL-BHGo diagnosis");
		long start = System.currentTimeMillis();
		AtomicInteger newRecords = new AtomicInteger(0);
		AtomicInteger updatedRecords = new AtomicInteger(0);

		int codedDiagnosisCount = getCodedDiagnosisCount();
		if (codedDiagnosisCount == 0) {
			String response = "Not found any coded diagnosis on OCL";
			log.log(Level.INFO, response);
		}

		int numberOfPages = codedDiagnosisCount / LIMIT;
		numberOfPages = codedDiagnosisCount % LIMIT > 0 ? numberOfPages + 1 : numberOfPages;

		List<Integer> pages = Stream.iterate(1, page -> page + 1).limit(numberOfPages).collect(Collectors.toList());
		pages.forEach((page) -> {
			List<OCLConcept> codedDiagnoses = getConceptsFromOCL(null, page);

			// Take advantage of batching to avoid multiple db calls.
			List<Object> parameters = new ArrayList<Object>();

			Set<String> items = codedDiagnoses.stream().map(OCLConcept::getExternalId)
					.collect(Collectors.toSet());
			String inClause = QueryUtil.getWhereClauseAndSetParametersForSet(items, parameters);

			List<MBHCodedDiagnosis> mCodedDiagnoses = new Query(getCtx(), MBHCodedDiagnosis.Table_Name,
					MBHCodedDiagnosis.COLUMNNAME_BH_Coded_Diagnosis_UU + " IN ( " + inClause + " )", null)
					.setParameters(parameters).list();

			codedDiagnoses.forEach(codedDiagnosis -> {
				try {
					// search for coded diagnosis in db list
					MBHCodedDiagnosis foundCodedDiagnosis = mCodedDiagnoses.stream()
							.filter(filterCodedDiagnosis -> codedDiagnosis.getExternalId()
									.equals(filterCodedDiagnosis.getBH_Coded_Diagnosis_UU()))
							.findFirst().orElse(null);
					if (foundCodedDiagnosis == null) {
						// new record
						// if the external_id field is not set in OCL, we need to check if the name is
						// present to avoid creating
						// duplicates
						if (codedDiagnosis.getExternalId() == null || codedDiagnosis.getExternalId().isEmpty()) {
							foundCodedDiagnosis = new Query(getCtx(), MBHCodedDiagnosis.Table_Name,
									MBHCodedDiagnosis.COLUMNNAME_bh_cielname + " = ?", null)
									.setParameters(codedDiagnosis.getDisplayName()).first();
						}

						if (foundCodedDiagnosis == null) {
							foundCodedDiagnosis = new MBHCodedDiagnosis(getCtx(), 0, null);
							if (codedDiagnosis.getExternalId() != null && !codedDiagnosis.getExternalId().isEmpty()) {
								foundCodedDiagnosis.setBH_Coded_Diagnosis_UU(codedDiagnosis.getExternalId());
							}

							newRecords.incrementAndGet();
						} else {
							updatedRecords.incrementAndGet();
						}

					} else {
						updatedRecords.incrementAndGet();
					}

					foundCodedDiagnosis.setIsActive(!codedDiagnosis.isRetired());

					List<OCLConceptMapping> codedDiagnosisMapping = codedDiagnosis.getMappings();
					OCLConceptMapping cielMapping = codedDiagnosisMapping.stream()
							.filter(mapping -> CIEL.equals(mapping.getToSourceName())).findFirst().orElse(null);
					OCLConceptMapping icd10wHOMapping = codedDiagnosisMapping.stream()
							.filter(mapping -> ICD_10_WHO.equals(mapping.getToSourceName())).findFirst().orElse(null);
					
					foundCodedDiagnosis.setbh_cielname(codedDiagnosis.getDisplayName());

					if (cielMapping != null && cielMapping.getToConceptCode() != null) {
						foundCodedDiagnosis.setBH_CielID(Integer.parseInt(cielMapping.getToConceptCode()));
					}

					foundCodedDiagnosis.setbh_concept_class(codedDiagnosis.getConceptClass());

					if (icd10wHOMapping != null && icd10wHOMapping.getToConceptCode() != null) {
						foundCodedDiagnosis.setbh_icd10who(icd10wHOMapping.getToConceptCode());
					}

					List<OCLConceptExtra> extras = codedDiagnosis.getExtras();
					OCLConceptExtra moh705A = extras.stream()
							.filter(extra -> MOH_705A_LESSTHAN5.equals(extra.getKey())).findFirst().orElse(null);
					OCLConceptExtra moh705B = extras.stream()
							.filter(extra -> MOH_705B_GREATERTHAN5.equals(extra.getKey())).findFirst().orElse(null);
					OCLConceptExtra indexTerms = extras.stream()
							.filter(extra -> INDEX_TERMS.equals(extra.getKey())).findFirst().orElse(null);
					
					if (moh705A != null) {
						foundCodedDiagnosis.setbh_moh705a_lessthan5(moh705A.getValue());	
					}
					
					if (moh705B != null) {
						foundCodedDiagnosis.setbh_moh705b_greaterthan5(moh705B.getValue());
					}
					
					if (indexTerms != null) {
						foundCodedDiagnosis.setbh_searchterms(indexTerms.getValue());	
					}

					foundCodedDiagnosis.saveEx();

					downloadChildMappings(foundCodedDiagnosis, codedDiagnosis, codedDiagnosisMapping);
				} catch (Exception ex) {
					log.log(Level.SEVERE, ex.getMessage());
				}
			});
		});

		// Update all client IDs to be for the system client in case it wasn't run for as the system client
		DB.executeUpdate("UPDATE " + MBHCodedDiagnosis.Table_Name + " SET ad_client_id = 0 WHERE ad_client_id != 0",
				get_TrxName());
		DB.executeUpdate("UPDATE " + MBHCodedDiagnosisMapping.Table_Name + " SET ad_client_id = 0 WHERE ad_client_id != 0",
				get_TrxName());

		String successMessage = "SUCCESSFULLY created " + newRecords.get() + ", updated " + updatedRecords.get()
				+ " records in " + (System.currentTimeMillis() - start) / 1000 + " secs";

		log.log(Level.INFO, successMessage);

		return successMessage;
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
		List<OCLConcept> oclCodedDiagnoses = new ArrayList<OCLConcept>();
		try {
			oclCodedDiagnoses = JsonUtils.convertFromJsonToList(response.get().body(),
					new TypeReference<List<OCLConcept>>() {
					});
		} catch (InterruptedException | ExecutionException | IOException e) {
			log.log(Level.SEVERE, "Error getting concepts: ", e);
			return null;
		}

		response.join();

		return oclCodedDiagnoses;

	}

	/**
	 * Get a concept from OCL
	 *
	 * @param source
	 * @return
	 */
	private OCLConcept getConceptFromOCL(String source) {
		CompletableFuture<HttpResponse<String>> response = makeRequest(source, 0);
		OCLConcept oclCodedDiagnosis = new OCLConcept();
		try {
			oclCodedDiagnosis = JsonUtils.covertFromJsonToObject(response.get().body(), OCLConcept.class);
		} catch (InterruptedException | ExecutionException | IOException e) {
			log.log(Level.SEVERE, "Error getting concept: ", e);
			return null;
		}

		response.join();

		return oclCodedDiagnosis;
	}

	/**
	 * OCL's pagination no-longer works correctly leading to an infinite loop. Make
	 * an initial request to fetch `num_found` to use in pagination.
	 *
	 * @return count
	 */
	private int getCodedDiagnosisCount() {
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
	 * @param codedDiagnosisMapping
	 */
	private void downloadChildMappings(MBHCodedDiagnosis parentConcept, OCLConcept oclConcept,
			List<OCLConceptMapping> codedDiagnosisMapping) {
		// Take advantage of batching to avoid multiple db calls.
		List<Object> parameters = new ArrayList<Object>();

		String inClause = QueryUtil.getWhereClauseAndSetParametersForSet(
				codedDiagnosisMapping.stream().map(OCLConceptMapping::getExternalId).collect(Collectors.toSet()),
				parameters);

		List<MBHCodedDiagnosisMapping> mCodedDiagnosisMappings = new Query(getCtx(),
				MBHCodedDiagnosisMapping.Table_Name,
				MBHCodedDiagnosisMapping.COLUMNNAME_BH_ExternalID + " IN ( " + inClause + " )", null)
				.setParameters(parameters).list();

		// save every mapping and check underlying concepts
		codedDiagnosisMapping.forEach((mapping) -> {
			// search mapping in db list
			MBHCodedDiagnosisMapping foundCodedDiagnosisMapping = mCodedDiagnosisMappings.stream()
					.filter(filterCodedDiagnosisMapping -> mapping.getExternalId()
							.equals(filterCodedDiagnosisMapping.getBH_ExternalID()))
					.findFirst().orElse(null);

			if (foundCodedDiagnosisMapping == null) {
				// new record
				foundCodedDiagnosisMapping = new MBHCodedDiagnosisMapping(getCtx(), 0, null);
				foundCodedDiagnosisMapping.setBH_ExternalID(mapping.getExternalId());
			}

			foundCodedDiagnosisMapping.setIsActive(mapping.isRetired());
			foundCodedDiagnosisMapping.setBH_Coded_Diagnosis_ID(parentConcept.get_ID());
			foundCodedDiagnosisMapping.setBH_Source(mapping.getToSourceOwner());
			foundCodedDiagnosisMapping.setBH_Map_Type(mapping.getMapType());
			foundCodedDiagnosisMapping.setBH_Owner(mapping.getOwner());
			foundCodedDiagnosisMapping.setBH_Concept_Code(mapping.getToConceptCode());
			foundCodedDiagnosisMapping.setBH_Concept_Name_Resolved(mapping.getToConceptNameResolved());
			foundCodedDiagnosisMapping.saveEx();

			// save ICD-10 code in bh_coded_diagnosis
			if (ICD_10_WHO.equals(mapping.getToSourceName())) {
				parentConcept.setbh_icd10who(mapping.getToConceptCode());
				parentConcept.saveEx();
			}

			// make sure the url
			String mappingUrl = mapping.getToConceptUrl();
			if (mappingUrl == null || "null".equals(mappingUrl)) {
				return;
			}

			// some concepts are mapped to themselves leading to an infinite loop.
			if (!oclConcept.getUrl().equals(mappingUrl)) {
				// check mappings
				OCLConcept concept = getConceptFromOCL(mappingUrl);
				if (concept != null && concept.getMappings() != null && !concept.getMappings().isEmpty()) {
					downloadChildMappings(parentConcept, concept, concept.getMappings());
				}
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
