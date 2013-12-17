package com.fsff.admin.adminservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fsff.entity.Festival;
import com.fsff.entity.Film;
import com.fsff.sessionmanager.SessionManager;
import com.fsff.ui.entity.AdminFilmData;
import com.fsff.ui.entity.AdminFilmDataMsg;
import com.fsff.ui.entity.AdminIndexData;
import com.fsff.ui.entity.FestivalPeriod;
import com.fsff.util.FilmComparatorByVotes;
import com.fsff.util.FilmDataManipulation;
import com.fsff.util.SubmittedFilmComparator;

public class AdminService implements Admin {

	private static final String SUBMISSION = "Films Submission";
	private static final String ROUND_ONE = "Round One";
	private static final String ROUND_TWO = "Round Two";
	private static final String ROUND_THREE = "Round Three";
	private static final String WINNER = "winner";
	private static final String NO_FESTIVAL = "noFestival";
	private static final String REJECTED = "Rejected";
	private static final String APPROVED = "Approved";
	private static final String RECEIVED = "Received";
	private static final String PENDING = "Pending";
	private static final String EDITOR_SELECTED = "selected";
	private static final String EDITOR_REMOVED = "removed";

	public AdminIndexData getAdminIndex() {
		AdminIndexData data = new AdminIndexData();
		SessionManager.createSession();
		SessionManager.createEntityManager();
		EntityManager entityManager = SessionManager.getEntityManager();
		Query festivalQuery = entityManager
				.createQuery("from Festival where active = 1");
		List festivalList = festivalQuery.getResultList();
		if (festivalList == null || (festivalList.isEmpty())) {
			data.setFestivalName("No");
		} else {
			Festival festival = (Festival) festivalList.get(0);
			String round = checkDateRangeApproveFilms(festival);
			if (!round.equals(NO_FESTIVAL)) {
				data.setFestivalName("Yes");
				data.setFestivalStartDate(""
						+ festival.getSubmissionStartDate());
				data.setRoundOneStartDate("" + festival.getRoundOneStartDate());
				data.setRoundTwoStartDate("" + festival.getRoundTwoStartDate());
				data.setRoundThreeStartDate(""
						+ festival.getRoundThreeStartDate());
				data.setFestivalEndDate("" + festival.getRoundThreeEndDate());
				Set<Film> films = festival.getFilms();

				data.setFestivalRound(round);
				List<String> stats = null;
				if (round.equals(SUBMISSION)) {
					stats = getSubmissionStats(films);
					data.setApproveURL("/filmapproval.jsp");
					data.setNoOfFilmsPendingApproval(stats.get(0));
					data.setNoOfFilmsApproved(stats.get(1));
					data.setNoOfFilmsRejected(stats.get(2));
				} else if (round.equals(ROUND_ONE)) {
					stats = getRoundOneStats(films);
					data.setApproveURL("/filmapprovalround1.jsp");
					data.setNoOfFilmsPendingApproval(stats.get(0));
					data.setNoOfFilmsApproved(stats.get(1));
					data.setNoOfFilmsRejected(stats.get(2));
				} else if (round.equals(ROUND_TWO)) {
					stats = getRoundTwoStats(films);
					data.setApproveURL("/filmapprovalround2.jsp");
					data.setNoOfFilmsPendingApproval(stats.get(0));
					data.setNoOfFilmsApproved(stats.get(1));
					data.setNoOfFilmsRejected(stats.get(2));
				} else if (round.equals(ROUND_THREE)) {
					stats = getRoundThreeStats(films);
					data.setApproveURL("/filmapprovalround3.jsp");
					data.setNoOfFilmsPendingApproval(stats.get(0));
					data.setNoOfFilmsApproved(stats.get(1));
					data.setNoOfFilmsRejected(stats.get(2));
				}
			}
			// TODO: Implement else

		}
		return data;
	}

