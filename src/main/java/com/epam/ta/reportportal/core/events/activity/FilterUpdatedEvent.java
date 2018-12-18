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

package com.epam.ta.reportportal.core.events.activity;

import com.epam.ta.reportportal.core.events.ActivityEvent;
import com.epam.ta.reportportal.entity.Activity;
import com.epam.ta.reportportal.ws.converter.builders.ActivityBuilder;
import com.epam.ta.reportportal.ws.model.activity.UserFilterActivityResource;

import static com.epam.ta.reportportal.core.events.activity.ActivityAction.UPDATE_FILTER;
import static com.epam.ta.reportportal.core.events.activity.util.ActivityDetailsUtil.processDescription;
import static com.epam.ta.reportportal.core.events.activity.util.ActivityDetailsUtil.processName;
import static com.epam.ta.reportportal.entity.Activity.ActivityEntityType.FILTER;

/**
 * @author Pavel Bortnik
 */
public class FilterUpdatedEvent extends AroundEvent<UserFilterActivityResource> implements ActivityEvent {

	private Long updatedBy;

	public FilterUpdatedEvent() {
	}

	public FilterUpdatedEvent(UserFilterActivityResource before, UserFilterActivityResource after, Long updatedBy) {
		super(before, after);
		this.updatedBy = updatedBy;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public Activity toActivity() {
		//processShared
		return new ActivityBuilder().addCreatedNow()
				.addAction(UPDATE_FILTER)
				.addActivityEntityType(FILTER)
				.addUserId(updatedBy)
				.addObjectId(getAfter().getId())
				.addObjectName(getAfter().getName())
				.addProjectId(getAfter().getProjectId())
				.addHistoryField(processName(getBefore().getName(), getAfter().getName()))
				.addHistoryField(processDescription(getBefore().getDescription(), getAfter().getDescription()))
				.get();
	}
}