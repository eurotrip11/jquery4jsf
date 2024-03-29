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
package org.jquery4jsf.custom.tablesorter;

import java.io.IOException;
import java.util.ArrayList;

import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import org.jquery4jsf.component.ComponentUtilities;
import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.resource.ResourceContext;
import org.jquery4jsf.utilities.MessageFactory;
import org.jquery4jsf.utilities.TextUtilities;
public class TableSorterRenderer extends TableSorterBaseRenderer {
	private static final String THEME_ROLLER_JS = "tablesorter/jquery.tablesorter-theme.js";
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        TableSorter tableSorter = null;
        if(component instanceof TableSorter)
        	tableSorter = (TableSorter)component;
        
        encodeResources(tableSorter);
        encodeTableSorterScript(context, tableSorter);
	}
	
	protected void encodeResources(TableSorter tableSorter){
		String[] resources = tableSorter.getResources();
		for (int i = 0; i < resources.length; i++) {
			String resource = resources[i];
			if (!resource.equalsIgnoreCase(THEME_ROLLER_JS)){
				ResourceContext.getInstance().addResource(resource);
			}
			else{
				if (tableSorter.isThemeroller()){
					ResourceContext.getInstance().addResource(resource);
				}
			}
		}
	}
	
	protected void encodeTableSorterScript(FacesContext context, TableSorter tableSorter) throws IOException{
        JSDocumentElement documentElement = JSDocumentElement.getInstance();
        JSFunction function = new JSFunction();
        function.addJSElement(getJSElement(context, tableSorter));
        documentElement.addFunctionToReady(function);
	}
	
	protected String encodeOptionComponent(StringBuffer options, TableSorter tableSorter , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, tableSorter.getAscStyleClass(), "cssAsc", null);
		encodeOptionComponentByType(options, tableSorter.getDescStyleClass(), "cssDesc", null);
		encodeOptionComponentByType(options, tableSorter.getHeaderStyleClass(), "cssHeader", null);
		if (!TextUtilities.isStringVuota(tableSorter.getSortedColumns()))
		{
			UIComponent dataTable = ComponentUtilities.findComponentInRoot(tableSorter.getTarget());
			if (dataTable instanceof UIData) {
				UIData data = (UIData) dataTable;
				StringBuffer headers = new StringBuffer();
				ArrayList columnsList = ComponentUtilities.getColumns(data);
				String[] spliter = tableSorter.getSortedColumns().split(",");
				for (int i = 0; i < columnsList.size(); i++) {
					boolean isCheck = false;
					for (int j = 0; j < spliter.length; j++) {
						String idColumn = spliter[j];
						if (!TextUtilities.isNumber(idColumn))
							throw new FacesException("Solo numeri");
						if (i == Integer.parseInt(idColumn)){
							isCheck = true;
							break;
						}
					}
					if(!isCheck){
						StringBuffer sbColumn = new StringBuffer();
						encodeOptionComponentByType(sbColumn, false, "sorter", "true");
						encodeOptionComponentOptionsByType(headers,sbColumn.toString(), Integer.toString(i), null);
					}
				}
				encodeOptionComponentOptionsByType(options,headers.toString(), "headers", null);
			}
		}
		encodeOptionComponentByType(options, tableSorter.getSortMultiSortKey(), "sortMultiSortKey", null);
		encodeOptionComponentByType(options, true, "widthFixed", null);
		if (options.toString().endsWith(", \n")){
			String stringa = options.substring(0, options.length()-3);
			options = new StringBuffer(stringa);
		}
		boolean noParams = false;
		if (options.toString().endsWith(" {\n")){
			String stringa = options.substring(0, options.length()-3);
			options = new StringBuffer(stringa);
			noParams = true;
		}
		if (!noParams)
		{
			options.append(" }");
		}
		return options.toString();
	}

	public JSElement getJSElement(FacesContext context, UIComponent component) {
        TableSorter tableSorter = null;
        if(component instanceof TableSorter)
        	tableSorter = (TableSorter)component;
        String id = RendererUtilities.getJQueryIdComponent(tableSorter.getTarget(), context, tableSorter);
        JSElement element = new JSElement(id);
        JSAttribute jsTableSorter = new JSAttribute("tablesorter", false);
        StringBuffer sbOption = new StringBuffer();
        jsTableSorter.addValue(encodeOptionComponent(sbOption, tableSorter, context));
        element.addAttribute(jsTableSorter);
		return element;
	}
}
