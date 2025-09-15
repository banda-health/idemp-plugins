package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IChuBoePopulateFactory;

import java.util.ArrayList;
import java.util.List;

public class BandaReportTestFactory implements IChuBoePopulateFactory {
	@Override
	public List<ChuBoePopulateFactoryVO> newChuBoePopulateInstance() {
		List<ChuBoePopulateFactoryVO> tests = new ArrayList<>();

		// Reports
		tests.add(new CashierPatientTransactionsTest());
		tests.add(new CashierTransactionDifferencesTest());
		tests.add(new ChangesToInventoryTest());
		tests.add(new DailyCashierCollectionsTest());
		tests.add(new DeletedDraftedBillsReportTest());
		tests.add(new DiagnosisReportTest());
		tests.add(new DonorFundReportTest());
		tests.add(new ExpensesTest());
		tests.add(new ExpiredProductListTest());
		tests.add(new IncomeExpenseOverviewTest());
		tests.add(new IncomeStatementProfitAndLossTest());
		tests.add(new InPatientReportTest());
		tests.add(new InventoryQuantityReportTest());
		tests.add(new InventorySoldReportTest());
		tests.add(new MoH705AOutPatientUnder5yrSummaryTest());
		tests.add(new MoH705BOutPatientOver5yrSummaryTest());
		tests.add(new MoH706LabTestsSummaryTest());
		tests.add(new MoH717NewAndRevisitPatientCountTest());
		tests.add(new MoH747AContraceptivesConsumptionReportTest());
		tests.add(new OpenBalanceListTest());
		tests.add(new OpenBalanceInvoiceTest());
		tests.add(new OpenBalanceReceiptTest());
		tests.add(new OTCSalesTest());
		tests.add(new PatientsTest());
		tests.add(new PatientTransactionsTest());
		tests.add(new PatientVisitsAndReferralsTest());
		tests.add(new PaymentTrailTest());
		tests.add(new ProductsAndPricesTest());
		tests.add(new ServiceListReportTest());
		tests.add(new ServicesChargedReportTest());
		tests.add(new StockToBeOrderedTest());
		tests.add(new StockTransferReportTest());
		tests.add(new ValueOfOpeningAndClosingStockTest());
		tests.add(new VisitInvoiceTest());
		tests.add(new VisitReceiptTest());
		tests.add(new VoidedTransactionsListTest());
		tests.add(new NonPatientPaymentReportTest());
		tests.add(new PrescriptionFormReportTest());
		tests.add(new LaboratoryReportTest());

		// Report cross-checking
		tests.add(new CostOfGoodsSoldTest());
		tests.add(new ExpenseTest());
		tests.add(new IncomeTest());

		return tests;
	}
}
