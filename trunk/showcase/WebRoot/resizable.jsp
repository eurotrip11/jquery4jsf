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
		<link href="/demo.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<jsp:include page="inc/header.jsp"></jsp:include>
		<!--body part start -->
		<div id="mainBody">
			<jsp:include page="inc/menu-left.jsp"></jsp:include>
			<!--right side start -->
			<div id="rightPan">
				<f:view>
					<jq:div styleClass="demo">
						<jq:div id="resizable" styleClass="ui-widget-content">
							<h3 class="ui-widget-header">
								Resizable
							</h3>
							<p>
								Ristringimi dai su!!!!
							</p>
							<jq:resizable />
						</jq:div>
						<h:inputTextarea id="textarea" value="Resizemi!!!" cols="70">
							<jq:resizable distance="10" minHeight="10" minWidth="10" />
						</h:inputTextarea>
					</jq:div>
					<!-- End demo -->
					<div class="ui-widget-content">
						<p>
							Enable any DOM element to be resizable. With the cursor grab the
							right or bottom border and drag to the desired width or height.
						</p>
					</div>
				</f:view>
				<!-- End demo-description -->
			</div>
			<br class="blank" />
		</div>
		<!--body part end -->
		<jsp:include page="inc/footer.jsp"></jsp:include>
	</body>
</html>