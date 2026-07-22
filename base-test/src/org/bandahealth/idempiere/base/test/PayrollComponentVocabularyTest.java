package org.bandahealth.idempiere.base.test;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHPayrollComponent;
import org.bandahealth.idempiere.base.model.MBHPayrollFiling;
import org.bandahealth.idempiere.base.model.MBHPayrollRun;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.base.model.PayrollComponent;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PayrollComponentVocabularyTest extends ChuBoePopulateFactoryVO {

	private List<String> listValues(String referenceUu) {
		int referenceId = new Query(Env.getCtx(), MReference_BH.Table_Name,
				MReference_BH.COLUMNNAME_AD_Reference_UU + "=?", get_TrxName())
				.setParameters(referenceUu).firstId();
		return new Query(Env.getCtx(), MRefList.Table_Name,
				MRefList.COLUMNNAME_AD_Reference_ID + "=?", get_TrxName())
				.setParameters(referenceId)
				.setOnlyActiveRecords(true)
				.<MRefList>list().stream().map(MRefList::getValue).collect(Collectors.toList());
	}

	@IPopulateAnnotation.CanRun
	public void componentVocabulariesAreDictionaryOwned() {
		assertThat("all component categories are in the list",
				listValues(MReference_BH.PAYROLL_COMPONENT_CATEGORY_AD_REFERENCE_UU), hasItems(
						PayrollComponent.CATEGORY_EARNING,
						PayrollComponent.CATEGORY_EMPLOYER_CONTRIBUTION,
						PayrollComponent.CATEGORY_RELIEF,
						PayrollComponent.CATEGORY_STATUTORY_DEDUCTION,
						PayrollComponent.CATEGORY_VOLUNTARY_DEDUCTION));
		assertThat("all calculation methods are in the list",
				listValues(MReference_BH.PAYROLL_CALC_METHOD_AD_REFERENCE_UU), hasItems(
						PayrollComponent.METHOD_BANDS,
						PayrollComponent.METHOD_EMPLOYEE_AMOUNT,
						PayrollComponent.METHOD_FIXED,
						PayrollComponent.METHOD_PERCENT_OF_GROSS,
						PayrollComponent.METHOD_TIERED));
		assertThat("all statutory filing types are in the list",
				listValues(MReference_BH.PAYROLL_FILING_TYPE_AD_REFERENCE_UU), hasItems(
						"PAYE", "NSSF", "SHIF", "HLEVY", "NITA"));
	}

	@IPopulateAnnotation.CanRun
	public void componentRejectsUnknownCategory() {
		MBHPayrollComponent component = newComponent();
		component.setBH_Category("NOT_A_CATEGORY");
		component.setBH_CalcMethod(PayrollComponent.METHOD_FIXED);
		assertThrows(AdempiereException.class, component::saveEx);
	}

	@IPopulateAnnotation.CanRun
	public void componentRejectsUnknownCalcMethod() {
		MBHPayrollComponent component = newComponent();
		component.setBH_Category(PayrollComponent.CATEGORY_VOLUNTARY_DEDUCTION);
		component.setBH_CalcMethod("NOT_A_METHOD");
		assertThrows(AdempiereException.class, component::saveEx);
	}

	@IPopulateAnnotation.CanRun
	public void componentAcceptsListedVocabulary() {
		MBHPayrollComponent component = newComponent();
		component.setBH_Category(PayrollComponent.CATEGORY_VOLUNTARY_DEDUCTION);
		component.setBH_CalcMethod(PayrollComponent.METHOD_FIXED);
		try {
			component.saveEx();
		} finally {
			if (component.get_ID() > 0) {
				component.deleteEx(true);
			}
		}
	}

	@IPopulateAnnotation.CanRun
	public void filingRejectsUnknownFilingType() {
		MBHPayrollRun run = new MBHPayrollRun(Env.getCtx(), 0, get_TrxName());
		run.setBH_PayrollMonth(4);
		run.setBH_PayrollYear(2026);
		run.saveEx();
		try {
			MBHPayrollFiling filing = new MBHPayrollFiling(Env.getCtx(), 0, get_TrxName());
			filing.setBH_Payroll_Run_ID(run.get_ID());
			filing.setBH_FilingType("NOT_A_FILING");
			filing.setBH_EmployeeAmount(BigDecimal.ONE);
			filing.setBH_EmployerAmount(BigDecimal.ZERO);
			filing.setBH_TotalAmount(BigDecimal.ONE);
			assertThrows(AdempiereException.class, filing::saveEx);
		} finally {
			run.deleteEx(true);
		}
	}

	/** Scaffold: never effective (ValidFrom 9999) so the shared catalogue is not polluted. */
	private MBHPayrollComponent newComponent() {
		MBHPayrollComponent component = new MBHPayrollComponent(Env.getCtx(), 0, get_TrxName());
		component.setValue(getScenarioName() + "-VOCAB");
		component.setName(getScenarioName() + " vocabulary probe");
		component.setValidFrom(Timestamp.valueOf("9999-01-01 00:00:00"));
		component.setSeqNo(990);
		component.setBH_IsTaxDeductible(false);
		component.setBH_IsStatutory(false);
		return component;
	}
}
