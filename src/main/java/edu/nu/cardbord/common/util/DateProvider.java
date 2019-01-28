package edu.nu.cardbord.common.util;

import java.util.Date;

public interface DateProvider {

	/**
	 * 获取当前时间
	 * @return 当前时间
	 * @throws Exception
	 */
	Date getCurrentTime() throws Exception;
}
