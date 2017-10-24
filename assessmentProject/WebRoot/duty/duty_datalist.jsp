<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>" />
<s:append var="lst">
	<s:param value="%{pageBean.curPageData}"></s:param>
</s:append>

<%-- <input id="hid_totalcount" type="hidden" value="${page.totalCount }"/> --%>
<s:hidden name="infocatcode"></s:hidden>
<input id="hid_totalcount" type="hidden"
	value="<s:property value="%{pageBean.totalRecord}"/>" />

<div class="panel panel-default">
	<div class="panel-heading">
		数据(
		<s:property value="%{pageBean.totalRecord}" />
		)
	</div>
	<div class="panel-body">
		<div class="table-responsive">
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<td width="10%" align="center">序号</td>
						<td width="20%" align="center">部门名称</td>
						<td width="20%" align="center">职务名称</td>
						<td width="20%" align="center">薪资</td>				
						<td width="20%" align="center">操作</td>
					</tr>
				</thead>
				<tbody>
					<s:iterator var="ManageDto" value="%{#lst}" status="status">
						<tr>
							<td align="center"><s:property value="%{#status.index+1}" /></td>							
							<td align="center"><s:property value="#ManageDto.departmentName" /></td>
							<td align="center"><s:property value="#ManageDto.dutyName" /></td>
							<td align="center"><s:property value="#ManageDto.dutySalary" /></td>							
							<td align="center"><a class="act_edit"
								href="duty/duty_updateViewDuty?selectNumber=<s:property value="#ManageDto.dutyId"/>">编辑
							</a> &nbsp;&nbsp; <a class="act_delete"
								href="javascript:deletehosinfo('<s:property value="#ManageDto.dutyId"/>', <s:property value="%{pageBean.curPage}"/>);">删除</a>
							</td>
					</s:iterator>
					<s:if test="%{pageBean.totalRecord == 0}">
						<tr>
							<td align="center" colspan="5">暂无数据</td>
						</tr>
					</s:if>

				</tbody>
			</table>

			<div style="float: left;" align="left" class="pagination">
				&nbsp;&nbsp;共有 <font style="font-weight: bolder;"><s:property
						value="%{pageBean.totalRecord}" /> </font> 条记录，&nbsp;共
				<s:property value="%{pageBean.curPage}" />
				/
				<s:property value="%{pageBean.totalPage}" />
				页
			</div>
			<ul class="pagination" style="float: right;">
				<s:if test="%{pageBean.isFirstPage()}">
					<li><a class="pagination">首页</a></li>
				</s:if>
				<s:else>
					<li><a href="#" class="pagination"
						onclick="javascript:datalist_ctrl.topage('<s:property value="%{pageBean.getFirstPageUrl()}"/>');return false;">
							首页 </a></li>
				</s:else>

				<s:if test="%{pageBean.isFirstPage()}">
					<li><a class="pagination">上页</a></li>
				</s:if>
				<s:else>
					<li><a href="#" class="pagination"
						onclick="javascript:datalist_ctrl.topage('<s:property value="%{pageBean.getPrevPageUrl()}"/>');return false;">
							上页 </a></li>
				</s:else>

				<s:if test="%{pageBean.isLastPage()}">
					<li><a class="pagination">下页</a></li>
				</s:if>
				<s:else>
					<li><a href="#" class="pagination"
						onclick="javascript:datalist_ctrl.topage('<s:property value="%{pageBean.getNextPageUrl()}"/>'); return false;">
							下页 </a></li>
				</s:else>
				<s:if test="%{pageBean.isLastPage()}">
					<li><a class="pagination">末页</a></li>
				</s:if>
				<s:else>
					<li><a href="#" class="pagination"
						onclick="javascript:datalist_ctrl.topage('<s:property value="%{pageBean.getLastPageUrl()}"/>');return false;">
							末页 </a></li>
				</s:else>
			</ul>
		</div>
	</div>
</div>


