package org.bandahealth.idempiere.base.test;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IChuBoePopulateFactory;
import org.bandahealth.idempiere.base.test.modelevent.BusinessPartnerModelEventTest;
import org.bandahealth.idempiere.base.test.modelevent.InOutModelEventTest;
import org.bandahealth.idempiere.base.test.modelevent.InvoiceModelEventTest;
import org.bandahealth.idempiere.base.test.modelevent.UserModelEventTest;
import org.bandahealth.idempiere.base.test.payroll.PayrollCalculatorTest;
import org.bandahealth.idempiere.base.test.payroll.PayrollComponentResolutionTest;
import org.bandahealth.idempiere.base.test.process.CleanExpiredStockProcessTest;
import org.bandahealth.idempiere.base.test.process.ImportBusinessPartnersProcessTest;
import org.bandahealth.idempiere.base.test.process.ImportProductsProcessTest;
import org.bandahealth.idempiere.base.test.process.InitialBandaClientSetupTest;
import org.bandahealth.idempiere.base.test.process.RenameClientProcessTest;
import org.bandahealth.idempiere.base.test.process.ResetStockProcessTest;

import java.util.ArrayList;
import java.util.List;

public class BandaBaseTestFactory implements IChuBoePopulateFactory {
	@Override
	public List<ChuBoePopulateFactoryVO> newChuBoePopulateInstance() {
		List<ChuBoePopulateFactoryVO> tests = new ArrayList<>();

		// Model Events
		tests.add(new BusinessPartnerModelEventTest());
		tests.add(new InOutModelEventTest());
		tests.add(new InvoiceModelEventTest());
		tests.add(new UserModelEventTest());

		// Processes
		tests.add(new CleanExpiredStockProcessTest());
		tests.add(new ImportBusinessPartnersProcessTest());
		tests.add(new ImportProductsProcessTest());
		tests.add(new InitialBandaClientSetupTest());
		tests.add(new RenameClientProcessTest());
		tests.add(new ResetStockProcessTest());

		// Payroll
		tests.add(new PayrollCalculatorTest());
		tests.add(new PayrollComponentResolutionTest());

		// Generic
		tests.add(new OrderTest());
		tests.add(new PaymentTest());

		return tests;
	}
}
