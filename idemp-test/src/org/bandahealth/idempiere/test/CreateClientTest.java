package org.bandahealth.idempiere.test;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation.CanRun;

public class CreateClientTest extends ChuBoePopulateFactoryVO {

	@CanRun
	public void thisIsMyFirstTest() {
		System.out.println("This is my first test");
	}
}
