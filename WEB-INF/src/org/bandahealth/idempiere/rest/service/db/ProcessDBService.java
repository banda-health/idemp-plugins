package org.bandahealth.idempiere.rest.service.db;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.base.model.MDashboardButtonGroupButton;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.base.process.ExpenseProcess;
import org.bandahealth.idempiere.rest.function.VoidFunction;
import org.bandahealth.idempiere.rest.model.Process;
import org.bandahealth.idempiere.rest.model.ProcessParameter;
import org.bandahealth.idempiere.rest.model.ReportType;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.rest.model.BHProcessInfo;
import org.bandahealth.idempiere.rest.model.BHProcessInfoParameter;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Paging;
import org.compiere.model.MPInstance;
import org.compiere.model.MProcess;
import org.compiere.model.MProcessPara;
import org.compiere.model.MRefList;
import org.compiere.model.MReference;
import org.compiere.model.MRole;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfo;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.ServerProcessCtl;
import org.compiere.util.Env;

/**
 * A simple POJO that runs iDempiere processes
 *
 * @author andrew
 */
public class ProcessDBService extends BaseDBService<Process, MProcess> {

	// report UUIDs
	public static final String THERMAL_RECEIPT_REPORT = "30dd7243-11c1-4584-af26-5d977d117c84";
	public static final String DEBT_PAYMENT_RECEIPT = "173a691b-ba89-4987-9216-9b3f0a60c864";

	private final String SALES_PROCESS_CLASS_NAME = "org.bandahealth.idempiere.base.process.SalesProcess";
	private final String STOCKTAKE_PROCESS_CLASS_NAME = "org.bandahealth.idempiere.base.process.StockTakeProcess";
	private final String EXPENSE_PROCESS_CLASS_NAME = "org.bandahealth.idempiere.base.process.ExpenseProcess";
	private final String QUANTITY = "QUANTITY";

