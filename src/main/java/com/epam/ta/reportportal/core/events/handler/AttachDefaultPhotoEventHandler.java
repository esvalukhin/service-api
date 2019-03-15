package com.epam.ta.reportportal.core.events.handler;

import com.epam.ta.reportportal.BinaryData;
import com.epam.ta.reportportal.core.events.AttachDefaultPhotoEvent;
import com.epam.ta.reportportal.core.events.activity.UserCreatedEvent;
import com.epam.ta.reportportal.dao.UserRepository;
import com.epam.ta.reportportal.entity.user.User;
import com.epam.ta.reportportal.exception.ReportPortalException;
import com.epam.ta.reportportal.filesystem.DataEncoder;
import com.epam.ta.reportportal.ws.model.ErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import java.io.InputStream;

/**
 * @author <a href="mailto:ihar_kahadouski@epam.com">Ihar Kahadouski</a>
 */
@Profile("!unittest")
@Component
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class AttachDefaultPhotoEventHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserCreatedEvent.class);

	private final UserRepository userRepository;

	private final DataEncoder encoder;

	@Autowired
	public AttachDefaultPhotoEventHandler(UserRepository userRepository, DataEncoder encoder) {
		this.userRepository = userRepository;
		this.encoder = encoder;
	}

	@TransactionalEventListener
	public void handleDefaultPhotoAttached(AttachDefaultPhotoEvent event) {
		final User user = userRepository.findById(event.getUserId())
				.orElseThrow(() -> new ReportPortalException(ErrorType.USER_NOT_FOUND, event.getUserId()));
		attachPhoto(user, "image/nonameUserPhoto.jpg");
	}

	@EventListener
	public void handleContextRefresh(ContextRefreshedEvent event) {
		userRepository.findByLogin("superadmin").ifPresent(it -> attachPhoto(it, "image/superAdminPhoto.jpg"));
		userRepository.findByLogin("default").ifPresent(it -> attachPhoto(it, "image/defaultUserPhoto.jpg"));
	}

	private void attachPhoto(User user, String photoPath) {
		if (user.getAttachment() == null) {
			final InputStream inputStream;
			try {
				inputStream = new ClassPathResource(photoPath).getInputStream();
				BinaryData binaryData = new BinaryData(MediaType.IMAGE_JPEG_VALUE, (long) inputStream.available(), inputStream);
				final String path = userRepository.replaceUserPhoto(user.getLogin(), binaryData);
				user.setAttachment(encoder.encode(path));

			} catch (Exception exception) {
				LOGGER.error("Cannot attach default photo to user {}. Error: {}", user.getLogin(), exception);
			}
		}
	}
}