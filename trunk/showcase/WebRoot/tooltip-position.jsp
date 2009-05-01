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
			<jsp:include page="inc/menu-tooltip.jsp"></jsp:include>
			<!--right side start -->
			<div id="rightPan">
				<f:view>
					<jq:panel id="panel" header="Tooltip default">
						<h:panelGrid columns="2">
							<h:outputLabel for="dataPicker" value="Datepicker: " />
							<jq:datePicker id="dataPicker" title="This is a datepicker component">
								<jq:tooltip id="tooltip1" ></jq:tooltip>
							</jq:datePicker>
							<h:outputLabel for="link" value="Datepicker: " />
							<h:outputLink title="This a link of google ltd" id="link" value="http://www.google.com"><h:outputText value="Google" />
								<jq:tooltip id="tooltip2" ></jq:tooltip>
							</h:outputLink>
						</h:panelGrid>
					</jq:panel>
					<jq:paragraph />
					<jq:panel id="panelSource" header="Tooltip source">
						<jq:syntaxHighlighting type="xml">
&lt;jq:panel id=&quot;panel&quot; header=&quot;Tooltip default&quot;&gt;
	&lt;h:panelGrid columns=&quot;2&quot;&gt;
		&lt;h:outputLabel for=&quot;dataPicker&quot; value=&quot;Datepicker: &quot; /&gt;
		&lt;jq:datePicker id=&quot;dataPicker&quot; title=&quot;This is a datepicker component&quot;&gt;
			&lt;jq:tooltip id=&quot;tooltip1&quot; &gt;&lt;/jq:tooltip&gt;
		&lt;/jq:datePicker&gt;
		&lt;h:outputLabel for=&quot;link&quot; value=&quot;Datepicker: &quot; /&gt;
		&lt;h:outputLink title=&quot;This a link of google ltd&quot; id=&quot;link&quot; value=&quot;http://www.google.com&quot;&gt;&lt;h:outputText value=&quot;Google&quot; /&gt;
			&lt;jq:tooltip id=&quot;tooltip2&quot; &gt;&lt;/jq:tooltip&gt;
		&lt;/h:outputLink&gt;
	&lt;/h:panelGrid&gt;
&lt;/jq:panel&gt;
						</jq:syntaxHighlighting>
					</jq:panel>
				</f:view>
			</div>
			<br class="blank" />
		</div>
		<!--body part end -->
		<jsp:include page="inc/footer.jsp"></jsp:include>
	</body>
</html>