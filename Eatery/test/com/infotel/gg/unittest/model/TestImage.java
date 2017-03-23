/**
 * 
 */
package com.infotel.gg.unittest.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infotel.gg.model.ImageData;
import com.infotel.gg.model.Region;

/**
 * @author formation
 *
 */
public class TestImage {
	
	ImageData img;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		img=null;
	}
	
	//Test Image
		@Test
	public void TestImage() {
			byte[] test = new byte[2];
			for(int i = 0; i < 2; i++)
			{
				test[i] = 12;
			}
	img = new ImageData(1, test, "target", 1, "size");
		assertNotNull(img);
		assertEquals(img.getId(), 1);
		assertEquals(img.getContent(), test);
		assertEquals(img.getTarget(), "target");
		assertEquals(img.getTargetId(), 1);
		assertEquals(img.getSize(), "size");
	
	}
	
}
