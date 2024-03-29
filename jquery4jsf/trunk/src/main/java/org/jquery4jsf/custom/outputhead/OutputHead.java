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
package org.jquery4jsf.custom.outputhead;

import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import javax.faces.component.UIComponent;

public class OutputHead extends UIComponentBase {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.OutputHead";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.OutputHead";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.OutputHeadRenderer";

	private String[] resources;
	private String profile;
	private String dir;
	private String lang;
	private String langXml;

	public OutputHead() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getProfile() {
		if(profile != null )
			return profile;

		String oValue = (String) getLocalOrValueBindingValue(profile, "profile");
		return oValue != null ? oValue : null;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getDir() {
		if(dir != null )
			return dir;

		String oValue = (String) getLocalOrValueBindingValue(dir, "dir");
		return oValue != null ? oValue : null;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getLang() {
		if(lang != null )
			return lang;

		String oValue = (String) getLocalOrValueBindingValue(lang, "lang");
		return oValue != null ? oValue : null;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getLangXml() {
		if(langXml != null )
			return langXml;

		String oValue = (String) getLocalOrValueBindingValue(langXml, "langXml");
		return oValue != null ? oValue : null;
	}
	public void setLangXml(String langXml) {
		this.langXml = langXml;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[5];
		values[0] = super.saveState(context);
		values[1] = this.profile;
		values[2] = this.dir;
		values[3] = this.lang;
		values[4] = this.langXml;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.profile = (String) values[1];
		this.dir = (String) values[2];
		this.lang = (String) values[3];
		this.langXml = (String) values[4];
	}

	public String[] getResources() {
		return resources;
	}

	protected Object getLocalOrValueBindingValue(Object localValue, String valueBindingName)
	{
		if (localValue != null)
			return localValue;
		ValueBinding vb = getValueBinding(valueBindingName);
		return vb != null ? vb.getValue(getFacesContext()) : null;
	}
}