	public List<String> getSubmissionStats(Set<Film> films) {
		List<String> stats = new ArrayList<String>();
		int pending = 0, approved = 0, rejected = 0;
		for (Film film : films) {
			String status = film.getStatus();
			if (status.equals(APPROVED)) {
				approved++;
			} else if (status.equals(REJECTED)) {
				rejected++;
			} else {
				pending++;
			}
		}
		stats.add("" + pending);
		stats.add("" + approved);
		stats.add("" + rejected);
		return stats;
	}

	public List<String> getRoundOneStats(Set<Film> films) {
		List<String> stats = new ArrayList<String>();
		int pending = 0, approved = 0, rejected = 0;
		for (Film film : films) {
			String status = film.getRoundOneStatus();
			if (status.equals(APPROVED)) {
				approved++;
			} else if (status.equals(REJECTED)) {
				rejected++;
			} else {
				pending++;
			}
		}
		stats.add("" + pending);
		stats.add("" + approved);
		stats.add("" + rejected);
		return stats;
	}

	public List<String> getRoundTwoStats(Set<Film> films) {
		List<String> stats = new ArrayList<String>();
		int pending = 0, approved = 0, rejected = 0;
		for (Film film : films) {
			String status = film.getRoundTwoStatus();
			if (status.equals(APPROVED)) {
				approved++;
			} else if (status.equals(REJECTED)) {
				rejected++;
			} else {
				pending++;
			}
		}
		stats.add("" + pending);
		stats.add("" + approved);
		stats.add("" + rejected);
		return stats;
	}

	public List<String> getRoundThreeStats(Set<Film> films) {
		List<String> stats = new ArrayList<String>();
		int pending = 0, approved = 0, rejected = 0;
		for (Film film : films) {
			String status = film.getRoundThreeStatus();
			if (status.equals(APPROVED)) {
				approved++;
			} else if (status.equals(REJECTED)) {
				rejected++;
			} else {
				pending++;
			}
		}
		stats.add("" + pending);
		stats.add("" + approved);
		stats.add("" + rejected);
		return stats;
	}

	@Override
	public String createFilmFestival(String festivalName, String year,
			String quarter, Date submissionStartDate, Date submissionEndDate,
			Date roundOneStartDate, Date roundOneEndDate,
			Date roundTwoStartDate, Date roundTwoEndDate,
			Date roundThreeStartDate, Date roundThreeEndDate) {
		if (submissionStartDate.before(submissionEndDate)
				&& submissionEndDate.before(roundOneStartDate)
				&& roundOneStartDate.before(roundOneEndDate)
				&& roundOneEndDate.before(roundTwoStartDate)
				&& roundTwoStartDate.before(roundTwoEndDate)
				&& roundTwoEndDate.before(roundThreeStartDate)
				&& roundThreeStartDate.before(roundThreeEndDate)) {
			SessionManager.createSession();
			SessionManager.createEntityManager();
			EntityManager entityManager = SessionManager.getEntityManager();
			Query festivalQuery = entityManager
					.createQuery("from Festival where active = 1");
			List festivalList = festivalQuery.getResultList();
			if ((!festivalList.isEmpty())) {
				return "A festival is in progress. Cannot create new festival !!!";
			}
			Festival festival = new Festival();
			festival.setYear(year);
			festival.setQuarter(quarter);
			festival.setSubmissionStartDate(submissionStartDate);
			festival.setSubmissionEndDate(submissionEndDate);
			festival.setRoundOneStartDate(roundOneStartDate);
			festival.setRoundOneEndDate(roundOneEndDate);
			festival.setRoundTwoStartDate(roundTwoStartDate);
			festival.setRoundTwoEndDate(roundTwoEndDate);
			festival.setRoundThreeStartDate(roundThreeStartDate);
			festival.setRoundThreeEndDate(roundThreeEndDate);
			festival.setActive(true);
			entityManager.getTransaction().begin();
			entityManager.persist(festival);
			entityManager.getTransaction().commit();
			SessionManager.closeEntityManager();
			return "Festival created successfully";
		}
		return "Please check the dates for the festival !!";
	}

