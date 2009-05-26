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
package org.jquery4jsf.custom.dialog;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.custom.button.Button;
import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.resource.ResourceContext;
import org.jquery4jsf.utilities.MessageFactory;
public class AlertDialogRenderer extends AlertDialogBaseRenderer {

	public static final String RENDERER_TYPE = "org.jquery4jsf.DialogRenderer";

	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        AlertDialog alertDialog = null;
        if(component instanceof AlertDialog)
            alertDialog = (AlertDialog)component;
        ResponseWriter responseWriter = context.getResponseWriter();
        
        // TODO devo trovare il modo per scrivere i script nell'head
        String[] list = alertDialog.getResources();
        for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			ResourceContext.getInstance().addResource(resource);
		}
        String clientId = alertDialog.getClientId(context);
        if (alertDialog.getAction() != null 
        		|| alertDialog.getActionListener() != null){
        	HtmlCommandButton okButton = new HtmlCommandButton();
        	okButton.setId("buttonok_"+alertDialog.getId());
        	okButton.setAction(alertDialog.getAction());
        	okButton.setActionListener(alertDialog.getActionListener());
        	alertDialog.getChildren().add(okButton);
        }
        if (alertDialog.getOkAction() != null){
        	HtmlCommandButton okButton = new HtmlCommandButton();
        	okButton.setId("buttona_"+alertDialog.getId());
        	okButton.setAction(alertDialog.getOkAction());
        	alertDialog.getChildren().add(okButton);
        }
        if (alertDialog.getNoAction() != null){
        	HtmlCommandButton okButton = new HtmlCommandButton();
        	okButton.setId("buttonb_"+alertDialog.getId());
        	okButton.setAction(alertDialog.getNoAction());
        	alertDialog.getChildren().add(okButton);
        }
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        JSElement element = new JSElement(clientId);
        JSAttribute jsDialog = new JSAttribute("dialog", false);
        StringBuffer sbOption = new StringBuffer();
        jsDialog.addValue(encodeOptionComponent(sbOption, alertDialog, context));
        element.addAttribute(jsDialog);
        JSFunction function = new JSFunction();
        function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.createTagScriptForJs(component, responseWriter, sb);
        
        responseWriter.startElement(HTML.TAG_DIV, alertDialog);
        responseWriter.writeAttribute("id", clientId, "id");
	}
	
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.endElement(HTML.TAG_DIV);
	}

	public boolean getRendersChildren() {
		return true;
	}

	public void encodeChildren(FacesContext context, UIComponent component)throws IOException {
		RendererUtilities.renderChildren(context, component);
	}

	
	protected String encodeOptionComponent(StringBuffer options, AlertDialog alertDialog , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, alertDialog.isAutoOpen(), "autoOpen", "true");
		encodeOptionComponentByType(options, alertDialog.isBgiframe(), "bgiframe", "false");
		StringBuffer buttons = new StringBuffer();
		encodeOptionComponentFunction(buttons, "$(this).dialog('close');",alertDialog.getNoLabel());
		encodeOptionComponentFunction(buttons, "$(this).dialog('close');",alertDialog.getOkLabel());
		//encodeOptionComponentByType(options, alertDialog.getOkAction(), "okAction", null);
		//encodeOptionComponentByType(options, alertDialog.getNoAction(), "noAction", null);
		encodeOptionComponentOptionsByType(options, buttons.toString(), "buttons", null);
		encodeOptionComponentByType(options, alertDialog.isCloseOnEscape(), "closeOnEscape", "true");
		encodeOptionComponentByType(options, alertDialog.getDialogClass(), "dialogClass", null);
		encodeOptionComponentByType(options, alertDialog.isDraggable(), "draggable", "true");
		encodeOptionComponentByType(options, alertDialog.getHeight(), "height", null);
		encodeOptionComponentByType(options, alertDialog.getHide(), "hide", null);
		encodeOptionComponentByType(options, alertDialog.getMaxHeight(), "maxHeight", null);
		encodeOptionComponentByType(options, alertDialog.getMaxWidth(), "maxWidth", null);
		encodeOptionComponentByType(options, alertDialog.getMinHeight(), "minHeight", "150");
		encodeOptionComponentByType(options, alertDialog.getMinWidth(), "minWidth", "150");
		encodeOptionComponentByType(options, alertDialog.isModal(), "modal", "false");
		encodeOptionComponentByType(options, alertDialog.getPosition(), "position", "center");
		encodeOptionComponentByType(options, alertDialog.isResizable(), "resizable", "true");
		encodeOptionComponentByType(options, alertDialog.getShow(), "show", null);
		encodeOptionComponentByType(options, alertDialog.isStack(), "stack", "true");
		encodeOptionComponentByType(options, alertDialog.getTitle(), "title", null);
		encodeOptionComponentByType(options, alertDialog.getWidth(), "width", "300");
		encodeOptionComponentByType(options, alertDialog.getZindex(), "zIndex", "1000");
		encodeOptionComponentByType(options, alertDialog.getOnbeforeclose(), "onbeforeclose", null);
		encodeOptionComponentByType(options, alertDialog.getOnopen(), "onopen", null);
		encodeOptionComponentByType(options, alertDialog.getOnfocus(), "onfocus", null);
		encodeOptionComponentByType(options, alertDialog.getOndragStart(), "ondragStart", null);
		encodeOptionComponentByType(options, alertDialog.getOndrag(), "ondrag", null);
		encodeOptionComponentByType(options, alertDialog.getOndragStop(), "ondragStop", null);
		encodeOptionComponentByType(options, alertDialog.getOnresizeStart(), "onresizeStart", null);
		encodeOptionComponentByType(options, alertDialog.getOnresize(), "onresize", null);
		encodeOptionComponentByType(options, alertDialog.getOnresizeStop(), "onresizeStop", null);
		encodeOptionComponentByType(options, alertDialog.getOnclose(), "onclose", null);
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
}