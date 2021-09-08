package org.bandahealth.idempiere.base.process;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.stream.Collectors;

import org.bandahealth.idempiere.base.model.MBHCodedDiagnosis;
import org.bandahealth.idempiere.base.model.OCLCodedDiagnosis;
import org.bandahealth.idempiere.base.model.OCLCodedDiagnosisMapping;
import org.bandahealth.idempiere.base.utils.JsonUtils;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;

import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Process that syncs CodedDiagnosis (concepts) with OCL
 * 
 * @author andrew
 *
 */
public class CodedDiagnosisSyncProcess extends SvrProcess {

	private final int LIMIT = 100;
	private String OCL_BASE_URL = "https://api.openconceptlab.org/orgs/bandahealth/sources/";
	private final String CIEL = "CIEL";
	private final String ICD_10_WHO = "ICD-10-WHO";
	private final String MOH_705A_LESSTHAN5 = "MOH-705A-LESSTHAN5";
	private final String MOH_705B_GREATERTHAN5 = "MOH-705B-GREATERTHAN5";
	private final String INDEX_TERMS = "index_terms";

	private final HttpClient client = HttpClient.newBuilder().version(Version.HTTP_2).build();

	private String source = "BHGO"; // set default source

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

		OCL_BASE_URL += source + "/concepts/?includeMappings=true&sortAsc=name&verbose=true&limit=" + LIMIT;
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
		int page = 1;
		boolean hasResults = true;
		AtomicInteger newRecords = new AtomicInteger(0);
		AtomicInteger updatedRecords = new AtomicInteger(0);

		do {
			List<OCLCodedDiagnosis> codedDiagnoses = getCodedDiagnosisFromOCL(page);
			hasResults = !codedDiagnoses.isEmpty();
			if (!hasResults) {
				break;
			}
			// Take advantage of batching to avoid multiple db calls.
			List<Object> parameters = new ArrayList<Object>();

			String inClause = QueryUtil.getWhereClauseAndSetParametersForSet(codedDiagnoses.stream()
					.map(codedDiagnosis -> codedDiagnosis.getExternalId()).collect(Collectors.toSet()), parameters);

			List<MBHCodedDiagnosis> mCodedDiagnoses = new Query(getCtx(), MBHCodedDiagnosis.Table_Name,
					MBHCodedDiagnosis.COLUMNNAME_BH_Coded_Diagnosis_UU + " IN ( " + inClause + " )", null)
							.setParameters(parameters).list();

			codedDiagnoses.forEach(codedDiagnosis -> {
				// search for coded diagnosis in db list
				MBHCodedDiagnosis foundCodedDiagnosis = mCodedDiagnoses.stream()
						.filter(filterCodedDiagnosis -> codedDiagnosis.getExternalId()
								.equals(filterCodedDiagnosis.getBH_CodedDiagnosis_UU()))
						.findFirst().orElse(null);
				if (foundCodedDiagnosis == null) {
					// new record
					foundCodedDiagnosis = new MBHCodedDiagnosis(getCtx(), 0, null);
					foundCodedDiagnosis.setBH_CodedDiagnosis_UU(
							codedDiagnosis.getExternalId() != null && !codedDiagnosis.getExternalId().isEmpty()
									? codedDiagnosis.getExternalId()
									: codedDiagnosis.getUuid());
					newRecords.incrementAndGet();
				} else {
					foundCodedDiagnosis.setIsActive(codedDiagnosis.isRetired());
					updatedRecords.incrementAndGet();
				}

				List<OCLCodedDiagnosisMapping> codedDiagnosisMapping = codedDiagnosis.getMappings();
				OCLCodedDiagnosisMapping cielMapping = codedDiagnosisMapping.stream()
						.filter(mapping -> CIEL.equals(mapping.getToSourceName())).findFirst().orElse(null);
				OCLCodedDiagnosisMapping icd10wHOMapping = codedDiagnosisMapping.stream()
						.filter(mapping -> ICD_10_WHO.equals(mapping.getToSourceName())).findFirst().orElse(null);
				Map<String, String> extras = codedDiagnosis.getExtras();

				foundCodedDiagnosis.setBH_CielName(codedDiagnosis.getDisplayName());

				if (cielMapping != null && cielMapping.getToConceptCode() != null) {
					foundCodedDiagnosis.setBH_CielId(Integer.valueOf(cielMapping.getToConceptCode()));
				}

				foundCodedDiagnosis.setBH_ConceptClass(codedDiagnosis.getConceptClass());
				foundCodedDiagnosis.setBH_ICD10(icd10wHOMapping != null ? icd10wHOMapping.getToConceptCode() : null);
				foundCodedDiagnosis.setBH_MoH705ALessThan5(extras.get(MOH_705A_LESSTHAN5));
				foundCodedDiagnosis.setBH_MoH705BGreaterThan5(extras.get(MOH_705B_GREATERTHAN5));
				foundCodedDiagnosis.setBH_SearchTerms(extras.get(INDEX_TERMS));

				foundCodedDiagnosis.saveEx();
			});

			page++;
		} while (hasResults);

		String successMessage = "SUCCESSFULLY created " + newRecords.get() + ", updated " + updatedRecords.get()
				+ " records in " + (System.currentTimeMillis() - start) / 1000 + " secs";

		log.log(Level.INFO, successMessage);

		return successMessage;
	}

	private List<OCLCodedDiagnosis> getCodedDiagnosisFromOCL(int page) {
		HttpRequest request = HttpRequest.newBuilder(URI.create(OCL_BASE_URL + "&page=" + page))
				.header("Content-Type", "application/json").build();

		CompletableFuture<HttpResponse<String>> response = client.sendAsync(request, BodyHandlers.ofString());
		List<OCLCodedDiagnosis> oclCodedDiagnoses = new ArrayList<OCLCodedDiagnosis>();
		try {
			oclCodedDiagnoses = JsonUtils.convertFromJsonToList(response.get().body(),
					new TypeReference<List<OCLCodedDiagnosis>>() {
					});
		} catch (InterruptedException | ExecutionException | IOException e) {
			log.log(Level.SEVERE, "Error getting concepts: ", e);
		}

		response.join();

		return oclCodedDiagnoses;

	}
}
