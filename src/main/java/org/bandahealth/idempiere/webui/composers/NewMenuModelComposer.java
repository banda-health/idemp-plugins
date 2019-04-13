package org.bandahealth.idempiere.webui.composers;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.metainfo.ComponentInfo;
import org.zkoss.zk.ui.util.Composer;
import org.zkoss.zk.ui.util.ComposerExt;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Tabbox;

public class NewMenuModelComposer implements Composer<Tabbox>, ComposerExt<Tabbox>{

	private ListModelList<String>  model;
	
	@Override
	public ComponentInfo doBeforeCompose(Page page, Component parent, ComponentInfo compInfo) throws Exception {
		return null;
	}

	@Override
	public void doBeforeComposeChildren(Tabbox tabbox) throws Exception {
		model = new ListModelList<>();
		model.add("Test1");
		model.add("Test2");
		model.add("Test 3");
		tabbox.setAttribute("tabmodel", model);
	}

	@Override
	public boolean doCatch(Throwable ex) throws Exception {
		return false;
	}

	@Override
	public void doFinally() throws Exception {
		
	}

	@Override
	public void doAfterCompose(Tabbox comp) throws Exception {
		
	}

}
