package org.jquery4jsf.renderkit.html;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.ResponseWriter;

public class HtmlRendererUtilities {

	public static boolean writeHtmlAttributes(ResponseWriter writer, UIComponent component, String[] attributes) throws IOException {
		boolean isWriteAttribute = false;
		for (int i = 0, len = attributes.length; i < len; i++) {
			String attrName = attributes[i];
			if (writeHtmlAttribute(writer, component, attrName, attrName)) {
				isWriteAttribute = true;
			}
		}
		return isWriteAttribute;
	}
	
	public static boolean writeHtmlAttribute(ResponseWriter writer, UIComponent component, String propertyComponent, String attributeName) throws IOException {
		Object value = component.getAttributes().get(propertyComponent);
	    return writeHtmlAttribute(writer, propertyComponent, attributeName, value);
	}
	
	public static boolean writeHtmlAttribute(ResponseWriter writer, String propertyComponent, String attributeName, Object value) throws IOException {
        if (!isDefaultAttributeValue(value)) {
            String htmlAttrName = attributeName.equals(JSFConstants.STYLE_CLASS) ? HTML.STYLE_CLASS : attributeName;
            writer.writeAttribute(htmlAttrName, value, propertyComponent);
            return true;
        }
        return false;
	}
	
	/*
	 * Metodo per il valore di default delle specifiche jsf 
	 */
	public static boolean isDefaultAttributeValue(Object value) {
        if (value == null) {
            return true;
        }
        else if (value instanceof Boolean) {
            return !((Boolean) value).booleanValue();
        }
        else if (value instanceof Number) {
            if (value instanceof Integer) {
                return ((Number) value).intValue() == Integer.MIN_VALUE;
            }
            else if (value instanceof Double) {
                return ((Number) value).doubleValue() == Double.MIN_VALUE;
            }
            else if (value instanceof Long) {
                return ((Number) value).longValue() == Long.MIN_VALUE;
            }
            else if (value instanceof Byte) {
                return ((Number) value).byteValue() == Byte.MIN_VALUE;
            }
            else if (value instanceof Float) {
                return ((Number) value).floatValue() == Float.MIN_VALUE;
            }
            else if (value instanceof Short) {
                return ((Number) value).shortValue() == Short.MIN_VALUE;
            }
        }
        return false;
    }
	
}