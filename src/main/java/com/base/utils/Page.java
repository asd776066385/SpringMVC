package com.base.utils;


import java.io.Serializable;
import java.util.List;

public class Page implements Serializable {


    private static final long serialVersionUID = -1021645680161459076L;

    private List<?> dataList;//数据

    private long pageNo;//当前页码

    private long pageSize;//每页数据量

    private long total;//总条数

    

    public List<?> getDataList() {
		return dataList;
	}

	public void setDataList(List<?> dataList) {
		this.dataList = dataList;
	}

	public long getPageNo() {
        return pageNo;
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
