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
package org.jquery4jsf.custom.accordion;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import javax.faces.context.FacesContext;

public class AccordionPanelBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, AccordionPanel accordionPanel , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, accordionPanel.getActive(), "active", null);
		encodeOptionComponentByType(options, accordionPanel.getAnimated(), "animated", null);
		encodeOptionComponentByType(options, accordionPanel.isAutoHeight(), "autoHeight", "true");
		encodeOptionComponentByType(options, accordionPanel.isClearStyle(), "clearStyle", null);
		encodeOptionComponentByType(options, accordionPanel.isCollapsible(), "collapsible", null);
		encodeOptionComponentByType(options, accordionPanel.getEvent(), "event", null);
		encodeOptionComponentByType(options, accordionPanel.isFillSpace(), "fillSpace", null);
		encodeOptionComponentByType(options, accordionPanel.getIcons(), "icons", null);
		encodeOptionComponentByType(options, accordionPanel.isNavigation(), "navigation", null);
		encodeOptionComponentByType(options, accordionPanel.getHeader(), "header", null);
		encodeOptionComponentByType(options, accordionPanel.getNavigationFilter(), "navigationFilter", null);
		encodeOptionComponentByType(options, accordionPanel.getOnaccordionchange(), "onaccordionchange", null);
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