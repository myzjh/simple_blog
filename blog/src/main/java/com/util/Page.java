package com.util;

import java.io.PrintWriter;
import java.util.List;

/**
 * 分页信息类
 * 
 * <pre>
 * @author zhangjh
 * @param itemCount  数据总数
 * @param getPageCount 总页数
 * @param pageSize 每页数据数量
 * @param currentPage  当前页
 * @param getStartItem 开始位置
 * @param getEndItem 结束位置
 * </pre>
 */

public class Page<T> {

	private int itemCount;// 数据总数
	private int pageSize;// 每页数据数量
	private int currentPage;// 当前页
	private List<T> list;// 结果集

	/**
	 * 初始化数据
	 * 
	 * @param pageSize
	 *            =8; 一页显示的数据量 -- 8
	 * @param currentPage
	 *            =1; 当前页码 -- 第一页
	 */
	public Page() {
		pageSize = 8;
		currentPage = 1;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		// 不允许非法页码
		if (currentPage < 1) {
			currentPage = 1;
		}

		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * 计算总页数
	 * 
	 * @return
	 */
	public int getPageCount() {
		return itemCount % pageSize == 0 ? itemCount / pageSize : itemCount
				/ pageSize + 1;
	}

	public int getStartItem() {
		return (getCurrentPage() - 1) * pageSize;
	}

	public int getEndItem() {
		return getStartItem() + pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out);
		out.write("\r\n");
        out.write("\t\t<aside class=\"sidebar\">\r\n");
        out.write("\t\t\t<h2>页面导航</h2>\r\n");
        out.write("\t\t\t<ul>\r\n");
        out.write("\t\t\t\t<li><a href=\"/blog/index\">博客首页</a></li>\r\n");
        out.write("\t\t\t\t<li><a href=\"/blog/user/home\">用户首页</a></li>\r\n");
        out.write("\t\t\t\t<li><a href=\"/blog/user/setting\">个性化设置</a></li>\r\n");
        out.write("\t\t\t\t<li><a href=\"/blog/article/addPage\">写日志</a></li>\r\n");
        out.write("\t\t\t\t<li><a href=\"/blog/p/show\">相册</a></li>\r\n");
        out.write("\t\t\t\t<li><a href=\"/blog/user/logout\">退出</a></li>\r\n");
        out.write("\t\t\t</ul>\r\n");
        out.write("\t\t</aside>\r\n");
        out.write("\t");
	        out.flush();
	}
}