	public List<FestivalPeriod> fetchFestivals() {
		List<FestivalPeriod> festivals = null;
		SessionManager.createSession();
		SessionManager.createEntityManager();
		EntityManager entityManager = SessionManager.getEntityManager();
		Query genreQuery = entityManager.createQuery(" from Festival");
		List<Festival> festivalList = genreQuery.getResultList();
		if (festivalList == null || festivalList.isEmpty()) {
			return null;
		}
		festivals = new ArrayList<FestivalPeriod>();
		for (Festival festival : festivalList) {
			FestivalPeriod festivalPeriod = new FestivalPeriod();
			festivalPeriod.setYear(festival.getYear());
			festivalPeriod.setQuarter(festival.getQuarter());
			festivals.add(festivalPeriod);
		}
		return festivals;
	}

	public AdminFilmDataMsg fetchAllFilms() {
		AdminFilmDataMsg adminFilmDataMsg = null;
		SessionManager.createSession();
		SessionManager.createEntityManager();
		EntityManager entityManager = SessionManager.getEntityManager();
		Query festivalQuery = entityManager
				.createQuery("from Festival where active = 1");
		List festivalList = festivalQuery.getResultList();
		if (festivalList == null || festivalList.isEmpty()) {
			adminFilmDataMsg = new AdminFilmDataMsg();
			adminFilmDataMsg.setAdminFilmData(null);
			adminFilmDataMsg.setMessage("No Festival in progress !!");
		} else {
			String message = "";
			Festival festival = (Festival) festivalList.get(0);
			message = checkDateRangeAllFilms(festival);
			Set<Film> films = festival.getFilms();
			SubmittedFilmComparator filmComparator = new SubmittedFilmComparator();
			Set<Film> sortedFilms = new TreeSet<Film>(filmComparator);
			sortedFilms.addAll(films);
			FilmComparatorByVotes filmComparatorByVotes = new FilmComparatorByVotes();
			Set<Film> sortedFilmsByVote = new TreeSet<Film>(
					filmComparatorByVotes);
			sortedFilmsByVote.addAll(sortedFilms);
			AdminFilmData[] adminFilms = FilmDataManipulation
					.convertFilmToAdminData(sortedFilmsByVote, SUBMISSION);
			adminFilmDataMsg = new AdminFilmDataMsg();
			adminFilmDataMsg.setAdminFilmData(adminFilms);
			adminFilmDataMsg.setMessage(message);
		}
		return adminFilmDataMsg;
	}

	public String checkDateRangeAllFilms(Festival festival) {
		String msg = "";
		Date now = new Date();
		if (now.before(festival.getSubmissionStartDate())) {
			msg = "Film festival submission starts only on "
					+ festival.getSubmissionStartDate();
		} else if (now.after(festival.getSubmissionStartDate())
				&& now.before(festival.getRoundOneStartDate())) {
			msg = "";
		} else if (now.after(festival.getRoundOneStartDate())
				&& now.before(festival.getRoundTwoStartDate())) {
			msg = "Festival is in round One now. You will be redirected to Round One Page in 10 secs. "
					+ "##<meta http-equiv='refresh' content='10; url=/filmapprovalround1.jsp'>";
		} else if (now.after(festival.getRoundTwoStartDate())
				&& now.before(festival.getRoundThreeStartDate())) {
			msg = "Festival is in round Two now. You will be redirected to Round Two Page in 10 secs. "
					+ "##<meta http-equiv='refresh' content='10; url=/filmapprovalround2.jsp'>";
		} else if (now.after(festival.getRoundThreeStartDate())
				&& now.before(festival.getRoundThreeEndDate())) {
			msg = "Festival is in round Three now. You will be redirected to Round Three Page in 10 secs. "
					+ "##<meta http-equiv='refresh' content='10; url=/filmapprovalround3.jsp'>";
		} else {
			msg = "No festival active now !!!";
		}
		return msg;
	}

