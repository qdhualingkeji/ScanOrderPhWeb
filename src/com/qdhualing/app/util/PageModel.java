package com.qdhualing.app.util;

/**
 * 分页处理工具类
 */

public class PageModel {
	
	
	private int pageNo; // 第几页
	private int pageSize; // 一页显示多少条记录
	private int dataCount; // 总记录数
	
	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getDataCount() {
		return dataCount;
	}
	
	private int pageCount; // 总页数
	
	public int getPageCount() {
		pageCount=	(dataCount - 1) / pageSize + 1;
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	// 获得第一页
	public int getFirstPage() {
		return 1;
	}

	// 获得最后一页
	public int getLastPage() {
		return this.getPageCount();
	}

	// 获得下一页
	public int getNextPage() {
		if (pageNo < this.getPageCount())
			return pageNo + 1;

		return this.getPageCount();
	}



	public int getPageNo() {
		if (pageNo < 1)
			pageNo = 1;

		if (pageNo > this.getPageCount())
			pageNo = this.getPageCount();

		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	// 获得上一页
	public int getPrevPage() {
		if (pageNo > 1)
			return pageNo - 1;

		return 1;
	}
	
}
