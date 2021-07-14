package org.bandahealth.idempiere.base.config;

import java.lang.reflect.Field;

import org.compiere.model.MSysConfig;
import org.compiere.util.CLogger;
import org.compiere.util.CacheMgt;
import org.compiere.util.Env;

public class BHConfigLoader {
	private CLogger log = CLogger.getCLogger(BHConfigLoader.class);

	private BHConfigLoader() {
	}

	public static BHConfigLoader getInstance() {
		return Holder.INSTANCE;
	}

	public BHConfigLoader loadConfigs() {
		try {
			for (Field prop : IBHConfig.class.getFields()) {
				MSysConfig conf = new MSysConfig(Env.getCtx(), null, null);
				if (!conf.getName().equalsIgnoreCase(prop.getName())) {
					conf.setName(prop.getName());
					conf.setValue((String) prop.get(new String()));
					conf.saveEx();
				}
			}
		} catch (Exception ex) {
			log.saveError("Error loading configs", ex);
		} finally {
			CacheMgt.get().reset(MSysConfig.Table_Name);
		}

		return this;
	}

	private static class Holder {
		private static final BHConfigLoader INSTANCE = new BHConfigLoader().loadConfigs();
	}
}
