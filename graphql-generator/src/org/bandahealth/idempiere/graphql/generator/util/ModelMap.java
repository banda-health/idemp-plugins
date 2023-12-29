package org.bandahealth.idempiere.graphql.generator.util;

public class ModelMap {
	private String tableName;
	private String interfacePackageName;
	private String interfaceName;
	private String generatedClassPackageName;
	private String generatedClassName;
	private String classPackageName;
	private String className;

	public ModelMap(String tableName) {
		this.tableName = tableName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getClassPackageName() {
		return classPackageName;
	}

	public void setClassPackageName(String classPackageName) {
		this.classPackageName = classPackageName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getInterfacePackageName() {
		return interfacePackageName;
	}

	public void setInterfacePackageName(String interfacePackageName) {
		this.interfacePackageName = interfacePackageName;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public String getGeneratedClassPackageName() {
		return generatedClassPackageName;
	}

	public void setGeneratedClassPackageName(String generatedClassPackageName) {
		this.generatedClassPackageName = generatedClassPackageName;
	}

	public String getGeneratedClassName() {
		return generatedClassName;
	}

	public void setGeneratedClassName(String generatedClassName) {
		this.generatedClassName = generatedClassName;
	}
}
