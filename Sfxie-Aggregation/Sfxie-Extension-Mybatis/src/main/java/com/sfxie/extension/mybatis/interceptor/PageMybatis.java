package com.sfxie.extension.mybatis.interceptor;

import java.util.List;

import com.sfxie.core.condition.Condition;

 
/**
 * 对分页的基本数据进行一个简单的封装
 */
public class PageMybatis<T> {
 
    private int pageNo = 1;//页码，默认是第一页
    private int pageSize = 15;//每页显示的记录数，默认是15
    private int totalRecord;//总记录数
    private int totalPage;//总页数
    private List<T> results;//对应的当前页记录
    /** mybatis查询条件对象 */
    private Condition condition;
 
    public int getPageNo() {
       return pageNo;
    }
 
    public void setPageNo(int pageNo) {
       this.pageNo = pageNo;
    }
 
    public int getPageSize() {
       return pageSize;
    }
 
    public void setPageSize(int pageSize) {
       this.pageSize = pageSize;
    }
 
    /**
     * 获取总记录数,如果数据是从cabor代理层来的,则判断totalRecord!=results.size()
     * 如果相等,则返回记录,
     * 如果不相等,则返回results.size()
     * @return 
     */
    public int getTotalRecord() {
       return totalRecord!=results.size()?results.size():totalRecord;
    }
 
    public void setTotalRecord(int totalRecord) {
       this.totalRecord = totalRecord;
       //在设置总页数的时候计算出对应的总页数，在下面的三目运算中加法拥有更高的优先级，所以最后可以不加括号。
       int totalPage = totalRecord%pageSize==0 ? totalRecord/pageSize : totalRecord/pageSize + 1;
       this.setTotalPage(totalPage);
    }
 
    /**
     * 获取总页数,如果数据是从cabor代理层来的,则判断totalRecord!=results.size()
     * 如果相等,则返回totalPage,
     * 如果不相等,则返回
     * @return
     */
    public int getTotalPage() {
//    	if(totalRecord!=results.size()){
    		return getTotalRecord()%pageSize==0 ? getTotalRecord()/pageSize : getTotalRecord()/pageSize + 1;
//    	}else{
//    		return totalPage;
//    	}
    }
 
    public void setTotalPage(int totalPage) {
       this.totalPage = totalPage;
    }
 
    /**
     * 获取数据列表
     * @return
     */
    public List<T> getResults() {
       return results;
    }
 
    public void setResults(List<T> results) {
       this.results = results;
    }
   
    /**
     * 获取mybatis查询条件对象
     * @return
     */
    public Condition getCondition() {
		return condition;
	}

    /**
     * 设置mybatis查询条件对象
     * @param condition
     */
	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	@Override
    public String toString() {
       StringBuilder builder = new StringBuilder();
       builder.append("Page [pageNo=").append(pageNo).append(", pageSize=")
              .append(pageSize).append(", results=").append(results).append(
                     ", totalPage=").append(getTotalPage()).append(
                     ", totalRecord=").append(getTotalRecord()).append("]");
       return builder.toString();
    }
    
 
}
