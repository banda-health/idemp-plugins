package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;

import java.io.IOException;
import java.sql.SQLException;

public class MoH705AOutPatientUnder5yrSummaryTest extends ChuBoePopulateFactoryVO {

	@IPopulateAnnotation.CanRun
	public void canRunReport() throws SQLException, IOException {
	}
}
