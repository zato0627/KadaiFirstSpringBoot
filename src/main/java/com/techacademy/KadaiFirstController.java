package com.techacademy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

	@GetMapping("dayofweek/{date}")
	public String dispDayOfWeek(@PathVariable String date) {

		String[] week_name = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Satueday"};
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		Date inputDate;
		try {
			inputDate = sdf.parse(date);
		}catch(ParseException e) {
			return "ng";
		}

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(inputDate);

		int week = calendar.get(Calendar.DAY_OF_WEEK);
		return week_name[week -1];
	}




	/*四則演算*/
	@GetMapping("/plus/{val1}/{val2}")
	public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
		int res = 0;
		res = val1 + val2;
		return "実行結果 : " + res;
	}

	@GetMapping("/minus/{val1}/{val2}")
	public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
		int res = 0;
		res = val1 - val2;
		return "実行結果 : " + res;
	}

	@GetMapping("/times/{val1}/{val2}")
	public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
		int res = 0;
		res = val1 * val2;
		return "実行結果 : " + res;
	}

	@GetMapping("/divide/{val1}/{val2}")
	public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
		if(val2 == 0) {
			System.err.println("0では割れない");
		}
		int res = 0;
		res = val1 / val2;
		return "実行結果 : " + res;
	}

}
