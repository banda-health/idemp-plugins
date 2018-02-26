package org.bandahealth.idempiere.base.config;

import java.lang.reflect.Field;
import java.util.Properties;

import org.compiere.model.MSysConfig;
import org.compiere.util.CacheMgt;

public class BHConfigLoader {

	private BHConfigLoader() {
	}

	public static BHConfigLoader getInstance() {
		return Holder.INSTANCE;
	}

	public BHConfigLoader loadConfigs(Properties ctx) {
		try {
			for (Field prop : IBHConfig.class.getFields()) {
				MSysConfig conf = new MSysConfig(ctx, null, null);
				conf.setName(prop.getName());
				conf.setValue((String) prop.get(new String()));
				conf.saveEx();
			}
		} catch (Exception ex) {
		} finally {
			CacheMgt.get().reset(MSysConfig.Table_Name);
		}

		return this;
	}

	private static class Holder {
		private static final BHConfigLoader INSTANCE = new BHConfigLoader().loadConfigs(null);
	}
}
