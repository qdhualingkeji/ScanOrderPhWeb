package com.qdhualing.app.util;

/**
 * ��ҳ��������
 */

public class PageModel {
	
	
	private int pageNo; // �ڼ�ҳ
	private int pageSize; // һҳ��ʾ��������¼
	private int dataCount; // �ܼ�¼��
	
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
	
	private int pageCount; // ��ҳ��
	
	public int getPageCount() {
		pageCount=	(dataCount - 1) / pageSize + 1;
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	// ��õ�һҳ
	public int getFirstPage() {
		return 1;
	}

	// ������һҳ
	public int getLastPage() {
		return this.getPageCount();
	}

	// �����һҳ
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

	// �����һҳ
	public int getPrevPage() {
		if (pageNo > 1)
			return pageNo - 1;

		return 1;
	}
	
}
