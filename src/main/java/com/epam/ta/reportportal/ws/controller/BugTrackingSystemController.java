/*
 * Copyright 2018 EPAM Systems
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.epam.ta.reportportal.ws.controller;

import com.epam.ta.reportportal.auth.ReportPortalUser;
import com.epam.ta.reportportal.commons.EntityUtils;
import com.epam.ta.reportportal.core.bts.handler.CreateTicketHandler;
import com.epam.ta.reportportal.core.bts.handler.GetTicketHandler;
import com.epam.ta.reportportal.core.bts.handler.UpdateBugTrackingSystemHandler;
import com.epam.ta.reportportal.ws.model.OperationCompletionRS;
import com.epam.ta.reportportal.ws.model.externalsystem.PostFormField;
import com.epam.ta.reportportal.ws.model.externalsystem.PostTicketRQ;
import com.epam.ta.reportportal.ws.model.externalsystem.Ticket;
import com.epam.ta.reportportal.ws.model.externalsystem.UpdateBugTrackingSystemRQ;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.epam.ta.reportportal.auth.permissions.Permissions.ASSIGNED_TO_PROJECT;
import static com.epam.ta.reportportal.auth.permissions.Permissions.PROJECT_MANAGER;
import static com.epam.ta.reportportal.util.ProjectExtractor.extractProjectDetails;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Controller implementation for working with external systems.
 *
 * @author Aliaksei_Makayed
 * @author Andrei_Ramanchuk
 */
@RestController
@RequestMapping("/{projectName}/integration")
@PreAuthorize(ASSIGNED_TO_PROJECT)
public class BugTrackingSystemController {

	private final CreateTicketHandler createTicketHandler;
	private final GetTicketHandler getTicketHandler;
	private final UpdateBugTrackingSystemHandler updateBugTrackingSystemHandler;

	@Autowired
	public BugTrackingSystemController(CreateTicketHandler createTicketHandler, GetTicketHandler getTicketHandler,
			UpdateBugTrackingSystemHandler updateBugTrackingSystemHandler) {
		this.createTicketHandler = createTicketHandler;
		this.getTicketHandler = getTicketHandler;
		this.updateBugTrackingSystemHandler = updateBugTrackingSystemHandler;
	}

	@Transactional
	@PutMapping(value = "/{integrationId}", consumes = { APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation("Update integration instance")
	@PreAuthorize(PROJECT_MANAGER)
	public OperationCompletionRS updateIntegration(@Validated @RequestBody UpdateBugTrackingSystemRQ updateRequest,
			@PathVariable String projectName, @PathVariable Long integrationId, @AuthenticationPrincipal ReportPortalUser user) {
		return updateBugTrackingSystemHandler.updateBugTrackingSystem(updateRequest,
				integrationId,
				extractProjectDetails(user, EntityUtils.normalizeId(projectName)),
				user
		);
	}

	@Transactional
	@PutMapping(value = "/{integrationId}/connect", consumes = { APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation("Check connection to the integration instance")
	@PreAuthorize(PROJECT_MANAGER)
	public OperationCompletionRS checkConnection(@PathVariable String projectName, @PathVariable Long integrationId,
			@RequestBody @Validated UpdateBugTrackingSystemRQ updateRequest, @AuthenticationPrincipal ReportPortalUser user) {
		return updateBugTrackingSystemHandler.integrationConnect(updateRequest,
				integrationId,
				extractProjectDetails(user, EntityUtils.normalizeId(projectName))
		);
	}

	@Transactional(readOnly = true)
	@GetMapping(value = "/{integrationId}/fields-set")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation("Get list of fields required for posting ticket")
	@PreAuthorize(PROJECT_MANAGER)
	public List<PostFormField> getSetOfIntegrationSystemFields(@RequestParam(value = "issueType") String issuetype,
			@PathVariable String projectName, @PathVariable Long integrationId, @AuthenticationPrincipal ReportPortalUser user) {
		return getTicketHandler.getSubmitTicketFields(issuetype,
				integrationId,
				extractProjectDetails(user, EntityUtils.normalizeId(projectName))
		);
	}

	@Transactional(readOnly = true)
	@GetMapping(value = "/{integrationId}/issue_types")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation("Get list of fields required for posting ticket")
	@PreAuthorize(PROJECT_MANAGER)
	public List<String> getAllowableIssueTypes(@PathVariable String projectName, @PathVariable Long integrationId,
			@AuthenticationPrincipal ReportPortalUser user) {
		return getTicketHandler.getAllowableIssueTypes(integrationId, extractProjectDetails(user, EntityUtils.normalizeId(projectName)));
	}

	//
	//	// ===================
	//	// TICKETS BLOCK
	//	// ===================
	//
	@Transactional
	@PostMapping(value = "{integrationId}/ticket")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation("Post ticket to the bts integration")
	public Ticket createIssue(@Validated @RequestBody PostTicketRQ ticketRQ, @PathVariable String projectName,
			@PathVariable Long integrationId, @AuthenticationPrincipal ReportPortalUser user) {
		return createTicketHandler.createIssue(ticketRQ,
				integrationId,
				extractProjectDetails(user, EntityUtils.normalizeId(projectName)),
				user
		);
	}

	@Transactional(readOnly = true)
	@GetMapping(value = "/{integrationId}/ticket/{ticketId}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation("Get ticket from the bts integration")
	public Ticket getTicket(@PathVariable String ticketId, @PathVariable String projectName, @PathVariable Long integrationId,
			@AuthenticationPrincipal ReportPortalUser user) {
		return getTicketHandler.getTicket(ticketId, integrationId, extractProjectDetails(user, EntityUtils.normalizeId(projectName)));
	}

}