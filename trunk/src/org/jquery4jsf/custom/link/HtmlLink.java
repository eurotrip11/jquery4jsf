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
package org.jquery4jsf.custom.link;

import javax.faces.context.FacesContext;

import org.jquery4jsf.component.ext.HtmlBaseOutputComponent;
import org.jquery4jsf.component.ext.HtmlElementEvent;
import org.jquery4jsf.component.ext.HtmlKeyEvent;
import org.jquery4jsf.component.ext.HtmlMouseEvent;
import org.jquery4jsf.renderkit.html.ext.HtmlLinkRenderer;

public class HtmlLink extends HtmlBaseOutputComponent implements HtmlKeyEvent, HtmlMouseEvent, HtmlElementEvent {

	//Standard javascript event for tag <a>
	private String onclick;
	private String ondblclick;
	private String onkeydown;
	private String onkeypress;
	private String onkeyup;
	private String onmousedown;
	private String onmousemove;
	private String onmouseout;
	private String onmouseover;
	private String onmouseup;
	private String onchange;
	private String onblur;
	private String onfocus;

	//Attribute for tag <a>;
	private String charset;
	private String coords;
	private String href;
	private String hreflang;
	private String name;
	private String rel;
	private String rev;
	private String shape;
	private String target;

	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Link";
	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlLink";
	public static final String DEFAULT_RENDERER_TYPE = HtmlLinkRenderer.RENDERER_TYPE;

	public String getFamily() {
		return COMPONENT_FAMILY;
	}
	
    public void restoreState(FacesContext context, Object state)
    {
        Object[] values = (Object[]) state;
        super.restoreState(context, values[0]);
        onclick		= (String)values[1];
        ondblclick	= (String)values[2];
        onkeydown	= (String)values[3];
        onkeypress	= (String)values[4];
        onkeyup		= (String)values[5];
        onmousedown	= (String)values[6];
        onmousemove	= (String)values[7];
        onmouseout	= (String)values[8];
        onmouseover	= (String)values[9];
        onmouseup	= (String)values[10];
        onchange	= (String)values[11];
        onblur		= (String)values[12];
        onfocus		= (String)values[13];
        charset		= (String)values[14];
        coords		= (String)values[15];
        href		= (String)values[16];
        hreflang	= (String)values[17];
        name		= (String)values[18];
        rel			= (String)values[19];
        rev			= (String)values[20];
        shape		= (String)values[21];
        target		= (String)values[22];
    }
    
    public Object saveState(FacesContext context)
    {
        Object[] values = new Object[23];
        values[0] = super.saveState(context);
        values[1]=onclick;
        values[2]=ondblclick;
        values[3]=onkeydown;
        values[4]=onkeypress;
        values[5]=onkeyup;
        values[6]=onmousedown;
        values[7]=onmousemove;
        values[8]=onmouseout;
        values[9]=onmouseover;
        values[10]=onmouseup;
        values[11]=onchange;
        values[12]=onblur;
        values[13]=onfocus;
        values[14]=charset;
        values[15]=coords;
        values[16]=href;
        values[17]=hreflang;
        values[18]=name;
        values[19]=rel;
        values[20]=rev;
        values[21]=shape;
        values[22]=target;
        return values;
    }

	public String getOnclick() {
		return (String) getLocalOrValueBindingValue(onclick, "onclick");
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public String getOndblclick() {
		return (String) getLocalOrValueBindingValue(ondblclick, "ondblclick");
	}

	public void setOndblclick(String ondblclick) {
		this.ondblclick = ondblclick;
	}

	public String getOnkeydown() {
		return (String) getLocalOrValueBindingValue(onkeydown, "onkeydown");
	}

	public void setOnkeydown(String onkeydown) {
		this.onkeydown = onkeydown;
	}

	public String getOnkeypress() {
		return (String) getLocalOrValueBindingValue(onkeypress,"onkeypress");
	}

	public void setOnkeypress(String onkeypress) {
		this.onkeypress = onkeypress;
	}

	public String getOnkeyup() {
		return (String) getLocalOrValueBindingValue(onkeyup,"onkeyup");
	}

	public void setOnkeyup(String onkeyup) {
		this.onkeyup = onkeyup;
	}

	public String getOnmousedown() {
		return (String) getLocalOrValueBindingValue(onmousedown, "onmousedown");
	}

	public void setOnmousedown(String onmousedown) {
		this.onmousedown = onmousedown;
	}

	public String getOnmousemove() {
		return (String) getLocalOrValueBindingValue(onmousemove, "onmousemove");
	}

	public void setOnmousemove(String onmousemove) {
		this.onmousemove = onmousemove;
	}

	public String getOnmouseout() {
		return (String) getLocalOrValueBindingValue(onmouseout, "onmouseout");
	}

	public void setOnmouseout(String onmouseout) {
		this.onmouseout = onmouseout;
	}

	public String getOnmouseover() {
		return (String) getLocalOrValueBindingValue(onmouseover, "onmouseover");
	}

	public void setOnmouseover(String onmouseover) {
		this.onmouseover = onmouseover;
	}

	public String getOnmouseup() {
		return (String) getLocalOrValueBindingValue(onmouseup, "onmouseup");
	}

	public void setOnmouseup(String onmouseup) {
		this.onmouseup = onmouseup;
	}
	public String getOnchange() {
		return (String) getLocalOrValueBindingValue(onchange,"onchange");
	}

	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	public String getOnblur() {
		return (String) getLocalOrValueBindingValue(onblur, "onblur");
	}

	public void setOnblur(String onblur) {
		this.onblur = onblur;
	}

	public String getOnfocus() {
		return (String) getLocalOrValueBindingValue(onfocus, "onfocus");
	}

	public void setOnfocus(String onfocus) {
		this.onfocus = onfocus;
	}
	
	public String getCharset() {
		return (String) getLocalOrValueBindingValue(charset, "charset");
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getCoords() {
		return (String) getLocalOrValueBindingValue(coords, "coords");
	}

	public void setCoords(String coords) {
		this.coords = coords;
	}

	public String getHref() {
		return (String) getLocalOrValueBindingValue(href, "href");
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getHreflang() {
		return (String) getLocalOrValueBindingValue(hreflang, "hreflang");
	}

	public void setHreflang(String hreflang) {
		this.hreflang = hreflang;
	}

	public String getName() {
		return (String) getLocalOrValueBindingValue(name, "name");
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRel() {
		return (String) getLocalOrValueBindingValue(rel, "rel");
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getRev() {
		return (String) getLocalOrValueBindingValue(rev, "rev");
	}

	public void setRev(String rev) {
		this.rev = rev;
	}

	public String getShape() {
		return (String) getLocalOrValueBindingValue(shape,"shape");
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getTarget() {
		return (String) getLocalOrValueBindingValue(target, "target");
	}

	public void setTarget(String target) {
		this.target = target;
	}
}
