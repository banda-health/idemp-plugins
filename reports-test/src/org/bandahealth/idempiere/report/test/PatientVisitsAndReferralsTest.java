package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;

import java.io.IOException;
import java.sql.SQLException;

public class PatientVisitsAndReferralsTest extends ChuBoePopulateFactoryVO {

	@IPopulateAnnotation.CanRun
	public void canRunReport() throws SQLException, IOException {
		// TODO: This report doesn't seem like it exists - should we remove it from the dropdown?
	}
}