	public AdminFilmDataMsg fetchRoundOneFilms() {
		AdminFilmDataMsg adminFilmDataMsg = null;
		SessionManager.createSession();
		SessionManager.createEntityManager();
		EntityManager entityManager = SessionManager.getEntityManager();
		Query festivalQuery = entityManager
				.createQuery("from Festival where active = 1");
		List festivalList = festivalQuery.getResultList();
		if (festivalList == null || festivalList.isEmpty()) {
			adminFilmDataMsg = new AdminFilmDataMsg();
			adminFilmDataMsg.setAdminFilmData(null);
			adminFilmDataMsg.setMessage("No Festival in progress !!");
		} else {
			String message = "";
			Festival festival = (Festival) festivalList.get(0);
			message = checkDateRangeRoundOneFilms(festival);
			Set<Film> films = festival.getFilms();
			Set<Film> approvedFilms = getSubmittedApprovedFilms(films);
			AdminFilmData[] adminFilms = FilmDataManipulation
					.convertFilmToAdminData(approvedFilms, ROUND_ONE);
			adminFilmDataMsg = new AdminFilmDataMsg();
			adminFilmDataMsg.setAdminFilmData(adminFilms);
			adminFilmDataMsg.setMessage(message);
		}
		return adminFilmDataMsg;
	}

	public String checkDateRangeRoundOneFilms(Festival festival) {
		String msg = "";
		Date now = new Date();
		if (now.before(festival.getSubmissionStartDate())) {
			msg = "Film festival submission starts only on "
					+ festival.getSubmissionStartDate();
		} else if (now.after(festival.getSubmissionStartDate())
				&& now.before(festival.getRoundOneStartDate())) {
			msg = "Round One has not yet started. Click <a href='/filmapproval.jsp\'>here</a>";
		} else if (now.after(festival.getRoundOneStartDate())
				&& now.before(festival.getRoundTwoStartDate())) {
			msg = "";
		} else if (now.after(festival.getRoundTwoStartDate())
				&& now.before(festival.getRoundThreeStartDate())) {
			msg = "Festival is in round Two now. Click <a href='/filmapprovalround2.jsp'>here</a>";
		} else if (now.after(festival.getRoundThreeStartDate())
				&& now.before(festival.getRoundThreeEndDate())) {
			msg = "Festival is in round Three now. Click <a href='/filmapprovalround3.jsp'>here</a>";
		} else {
			msg = "No festival active now !!!";
		}
		return msg;
	}

	private Set<Film> getSubmittedApprovedFilms(Set<Film> films) {
		FilmComparatorByVotes filmComparator = new FilmComparatorByVotes();
		Set<Film> approvedFilms = new TreeSet<Film>(filmComparator);
		for (Film film : films) {
			if (film.getStatus().equals(APPROVED)) {
				approvedFilms.add(film);
			}
		}
		return approvedFilms;
	}

	public AdminFilmDataMsg fetchRoundTwoFilms() {
		AdminFilmDataMsg adminFilmDataMsg = null;
		SessionManager.createSession();
		SessionManager.createEntityManager();
		EntityManager entityManager = SessionManager.getEntityManager();
		Query festivalQuery = entityManager
				.createQuery("from Festival where active = 1");
		List festivalList = festivalQuery.getResultList();
		if (festivalList == null || festivalList.isEmpty()) {
			adminFilmDataMsg = new AdminFilmDataMsg();
			adminFilmDataMsg.setAdminFilmData(null);
			adminFilmDataMsg.setMessage("No Festival in progress !!");
		} else {
			String message = "";
			Festival festival = (Festival) festivalList.get(0);
			message = checkDateRangeRoundTwoFilms(festival);
			Set<Film> films = festival.getFilms();
			Set<Film> approvedFilms = getRoundOneApprovedFilms(films);
			AdminFilmData[] adminFilms = FilmDataManipulation
					.convertFilmToAdminData(approvedFilms, ROUND_TWO);
			adminFilmDataMsg = new AdminFilmDataMsg();
			adminFilmDataMsg.setAdminFilmData(adminFilms);
			adminFilmDataMsg.setMessage(message);
		}
		return adminFilmDataMsg;
	}

