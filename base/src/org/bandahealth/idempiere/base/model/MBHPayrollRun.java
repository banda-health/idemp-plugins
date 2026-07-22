package org.bandahealth.idempiere.base.model;

import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.DB;
import org.compiere.util.Env;

import java.io.File;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class MBHPayrollRun extends X_BH_Payroll_Run implements DocAction {

	/** Last document-action message (surfaced via {@link #getProcessMsg()}). */
	private String m_processMsg = null;

	public MBHPayrollRun(Properties ctx, int BH_Payroll_Run_ID, String trxName) {
		super(ctx, BH_Payroll_Run_ID, trxName);
	}

	public MBHPayrollRun(Properties ctx, int BH_Payroll_Run_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_Payroll_Run_ID, trxName, virtualColumns);
	}

	public MBHPayrollRun(Properties ctx, String BH_Payroll_Run_UU, String trxName) {
		super(ctx, BH_Payroll_Run_UU, trxName);
	}

	public MBHPayrollRun(Properties ctx, String BH_Payroll_Run_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_Payroll_Run_UU, trxName, virtualColumns);
	}

	public MBHPayrollRun(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public Timestamp getPeriodStart() {
		return Timestamp.valueOf(LocalDate.of(getBH_PayrollYear(), getBH_PayrollMonth(), 1).atStartOfDay());
	}

	public Timestamp getPeriodEnd() {
		return Timestamp.valueOf(LocalDate.of(getBH_PayrollYear(), getBH_PayrollMonth(), 1)
				.plusMonths(1).minusDays(1).atStartOfDay());
	}

	/** Recompute all lines from live employee data + the resolved catalogue. Draft-state only. */
	public int generateLines(List<MBHPayrollComponent> effectiveCatalogue) {
		// wipe: items first (FK), then lines
		DB.executeUpdateEx("DELETE FROM BH_Payroll_Run_Line_Item WHERE BH_Payroll_Run_Line_ID IN "
				+ "(SELECT BH_Payroll_Run_Line_ID FROM BH_Payroll_Run_Line WHERE BH_Payroll_Run_ID=?)",
				new Object[]{get_ID()}, get_TrxName());
		DB.executeUpdateEx("DELETE FROM BH_Payroll_Run_Line WHERE BH_Payroll_Run_ID=?",
				new Object[]{get_ID()}, get_TrxName());

		List<PayrollComponent> specs = effectiveCatalogue.stream()
				.map(component -> component.toSpec(get_TrxName())).collect(Collectors.toList());
		List<MHREmployee_BH> employees = new Query(getCtx(), MHREmployee_BH.Table_Name,
				MHREmployee_BH.COLUMNNAME_AD_Client_ID + "=? AND " + MHREmployee_BH.COLUMNNAME_StartDate
						+ "<=? AND (" + MHREmployee_BH.COLUMNNAME_EndDate + " IS NULL OR "
						+ MHREmployee_BH.COLUMNNAME_EndDate + ">=?)", get_TrxName())
				.setParameters(getAD_Client_ID(), getPeriodEnd(), getPeriodStart())
				.setOnlyActiveRecords(true)
				.setOrderBy(MHREmployee_BH.COLUMNNAME_Name)
				.list();
		for (MHREmployee_BH employee : employees) {
			PayrollEarnings earnings = new PayrollEarnings(employee.getBH_BasicSalary(),
					employee.getBH_HouseAllowance(), employee.getBH_TransportAllowance());
			List<PayrollAssignment> assignments = MBHEmployeeComponent.resolveAssignments(getCtx(),
					employee.get_ID(), effectiveCatalogue, getPeriodStart(), getPeriodEnd(), get_TrxName());
			PayrollBreakdown breakdown = PayrollCalculator.calculate(earnings, specs, assignments);

			MBHPayrollRunLine line = new MBHPayrollRunLine(getCtx(), 0, get_TrxName());
			line.setBH_Payroll_Run_ID(get_ID());
			line.setHR_Employee_ID(employee.get_ID());
			line.setBH_EmployeeName(employee.getName());
			line.setBH_KRA_PIN(employee.getBH_KRA_PIN());
			// NSSF number is core's SSCode (Social Security Code) — no separate BH_ column on HR_Employee.
			line.setBH_NSSF_Number(employee.getSSCode());
			line.setBH_SHIF_Number(employee.getBH_SHIF_Number());
			line.setBH_BasicSalary(earnings.basicSalary);
			line.setBH_HouseAllowance(earnings.houseAllowance);
			line.setBH_TransportAllowance(earnings.transportAllowance);
			line.setBH_GrossPay(breakdown.grossPay);
			line.setBH_TaxablePay(breakdown.taxablePay);
			line.setBH_PAYE_Amount(breakdown.payeAmount);
			line.setBH_TotalDeductions(breakdown.totalDeductions);
			line.setBH_NetPay(breakdown.netPay);
			line.setBH_CostToEmployer(breakdown.costToEmployer);
			line.saveEx();

			// breakdown.items is already in render order (calculator sorts components by seqNo,
			// PAYE appended last); mirror that order onto SeqNo (10-step, house convention).
			int itemSequence = 0;
			for (PayrollLineItem item : breakdown.items) {
				MBHPayrollRunLineItem lineItem = new MBHPayrollRunLineItem(getCtx(), 0, get_TrxName());
				lineItem.setBH_Payroll_Run_Line_ID(line.get_ID());
				lineItem.setValue(item.code);
				lineItem.setName(item.name);
				lineItem.setBH_Category(item.category);
				lineItem.setBH_IsTaxDeductible(item.taxDeductible);
				lineItem.setBH_EmployeeAmount(item.employeeAmount);
				lineItem.setBH_EmployerAmount(item.employerAmount);
				itemSequence += 10;
				lineItem.setSeqNo(itemSequence);
				lineItem.saveEx();
			}
		}
		return employees.size();
	}

	/**
	 * Two-state document dispatch (no DocumentEngine, no AD_Workflow): CO completes, RE re-activates.
	 * Maintains the DocStatus/DocAction columns; the caller persists the run.
	 */
	@Override
	public boolean processIt(String action) throws Exception {
		m_processMsg = null;
		if (DocAction.ACTION_Complete.equals(action)) {
			// Two-state document: a refused complete stays DR/CO (STATUS_Invalid is not in the
			// payroll doc-status list), mirroring the guarded RE branch below.
			if (DocAction.STATUS_Completed.equals(completeIt())) {
				setDocStatus(DocAction.STATUS_Completed);
				setDocAction(DocAction.ACTION_ReActivate);
				return true;
			}
			return false;
		}
		if (DocAction.ACTION_ReActivate.equals(action)) {
			boolean ok = reActivateIt();
			if (ok) {
				setDocStatus(DocAction.STATUS_Drafted);
				setDocAction(DocAction.ACTION_Complete);
			}
			return ok;
		}
		return false;
	}

	/**
	 * Lock the period: regenerate lines from live data, stamp the component snapshot, assign payslip
	 * numbers, aggregate statutory filings, audit the lock, then mark Processed LAST (write-protection
	 * keys off Processed, so every write above precedes it).
	 */
	@Override
	public String completeIt() {
		// Guard against a double-CO before any I/O: without this, generateLines() below deletes every
		// line via direct SQL (bypassing PO write-protection), then dies re-inserting them because the
		// still-Processed run locks MBHPayrollRunLine#beforeSave — a misleading error, and only the
		// caller's transaction rollback saves the data. Mirrors the reActivateIt guard below.
		if (DocAction.STATUS_Completed.equals(getDocStatus())) {
			m_processMsg = "Payroll run is already completed";
			return DocAction.STATUS_Invalid;
		}
		List<MBHPayrollComponent> catalogue = MBHPayrollComponent.getEffectiveAll(getCtx(),
				getAD_Client_ID(), getPeriodEnd(), get_TrxName());
		// An empty period must not lock: it would stamp zero-amount statutory filings and a
		// PERIOD_LOCK audit for a month with no payroll. Callers roll back on non-Completed.
		if (generateLines(catalogue) == 0) {
			m_processMsg = "No active employees for this period";
			return DocAction.STATUS_Invalid;
		}

		List<PayrollComponent> specs = catalogue.stream()
				.map(component -> component.toSpec(get_TrxName())).collect(Collectors.toList());
		setBH_Components_Snapshot(ComponentSnapshotJson.toJson(specs));

		assignPayslipNumbers();
		createFilings(catalogue);
		writeAudit(MBHPayrollAudit.BH_ACTIONTYPE_PeriodLock);

		MBHPayrollSettings settings = MBHPayrollSettings.getByClientId(getCtx(), getAD_Client_ID(),
				get_TrxName());
		setBH_PayDate(resolvePayDate(settings));
		advanceSettingsPeriod(settings);

		setProcessed(true);
		setDocStatus(DocAction.STATUS_Completed);
		return DocAction.STATUS_Completed;
	}

	/**
	 * Move the client's "current payroll period" to the month after this run — but only when the
	 * settings period equals this run's period exactly. Re-locking an older, previously unlocked
	 * month while settings already point ahead must not advance again; a null/absent settings
	 * period means the clinic hasn't opted into period tracking, so it stays untouched. (A null
	 * settings month reads as 0, which never equals a run month 1-12.) Runs on the run's own trx
	 * so the advance commits or rolls back with the completion. Takes the already-loaded settings
	 * so completion reads the client's settings row once.
	 */
	private void advanceSettingsPeriod(MBHPayrollSettings settings) {
		if (settings == null || settings.getBH_PayrollMonth() != getBH_PayrollMonth()
				|| settings.getBH_PayrollYear() != getBH_PayrollYear()) {
			return;
		}
		if (getBH_PayrollMonth() == 12) {
			settings.setBH_PayrollMonth(1);
			settings.setBH_PayrollYear(getBH_PayrollYear() + 1);
		} else {
			settings.setBH_PayrollMonth(getBH_PayrollMonth() + 1);
		}
		settings.saveEx();
	}

	/**
	 * The run's pay date: the configured pay day ({@code BH_Payroll_Settings.BH_PayDay}, a day of the
	 * month) landing inside this run's own period month, clamped to that month's length. When no pay
	 * day is configured (no settings row, or day 0), fall back to the last day of the period month.
	 * Mirrors the frontend pay-day/month-end convention so the History page and payslips show a real
	 * date instead of a blank.
	 */
	private Timestamp resolvePayDate(MBHPayrollSettings settings) {
		LocalDate periodMonth = LocalDate.of(getBH_PayrollYear(), getBH_PayrollMonth(), 1);
		int payDay = settings != null ? settings.getBH_PayDay() : 0;
		int dayOfMonth = payDay >= 1 ? Math.min(payDay, periodMonth.lengthOfMonth())
				: periodMonth.lengthOfMonth();
		return Timestamp.valueOf(periodMonth.withDayOfMonth(dayOfMonth).atStartOfDay());
	}

	/** Payslip numbers PS-&lt;year&gt;&lt;month 2d&gt;-&lt;seq 3d&gt; in line (creation) order. */
	private void assignPayslipNumbers() {
		List<MBHPayrollRunLine> lines = new Query(getCtx(), MBHPayrollRunLine.Table_Name,
				MBHPayrollRunLine.COLUMNNAME_BH_Payroll_Run_ID + "=?", get_TrxName())
				.setParameters(get_ID())
				.setOrderBy(MBHPayrollRunLine.COLUMNNAME_BH_Payroll_Run_Line_ID)
				.list();
		int sequence = 0;
		for (MBHPayrollRunLine line : lines) {
			sequence++;
			line.setBH_PayslipNumber(String.format("PS-%d%02d-%03d",
					getBH_PayrollYear(), getBH_PayrollMonth(), sequence));
			line.saveEx();
		}
	}

	/** One BH_Payroll_Filing per statutory component present in the resolved catalogue. */
	private void createFilings(List<MBHPayrollComponent> effectiveCatalogue) {
		for (MBHPayrollComponent component : effectiveCatalogue) {
			if (!component.isBH_IsStatutory()) {
				continue;
			}
			BigDecimal employee = sumItems(component.getValue(), "BH_EmployeeAmount");
			BigDecimal employer = sumItems(component.getValue(), "BH_EmployerAmount");
			MBHPayrollFiling filing = new MBHPayrollFiling(getCtx(), 0, get_TrxName());
			filing.setBH_Payroll_Run_ID(get_ID());
			filing.setBH_FilingType(component.getValue());
			filing.setBH_EmployeeAmount(employee);
			filing.setBH_EmployerAmount(employer);
			filing.setBH_TotalAmount(employee.add(employer));
			filing.saveEx();
		}
	}

	private BigDecimal sumItems(String code, String amountColumn) {
		return DB.getSQLValueBDEx(get_TrxName(),
				"SELECT COALESCE(SUM(i." + amountColumn + "),0) FROM BH_Payroll_Run_Line_Item i "
						+ "JOIN BH_Payroll_Run_Line l ON l.BH_Payroll_Run_Line_ID=i.BH_Payroll_Run_Line_ID "
						+ "WHERE l.BH_Payroll_Run_ID=? AND i.Value=?", get_ID(), code);
	}

	private void writeAudit(String actionType) {
		MBHPayrollAudit audit = new MBHPayrollAudit(getCtx(), 0, get_TrxName());
		audit.setBH_ActionType(actionType);
		audit.setBH_Payroll_Run_ID(get_ID());
		audit.setAD_Role_ID(Env.getContextAsInt(getCtx(), "#AD_Role_ID"));
		audit.setBH_Detail(String.format("%d-%02d", getBH_PayrollYear(), getBH_PayrollMonth()));
		audit.saveEx();
	}

	/**
	 * Unlock the period. Only the LATEST completed run for the client may unlock, and no filing may
	 * already be paid. On success delete the run's filings (direct SQL, deliberately bypassing PO
	 * write-protection), audit the unlock, and drop back to Drafted.
	 */
	@Override
	public boolean reActivateIt() {
		// Only a completed run can be unlocked; guard so RE on a draft errors instead of writing a
		// spurious PERIOD_UNLOCK audit (GO-3624 Task 4 review decision).
		if (!DocAction.STATUS_Completed.equals(getDocStatus())) {
			m_processMsg = "Only a completed payroll run can be unlocked";
			return false;
		}
		int thisPeriod = getBH_PayrollYear() * 100 + getBH_PayrollMonth();
		int latestPeriod = DB.getSQLValueEx(get_TrxName(),
				"SELECT COALESCE(MAX(BH_PayrollYear*100+BH_PayrollMonth),0) FROM BH_Payroll_Run "
						+ "WHERE AD_Client_ID=? AND DocStatus=?", getAD_Client_ID(), DocAction.STATUS_Completed);
		if (thisPeriod < latestPeriod) {
			m_processMsg = "Only the latest completed payroll run can be unlocked";
			return false;
		}
		int paidFilings = DB.getSQLValueEx(get_TrxName(),
				"SELECT COUNT(*) FROM BH_Payroll_Filing WHERE BH_Payroll_Run_ID=? AND BH_IsPaid=?",
				get_ID(), "Y");
		if (paidFilings > 0) {
			m_processMsg = "Payroll run has paid statutory filings and cannot be unlocked";
			return false;
		}
		DB.executeUpdateEx("DELETE FROM BH_Payroll_Filing WHERE BH_Payroll_Run_ID=?",
				new Object[]{get_ID()}, get_TrxName());
		writeAudit(MBHPayrollAudit.BH_ACTIONTYPE_PeriodUnlock);
		setProcessed(false);
		setDocStatus(DocAction.STATUS_Drafted);
		return true;
	}

	@Override
	protected boolean beforeSave(boolean newRecord) {
		if (!newRecord) {
			Object oldProcessed = get_ValueOld(COLUMNNAME_Processed);
			boolean wasProcessed = oldProcessed != null
					&& (Boolean.TRUE.equals(oldProcessed) || "Y".equals(oldProcessed));
			if (wasProcessed) {
				for (int i = 0; i < get_ColumnCount(); i++) {
					if (!is_ValueChanged(i)) {
						continue;
					}
					String columnName = get_ColumnName(i);
					if (COLUMNNAME_DocStatus.equals(columnName) || COLUMNNAME_DocAction.equals(columnName)
							|| COLUMNNAME_Processed.equals(columnName)
							|| "Updated".equals(columnName) || "UpdatedBy".equals(columnName)) {
						continue;
					}
					log.saveError("Error", "Payroll run is locked");
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public String prepareIt() {
		return DocAction.STATUS_InProgress;
	}

	@Override
	public boolean unlockIt() {
		return false;
	}

	@Override
	public boolean invalidateIt() {
		return false;
	}

	@Override
	public boolean approveIt() {
		return false;
	}

	@Override
	public boolean rejectIt() {
		return false;
	}

	@Override
	public boolean voidIt() {
		return false;
	}

	@Override
	public boolean closeIt() {
		return false;
	}

	@Override
	public boolean reverseCorrectIt() {
		return false;
	}

	@Override
	public boolean reverseAccrualIt() {
		return false;
	}

	@Override
	public String getSummary() {
		return getDocumentInfo();
	}

	@Override
	public String getDocumentNo() {
		return "BPR-" + getBH_PayrollYear() + "-" + getBH_PayrollMonth();
	}

	@Override
	public String getDocumentInfo() {
		return "Payroll Run " + String.format("%d-%02d", getBH_PayrollYear(), getBH_PayrollMonth());
	}

	@Override
	public File createPDF() {
		return null;
	}

	@Override
	public String getProcessMsg() {
		return m_processMsg;
	}

	@Override
	public int getDoc_User_ID() {
		return getCreatedBy();
	}

	@Override
	public int getC_Currency_ID() {
		return 0;
	}

	@Override
	public BigDecimal getApprovalAmt() {
		return Env.ZERO;
	}
}
