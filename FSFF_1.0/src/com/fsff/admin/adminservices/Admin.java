package com.fsff.admin.adminservices;

import java.util.Date;

public interface Admin {

	public String createFilmFestival(String festivalName, String year,
			String quarter, Date submissionStartDate, Date submissionEndDate,
			Date roundOneStartDate, Date roundOneEndDate,
			Date roundTwoStartDate, Date roundTwoEndDate,
			Date roundThreeStartDate, Date roundThreeEndDate);



}
