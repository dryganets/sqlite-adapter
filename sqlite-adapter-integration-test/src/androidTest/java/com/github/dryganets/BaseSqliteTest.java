package com.github.dryganets;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import android.support.test.runner.AndroidJUnit4;

import com.github.dryganets.sqlite.adapter.DefaultConnectionProvider;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class BaseSqliteTest {

	private static List<ProviderTestWrapper> providers = new ArrayList<>();
	static {
		providers.add(new ProviderTestWrapper(new DefaultConnectionProvider(), "default"));
	}

	public BaseSqliteTest() {

	}

	@BeforeClass
	public static void setup() {
		for (ProviderTestWrapper provider : providers) {
			provider.get();
		}
	}

	@AfterClass
	public static void teardown() throws IOException {
		for (ProviderTestWrapper provider : providers) {
			provider.close();
		}
	}

	@Test
	public void testInsert() throws Exception {
		// Context of the app under test.
		Context appContext = InstrumentationRegistry.getTargetContext();

		assertEquals("com.github.dryganets.test", appContext.getPackageName());
	}
}
