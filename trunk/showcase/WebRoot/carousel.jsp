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
			<jsp:include page="inc/menu-left.jsp"></jsp:include>
			<!--right side start -->
			<div id="rightPan">
				<f:view>
					<jq:carousel id="carousel">
						<h:graphicImage
							value="http://static.flickr.com/66/199481236_dc98b5abb3_s.jpg"
							width="75" height="75" alt="" />
						<h:graphicImage
							value="http://static.flickr.com/75/199481072_b4a0d09597_s.jpg"
							width="75" height="75" alt="" />
						<h:graphicImage
							value="http://static.flickr.com/57/199481087_33ae73a8de_s.jpg"
							width="75" height="75" alt="" />
						<h:graphicImage
							value="http://static.flickr.com/77/199481108_4359e6b971_s.jpg"
							width="75" height="75" alt="" />
						<h:graphicImage
							value="http://static.flickr.com/58/199481143_3c148d9dd3_s.jpg"
							width="75" height="75" alt="" />
						<h:graphicImage
							value="http://static.flickr.com/72/199481203_ad4cdcf109_s.jpg"
							width="75" height="75" alt="" />
						<h:graphicImage
							value="http://static.flickr.com/58/199481218_264ce20da0_s.jpg"
							width="75" height="75" alt="" />
						<h:graphicImage
							value="http://static.flickr.com/69/199481255_fdfe885f87_s.jpg"
							width="75" height="75" alt="" />
						<h:graphicImage
							value="http://static.flickr.com/60/199480111_87d4cb3e38_s.jpg"
							width="75" height="75" alt="" />
						<h:graphicImage
							value="http://static.flickr.com/70/229228324_08223b70fa_s.jpg"
							width="75" height="75" alt="" />
					</jq:carousel>
				</f:view>
			</div>
			<br class="blank" />
		</div>
		<!--body part end -->
		<jsp:include page="inc/footer.jsp"></jsp:include>
	</body>
</html>