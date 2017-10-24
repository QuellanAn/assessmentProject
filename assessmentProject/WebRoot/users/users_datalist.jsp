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
<div class="row">
	<div class="col-md-12">
		<!--   Kitchen Sink -->
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
								<th width="6%">序号</th>
								<th width="7%">姓名</th>
								<th width="7%">性别</th>
								<th width="9%">电话</th>
								<th width="9%">邮箱</th>
								<th width="10%">身份证</th>
								<th width="9%">部门</th>
								<th width="9%">职位</th>
								<th width="14%">户籍所在地</th>
								<th width="11%">现居地址</th>
								<th width="9%">操作</th>

							</tr>
						</thead>
						<tbody>
							<s:iterator var="ManageDto" value="%{#lst}" status="status">
								<tr>
									<td><s:property value="%{#status.index+1}" />
									</td>
									<td>				
										<a href="user/manager_getUserMsgById?userId=<s:property value="#ManageDto.userId"/>">
											<s:if test="null != #ManageDto.userName && #ManageDto.userName.length()>6">
												<s:property value="#ManageDto.userName.substring(0,6)" />...
											</s:if> 
											<s:else>
												<s:property value="#ManageDto.userName" default="" />
											</s:else> 
										</a>
									</td>
									<td><s:property value="#ManageDto.userSex" />
									</td>
									<td><s:property value="#ManageDto.telephone" />
									</td>
									<td><s:property value="#ManageDto.email" />
									</td>
									<td><s:property value="#ManageDto.identificationCard" />
									</td>
									<td><s:property value="#ManageDto.departmentName" />
									</td>
									<td><s:property value="#ManageDto.dutyName" />
									</td>
									<td><s:property value="#ManageDto.domicile" />
									</td>
									<td><s:property value="#ManageDto.address" />
									</td>

									<td align="center"><a class="act_edit"
										href="user/manager_updateViewUser?selectNumber=<s:property value="#ManageDto.userId"/>">&nbsp;&nbsp;&nbsp;编辑
									</a> &nbsp;&nbsp; <a class="act_delete"
										href="javascript:deletehosinfo('<s:property value="#ManageDto.userId"/>', <s:property value="%{pageBean.curPage}"/>);">删除</a>
									</td>
							</s:iterator>
							<s:if test="%{pageBean.totalRecord == 0}">
								<tr>
									<td align="center" colspan="11">暂无数据</td>
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
							<li><a class="pagination">首页</a>
							</li>
						</s:if>
						<s:else>
							<li><a href="#" class="pagination"
								onclick="javascript:datalist_ctrl.topage('<s:property value="%{pageBean.getFirstPageUrl()}"/>');return false;">
									首页 </a>
							</li>
						</s:else>

						<s:if test="%{pageBean.isFirstPage()}">
							<li><a class="pagination">上页</a>
							</li>
						</s:if>
						<s:else>
							<li><a href="#" class="pagination"
								onclick="javascript:datalist_ctrl.topage('<s:property value="%{pageBean.getPrevPageUrl()}"/>');return false;">
									上页 </a>
							</li>
						</s:else>

						<s:if test="%{pageBean.isLastPage()}">
							<li><a class="pagination">下页</a>
							</li>
						</s:if>
						<s:else>
							<li><a href="#" class="pagination"
								onclick="javascript:datalist_ctrl.topage('<s:property value="%{pageBean.getNextPageUrl()}"/>'); return false;">
									下页 </a>
							</li>
						</s:else>
						<s:if test="%{pageBean.isLastPage()}">
							<li><a class="pagination">末页</a>
							</li>
						</s:if>
						<s:else>
							<li><a href="#" class="pagination"
								onclick="javascript:datalist_ctrl.topage('<s:property value="%{pageBean.getLastPageUrl()}"/>');return false;">
									末页 </a>
							</li>
						</s:else>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>

