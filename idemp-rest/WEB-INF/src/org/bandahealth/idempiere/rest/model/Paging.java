package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class contains the paging information used by the entity services to
 * paginate results.
 */
@XmlRootElement(name = "paging")
public class Paging {

	/**
	 * Sets the page size to 10, matching the default page size for most entities.
	 */
	public static class DEFAULT {

		public static Paging getInstance() {
			return new Paging(0, 10);
		}
	}

	/**
	 * Meant to be a paging that gets all results (it'll actually just get the top 1000000...)
	 */
	public static class ALL {

		public static Paging getInstance() {
			return new Paging(0, 1000000);
		}
	}

	private int page;
	private int pageSize;
	private Integer totalRecordCount;
	private boolean hasMoreResults;

	public Paging() {
	}

	/**
	 * Creates a new {@link Paging} instance.
	 * 
	 * @param page     The 0-based number of the page being requested.
	 * @param pageSize The number of records to include on each page.
	 */
	public Paging(int page, int pageSize) {
		this.page = page;
		this.pageSize = pageSize;
	}

	public static boolean isValid(Paging pagingInfo) {
		return pagingInfo != null && pagingInfo.getPage() >= 0 && pagingInfo.getPageSize() > 0;
	}

	@XmlElement
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@XmlElement
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@XmlElement
	public Integer getTotalRecordCount() {
		return totalRecordCount;
	}

	public void setTotalRecordCount(Integer totalRecordCount) {
		this.totalRecordCount = totalRecordCount;

		checkHasMoreResults();
	}

	@XmlElement
	public Integer getTotalPages() {
		return getTotalPages(pageSize);
	}

	public Integer getTotalPages(int pageSize) {
		Integer totalRecordCount = getTotalRecordCount();
		if (totalRecordCount == null) {
			return 0;
		}
		
		return (int) Math.ceil((double) totalRecordCount / (double) pageSize);
	}

	@XmlElement
	public boolean isHasMoreResults() {
		return hasMoreResults;
	}

	public void setHasMoreResults(boolean hasMoreResults) {
		this.hasMoreResults = hasMoreResults;
	}

	private void checkHasMoreResults() {
		setHasMoreResults(getPage() < getTotalPages());
	}

	@Override
	public boolean equals(Object object) {
		if (object.getClass() == Paging.class) {
			Paging pagingInfo = (Paging) object;
			return pagingInfo.getPage() == this.getPage() && pagingInfo.getPageSize() == this.getPageSize();
		}
		return false;
	}
}
