package org.bandahealth.idempiere.base.process;

import com.fasterxml.jackson.core.type.TypeReference;
import org.adempiere.util.IProcessUI;
import org.bandahealth.idempiere.base.function.Recursive;
import org.bandahealth.idempiere.base.model.DummyProcessMonitor;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHConceptDescription;
import org.bandahealth.idempiere.base.model.MBHConceptExtra;
import org.bandahealth.idempiere.base.model.MBHConceptMapping;
import org.bandahealth.idempiere.base.model.MBHConceptName;
import org.bandahealth.idempiere.base.model.MBHOclOriginatingSource;
import org.bandahealth.idempiere.base.model.OCLConcept;
import org.bandahealth.idempiere.base.model.OCLConceptDescription;
import org.bandahealth.idempiere.base.model.OCLConceptExtra;
import org.bandahealth.idempiere.base.model.OCLConceptMapping;
import org.bandahealth.idempiere.base.model.OCLConceptName;
import org.bandahealth.idempiere.base.utils.JsonUtils;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.bandahealth.idempiere.base.utils.StringUtil;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Process that syncs Concepts with OCL
 * <p>
 * TODO: ConceptSyncProcess will be replaced by this class.
 *
 * @author andrew
 */
public class ConceptSyncProcess extends SvrProcess {

	private String source = "BHGO"; // set default source
	private Boolean fetchMappings = false;
	private Boolean followMappings = false;
	private String sourceIDFilter = "";

	private final int LIMIT = 100;
	private final String OCL_BASE_URL = StringUtil.isNullOrEmpty(System.getenv("OCL_BASE_URL"))
			? "https://api.openconceptlab.org"
			: System.getenv("OCL_BASE_URL");
	private String URI_OPTIONS = "?includeRetired=true&verbose=true";
	private String BHGO_URI = "/orgs/bandahealth/sources/";
	private final String CONCEPTS_URI = "/concepts/";

	private HttpClient client;
	private Set<String> visitedConcepts;
	private Map<String, OCLConcept> conceptsFromOclByUrl;
	private Map<String, OCLConcept> compressedConceptsFromOclByUrl;
	private Map<String, MBHConceptMapping> newlySavedConceptMappingsByOclUuid;
	private Map<String, Set<String>> overrides;
	private AtomicInteger newRecords;
	private AtomicInteger updatedRecords;
	private AtomicInteger deactivatedRecords;
	private Set<String> compressedConcepts;
	private Set<Integer> savedSourceConcepts;

