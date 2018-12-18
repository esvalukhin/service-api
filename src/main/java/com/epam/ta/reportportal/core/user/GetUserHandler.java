/*
 * Copyright 2016 EPAM Systems
 *
 *
 * This file is part of EPAM Report Portal.
 * https://github.com/reportportal/service-api
 *
 * Report Portal is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Report Portal is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Report Portal.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.epam.ta.reportportal.core.user;

import com.epam.ta.reportportal.auth.ReportPortalUser;
import com.epam.ta.reportportal.commons.querygen.Filter;
import com.epam.ta.reportportal.ws.model.YesNoRS;
import com.epam.ta.reportportal.ws.model.user.UserBidRS;
import com.epam.ta.reportportal.ws.model.user.UserResource;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * @author Andrei_Ramanchuk
 */
public interface GetUserHandler {

	/**
	 * Get specified user info
	 *
	 * @param username    Username
	 * @param currentUser Logged-in username
	 * @return
	 */
	UserResource getUser(String username, ReportPortalUser currentUser);

	/**
	 * Get logged-in user info
	 *
	 * @param currentUser Logged-in username
	 * @return
	 */
	UserResource getUser(ReportPortalUser currentUser);

	/**
	 * Get information about user registration bid
	 *
	 * @param uuid
	 * @return
	 */
	UserBidRS getBidInformation(String uuid);

	/**
	 * Validate existence of username or email
	 *
	 * @param username
	 * @param email
	 * @return
	 */
	YesNoRS validateInfo(String username, String email);

	/**
	 * Get all users by filter with paging
	 *
	 * @param filter         Filter
	 * @param pageable       Paging
	 * @param projectDetails Project details
	 * @return Page of users
	 */
	Iterable<UserResource> getUsers(Filter filter, Pageable pageable, ReportPortalUser.ProjectDetails projectDetails);

	Map<String, UserResource.AssignedProject> getUserProjects(String userName);

	Iterable<UserResource> getAllUsers(Filter filter, Pageable pageable);

	Iterable<UserResource> searchUsers(String term, Pageable pageable);
}