	public String checkDateRangeRoundTwoFilms(Festival festival) {
		String msg = "";
		Date now = new Date();
		if (now.before(festival.getSubmissionStartDate())) {
			msg = "Film festival submission starts only on "
					+ festival.getSubmissionStartDate();
		} else if (now.after(festival.getSubmissionStartDate())
				&& now.before(festival.getRoundOneStartDate())) {
			msg = "Film festival has not yet started. Click <a href='/filmapproval.jsp'>here</a>";
		} else if (now.after(festival.getRoundOneStartDate())
				&& now.before(festival.getRoundTwoStartDate())) {
			msg = "Festival is in round One now. Click <a href='/filmapprovalround1.jsp'>here</a>";
		} else if (now.after(festival.getRoundTwoStartDate())
				&& now.before(festival.getRoundThreeStartDate())) {
			msg = "";
		} else if (now.after(festival.getRoundThreeStartDate())
				&& now.before(festival.getRoundThreeEndDate())) {
			msg = "Festival is in round Three now. Click <a href='/filmapprovalround3.jsp'>here</a>";
		} else {
			msg = "No festival active now !!!";
		}
		return msg;
	}

	private Set<Film> getRoundOneApprovedFilms(Set<Film> films) {
		FilmComparatorByVotes filmComparator = new FilmComparatorByVotes();
		Set<Film> approvedFilms = new TreeSet<Film>(filmComparator);
		for (Film film : films) {
			if (film.getRoundOneStatus().equals(APPROVED)) {
				approvedFilms.add(film);
			}
		}
		return approvedFilms;
	}

	public AdminFilmDataMsg fetchRoundThreeFilms() {
		AdminFilmDataMsg adminFilmDataMsg = null;
		SessionManager.createSession();
		SessionManager.createEntityManager();
		EntityManager entityManager = SessionManager.getEntityManager();
		Query festivalQuery = entityManager
				.createQuery("from Festival where active = 1");
		List festivalList = festivalQuery.getResultList();
		if (festivalList == null || festivalList.isEmpty()) {
			adminFilmDataMsg = new AdminFilmDataMsg();
			adminFilmDataMsg.setAdminFilmData(null);
			adminFilmDataMsg.setMessage("No Festival in progress !!");
		} else {
			String message = "";
			Festival festival = (Festival) festivalList.get(0);
			message = checkDateRangeRoundThreeFilms(festival);
			Set<Film> films = festival.getFilms();
			Set<Film> approvedFilms = getRoundTwoApprovedFilms(films);
			AdminFilmData[] adminFilms = FilmDataManipulation
					.convertFilmToAdminData(approvedFilms, ROUND_THREE);
			adminFilmDataMsg = new AdminFilmDataMsg();
			adminFilmDataMsg.setAdminFilmData(adminFilms);
			adminFilmDataMsg.setMessage(message);
		}
		return adminFilmDataMsg;
	}

	public String checkDateRangeRoundThreeFilms(Festival festival) {
		String msg = "";
		Date now = new Date();
		if (now.before(festival.getSubmissionStartDate())) {
			msg = "Film festival submission starts only on "
					+ festival.getSubmissionStartDate();
		} else if (now.after(festival.getSubmissionStartDate())
				&& now.before(festival.getRoundOneStartDate())) {
			msg = "Film festival has not yet started. Click <a href='/filmapproval.jsp'>here</a>";
		} else if (now.after(festival.getRoundOneStartDate())
				&& now.before(festival.getRoundTwoStartDate())) {
			msg = "Festival is in round One now. Click <a href='/filmapprovalround1.jsp'>here</a>";
		} else if (now.after(festival.getRoundTwoStartDate())
				&& now.before(festival.getRoundThreeStartDate())) {
			msg = "Festival is in round Two now. Click <a href='/filmapprovalround2.jsp'>here</a>";
		} else if (now.after(festival.getRoundThreeStartDate())
				&& now.before(festival.getRoundThreeEndDate())) {
			msg = "";
		} else {
			msg = "No festival active now !!!";
		}
		return msg;
	}

