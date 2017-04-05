/**
 * 
 */
package com.infotel.gg.unittest.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ BookingServiceImplTest.class, CatalogServiceImplTest.class, UserServiceImplTest.class })
public class AllTests {

}
