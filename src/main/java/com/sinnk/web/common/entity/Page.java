package com.sinnk.web.common.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import com.sinnk.web.common.utils.CookieUtils;
import com.sinnk.web.common.utils.Global;

public class Page<T> {

	private int pageNo;// 当前页码

	private int pageSize; // 页面大小，即每页显示的数据条数

	private int dataIndex = 0;// 数据游标

	private long count;// 总记录数

	private int first;// 首页索引

	private int last;// 尾页索引

	private int prev;// 前一页索引

	private int next;// 下一页索引

	private boolean isFirstPage;// 是否是第一页

	private boolean isLastPage;// 是否是最后一页

	private int length;// 显示页面长度

	private int slide;// 前后显示页面长度

	private List<T> list = new ArrayList<T>();// 要展示的数据列表

	private String orderBy = ""; // 排序规则

	private String funcName = "page";// 点击页码调用的JS函数

	public Page() {

	}

	/**
	 * 构造函数
	 * 
	 * @param request
	 * @param response
	 * @param totalAmount
	 */
	public Page(HttpServletRequest request, HttpServletResponse response, long totalAmount) {

		/*
		 * 初始化pageSize
		 */
		this.pageSize = Global.getPageSize();

		/*
		 * 设置记录总数
		 */
		this.count = totalAmount;

		/*
		 * 设置页码数 pageNo
		 */
		String no = request.getParameter("pageNo");
		if (StringUtils.isNumeric(no)) {
			CookieUtils.setCookie(response, "pageNo", no);
			this.pageNo = Integer.parseInt(no);
		} else {
			no = CookieUtils.getCookie(request, "pageNo");
			if (StringUtils.isNumeric(no)) {
				this.pageNo = Integer.parseInt(no);
			} else {
				this.pageNo = 1;
				CookieUtils.setCookie(response, "pageNo", "1");
			}
		}

		/*
		 * 设置排序参数 orderBy
		 */
		String orderBy = request.getParameter("orderBy");
		if (StringUtils.isNotBlank(orderBy)) {
			CookieUtils.setCookie(response, "orderBy", orderBy);
			this.orderBy = orderBy;
		} else {
			orderBy = CookieUtils.getCookie(request, "orderBy");
			if (StringUtils.isNotBlank(orderBy)) {
				this.orderBy = orderBy;
			}
		}

		this.first = 1;
		this.last = (int) (count / this.pageSize);

		if (this.count % this.pageSize != 0 || this.last == 0) {
			this.last++;
		}

		if (this.last < this.first) {
			this.last = this.first;
		}

		if (this.pageNo <= 1) {
			this.pageNo = this.first;
			this.isFirstPage = true;
		}

		if (this.pageNo >= this.last) {
			this.pageNo = this.last;
			this.isLastPage = true;
		}

		if (this.pageNo < this.last - 1) {
			this.next = this.pageNo + 1;
		} else {
			this.next = this.last;
		}

		if (this.pageNo > 1) {
			this.prev = this.pageNo - 1;
		} else {
			this.prev = this.first;
		}

		if (this.pageNo < this.first) {// 如果当前页小于首页
			this.pageNo = this.first;
		}

		if (this.pageNo > this.last) {// 如果当前页大于尾页
			this.pageNo = this.last;
		}

		/*
		 * 设置数据位置游标
		 */
		this.dataIndex = (this.pageNo - 1) * this.pageSize;

		this.length = 10;

		this.slide = 3;

		this.orderBy = "ORDER BY C.updateDate DESC";

	}

