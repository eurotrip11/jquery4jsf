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
package org.jquery4jsf.custom.toplink;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class HtmlTopLinkTag extends UIComponentTagBase {

	private String value;
	private String converter;
	private String dir;
	private String lang;
	private String title;
	private String xmlLang;
	private String style;
	private String styleClass;
	private String min;
	private String fadeSpeed;
	private String ieOffset;
	private String target;

	public void release(){
		super.release();
		this.value = null;
		this.converter = null;
		this.dir = null;
		this.lang = null;
		this.title = null;
		this.xmlLang = null;
		this.style = null;
		this.styleClass = null;
		this.min = null;
		this.fadeSpeed = null;
		this.ieOffset = null;
		this.target = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.toplink.HtmlTopLink component = null;
		try {
			component = (org.jquery4jsf.custom.toplink.HtmlTopLink) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setValueProperty(getFacesContext(), component, "value", value);
		setConverterProperty(getFacesContext(), component, "converter", converter);
		setStringProperty(getFacesContext(), component, "dir", dir);
		setStringProperty(getFacesContext(), component, "lang", lang);
		setStringProperty(getFacesContext(), component, "title", title);
		setStringProperty(getFacesContext(), component, "xmlLang", xmlLang);
		setStringProperty(getFacesContext(), component, "style", style);
		setStringProperty(getFacesContext(), component, "styleClass", styleClass);
		setIntegerProperty(getFacesContext(), component, "min", min);
		setIntegerProperty(getFacesContext(), component, "fadeSpeed", fadeSpeed);
		setIntegerProperty(getFacesContext(), component, "ieOffset", ieOffset);
		setStringProperty(getFacesContext(), component, "target", target);
	}

	public String getComponentType() {
		return HtmlTopLink.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.HtmlTopLinkRenderer";
	}

	public void setValue(String value){
		this.value = value;
	}

	public void setConverter(String value){
		this.converter = value;
	}

	public void setDir(String value){
		this.dir = value;
	}

	public void setLang(String value){
		this.lang = value;
	}

	public void setTitle(String value){
		this.title = value;
	}

	public void setXmlLang(String value){
		this.xmlLang = value;
	}

	public void setStyle(String value){
		this.style = value;
	}

	public void setStyleClass(String value){
		this.styleClass = value;
	}

	public void setMin(String value){
		this.min = value;
	}

	public void setFadeSpeed(String value){
		this.fadeSpeed = value;
	}

	public void setIeOffset(String value){
		this.ieOffset = value;
	}

	public void setTarget(String value){
		this.target = value;
	}

}