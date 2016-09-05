package util;

import org.testng.annotations.Test;

import com.xzeng.logging.enums.TestEvent;
import com.xzeng.logging.util.AppEventUtils;

public class AppEeventUtilsTest {
	@Test
	public void testLogInfo(){
		AppEventUtils.logInfo(TestEvent.UNKNOW_EXCEPTION, new Object[]{"hello", "I'm data"});
	}
	
	@Test
	public void testLogError(){
		AppEventUtils.logError(new NullPointerException(), TestEvent.UNKNOW_EXCEPTION, new Object[]{"hello", "I'm data"});
	}
}