	private Set<Film> getRoundTwoApprovedFilms(Set<Film> films) {
		FilmComparatorByVotes filmComparator = new FilmComparatorByVotes();
		Set<Film> approvedFilms = new TreeSet<Film>(filmComparator);
		for (Film film : films) {
			if (film.getRoundTwoStatus().equals(APPROVED)) {
				approvedFilms.add(film);
			}
		}
		return approvedFilms;
	}

	public String approveFilms(String[] filmId, String approvalStatus) {
		if (filmId == null)
			return "Select films to be approved";
		List<String> filmList = Arrays.asList(filmId);
		String successMsg = "";
		SessionManager.createSession();
		SessionManager.createEntityManager();
		EntityManager entityManager = SessionManager.getEntityManager();
		Query festivalQuery = entityManager
				.createQuery("from Festival where active = 1");
		List<Festival> festivalList = festivalQuery.getResultList();
		if (festivalList == null || festivalList.isEmpty()) {
			return null;
		}
		Festival festival = (Festival) festivalList.get(0);
		String round = checkDateRangeApproveFilms(festival);
		Set<Film> films = festival.getFilms();
		List<Film> approvedFilms = null;
		if (round.equals(SUBMISSION)) {
			approvedFilms = changeSubmittedApprovalStatus(films, filmList,
					approvalStatus);
		} else if (round.equals(ROUND_ONE)) {
			approvedFilms = changeRoundOneApprovalStatus(films, filmList,
					approvalStatus);
		} else if (round.equals(ROUND_TWO)) {
			approvedFilms = changeRoundTwoApprovalStatus(films, filmList,
					approvalStatus);
		} else if (round.equals(ROUND_THREE)) {
			approvedFilms = changeRoundThreeApprovalStatus(films, filmList,
					approvalStatus);
		}
		// TODO: Manage else
		entityManager.getTransaction().begin();
		for (Film film : approvedFilms) {
			entityManager.merge(film);
		}
		entityManager.getTransaction().commit();
		SessionManager.closeEntityManager();
		if (approvalStatus.equals(APPROVED)) {
			successMsg = "Film(s) Approved !!!";
		} else {
			successMsg = "Film(s) Rejected !!!";
		}
		return successMsg;
	}

	public String receivedFilms(String[] filmId, String approvalStatus) {
		if (filmId == null)
			return "Select films to be approved";
		List<String> filmList = Arrays.asList(filmId);
		String successMsg = "";
		SessionManager.createSession();
		SessionManager.createEntityManager();
		EntityManager entityManager = SessionManager.getEntityManager();
		Query festivalQuery = entityManager
				.createQuery("from Festival where active = 1");
		List<Festival> festivalList = festivalQuery.getResultList();
		if (festivalList == null || festivalList.isEmpty()) {
			return null;
		}
		Festival festival = (Festival) festivalList.get(0);
		String round = checkDateRangeApproveFilms(festival);
		Set<Film> films = festival.getFilms();
		Date now = new Date();
		List<Film> approvedFilms = new ArrayList<Film>();
		for (Film film : films) {
			String id = "" + film.getId();
			if (filmList.contains(id)) {
				if (approvalStatus.equals(RECEIVED)) {
					film.setFullMovieReceived(true);
					film.setFullMovieReceivedDate(now);
				} else {
					film.setFullMovieReceived(false);
				}
				approvedFilms.add(film);
			}
		}
		entityManager.getTransaction().begin();
		for (Film film : approvedFilms) {
			entityManager.merge(film);
		}
		entityManager.getTransaction().commit();
		SessionManager.closeEntityManager();
		successMsg = "Films Approved !!!";
		return successMsg;
	}

