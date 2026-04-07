package org.bandahealth.idempiere.report.test;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;

public class PatientSummaryReportTest extends ChuBoePopulateFactoryVO {

    private static final String patientSummaryReportUU = "c0e1adfc-f743-49e4-9346-4da29f1e9f6c";

    @IPopulateAnnotation.CanRunBeforeClass
    public void prepareIt() throws Exception {
        ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
        valueObject.prepareIt(getScenarioName(), true, get_TrxName());
        assertThat("VO validation gives no errors", valueObject.getErrorMessage(), Matchers.is(Matchers.nullValue()));

        valueObject.setStepName("Open needed periods");
        ChuBoeCreateEntity.createAndOpenAllFiscalYears(valueObject);
        commitEx();

    }
}