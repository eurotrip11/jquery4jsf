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
package org.jquery4jsf.custom.html;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.renderkit.HtmlBasicRenderer;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.renderkit.html.HtmlRendererUtilities;

public class HtmlAcronymRenderer extends HtmlBasicRenderer {

	public static final String RENDERER_TYPE = "org.jquery4jsf.HtmlAcronymRenderer";

	
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        if ((context == null) || (component == null))
        {
            throw new NullPointerException();
        }
        HtmlAcronym htmlAcronym = null;
        if (component instanceof HtmlAcronym){
        	htmlAcronym = (HtmlAcronym)component;
        }
        if (!htmlAcronym.isRendered())
        	return;
        
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement(HTML.TAG_ACRONYM, htmlAcronym);
        HtmlRendererUtilities.writeHtmlAttributes(writer, component, HTML.HTML_STD_ATTR);
        HtmlRendererUtilities.writeHtmlAttributes(writer, component, HTML.HTML_JS_STD_ATTR);

	}

	public void encodeChildren(FacesContext context, UIComponent component)throws IOException {
		super.encodeChildren(context, component);
	}

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		if ((context == null) || (component == null))
        {
            throw new NullPointerException();
        }
        HtmlAcronym htmlAcronym = null;
        if (component instanceof HtmlAcronym){
        	htmlAcronym = (HtmlAcronym)component;
        }
        if (!htmlAcronym.isRendered())
        	return;
        ResponseWriter writer = context.getResponseWriter();
        writer.endElement(HTML.TAG_ACRONYM);
	}

	public boolean getRendersChildren() {
		return false;
	}
	
}
