package edu.nu.cardbord.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateProviderImpl implements DateProvider {

	@Override
	public Date getCurrentTime() throws Exception {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormatter.parse(dateFormatter.format(new Date()));
	}

}
