<%--

     Copyright (c) 2009 Giuseppe Trisciuoglio

     Licensed under the Apache License, Version 2.0 (the "License");
     you may not use this file except in compliance with the License.
     You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

     Unless required by applicable law or agreed to in writing, software
     distributed under the License is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     See the License for the specific language governing permissions and
     limitations under the License.


--%>
<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://www.jquery4jsf.org/jsf" prefix="jq"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=iso-8859-1" />
		<title>jQuery4jsf</title>
		<%String path = request.getContextPath();String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%><link
			href="<%=basePath%>style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<jsp:include page="inc/header.jsp"></jsp:include>
		<!--body part start -->
		<div id="mainBody">
			<jsp:include page="inc/menu-dialog.jsp"></jsp:include>
			<!--right side start -->
			<div id="rightPan">
				<f:view>
					<jq:dialog id="dialog" title="Empty the recycle bin?"
						autoOpen="true" bgiframe="true" resizable="false" height="140"
						modal="true"
						buttons="{'Delete all items in recycle bin': function() {
										$(this).dialog('close');
									},
									Cancel: function() {
										$(this).dialog('close');
									}
								}">
						<f:verbatim escape="false">
							<p>
								<span class="ui-icon ui-icon-alert"
									style="float: left; margin: 0 7px 20px 0;"></span>These items
								will be permanently deleted and cannot be recovered. Are you
								sure?
							</p>
						</f:verbatim>
					</jq:dialog>
					<h:form id="form1">
						<div class="demo">
							<!-- Sample page content to illustrate the layering of the dialog -->
							<div class="hiddenInViewSource" style="padding: 20px;">
								<p>
									Sed vel diam id libero
									<a href="http://example.com">rutrum convallis</a>. Donec
									aliquet leo vel magna. Phasellus rhoncus faucibus ante. Etiam
									bibendum, enim faucibus aliquet rhoncus, arcu felis ultricies
									neque, sit amet auctor elit eros a lectus.
								</p>
								<input value="text input" />
								<br />
								<input type="checkbox" />
								checkbox
								<br />
								<input type="radio" />
								radio
								<br />
								<select>
									<option>
										select
									</option>
								</select>
								<br />
								<br />
								<textarea>textarea</textarea>
								<br />
							</div>
							<!-- End sample page content -->
							<div class="ui-widget-content ui-corner-all">
								<p>
									Confirm an action that may be destructive or important. Set the
									<code>
										modal
									</code>
									option to true, and specify primary and secondary user actions
									with the
									<code>
										buttons
									</code>
									option.
								</p>
							</div>
							<!-- End demo-description -->
						</div>
						<!-- End demo -->
					</h:form>
				</f:view>
			</div>
			<br class="blank" />
		</div>
		<!--body part end -->
		<jsp:include page="inc/footer.jsp"></jsp:include>
	</body>
</html>