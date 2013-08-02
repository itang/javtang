package javtang;

import org.junit.Test;
import org.junit.Assert;

public class StringsTest extends Assert {

		@Test
		public void testRepeat() {
				assertEquals("", Strings.repeat("*", -1));
				assertEquals("", Strings.repeat("*", 0));
				assertEquals("*", Strings.repeat("*", 1));
				assertEquals("**", Strings.repeat("*", 2));
				assertEquals("***", Strings.repeat("*", 3));
				assertEquals("=|=|=|", Strings.repeat("=|", 3));
		}
}