	/**
	 * 输入分页内容
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		if (pageNo == first) {
			sb.append(
					"<li class=\"disabled\"><a href=\"javascript:void(0)\" aria-label=\"Previous\"> <span aria-hidden=\"true\">&laquo;</span></a></li>\n");
		} else {
			sb.append("<li><a href=\"javascript:void(0)\" onclick=\"" + funcName + "(" + prev
					+ ");\"> <span aria-hidden=\"true\">&laquo;</span></a></li>\n");
		}

		int begin = pageNo - (length / 2);

		if (begin < first) {
			begin = first;
		}

		int end = begin + length - 1;

		if (end >= last) {
			end = last;
			begin = end - length + 1;
			if (begin < first) {
				begin = first;
			}
		}

		if (begin > first) {
			int i = 0;
			for (i = first; i < first + slide && i < begin; i++) {
				sb.append("<li><a href=\"javascript:void(0)\" onclick=\"" + funcName + "(" + i + ");\">"
						+ (i + 1 - first) + "</a></li>\n");
			}
			if (i < begin) {
				sb.append("<li class=\"disabled\"><a href=\"javascript:void(0)\">...</a></li>\n");
			}
		}

		for (int i = begin; i <= end; i++) {
			if (i == pageNo) {
				sb.append("<li class=\"active\"><a href=\"javascript:void(0)\">" + (i + 1 - first) + "</a></li>\n");
			} else {
				sb.append("<li><a href=\"javascript:void(0)\" onclick=\"" + funcName + "(" + i + "," + pageSize + ",'"
						+ "');\">" + (i + 1 - first) + "</a></li>\n");
			}
		}

		if (last - end > slide) {
			sb.append("<li class=\"disabled\"><a href=\"javascript:void(0)\">...</a></li>\n");
			end = last - slide;
		}

		for (int i = end + 1; i <= last; i++) {
			sb.append("<li><a href=\"javascript:void(0)\" onclick=\"" + funcName + "(" + i + "," + pageSize + ",'"
					+ "');\">" + (i + 1 - first) + "</a></li>\n");
		}

		if (pageNo == last) {
			sb.append(
					"<li class=\"disabled\"><a href=\"javascript:void(0)\" aria-label=\"Next\"> <span aria-hidden=\"true\">&raquo;</span></a></li>\n");
		} else {
			sb.append("<li><a href=\"javascript:void(0)\" aria-label=\"Next\" onclick=\"" + funcName + "(" + next + ","
					+ pageSize + ",'" + "');\">" + "<span aria-hidden=\"true\">&raquo;</span></a></li>\n");
		}

		// sb.append("<li class=\"disabled controls\"><a
		// href=\"javascript:void(0)\">当前 ");
		// sb.append("<input type=\"text\" value=\"" + pageNo
		// + "\" onkeypress=\"var e=window.event||event;var
		// c=e.keyCode||e.which;if(c==13)");
		// sb.append(funcName + "(this.value," + pageSize + ",'" + "');\"
		// onclick=\"this.select();\"/> / ");
		// sb.append("<input type=\"text\" value=\"" + pageSize
		// + "\" onkeypress=\"var e=window.event||event;var
		// c=e.keyCode||e.which;if(c==13)");
		// sb.append(funcName + "(" + pageNo + ",this.value,'" + "');\"
		// onclick=\"this.select();\"/> 条，");
		// sb.append("共 " + count + " 条" + "</a></li>\n");

		// sb.insert(0, "<ul>\n").append("</ul>\n");

		return sb.toString();
	}

	public List<T> getList() {
		return list;
	}

	public Page<T> setList(List<T> list) {
		this.list = list;
		return this;
	}

	public String getOrderBy() {
		String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|"
				+ "(\\b(select|update|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";
		Pattern sqlPattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
		if (sqlPattern.matcher(orderBy).find()) {
			return "";
		}
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

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

	public int getDataIndex() {
		return dataIndex;
	}

	public void setDataIndex(int dataIndex) {
		this.dataIndex = dataIndex;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public int getPrev() {
		return prev;
	}

	public void setPrev(int prev) {
		this.prev = prev;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public boolean isFirstPage() {
		return isFirstPage;
	}

	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	public boolean isLastPage() {
		return isLastPage;
	}

	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getSlide() {
		return slide;
	}

	public void setSlide(int slide) {
		this.slide = slide;
	}

	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

}
