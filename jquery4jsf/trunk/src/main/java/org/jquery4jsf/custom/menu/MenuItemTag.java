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
package org.jquery4jsf.custom.menu;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class MenuItemTag extends UIComponentTagBase {

	private String value;
	private String actionListener;
	private String action;
	private String immediate;
	private String ajaxSubmit;
	private String label;
	private String disabled;
	private String disabledClass;
	private String target;

	public void release(){
		super.release();
		this.value = null;
		this.actionListener = null;
		this.action = null;
		this.immediate = null;
		this.ajaxSubmit = null;
		this.label = null;
		this.disabled = null;
		this.disabledClass = null;
		this.target = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.menu.MenuItem component = null;
		try {
			component = (org.jquery4jsf.custom.menu.MenuItem) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setValueProperty(getFacesContext(), component, "value", value);
		setActionListenerProperty(getFacesContext(), component, "actionListener", actionListener);
		setActionProperty(getFacesContext(), component, "action", action);
		setBooleanProperty(getFacesContext(), component, "immediate", immediate);
		setBooleanProperty(getFacesContext(), component, "ajaxSubmit", ajaxSubmit);
		setStringProperty(getFacesContext(), component, "label", label);
		setBooleanProperty(getFacesContext(), component, "disabled", disabled);
		setStringProperty(getFacesContext(), component, "disabledClass", disabledClass);
		setStringProperty(getFacesContext(), component, "target", target);
	}

	public String getComponentType() {
		return MenuItem.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return null;
	}

	public void setValue(String value){
		this.value = value;
	}

	public void setActionListener(String value){
		this.actionListener = value;
	}

	public void setAction(String value){
		this.action = value;
	}

	public void setImmediate(String value){
		this.immediate = value;
	}

	public void setAjaxSubmit(String value){
		this.ajaxSubmit = value;
	}

	public void setLabel(String value){
		this.label = value;
	}

	public void setDisabled(String value){
		this.disabled = value;
	}

	public void setDisabledClass(String value){
		this.disabledClass = value;
	}

	public void setTarget(String value){
		this.target = value;
	}

}