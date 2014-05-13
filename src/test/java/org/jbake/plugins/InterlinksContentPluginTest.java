package org.jbake.plugins;

import static org.junit.Assert.*;

import org.apache.commons.configuration.CompositeConfiguration;
import org.junit.Test;

public class InterlinksContentPluginTest {

	@Test
	public void test() throws ContentPluginException {

		CompositeConfiguration config = new CompositeConfiguration();
		config.addProperty("interlinks.coollink", "http://www.cool-link.org");

		String mdContent = "This is a [cool link](coollink>) that links to this site.";
		
		String expected = "This is a [cool link](http://www.cool-link.org) that links to this site.";

		InterlinksContentPlugin plugin = new InterlinksContentPlugin();

		String parsedContent = plugin.parse(mdContent, config);

		assertEquals(expected, parsedContent);
	}

}
