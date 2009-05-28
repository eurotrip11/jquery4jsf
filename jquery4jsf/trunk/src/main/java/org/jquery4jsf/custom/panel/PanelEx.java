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

import org.jquery4jsf.custom.panel.Panel;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.custom.JQueryHtmlObject;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import javax.faces.component.UIComponent;

public class PanelEx extends Panel implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlPanelEx";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.PanelEx";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.PanelExRenderer";

	private String[] resources;
	private String header;
	private String event;
	private Boolean collapsible;
	private String collapseType;
	private Boolean collapsed;
	private String collapseSpeed;
	private Boolean controls;
	private String widgetClass;
	private String headerClass;
	private String contentClass;
	private String rightboxClass;
	private String controlsClass;
	private String titleClass;
	private String titleTextClass;
	private String iconClass;
	private String hoverClass;
	private String collapsePnlClass;
	private String headerIconClpsd;
	private String headerIcon;
	private String slideRIconClpsd;
	private String slideRIcon;
	private String slideLIconClpsd;
	private String slideLIcon;
	private String onunfold;
	private String onfold;

	public PanelEx() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"ui/ui.core.js",
			"panel/ui.panel.js",
			"themes/base/ui.all.css",
			"panel/ui.panel.css"
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

	public String getEvent() {
		if(event != null )
			return event;

		String oValue = (String) getLocalOrValueBindingValue(event, "event");
		return oValue != null ? oValue : null;
	}
	public void setEvent(String event) {
		this.event = event;
	}

	public boolean isCollapsible() {
		if(collapsible != null )
			return collapsible.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(collapsible, "collapsible");
		return oValue != null ? oValue.booleanValue()  : true;
	}
	public void setCollapsible(boolean collapsible) {
		this.collapsible = new Boolean(collapsible);
	}

	public String getCollapseType() {
		if(collapseType != null )
			return collapseType;

		String oValue = (String) getLocalOrValueBindingValue(collapseType, "collapseType");
		return oValue != null ? oValue : null;
	}
	public void setCollapseType(String collapseType) {
		this.collapseType = collapseType;
	}

	public boolean isCollapsed() {
		if(collapsed != null )
			return collapsed.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(collapsed, "collapsed");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setCollapsed(boolean collapsed) {
		this.collapsed = new Boolean(collapsed);
	}

	public String getCollapseSpeed() {
		if(collapseSpeed != null )
			return collapseSpeed;

		String oValue = (String) getLocalOrValueBindingValue(collapseSpeed, "collapseSpeed");
		return oValue != null ? oValue : null;
	}
	public void setCollapseSpeed(String collapseSpeed) {
		this.collapseSpeed = collapseSpeed;
	}

	public boolean isControls() {
		if(controls != null )
			return controls.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(controls, "controls");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setControls(boolean controls) {
		this.controls = new Boolean(controls);
	}

	public String getWidgetClass() {
		if(widgetClass != null )
			return widgetClass;

		String oValue = (String) getLocalOrValueBindingValue(widgetClass, "widgetClass");
		return oValue != null ? oValue : null;
	}
	public void setWidgetClass(String widgetClass) {
		this.widgetClass = widgetClass;
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

	public String getRightboxClass() {
		if(rightboxClass != null )
			return rightboxClass;

		String oValue = (String) getLocalOrValueBindingValue(rightboxClass, "rightboxClass");
		return oValue != null ? oValue : null;
	}
	public void setRightboxClass(String rightboxClass) {
		this.rightboxClass = rightboxClass;
	}

	public String getControlsClass() {
		if(controlsClass != null )
			return controlsClass;

		String oValue = (String) getLocalOrValueBindingValue(controlsClass, "controlsClass");
		return oValue != null ? oValue : null;
	}
	public void setControlsClass(String controlsClass) {
		this.controlsClass = controlsClass;
	}

	public String getTitleClass() {
		if(titleClass != null )
			return titleClass;

		String oValue = (String) getLocalOrValueBindingValue(titleClass, "titleClass");
		return oValue != null ? oValue : null;
	}
	public void setTitleClass(String titleClass) {
		this.titleClass = titleClass;
	}

	public String getTitleTextClass() {
		if(titleTextClass != null )
			return titleTextClass;

		String oValue = (String) getLocalOrValueBindingValue(titleTextClass, "titleTextClass");
		return oValue != null ? oValue : null;
	}
	public void setTitleTextClass(String titleTextClass) {
		this.titleTextClass = titleTextClass;
	}

	public String getIconClass() {
		if(iconClass != null )
			return iconClass;

		String oValue = (String) getLocalOrValueBindingValue(iconClass, "iconClass");
		return oValue != null ? oValue : null;
	}
	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}

	public String getHoverClass() {
		if(hoverClass != null )
			return hoverClass;

		String oValue = (String) getLocalOrValueBindingValue(hoverClass, "hoverClass");
		return oValue != null ? oValue : null;
	}
	public void setHoverClass(String hoverClass) {
		this.hoverClass = hoverClass;
	}

	public String getCollapsePnlClass() {
		if(collapsePnlClass != null )
			return collapsePnlClass;

		String oValue = (String) getLocalOrValueBindingValue(collapsePnlClass, "collapsePnlClass");
		return oValue != null ? oValue : null;
	}
	public void setCollapsePnlClass(String collapsePnlClass) {
		this.collapsePnlClass = collapsePnlClass;
	}

	public String getHeaderIconClpsd() {
		if(headerIconClpsd != null )
			return headerIconClpsd;

		String oValue = (String) getLocalOrValueBindingValue(headerIconClpsd, "headerIconClpsd");
		return oValue != null ? oValue : null;
	}
	public void setHeaderIconClpsd(String headerIconClpsd) {
		this.headerIconClpsd = headerIconClpsd;
	}

	public String getHeaderIcon() {
		if(headerIcon != null )
			return headerIcon;

		String oValue = (String) getLocalOrValueBindingValue(headerIcon, "headerIcon");
		return oValue != null ? oValue : null;
	}
	public void setHeaderIcon(String headerIcon) {
		this.headerIcon = headerIcon;
	}

	public String getSlideRIconClpsd() {
		if(slideRIconClpsd != null )
			return slideRIconClpsd;

		String oValue = (String) getLocalOrValueBindingValue(slideRIconClpsd, "slideRIconClpsd");
		return oValue != null ? oValue : null;
	}
	public void setSlideRIconClpsd(String slideRIconClpsd) {
		this.slideRIconClpsd = slideRIconClpsd;
	}

	public String getSlideRIcon() {
		if(slideRIcon != null )
			return slideRIcon;

		String oValue = (String) getLocalOrValueBindingValue(slideRIcon, "slideRIcon");
		return oValue != null ? oValue : null;
	}
	public void setSlideRIcon(String slideRIcon) {
		this.slideRIcon = slideRIcon;
	}

	public String getSlideLIconClpsd() {
		if(slideLIconClpsd != null )
			return slideLIconClpsd;

		String oValue = (String) getLocalOrValueBindingValue(slideLIconClpsd, "slideLIconClpsd");
		return oValue != null ? oValue : null;
	}
	public void setSlideLIconClpsd(String slideLIconClpsd) {
		this.slideLIconClpsd = slideLIconClpsd;
	}

	public String getSlideLIcon() {
		if(slideLIcon != null )
			return slideLIcon;

		String oValue = (String) getLocalOrValueBindingValue(slideLIcon, "slideLIcon");
		return oValue != null ? oValue : null;
	}
	public void setSlideLIcon(String slideLIcon) {
		this.slideLIcon = slideLIcon;
	}

	public String getOnunfold() {
		if(onunfold != null )
			return onunfold;

		String oValue = (String) getLocalOrValueBindingValue(onunfold, "onunfold");
		return oValue != null ? oValue : null;
	}
	public void setOnunfold(String onunfold) {
		this.onunfold = onunfold;
	}

	public String getOnfold() {
		if(onfold != null )
			return onfold;

		String oValue = (String) getLocalOrValueBindingValue(onfold, "onfold");
		return oValue != null ? oValue : null;
	}
	public void setOnfold(String onfold) {
		this.onfold = onfold;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[26];
		values[0] = super.saveState(context);
		values[1] = header;
		values[2] = event;
		values[3] = collapsible;
		values[4] = collapseType;
		values[5] = collapsed;
		values[6] = collapseSpeed;
		values[7] = controls;
		values[8] = widgetClass;
		values[9] = headerClass;
		values[10] = contentClass;
		values[11] = rightboxClass;
		values[12] = controlsClass;
		values[13] = titleClass;
		values[14] = titleTextClass;
		values[15] = iconClass;
		values[16] = hoverClass;
		values[17] = collapsePnlClass;
		values[18] = headerIconClpsd;
		values[19] = headerIcon;
		values[20] = slideRIconClpsd;
		values[21] = slideRIcon;
		values[22] = slideLIconClpsd;
		values[23] = slideLIcon;
		values[24] = onunfold;
		values[25] = onfold;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.header = (String) values[1];
		this.event = (String) values[2];
		this.collapsible = (Boolean) values[3];
		this.collapseType = (String) values[4];
		this.collapsed = (Boolean) values[5];
		this.collapseSpeed = (String) values[6];
		this.controls = (Boolean) values[7];
		this.widgetClass = (String) values[8];
		this.headerClass = (String) values[9];
		this.contentClass = (String) values[10];
		this.rightboxClass = (String) values[11];
		this.controlsClass = (String) values[12];
		this.titleClass = (String) values[13];
		this.titleTextClass = (String) values[14];
		this.iconClass = (String) values[15];
		this.hoverClass = (String) values[16];
		this.collapsePnlClass = (String) values[17];
		this.headerIconClpsd = (String) values[18];
		this.headerIcon = (String) values[19];
		this.slideRIconClpsd = (String) values[20];
		this.slideRIcon = (String) values[21];
		this.slideLIconClpsd = (String) values[22];
		this.slideLIcon = (String) values[23];
		this.onunfold = (String) values[24];
		this.onfold = (String) values[25];
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

	public void encodePartially(FacesContext facesContext) throws IOException {
		Renderer renderer = getRenderer(facesContext);

		if(renderer instanceof AjaxBaseRenderer) {
			((AjaxBaseRenderer)renderer).encodePartially(facesContext, this);
		}
	}
}