	@Override
	protected void prepare() {
		ProcessInfoParameter[] parameters = getParameter();

		for (ProcessInfoParameter parameter : parameters) {
			String parameterName = parameter.getParameterName();

			if (parameterName.equalsIgnoreCase("source")) {
				source = parameter.getParameterAsString();
			} else if (parameterName.equalsIgnoreCase("shallow")) {
				fetchMappings = !parameter.getParameterAsBoolean();
			} else if (parameterName.equalsIgnoreCase("skipMappings")) {
				followMappings = !parameter.getParameterAsBoolean();
			} else if (parameterName.equalsIgnoreCase("sourceIDFilter")) {
				sourceIDFilter = parameter.getParameterAsString();
			} else {
				log.log(Level.SEVERE, "Unknown Parameter: " + parameterName);
			}
		}

		// Since shallow doesn't fetch the mappings, we can't follow them
		if (!fetchMappings) {
			followMappings = false;
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
		newRecords = new AtomicInteger(0);
		updatedRecords = new AtomicInteger(0);
		deactivatedRecords = new AtomicInteger(0);
		visitedConcepts = new HashSet<>();
		conceptsFromOclByUrl = new HashMap<>();
		overrides = new HashMap<>();
		savedSourceConcepts = new HashSet<>();
		newlySavedConceptMappingsByOclUuid = new HashMap<>();
		client = HttpClient.newBuilder().version(Version.HTTP_2).build();

		IProcessUI processMonitor = Env.getProcessUI(getCtx());
		if (processMonitor == null) {
			processMonitor = new DummyProcessMonitor();
		}
		processMonitor.statusUpdate("Fetching data from OCL...");
		List<OCLConcept> allOclConceptsFromSource = new ArrayList<>();
		//
		// If we're filtering to the specific IDs, go and get those
		boolean areFilteringByID = false;
		if (sourceIDFilter != null && !sourceIDFilter.isEmpty() && !sourceIDFilter.isBlank()) {
			areFilteringByID = true;
			String[] conceptIDs = sourceIDFilter.split(",");
			int counter = 1;
			for (String conceptID : conceptIDs) {
				log.info("Fetching data from OCL...concept " + counter + " of " + conceptIDs.length + ": " + conceptID);
				processMonitor.statusUpdate(
						"Fetching data from OCL...concept " + counter + " of " + conceptIDs.length + ": " + conceptID);
				OCLConcept conceptFromOcl = getConceptFromOCL(constructUrlFromConceptID(conceptID.trim()));
				if (conceptFromOcl == null) {
					continue;
				}
				conceptsFromOclByUrl.put(conceptFromOcl.getUrl(), conceptFromOcl);
				if (followMappings) {
					log.info("Fetching data from OCL...concept " + counter + " of " + conceptIDs.length + ": " + conceptID +
							", following mappings");
					processMonitor.statusUpdate(
							"Fetching data from OCL...concept " + counter + " of " + conceptIDs.length + ": " + conceptID +
									", following mappings");
					fetchChildConcepts(conceptFromOcl);
				}
				allOclConceptsFromSource.add(conceptFromOcl);
				counter++;
			}
		} else { // Go fetch based on pages
			int conceptCount = getConceptCount();
			if (conceptCount == 0) {
				String response = "Not found any concept on OCL";
				log.log(Level.INFO, response);
			}

			int numberOfPages = conceptCount / LIMIT;
			numberOfPages = conceptCount % LIMIT > 0 ? numberOfPages + 1 : numberOfPages;
			for (int page = 1; page <= numberOfPages; page++) {
				log.info("Fetching data from OCL...page " + page + " of " + numberOfPages);
				processMonitor.statusUpdate("Fetching data from OCL...page " + page + " of " + numberOfPages);
				List<OCLConcept> conceptsFromOcl = getConceptsFromOCL(page);
				if (conceptsFromOcl == null) {
					continue;
				}
				int counter = 1;
				for (OCLConcept conceptFromOcl : conceptsFromOcl) {
					conceptsFromOclByUrl.put(conceptFromOcl.getUrl(), conceptFromOcl);
					if (followMappings) {
						log.info(
								"Fetching data from OCL...page " + page + " of " + numberOfPages + ", concept " + counter + " of " +
										conceptsFromOcl.size() + ", following mappings for " + conceptFromOcl.getDisplayName());
						processMonitor.statusUpdate(
								"Fetching data from OCL...page " + page + " of " + numberOfPages + ", concept " + counter + " of " +
										conceptsFromOcl.size() + ", following mappings for " + conceptFromOcl.getDisplayName());
						fetchChildConcepts(conceptFromOcl);
						counter++;
					}
				}
				allOclConceptsFromSource.addAll(conceptsFromOcl);
			}
		}

		// Now that everything is compressed appropriately, we can save to the DB and skip the SAME-AS mappings
		// Take advantage of batching to avoid multiple db calls.
		List<Object> parameters = new ArrayList<>();
		Set<String> items = allOclConceptsFromSource.stream().map(OCLConcept::getUrl).collect(Collectors.toSet());
		String inClause = QueryUtil.getWhereClauseAndSetParametersForSet(items, parameters);
		List<MBHConcept> concepts = parameters.isEmpty() ? new ArrayList<>() :
				new Query(getCtx(), MBHConcept.Table_Name, MBHConcept.COLUMNNAME_URL + " IN ( " + inClause + " )",
						get_TrxName()).setParameters(parameters).list();
		Map<String, MBHConcept> conceptsByOclUrl =
				concepts.stream().collect(Collectors.toMap(MBHConcept::getURL, concept -> concept));

		int i = 0;
		for (OCLConcept conceptFromOcl : allOclConceptsFromSource) {
			i++;
			if (!conceptsFromOclByUrl.containsKey(conceptFromOcl.getUrl())) {
				continue;
			}
			try {
				processMonitor.statusUpdate(
						"Saving concept " + i + " of " + allOclConceptsFromSource.size() + ": " + conceptFromOcl.getDisplayName());
				compressedConcepts = new HashSet<>();
				compressedConceptsFromOclByUrl = new HashMap<>();
				if (followMappings) {
					compressConceptSameAsTree(conceptFromOcl);
				}
				saveConcept(compressedConceptsFromOclByUrl.getOrDefault(conceptFromOcl.getUrl(),
						conceptsFromOclByUrl.get(conceptFromOcl.getUrl())), conceptsByOclUrl.get(conceptFromOcl.getUrl()), false);
			} catch (Exception ex) {
				log.log(Level.SEVERE, ex.getMessage());
			}
		}

		// Delete all OCL originating source records for concepts that weren't saved
		if (!areFilteringByID) {
			processMonitor.statusUpdate("Cleaning up...");
			parameters = new ArrayList<>();
			parameters.add(source);
			String whereClause = MBHOclOriginatingSource.COLUMNNAME_BH_Ocl_Source + "=?";
			if (!savedSourceConcepts.isEmpty()) {
				inClause = QueryUtil.getWhereClauseAndSetParametersForSet(savedSourceConcepts, parameters);
				whereClause += " AND " + MBHOclOriginatingSource.COLUMNNAME_BH_Concept_ID + " NOT IN (" + inClause + ")";
			}
			List<MBHOclOriginatingSource> oclOriginatingSourceList = new Query(getCtx(), MBHOclOriginatingSource.Table_Name,
					whereClause, get_TrxName()).setParameters(parameters).list();
			oclOriginatingSourceList.forEach(oclOriginatingSource -> oclOriginatingSource.deleteEx(false));
		}

		String successMessage = "SUCCESSFULLY created " + newRecords.get() + ", updated " + updatedRecords.get()
				+ ", deactivated " + deactivatedRecords.get() + " records in " + (System.currentTimeMillis() - start) / 1000 +
				" secs";

		log.log(Level.INFO, successMessage);

		// Clear this to ensure memory can be freed
		newlySavedConceptMappingsByOclUuid = new HashMap<>();

		// Ensure GC can happen and close the connections
		client = null;

		return successMessage;
	}

	/**
	 * Load any child concepts from OCL via the mappings and construct the SAME-AS mapping tree
	 * <p>
	 * <p>
	 * c
	 *
	 * @param conceptFromOcl The concept to look through mappings for
	 */
	private void fetchChildConcepts(OCLConcept conceptFromOcl) {
		conceptFromOcl.getMappings().stream()
				// We'll skip the broader-than map types, retired mappings, and times where the mapping is to the own concept
				.filter(conceptMappingFromOcl ->
								!StringUtil.isNullOrEmpty(conceptMappingFromOcl.getToConceptUrl()) &&
								!conceptMappingFromOcl.getToConceptUrl().equalsIgnoreCase(conceptFromOcl.getUrl()) &&
								!conceptMappingFromOcl.isRetired())
				.forEach(conceptMappingFromOcl -> {
					// We're not going to exit out if we've already seen the child because we may need to handle SAME-AS mappings
					OCLConcept childConceptFromOcl =
							conceptsFromOclByUrl.getOrDefault(conceptMappingFromOcl.getToConceptUrl(), null);
					boolean haveAlreadyFetchedChildConcepts = false;
					if (childConceptFromOcl == null) {
						childConceptFromOcl = getConceptFromOCL(conceptMappingFromOcl.getToConceptUrl());
						if (childConceptFromOcl == null) {
							return;
						}
						conceptsFromOclByUrl.put(childConceptFromOcl.getUrl(), childConceptFromOcl);
					} else {
						haveAlreadyFetchedChildConcepts = true;
					}
					// If this child concept is active and has a same-as mapping that's not mapped to itself, add it
					if (!childConceptFromOcl.isRetired() &&
							!conceptFromOcl.getUrl().equalsIgnoreCase(childConceptFromOcl.getUrl()) &&
							(conceptMappingFromOcl.getMapType().equalsIgnoreCase(MBHConceptMapping.SAME_AS2_MAP_TYPE) ||
									conceptMappingFromOcl.getMapType().equalsIgnoreCase(MBHConceptMapping.SAME_AS_MAP_TYPE))) {
						if (!overrides.containsKey(conceptFromOcl.getUrl())) {
							overrides.put(conceptFromOcl.getUrl(), new HashSet<>());
						}
						overrides.get(conceptFromOcl.getUrl()).add(childConceptFromOcl.getUrl());
					}
					if (!haveAlreadyFetchedChildConcepts) {
						fetchChildConcepts(childConceptFromOcl);
					}
				});
	}

	/**
	 * Get the concepts that have SAME-AS mappings to others and bubble up the properties, exposing only the ones that
	 * a parent doesn't override. For infinite loops (i.e. concept A = B = C = A), cycle through and compress each,
	 * individually, then remove the looping.
	 *
	 * @param conceptFromOcl The concept we're starting with to compress
	 */
	private OCLConcept compressConceptSameAsTree(OCLConcept conceptFromOcl) {
		// If we've already compressed this concept, be done
		if (compressedConcepts.contains(conceptFromOcl.getUrl())) {
			return conceptFromOcl;
		}
		compressedConcepts.add(conceptFromOcl.getUrl());
		List<String> terminatingConceptUrls = new ArrayList<>();
		// Define our recursive function that will go and go all the way through the tree
		Recursive<Function<List<String>, List<String>>> getConceptChains = new Recursive<>();
		// This function will produce a list of distinct A > B > C URLs to show which concepts map where that we can
		// collapse
		getConceptChains.func = (parentConceptUrls) -> {
			OCLConcept startingConcept = conceptsFromOclByUrl.get(parentConceptUrls.get(parentConceptUrls.size() - 1));
			// If there are no overrides or every child is in the chain or terminating nodes, we've got a terminating node!
			if (!overrides.containsKey(startingConcept.getUrl()) ||
					new HashSet<>(parentConceptUrls).containsAll(overrides.get(startingConcept.getUrl())) ||
					new HashSet<>(terminatingConceptUrls).containsAll(overrides.get(startingConcept.getUrl()))) {
				terminatingConceptUrls.addAll(parentConceptUrls);
				return Collections.singletonList(String.join(" ", parentConceptUrls));
			}
			// Now look at the child concepts and see how we can construct the chain
			return overrides.get(startingConcept.getUrl()).stream()
					// Don't go back up the way we came and don't look at retired children
					.filter(childConceptUrl -> parentConceptUrls.size() < 2 ||
							!childConceptUrl.equalsIgnoreCase(parentConceptUrls.get(parentConceptUrls.size() - 2)) ||
							!conceptsFromOclByUrl.get(childConceptUrl).isRetired())
					// These concepts are okay, so investigate
					.flatMap(childConceptUrl -> {
						// If we've reached a terminating node or are back in the current chain via the parents, skip this (since
						// both of those cases will already be handled above)
						if (terminatingConceptUrls.contains(childConceptUrl) || parentConceptUrls.contains(childConceptUrl)) {
							return Stream.empty();
						}
						List<String> newParentConceptsUrls = new ArrayList<>(parentConceptUrls);
						newParentConceptsUrls.add(childConceptUrl);
						return getConceptChains.func.apply(newParentConceptsUrls).stream();
					}).collect(Collectors.toList());
		};
		Map<String, List<String>> temporaryOverrides = new HashMap<>();
		getConceptChains.func.apply(Collections.singletonList(conceptFromOcl.getUrl())).forEach(chain -> {
			List<String> chainOfConceptUrls = Arrays.asList(chain.split(" "));
			for (int i = 0; i < chainOfConceptUrls.size() - 1; i++) {
				if (!temporaryOverrides.containsKey(chainOfConceptUrls.get(i))) {
					temporaryOverrides.put(chainOfConceptUrls.get(i), new ArrayList<>());
				}
				if (!temporaryOverrides.get(chainOfConceptUrls.get(i)).contains(chainOfConceptUrls.get(i + 1))) {
					temporaryOverrides.get(chainOfConceptUrls.get(i)).add(chainOfConceptUrls.get(i + 1));
				}
			}
		});
		if (!temporaryOverrides.containsKey(conceptFromOcl.getUrl())) {
			return conceptFromOcl;
		}
		for (String oclConceptThatIsOverridden : temporaryOverrides.get(conceptFromOcl.getUrl())) {
			OCLConcept conceptToOverride = conceptsFromOclByUrl.get(oclConceptThatIsOverridden).cloneOriginal();
			// Compress this one first
			compressConceptSameAsTree(conceptToOverride);
			// Now update the current concept
			conceptFromOcl.setPropertiesFromSameAsChild(conceptToOverride);
			// Clear every dependent thing from the child (since it will be saved)
			conceptToOverride.truncate();
			compressedConceptsFromOclByUrl.put(conceptToOverride.getUrl(), conceptToOverride);
		}
		// Now update the concept in our mapping tree
		compressedConceptsFromOclByUrl.put(conceptFromOcl.getUrl(), conceptFromOcl);
		return conceptFromOcl;
	}

	/**
	 * Save concepts and child entities (mappings, extras)
	 *
	 * @return The saved concept
	 */
	private MBHConcept saveConcept(OCLConcept conceptFromOcl, MBHConcept concept, boolean isSameAsMapping) {
		// If there is no new concept to save or we already visited this concept, return
		// the concept that was passed in to be updated if there was one
		if (conceptFromOcl == null || visitedConcepts.contains(conceptFromOcl.getUrl())) {
			return concept;
		}

		if (concept == null) {
			concept = new MBHConcept(getCtx(), 0, get_TrxName());
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

		// If this is a same-as mapping, everything of importance will have been pulled up to the parent, so just be done
		if (isSameAsMapping) {
			return concept;
		}

		// Continue on and save everything
		visitedConcepts.add(conceptFromOcl.getUrl());

		final int conceptID = concept.getBH_Concept_ID();

		savedSourceConcepts.add(concept.get_ID());
		// check ocl originating source
		MBHOclOriginatingSource foundSource = new Query(getCtx(), MBHOclOriginatingSource.Table_Name,
				MBHOclOriginatingSource.COLUMNNAME_BH_Concept_ID + "=? AND "
						+ MBHOclOriginatingSource.COLUMNNAME_BH_Ocl_Source + "=?",
				get_TrxName()).setParameters(conceptID, source).first();

		// create ocl originating source if one doesn't exist
		if (foundSource == null) {
			foundSource = new MBHOclOriginatingSource(getCtx(), 0, get_TrxName());
			foundSource.setBH_Concept_ID(conceptID);
			foundSource.setBH_Ocl_Source(source);
			foundSource.saveEx();
		}

		// check existing extras
		List<MBHConceptExtra> conceptExtras = new Query(getCtx(), MBHConceptExtra.Table_Name,
				MBHConceptExtra.COLUMNNAME_BH_Concept_ID + "=? ", get_TrxName()).setParameters(conceptID).list();

		// save extras
		conceptFromOcl.getExtrasByKey().forEach((conceptExtraKeyFromOcl, conceptExtraValueFromOcl) -> {
			// search extra in db list
			MBHConceptExtra foundConceptExtra = conceptExtras.stream()
					.filter(filterConceptExtra -> conceptExtraKeyFromOcl.equalsIgnoreCase(filterConceptExtra.getBH_Key()))
					.findFirst().orElse(null);

			if (foundConceptExtra == null) {
				// new record
				foundConceptExtra = new MBHConceptExtra(getCtx(), 0, get_TrxName());
				foundConceptExtra.setBH_Concept_ID(conceptID);
				newRecords.incrementAndGet();
			} else {
				updatedRecords.incrementAndGet();
			}

			foundConceptExtra.setBH_Key(conceptExtraKeyFromOcl);
			foundConceptExtra.setBH_Value(conceptExtraValueFromOcl);
			foundConceptExtra.setIsActive(!conceptFromOcl.isRetired());
			foundConceptExtra.saveEx();
		});

		// Deactivate extras that are no longer used (if we followed child mappings because then we could have compressed
		// the SAME-AS tree and have all data)
		if (followMappings) {
			Set<String> currentOclConceptExtraKeys = conceptFromOcl.getExtrasByKey().keySet();
			conceptExtras.stream()
					.filter(conceptExtra -> !currentOclConceptExtraKeys.contains(conceptExtra.getBH_Key()))
					.forEach(conceptMappingExtra -> {
						deactivatedRecords.incrementAndGet();
						conceptMappingExtra.setIsActive(false);
						conceptMappingExtra.saveEx();
					});
		}

		// get concept names
		List<MBHConceptName> conceptNames = new Query(getCtx(), MBHConceptName.Table_Name,
				MBHConceptName.COLUMNNAME_BH_Concept_ID + "=?", get_TrxName()).setParameters(conceptID).list();
		Map<String, MBHConceptName> conceptNamesByOclUU =
				conceptNames.stream().collect(Collectors.toMap(MBHConceptName::getOcl_Uuid, conceptName -> conceptName));
		conceptFromOcl.getNamesByLanguageAndType().values().stream().flatMap(Collection::stream).forEach(oclConceptName -> {
			// search name in db list
			MBHConceptName foundConceptName = conceptNamesByOclUU.get(oclConceptName.getUuid());

			if (foundConceptName == null) {
				// new record
				foundConceptName = new MBHConceptName(getCtx(), 0, get_TrxName());
				foundConceptName.setOcl_Uuid(oclConceptName.getUuid());
				foundConceptName.setBH_Concept_ID(conceptID);
				newRecords.incrementAndGet();
			} else {
				updatedRecords.incrementAndGet();
			}

			foundConceptName.setIsActive(true);
			foundConceptName.setBH_Concept_Locale(oclConceptName.getLocale());
			foundConceptName.setName(oclConceptName.getName());
			foundConceptName.setBH_Concept_Type(oclConceptName.getType());
			foundConceptName.setBH_Concept_Name_Type(oclConceptName.getNameType());
			foundConceptName.setBH_Concept_Locale_Preferred(oclConceptName.isLocalePreferred());
			foundConceptName.saveEx();
			conceptNamesByOclUU.put(oclConceptName.getUuid(), foundConceptName);
		});

		// Deactivate names that are no longer used (if we followed child mappings because then we could have compressed
		// the SAME-AS tree and have all data)
		if (followMappings) {
			Set<String> currentOclConceptNameUUs =
					conceptFromOcl.getNamesByLanguageAndType().values().stream().flatMap(Collection::stream)
							.map(OCLConceptName::getUuid).collect(Collectors.toSet());
			conceptNames.stream()
					.filter(conceptName -> !currentOclConceptNameUUs.contains(conceptName.getOcl_Uuid()))
					.forEach(conceptName -> {
						deactivatedRecords.incrementAndGet();
						conceptName.setIsActive(false);
						conceptName.saveEx();
					});
		}

		// get concept descriptions
		List<MBHConceptDescription> conceptDescriptions = new Query(getCtx(), MBHConceptDescription.Table_Name,
				MBHConceptDescription.COLUMNNAME_BH_Concept_ID + "=?", get_TrxName()).setParameters(conceptID).list();
		Map<String, MBHConceptDescription> conceptDescriptionsByOclUU = conceptDescriptions.stream()
				.collect(Collectors.toMap(MBHConceptDescription::getOcl_Uuid, conceptDescription -> conceptDescription));
		conceptFromOcl.getDescriptionsByLanguageAndType().values().stream().flatMap(Collection::stream)
				.forEach(oclConceptDescription -> {
					// search name in db list
					MBHConceptDescription conceptDescription = conceptDescriptionsByOclUU.get(oclConceptDescription.getUuid());

					if (conceptDescription == null) {
						// new record
						conceptDescription = new MBHConceptDescription(getCtx(), 0, get_TrxName());
						conceptDescription.setOcl_Uuid(oclConceptDescription.getUuid());
						conceptDescription.setBH_Concept_ID(conceptID);
						newRecords.incrementAndGet();
					} else {
						updatedRecords.incrementAndGet();
					}

					conceptDescription.setIsActive(true);
					conceptDescription.setBH_Concept_Locale(oclConceptDescription.getLocale());
					conceptDescription.setName(oclConceptDescription.getDescription());
					conceptDescription.setBH_Concept_Type(oclConceptDescription.getType());
					conceptDescription.setBH_Concept_Description_Type(oclConceptDescription.getDescriptionType());
					conceptDescription.setBH_Concept_Locale_Preferred(oclConceptDescription.isLocalePreferred());
					conceptDescription.saveEx();
					conceptDescriptionsByOclUU.put(conceptDescription.getOcl_Uuid(), conceptDescription);
				});

		// Deactivate descriptions that are no longer used (if we followed child mappings because then we could have
		// compressed the SAME-AS tree and have all data)
		if (followMappings) {
			Set<String> currentOclConceptDescriptionUUs =
					conceptFromOcl.getDescriptionsByLanguageAndType().values().stream().flatMap(Collection::stream)
							.map(OCLConceptDescription::getUuid).collect(Collectors.toSet());
			conceptDescriptions.stream()
					.filter(conceptDescription -> !currentOclConceptDescriptionUUs.contains(conceptDescription.getOcl_Uuid()))
					.forEach(conceptDescription -> {
						deactivatedRecords.incrementAndGet();
						conceptDescription.setIsActive(false);
						conceptDescription.saveEx();
					});
		}

		// save mappings
		if (fetchMappings) {
			saveChildMappings(concept, conceptFromOcl);
		}

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
	private void saveChildMappings(MBHConcept parentConcept, OCLConcept oclConcept) {
		if (oclConcept.getMappings() == null || oclConcept.getMappings().isEmpty()) {
			return;
		}
		// Get mappings for this concept
		List<MBHConceptMapping> conceptMappings = new Query(getCtx(), MBHConceptMapping.Table_Name,
				MBHConceptMapping.COLUMNNAME_From_BH_Concept_ID + "=?", get_TrxName()).setParameters(
						parentConcept.getBH_Concept_ID())
				.list();
		Map<String, MBHConceptMapping> conceptMappingsByOclUU = conceptMappings.stream()
				.collect(Collectors.toMap(MBHConceptMapping::getOcl_Uuid, conceptMapping -> conceptMapping));

		List<OCLConceptMapping> oclConceptMappingsToWorkWith = oclConcept.getActiveMappingsByMapType().keySet().stream()
				.flatMap(conceptMappingMapType -> oclConcept.getActiveMappingsByMapType().get(conceptMappingMapType).stream())
				.toList();

		// Deactivate the mappings that we're not working with
		if (followMappings) {
			conceptMappingsByOclUU.keySet().stream().filter(oclUU -> oclConceptMappingsToWorkWith.stream()
							.noneMatch(oclConceptMappingToWorkWith -> oclConceptMappingToWorkWith.getUuid().equals(oclUU)))
					.forEach(oclConceptMappingUUToDelete -> {
						// Deactivate any extras that were used
						List<MBHConceptExtra> conceptExtras =
								new Query(getCtx(), MBHConceptExtra.Table_Name, MBHConceptExtra.COLUMNNAME_BH_Concept_Mapping_ID +
										"=?",
										get_TrxName()).setParameters(
										conceptMappingsByOclUU.get(oclConceptMappingUUToDelete).getBH_Concept_Mapping_ID()).list();
						conceptExtras.forEach(conceptExtraToDelete -> {
							deactivatedRecords.incrementAndGet();
							conceptExtraToDelete.setIsActive(false);
							conceptExtraToDelete.saveEx();
						});
						deactivatedRecords.incrementAndGet();
						conceptMappingsByOclUU.get(oclConceptMappingUUToDelete).setIsActive(false);
						conceptMappingsByOclUU.get(oclConceptMappingUUToDelete).saveEx();
					});
		}

		if (oclConceptMappingsToWorkWith.isEmpty()) {
			return;
		}

		// save every mapping and check underlying concepts
		oclConceptMappingsToWorkWith.forEach((conceptMappingFromOcl) -> {
			MBHConceptMapping foundConceptMapping = conceptMappingsByOclUU.get(conceptMappingFromOcl.getUuid());

			if (foundConceptMapping == null &&
					newlySavedConceptMappingsByOclUuid.containsKey(conceptMappingFromOcl.getUuid())) {
				foundConceptMapping = newlySavedConceptMappingsByOclUuid.get(conceptMappingFromOcl.getUuid());
			}

			if (foundConceptMapping == null) {
				// new record
				foundConceptMapping = new MBHConceptMapping(getCtx(), 0, get_TrxName());
				foundConceptMapping.setOcl_Uuid(conceptMappingFromOcl.getUuid());
				newRecords.incrementAndGet();
				newlySavedConceptMappingsByOclUuid.put(conceptMappingFromOcl.getUuid(), foundConceptMapping);
			} else {
				updatedRecords.incrementAndGet();
			}

			foundConceptMapping.setFrom_BH_Concept_ID(parentConcept.get_ID());
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
					MBHConceptExtra.COLUMNNAME_BH_Concept_Mapping_ID + "=? ", get_TrxName()).setParameters(conceptMappingID)
					.list();

			// get extras
			conceptMappingFromOcl.getExtras().forEach((extra) -> {
				// search extra in db list
				MBHConceptExtra foundConceptExtra = mConceptMappingExtras.stream()
						.filter(filterConceptExtra -> extra.getKey().equals(filterConceptExtra.getBH_Key()))
						.findFirst().orElse(null);

				if (foundConceptExtra == null) {
					// new record
					foundConceptExtra = new MBHConceptExtra(getCtx(), 0, get_TrxName());
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
			if (followMappings) {
				Set<String> currentOclConceptExtraKeys =
						conceptMappingFromOcl.getExtras().stream().map(OCLConceptExtra::getKey).collect(Collectors.toSet());
				mConceptMappingExtras.stream()
						.filter(conceptMappingExtra -> !currentOclConceptExtraKeys.contains(conceptMappingExtra.getBH_Key()))
						.forEach(conceptMappingExtra -> {
							deactivatedRecords.incrementAndGet();
							conceptMappingExtra.setIsActive(false);
							conceptMappingExtra.saveEx();
						});
			}

			String mappingUrl = conceptMappingFromOcl.getToConceptUrl();

			// some concepts are mapped to themselves leading to an infinite loop.
			if (!StringUtil.isNullOrEmpty(mappingUrl)) {
				if (!oclConcept.getUrl().equals(mappingUrl)) {
					if (followMappings) {
						// Child concepts may need to be compressed, too, so check it
						if (!compressedConceptsFromOclByUrl.containsKey(mappingUrl)) {
							compressConceptSameAsTree(conceptsFromOclByUrl.get(mappingUrl));
						}
						// get the child concept
						OCLConcept childOclConcept =
								compressedConceptsFromOclByUrl.getOrDefault(mappingUrl, conceptsFromOclByUrl.get(mappingUrl));
						MBHConcept foundChildConcept =
								new Query(getCtx(), MBHConcept.Table_Name, MBHConcept.COLUMNNAME_URL + "=?",
										get_TrxName()).setParameters(
										childOclConcept.getUrl()).first();

						MBHConcept savedChildConcept = saveConcept(childOclConcept, foundChildConcept,
								conceptMappingFromOcl.getMapType().equalsIgnoreCase(MBHConceptMapping.SAME_AS_MAP_TYPE) ||
										conceptMappingFromOcl.getMapType().equalsIgnoreCase(MBHConceptMapping.SAME_AS2_MAP_TYPE));

						// after populating and saving the child concept, link it to the "TO" end of this mapping
						foundConceptMapping.setTo_BH_Concept_ID(savedChildConcept == null ? 0 : savedChildConcept.get_ID());
						foundConceptMapping.saveEx();
					}
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
				URI_OPTIONS + (fetchMappings ? "&includeMappings=true" : "") +
				(includeSort ? "&sortAsc=name" : "") +
				(limit > 0 ? "&limit=" + limit : "") +
				(page > 0 ? "&page=" + page : "");
	}

	private String constructUrlFromConceptID(String conceptID) {
		return BHGO_URI + this.source + CONCEPTS_URI + conceptID + "/";
	}
}
