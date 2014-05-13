package org.jbake.plugins;

import org.apache.commons.configuration.CompositeConfiguration;

public interface ContentPlugin {
	
	public String parse(String content, CompositeConfiguration config) throws ContentPluginException;

}