	private List<Film> changeSubmittedApprovalStatus(Set<Film> films,
			List<String> filmList, String status) {
		List<Film> approvedFilms = new ArrayList<Film>();
		for (Film film : films) {
			String id = "" + film.getId();
			if (filmList.contains(id)) {
				film.setStatus(status);
				approvedFilms.add(film);
			}
		}
		return approvedFilms;
	}

	private List<Film> changeRoundOneApprovalStatus(Set<Film> films,
			List<String> filmList, String status) {
		List<Film> approvedFilms = new ArrayList<Film>();
		for (Film film : films) {
			String id = "" + film.getId();
			if (filmList.contains(id)) {
				film.setRoundOneStatus(status);
				approvedFilms.add(film);
			}
		}
		return approvedFilms;
	}

	private List<Film> changeRoundTwoApprovalStatus(Set<Film> films,
			List<String> filmList, String status) {
		List<Film> approvedFilms = new ArrayList<Film>();

		for (Film film : films) {
			String id = "" + film.getId();
			if (filmList.contains(id)) {
				film.setRoundTwoStatus(status);
				approvedFilms.add(film);
			}
		}
		return approvedFilms;
	}

	private List<Film> changeRoundThreeApprovalStatus(Set<Film> films,
			List<String> filmList, String status) {
		List<Film> approvedFilms = new ArrayList<Film>();

		for (Film film : films) {
			String id = "" + film.getId();
			if (filmList.contains(id)) {
				film.setRoundThreeStatus(status);
				approvedFilms.add(film);
			}
		}
		return approvedFilms;
	}

	public String checkDateRangeApproveFilms(Festival festival) {
		String msg = "";
		Date now = new Date();
		if ((now.after(festival.getSubmissionStartDate()) && now
				.before(festival.getSubmissionEndDate()))
				|| (now.after(festival.getSubmissionEndDate()) && now
						.before(festival.getRoundOneStartDate()))) {
			msg = SUBMISSION;
		} else if ((now.after(festival.getRoundOneStartDate()) && now
				.before(festival.getRoundOneEndDate()))
				|| (now.after(festival.getRoundOneEndDate()) && now
						.before(festival.getRoundTwoStartDate()))) {
			msg = ROUND_ONE;
		} else if ((now.after(festival.getRoundTwoStartDate()) && now
				.before(festival.getRoundTwoEndDate()))
				|| (now.after(festival.getRoundTwoEndDate()) && now
						.before(festival.getRoundThreeStartDate()))) {
			msg = ROUND_TWO;
		} else if (now.after(festival.getRoundThreeStartDate())
				&& now.before(festival.getRoundThreeEndDate())) {
			msg = ROUND_THREE;
		} else {
			msg = NO_FESTIVAL;
		}
		return msg;
	}

	public void setEditorsPick(String[] filmId, String status) {
		List<String> filmList = Arrays.asList(filmId);
		SessionManager.createSession();
		SessionManager.createEntityManager();
		EntityManager entityManager = SessionManager.getEntityManager();
		Query festivalQuery = entityManager
				.createQuery("from Festival where active = 1");
		List<Festival> festivalList = festivalQuery.getResultList();
		if (festivalList == null || festivalList.isEmpty()) {
			return;
		}
		Festival festival = (Festival) festivalList.get(0);
		Set<Film> allFilms = festival.getFilms();
		List<Film> editorPicks = new ArrayList<Film>();
		for (Film film : allFilms) {
			String id = "" + film.getId();
			if (filmList.contains(id)) {
				if (status.equals(EDITOR_SELECTED)) {
					film.setEditorPicks(true);
				} else {
					film.setEditorPicks(false);
				}
				editorPicks.add(film);
			}
		}

		entityManager.getTransaction().begin();
		for (Film film : editorPicks) {
			entityManager.merge(film);
		}
		entityManager.getTransaction().commit();
		SessionManager.closeEntityManager();
	}

}
