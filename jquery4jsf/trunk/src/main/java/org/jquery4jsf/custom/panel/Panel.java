/*
 
*  Copyright (c) 2009 Giuseppe Trisciuoglio 
* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jquery4jsf.custom.panel;

import org.jquery4jsf.component.ext.HtmlBaseOutputComponent;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.JQueryHtmlObject;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import javax.faces.component.UIComponent;

public class Panel extends HtmlBaseOutputComponent implements JQueryHtmlObject {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlPanel";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Panel";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.PanelRenderer";

	private String[] resources;
	private String header;
	private String headerClass;
	private String contentClass;

	public Panel() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"themes/base/ui.all.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getHeader() {
		if(header != null )
			return header;

		String oValue = (String) getLocalOrValueBindingValue(header, "header");
		return oValue != null ? oValue : null;
	}
	public void setHeader(String header) {
		this.header = header;
	}

	public String getHeaderClass() {
		if(headerClass != null )
			return headerClass;

		String oValue = (String) getLocalOrValueBindingValue(headerClass, "headerClass");
		return oValue != null ? oValue : null;
	}
	public void setHeaderClass(String headerClass) {
		this.headerClass = headerClass;
	}

	public String getContentClass() {
		if(contentClass != null )
			return contentClass;

		String oValue = (String) getLocalOrValueBindingValue(contentClass, "contentClass");
		return oValue != null ? oValue : null;
	}
	public void setContentClass(String contentClass) {
		this.contentClass = contentClass;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[4];
		values[0] = super.saveState(context);
		values[1] = this.header;
		values[2] = this.headerClass;
		values[3] = this.contentClass;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.header = (String) values[1];
		this.headerClass = (String) values[2];
		this.contentClass = (String) values[3];
	}

	public String[] getResources() {
		return resources;
	}

	public void encodeScript(FacesContext facesContext) throws IOException {
		Renderer renderer = getRenderer(facesContext);

		if(renderer instanceof org.jquery4jsf.renderkit.JQueryRenderer) {
			((org.jquery4jsf.renderkit.JQueryRenderer)renderer).encodeScript(facesContext, this);
		}
	}
}