	private final ProcessParameterDBService processParameterDBService;
	private final ReferenceDBService referenceDBService;
	private final ReferenceListDBService referenceListDBService;
	private final Map<ReportType, String> contentTypes = new HashMap<>() {{
		put(ReportType.CSV, "text/csv");
		put(ReportType.HTML, "text/html");
		put(ReportType.PDF, "application/pdf");
		put(ReportType.XLS, "application/vnd.ms-excel");
		put(ReportType.XLSX, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	}};

	public ProcessDBService() {
		processParameterDBService = new ProcessParameterDBService();
		referenceDBService = new ReferenceDBService();
		referenceListDBService = new ReferenceListDBService();
	}

	/**
	 * Run process
	 *
	 * @param request
	 * @return
	 */
	public static BHProcessInfo runProcess(BHProcessInfo request) {
		if (request == null) {
			return null;
		}

		MProcess mprocess = new Query(Env.getCtx(), MProcess.Table_Name, MProcess.COLUMNNAME_AD_Process_UU + "=?", null)
				.setOnlyActiveRecords(true).setParameters(request.getUuid()).first();

		MPInstance mpInstance = new MPInstance(mprocess, 0);

		ProcessInfo processInfo = new ProcessInfo(mprocess.getName(), mprocess.getAD_Process_ID());
		processInfo.setAD_PInstance_ID(mpInstance.getAD_PInstance_ID());
		processInfo.setAD_Client_ID(Env.getAD_Client_ID(Env.getCtx()));
		processInfo.setAD_PInstance_ID(mpInstance.getAD_PInstance_ID());
		processInfo.setAD_Process_UU(mprocess.getAD_Process_UU());

		if (request.getParameters() != null && !request.getParameters().isEmpty()) {
			processInfo.setParameter(getInfoParameters(request.getParameters()));
		}

		ServerProcessCtl.process(processInfo, null);

		BHProcessInfo response = new BHProcessInfo(mprocess.getName(), mprocess.getAD_Process_ID());
		response.setPinstanceId(processInfo.getAD_PInstance_ID());
		response.setSummary(processInfo.getSummary());
		response.setError(processInfo.isError());

		return response;
	}

	/**
	 * Retrieve process with the given uuid
	 *
	 * @param uuid
	 * @return
	 */
	public static Process getProcess(String uuid) {
		MProcess process = new Query(Env.getCtx(), MProcess.Table_Name, MProcess.COLUMNNAME_AD_Process_UU + "=?", null)
				.setOnlyActiveRecords(true).setParameters(uuid).first();

		if (process != null) {
			List<MProcessPara> params = new Query(Env.getCtx(), MProcessPara.Table_Name,
					MProcessPara.COLUMNNAME_AD_Process_ID + "=?", null).setOnlyActiveRecords(true)
					.setParameters(process.get_ID()).list();
			List<ProcessParameter> parameters = new ArrayList<>();
			for (MProcessPara param : params) {
				parameters.add(createProcessParameterInstance(param));
			}

			return createProcessInstance(process, parameters);
		}

		return null;
	}

	private static Process createProcessInstance(MProcess process, List<ProcessParameter> parameters) {
		return new Process(process.getAD_Client_ID(), process.getAD_Org_ID(), process.getAD_Process_UU(),
				process.isActive(), DateUtil.parse(process.getCreated()), process.getCreatedBy(),
				process.getDescription(), process.getName(), process.getAD_Form_ID(), process.getAD_ReportView_ID(),
				process.getAD_Workflow_ID(), process.getAllowMultipleExecution(), process.getClassname(),
				process.getCopyFromProcess(), process.getEntityType(), process.getExecutionType(),
				process.isDirectPrint(), process.isReport(), parameters);
	}

	private static ProcessParameter createProcessParameterInstance(MProcessPara param) {
		return new ProcessParameter(param.getAD_Client_ID(), param.getAD_Org_ID(), param.getAD_Process_Para_UU(),
				param.isActive(), DateUtil.parse(param.getCreated()), param.getCreatedBy(), param.getName(),
				param.getDescription(), param.getAD_Element_ID(), param.getAD_Reference_ID(),
				param.getAD_Reference_Value_ID(), param.getAD_Val_Rule_ID(), param.getDefaultValue(),
				param.getDefaultValue2(), param.getDisplayLogic(), param.getEntityType(), param.getFieldLength(),
				param.isEncrypted(), param.isMandatory(), param.isRange(), param.getMandatoryLogic(), param);
	}

	private static ProcessInfoParameter[] getInfoParameters(List<BHProcessInfoParameter> params) {
		ProcessInfoParameter[] results = new ProcessInfoParameter[params.size()];
		for (int index = 0; index < params.size(); index++) {
			BHProcessInfoParameter param = params.get(index);
			results[index] = new ProcessInfoParameter(param.getParameterName(), param.getParameter(),
					param.getParameterTo(), param.getInfo(), param.getInfoTo());
		}

		return results;
	}

	@Override
	protected boolean isClientIdFromTheContextNeededByDefaultForThisEntity() {
		return false;
	}

	/**
	 * Call and run the SalesProcess
	 *
	 * @param orderId
	 */
	public String runOrderProcess(int orderId) {
		MProcess mprocess = new Query(Env.getCtx(), MProcess.Table_Name, MProcess.COLUMNNAME_Classname + "=?", null)
				.setOnlyActiveRecords(true).setParameters(SALES_PROCESS_CLASS_NAME).first();

		MPInstance mpInstance = new MPInstance(mprocess, 0);

		ProcessInfo processInfo = new ProcessInfo(mprocess.getName(), mprocess.getAD_Process_ID());
		processInfo.setAD_PInstance_ID(mpInstance.getAD_PInstance_ID());
		processInfo.setAD_Process_UU(mprocess.getAD_Process_UU());

		processInfo.setParameter(new ProcessInfoParameter[]{
				new ProcessInfoParameter(MOrder_BH.COLUMNNAME_C_Order_ID, orderId, null, null, null)});

		ServerProcessCtl.process(processInfo, null);

		return Process.PROCESSING_MESSAGE;
	}

	/**
	 * Call and run the SalesProcess
	 *
	 * @param invoiceId
	 */
	public String runExpenseProcess(int invoiceId, boolean delete) {
		MProcess mprocess = new Query(
				Env.getCtx(),
				MProcess.Table_Name,
				MProcess.COLUMNNAME_Classname + "=?",
				null
		)
				.setOnlyActiveRecords(true).setParameters(EXPENSE_PROCESS_CLASS_NAME).first();

		MPInstance mpInstance = new MPInstance(mprocess, 0);

		ProcessInfo processInfo = new ProcessInfo(mprocess.getName(), mprocess.getAD_Process_ID());
		processInfo.setAD_PInstance_ID(mpInstance.getAD_PInstance_ID());
		processInfo.setAD_Process_UU(mprocess.getAD_Process_UU());

		processInfo.setParameter(new ProcessInfoParameter[]{
				new ProcessInfoParameter(ExpenseProcess.PARAMETERNAME_C_INVOICE_ID, invoiceId, null, null, null),
				new ProcessInfoParameter(
						ExpenseProcess.PARAMETERNAME_PROCESS_ACTION,
						delete ? ExpenseProcess.PROCESSACTION_Remove : ExpenseProcess.PROCESSACTION_Complete,
						null,
						null,
						null
				)
		});

		ServerProcessCtl.process(processInfo, null);

		return Process.PROCESSING_MESSAGE;
	}

	/**
	 * Call and run StockTake process
	 *
	 * @param productID
	 * @param attributeSetInstanceId
	 * @param quantity
	 */
	public String runStockTakeProcess(int productID, int attributeSetInstanceId, int quantity) {
		MProcess mprocess = new Query(Env.getCtx(), MProcess.Table_Name, MProcess.COLUMNNAME_Classname + "=?", null)
				.setOnlyActiveRecords(true).setParameters(STOCKTAKE_PROCESS_CLASS_NAME).first();

		MPInstance mpInstance = new MPInstance(mprocess, 0);

		ProcessInfo processInfo = new ProcessInfo(mprocess.getName(), mprocess.getAD_Process_ID());
		processInfo.setAD_PInstance_ID(mpInstance.getAD_PInstance_ID());
		processInfo.setAD_Process_UU(mprocess.getAD_Process_UU());

		processInfo
				.setParameter(new ProcessInfoParameter[]{
						new ProcessInfoParameter(MStorageOnHand.COLUMNNAME_M_Product_ID, productID, null, null, null),
						new ProcessInfoParameter(MStorageOnHand.COLUMNNAME_M_AttributeSetInstance_ID,
								attributeSetInstanceId, null, null, null),
						new ProcessInfoParameter(QUANTITY, quantity, null, null, null)});

		ServerProcessCtl.process(processInfo, null);

		return processInfo.getSummary();
	}

	/**
	 * Return all active processes for the logged in client
	 *
	 * @param filter     The filter JSON in case any reports should be filtered
	 * @param sortColumn The column to sort the results by
	 * @param sortOrder  The order by which to sort the results
	 * @param pagingInfo The paging info object to udpate with data from the DB
	 * @return A list of processes and their child info
	 */
	public BaseListResponse<Process> getAll(String filter, String sortColumn, String sortOrder, Paging pagingInfo) {
		// Get processes for GL
		List<Object> parameters = new ArrayList<>();
		parameters.add(MClient_BH.CLIENTID_LAST_SYSTEM);
		BaseListResponse<Process> processes =
				super.getAll(MProcess.COLUMNNAME_AD_Process_ID + ">?", parameters, pagingInfo, sortColumn, sortOrder,
						filter);


		// Map the process parameters to entities
		if (processes.getResults() != null && !processes.getResults().isEmpty()) {
			// Determine which processes are visible in the dropdown based on the buttons configured in iDempiere
			List<MDashboardButtonGroupButton> processButtons =
					new Query(Env.getCtx(), MDashboardButtonGroupButton.Table_Name,
							MDashboardButtonGroupButton.COLUMNNAME_AD_Process_ID + " IS NOT NULL", null).setOnlyActiveRecords(true)
							.list();
			Set<Integer> processIdsFromProcessButtons =
					processButtons.stream().map(MDashboardButtonGroupButton::getAD_Process_ID).collect(Collectors.toSet());
			// Determine which processes the user has access to
			MRole usersRole = MRole.get(Env.getCtx(), Env.getAD_Role_ID(Env.getCtx()));
			// Filter out processes the user can't see and then determine which processes are manually run-able
			processes
					.setResults(
							processes.getResults().stream().filter(process -> usersRole.getProcessAccess(process.getId()) != null)
									.peek(process -> {
										// If the button is present, it means the user needs to manually provide input to run the report
										if (processIdsFromProcessButtons.contains(process.getId())) {
											process.setNeedsManualInput(true);
										}
									})
									.collect(Collectors.toList()));

			// Get all the process info information for these processes
			Map<Integer, List<MProcessPara>> processParametersByProcess = processParameterDBService
					.getGroupsByIds(MProcessPara::getAD_Process_ID, MProcessPara.COLUMNNAME_AD_Process_ID,
							processes.getResults().stream().map(Process::getId).collect(Collectors.toSet()));

			// We need to get the reference and reference values for the process parameters
			List<MProcessPara> allProcessParameters =
					processParametersByProcess.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
			Map<Integer, MReference_BH> referencesById = referenceDBService.getByIds(
					allProcessParameters.stream().map(MProcessPara::getAD_Reference_ID).collect(Collectors.toSet()));
			// If the reference assigned to a process parameter equals "List", then the value stored in it's
			// AD_Reference_Value property is the AD_Reference for the available values
			Set<Integer> referencesThatAreListsAndNeedAcceptableValues = allProcessParameters.stream().filter(
					processParameter -> referencesById.containsKey(processParameter.getAD_Reference_ID()) &&
							processParameter.getAD_Reference_ID() == MReference_BH.LIST_AD_REFERENCE_ID
			).map(MProcessPara::getAD_Reference_Value_ID).collect(Collectors.toSet());
			Map<Integer, List<MRefList>> referenceListsByReference = referenceListDBService
					.getGroupsByIds(MRefList::getAD_Reference_ID, MRefList.COLUMNNAME_AD_Reference_ID,
							referencesThatAreListsAndNeedAcceptableValues);

			processes.getResults().forEach(process -> {
				if (!processParametersByProcess.containsKey(process.getId())) {
					return;
				}
				process.setParameters(
						processParametersByProcess.get(process.getId()).stream()
								.map(ProcessDBService::createProcessParameterInstance)
								.collect(Collectors.toList()));
				if (process.getParameters() != null) {
					process.getParameters().forEach(processParameter -> {
						if (referencesById.containsKey(processParameter.getAdReferenceId())) {
							processParameter.setReference(referenceDBService
									.createInstanceWithAllFields(referencesById.get(processParameter.getAdReferenceId())));
						}
						if (referenceListsByReference.containsKey(processParameter.getAdReferenceValueId())) {
							processParameter.setReferenceValues(
									referenceListsByReference.get(processParameter.getAdReferenceValueId()).stream()
											.map(referenceListDBService::createInstanceWithAllFields).collect(Collectors.toList()));
						}
					});
				}
			});
		}
		return processes;
	}

	/**
	 * Run an iDempiere process and get it's export
	 *
	 * @param process               The report (which is a process in iDempiere) to run
	 * @param reportType            What output the report should be
	 * @param processInfoParameters The parameters to pass to the report
	 * @return A file of the generated report, or null if an error occurred
	 */
	public File runAndExport(MProcess process, ReportType reportType,
			List<org.bandahealth.idempiere.rest.model.ProcessInfoParameter> processInfoParameters) {
		if (process == null) {
			throw new AdempiereException("Could not find report");
		}

		if (reportType == null) {
			reportType = ReportType.PDF;
		}

		// Initialize report info
		MPInstance mpInstance = new MPInstance(process, 0);
		ProcessInfo processInfo = new ProcessInfo(process.getName(), process.getAD_Process_ID());
		processInfo.setAD_PInstance_ID(mpInstance.getAD_PInstance_ID());
		processInfo.setAD_Process_UU(process.getAD_Process_UU());
		processInfo.setIsBatch(true);
		processInfo.setExport(true);
		processInfo.setReportType(reportType.toString().toUpperCase());
		processInfo.setExportFileExtension(reportType.toString().toLowerCase());

		// Let's process the parameters (really, we only need to convert dates if they're dates)
		// First, batch DB requests so we can avoid many queries
		Map<String, MProcessPara> processParametersByUuidMap = processParameterDBService
				.getGroupsByIds(MProcessPara::getAD_Process_ID, MProcessPara.COLUMNNAME_AD_Process_ID,
						new HashSet<>(Collections.singletonList(process.get_ID())))
				.getOrDefault(process.get_ID(), new ArrayList<>()).stream()
				.collect(Collectors.toMap(MProcessPara::getAD_Process_Para_UU, processParameter -> processParameter));
		Map<Integer, MReference_BH> referencesByIdMap =
				referenceDBService.getByIds(processParametersByUuidMap.values().stream().map(MProcessPara::getAD_Reference_ID)
						.collect(Collectors.toSet()));

		List<ProcessInfoParameter> processedInfoParameters = new ArrayList<>();
		// Now, cycle through and process each parameter passed in
		processInfoParameters.forEach(processInfoParameter -> {
			// Get the process parameter
			MProcessPara processParameter =
					processParametersByUuidMap.get(processInfoParameter.getProcessParameterUuid());

			// Get the reference to help determine what type of parameter this is
			MReference referenceForParameter = referencesByIdMap.get(processParameter.getAD_Reference_ID());
			Object parameter = processInfoParameter.getParameter();
			if (referenceForParameter.getAD_Reference_ID() == MReference_BH.DATE_AD_REFERENCE_ID) {
				parameter = DateUtil.parseDate(processInfoParameter.getParameter().toString());
			}

			// Since some reports want IDs, we need to convert UUIDs to IDs
			// TODO: Update all reports to use UUIDs instead of IDs
			if (processParameter.getName().toLowerCase().endsWith(MReference_BH.SUFFIX_ID)) {
				if (process.getAD_Process_UU().equalsIgnoreCase(THERMAL_RECEIPT_REPORT)) {
					MOrder_BH order = new Query(Env.getCtx(), MOrder_BH.Table_Name,
							MOrder_BH.COLUMNNAME_C_Order_UU + "=?", null)
							.setParameters(parameter.toString()).first();
					parameter = BigDecimal.valueOf(order.get_ID());
				} else if (process.getAD_Process_UU().equalsIgnoreCase(DEBT_PAYMENT_RECEIPT)) {
					MPayment_BH payment = new Query(Env.getCtx(), MPayment_BH.Table_Name,
							MPayment_BH.COLUMNNAME_C_Payment_UU + "=?", null)
							.setParameters(parameter.toString()).first();
					parameter = BigDecimal.valueOf(payment.get_ID());
				}
			}

			// Create a new process info parameter with the name fetched from MProcessParam
			processedInfoParameters.add(new ProcessInfoParameter(
					processParametersByUuidMap.get(processInfoParameter.getProcessParameterUuid()).getName(),
					parameter,
					processInfoParameter.getParameterTo(),
					processInfoParameter.getInfo(),
					processInfoParameter.getInfoTo()
			));
		});

		if (!processedInfoParameters.isEmpty()) {
			processInfo.setParameter(processedInfoParameters.toArray(ProcessInfoParameter[]::new));
		}

		// Run the report
		ServerProcessCtl.process(processInfo, null);

		if (processInfo.isError()) {
			throw new AdempiereException("Could not generate report " + process.getName());
		}

		if (processInfo.getExportFile() != null) {
			return processInfo.getExportFile();
		}

		return null;
	}

	@Override
	public Process saveEntity(Process entity) {
		return null;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		return null;
	}

	@Override
	protected Process createInstanceWithDefaultFields(MProcess instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Process createInstanceWithAllFields(MProcess instance) {
		return new Process(instance, null);
	}

	@Override
	protected Process createInstanceWithSearchFields(MProcess instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MProcess getModelInstance() {
		return new MProcess(Env.getCtx(), 0, null);
	}

	@Override
	protected Map<String, Function<MProcess, VoidFunction<String>>> getColumnsToTranslate() {
		return new HashMap<>() {{
			put(MProcess.COLUMNNAME_Name, entity -> entity::setName);
			put(MProcess.COLUMNNAME_Description, entity -> entity::setDescription);
		}};
	}
}
