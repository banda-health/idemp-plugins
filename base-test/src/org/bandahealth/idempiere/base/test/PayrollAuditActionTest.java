package org.bandahealth.idempiere.base.test;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHPayrollAudit;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.util.DB;
import org.compiere.util.Env;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PayrollAuditActionTest extends ChuBoePopulateFactoryVO {

	@IPopulateAnnotation.CanRun
	public void auditActionVocabularyIsDictionaryOwned() {
		int referenceId = new Query(Env.getCtx(), MReference_BH.Table_Name,
				MReference_BH.COLUMNNAME_AD_Reference_UU + "=?", get_TrxName())
				.setParameters(MReference_BH.PAYROLL_AUDIT_ACTION_AD_REFERENCE_UU).firstId();
		assertThat("audit action reference exists", referenceId > 0, is(true));

		List<String> values = new Query(Env.getCtx(), MRefList.Table_Name,
				MRefList.COLUMNNAME_AD_Reference_ID + "=?", get_TrxName())
				.setParameters(referenceId)
				.setOnlyActiveRecords(true)
				.<MRefList>list().stream().map(MRefList::getValue).collect(Collectors.toList());
		assertThat("all payroll audit actions are in the list", values, hasItems(
				MBHPayrollAudit.BH_ACTIONTYPE_PeriodLock,
				MBHPayrollAudit.BH_ACTIONTYPE_PeriodUnlock,
				MBHPayrollAudit.BH_ACTIONTYPE_ComponentChange,
				MBHPayrollAudit.BH_ACTIONTYPE_EmployeeAdd,
				MBHPayrollAudit.BH_ACTIONTYPE_EmployeeEdit,
				MBHPayrollAudit.BH_ACTIONTYPE_EmployeeDeactivate,
				MBHPayrollAudit.BH_ACTIONTYPE_EmployeeReactivate,
				MBHPayrollAudit.BH_ACTIONTYPE_FilingPaid,
				MBHPayrollAudit.BH_ACTIONTYPE_FilingReversed,
				MBHPayrollAudit.BH_ACTIONTYPE_SettingsChange));
	}

	@IPopulateAnnotation.CanRun
	public void auditRejectsUnknownActionType() {
		MBHPayrollAudit audit = new MBHPayrollAudit(Env.getCtx(), 0, get_TrxName());
		audit.setBH_ActionType("NOT_A_REAL_ACTION");
		audit.setBH_Detail("must never save");
		assertThrows(AdempiereException.class, audit::saveEx);
	}

	@IPopulateAnnotation.CanRun
	public void auditAcceptsListedActionType() {
		MBHPayrollAudit audit = new MBHPayrollAudit(Env.getCtx(), 0, get_TrxName());
		audit.setBH_ActionType(MBHPayrollAudit.BH_ACTIONTYPE_EmployeeAdd);
		audit.setBH_Detail("vocabulary smoke");
		try {
			audit.saveEx();
		} finally {
			// audit rows are delete-protected at the model layer; clean up with direct SQL
			if (audit.get_ID() > 0) {
				DB.executeUpdateEx("DELETE FROM BH_Payroll_Audit WHERE BH_Payroll_Audit_ID=?",
						new Object[]{audit.get_ID()}, get_TrxName());
			}
		}
	}
}
