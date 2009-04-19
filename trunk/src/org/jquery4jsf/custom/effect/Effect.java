/*
 *
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
package org.jquery4jsf.custom.effect;

import org.jquery4jsf.component.ext.HtmlBaseComponent;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.custom.JQueryHtmlObject;
import javax.faces.render.Renderer;
import java.io.IOException;
import java.lang.String;

public class Effect extends HtmlBaseComponent implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlEffect";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Effect";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.EffectRenderer";

	private String[] resources;
	private String _for;
	private String effect;
	private String options;
	private String speed;
	private String callback;

	public Effect() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"ui/ui.core.js",
			"ui/effects.core.js",
			"ui/effects.blind.js",
			"ui/effects.bounce.js",
			"ui/effects.clip.js",
			"ui/effects.drop.js",
			"ui/effects.explode.js",
			"ui/effects.fold.js",
			"ui/effects.highlight.js",
			"ui/effects.pulsate.js",
			"ui/effects.scale.js",
			"ui/effects.shake.js",
			"ui/effects.slide.js",
			"ui/effects.transfer.js",
			"themes/base/ui.all.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getFor() {
		if( _for != null )
			return _for;

		String oValue = (String) getLocalOrValueBindingValue( _for, "for");
		return oValue != null ? oValue : null;
	}
	public void setFor(String _for) {
		this._for = _for;
	}

	public String getEffect() {
		if(effect != null )
			return effect;

		String oValue = (String) getLocalOrValueBindingValue(effect, "effect");
		return oValue != null ? oValue : null;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getOptions() {
		if(options != null )
			return options;

		String oValue = (String) getLocalOrValueBindingValue(options, "options");
		return oValue != null ? oValue : null;
	}
	public void setOptions(String options) {
		this.options = options;
	}

	public String getSpeed() {
		if(speed != null )
			return speed;

		String oValue = (String) getLocalOrValueBindingValue(speed, "speed");
		return oValue != null ? oValue : null;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getCallback() {
		if(callback != null )
			return callback;

		String oValue = (String) getLocalOrValueBindingValue(callback, "callback");
		return oValue != null ? oValue : null;
	}
	public void setCallback(String callback) {
		this.callback = callback;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[6];
		values[0] = super.saveState(context);
		values[1] = _for;
		values[2] = effect;
		values[3] = options;
		values[4] = speed;
		values[5] = callback;
		return (values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this._for = (String) values[1];
		this.effect = (String) values[2];
		this.options = (String) values[3];
		this.speed = (String) values[4];
		this.callback = (String) values[5];
	}

	public String[] getResources() {
		return resources;
	}

	public void encodePartially(FacesContext facesContext) throws IOException {
		Renderer renderer = getRenderer(facesContext);

		if(renderer instanceof AjaxBaseRenderer) {
			((AjaxBaseRenderer)renderer).encodePartially(facesContext, this);
		}
	}
}