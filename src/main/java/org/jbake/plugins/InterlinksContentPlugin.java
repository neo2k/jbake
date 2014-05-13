package org.jbake.plugins;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.configuration.CompositeConfiguration;

public class InterlinksContentPlugin implements ContentPlugin {

	private Pattern				pattern;

	public static final String	PLUGIN_INTERLINKS_PREFIX	= "interlinks.";

	public InterlinksContentPlugin() {
		
		pattern = Pattern.compile("\\((.+?)>\\)");
	}

	@Override
	public String parse(String content, CompositeConfiguration config)
			throws ContentPluginException {


		Matcher matcher = pattern.matcher(content);

		StringBuffer sb = new StringBuffer();

		while (matcher.find()) {

			String interlinkName = matcher.group(1);

			String link = config.getString(PLUGIN_INTERLINKS_PREFIX
					+ interlinkName);

			if (link == null) {
				throw new ContentPluginException(
						"Could not find interlinks link '" + interlinkName
								+ "' in config file ");
			}
			matcher.appendReplacement(sb, "(" + link + ")");
		}

		matcher.appendTail(sb);

		return sb.toString();
	}
}
