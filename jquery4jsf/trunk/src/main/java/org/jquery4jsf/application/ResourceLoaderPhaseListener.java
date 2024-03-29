/*
 *  Copyright (c) 2009 Giuseppe Trisciuoglio
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.jquery4jsf.application;

import java.io.InputStream;
import java.net.URL;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public class ResourceLoaderPhaseListener implements PhaseListener {
	
	private static final long serialVersionUID = 3082470350095850621L;

	private static final String RESOURCE_LOADER_VIEW_ID = ".resource";
	
	private static final String RESOURCE_FOLDER = "/META-INF/resource";
	
	public void beforePhase(PhaseEvent event) {
		//No-op
	}
	
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
	
	public void afterPhase(PhaseEvent event) {
		FacesContext facesContext = event.getFacesContext();        
		String viewRootId = facesContext.getViewRoot().getViewId();
		
		if (viewRootId.indexOf(RESOURCE_LOADER_VIEW_ID) != -1) {
			serveResource(facesContext);
		}
	}
	
	private void serveResource(FacesContext facesContext) {
		Map requestMap = facesContext.getExternalContext().getRequestParameterMap();
		String resourceName = getResourceName(requestMap);
		String resourceType = getResourceType(resourceName);
		String contentType  = getContentType(resourceType);
		int indice, tempIndice;
		byte tempArr[];
		byte mainArr[] = new byte[0];
		byte byteArr[] = new byte[65535];
		HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
		try {
			String resourcePath = RESOURCE_FOLDER + "/" + resourceName;
			InputStream inputStream = ResourceLoaderPhaseListener.class.getResourceAsStream(resourcePath);
			URL url = ResourceLoaderPhaseListener.class.getResource(resourcePath);
			if (url == null) {
				// resource not found
				facesContext.responseComplete();        
				return;
			}
			response.setContentType(contentType);
			response.setStatus(200);
			ServletOutputStream outputStream = response.getOutputStream();
			for(indice = 0; (indice = inputStream.read(byteArr)) > 0;)  {
				tempIndice = mainArr.length + indice;
				tempArr = new byte[tempIndice];
				System.arraycopy(mainArr, 0, tempArr, 0, mainArr.length);
				System.arraycopy(byteArr, 0, tempArr, mainArr.length, indice);
				mainArr = tempArr;
			}
			outputStream.write(mainArr);
			outputStream.flush();
			outputStream.close();
			facesContext.responseComplete();    
		} 
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public static String getResourceName(Map requestMap) {
		String resourceName = (String) requestMap.get("name");
		return resourceName;
	}
	
	public static String getResourceType(String resourceName) {
		String resourceType = resourceName.substring(resourceName.lastIndexOf('.') + 1, resourceName.length());
		return resourceType;
	}
	
	public static String getContentType(String resourceType) {
		String contentType = null;
		if(resourceType.equals("js"))
			contentType = "text/javascript";
		else if(resourceType.equals("css"))
			contentType = "text/css";
		else if(resourceType.equals("jpg")) 
			contentType = "image/jpeg";
		else if (resourceType.equals("gif"))
			contentType = "image/gif";
		
		return contentType;
	}
}