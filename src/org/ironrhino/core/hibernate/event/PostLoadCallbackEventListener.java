package org.ironrhino.core.hibernate.event;

import javax.persistence.PostLoad;

import org.hibernate.event.spi.PostLoadEvent;
import org.hibernate.event.spi.PostLoadEventListener;
import org.ironrhino.core.util.ReflectionUtils;

public class PostLoadCallbackEventListener implements PostLoadEventListener {

	private static final long serialVersionUID = 857354753352009583L;

	@Override
	public void onPostLoad(PostLoadEvent event) {
		ReflectionUtils.processCallback(event.getEntity(), PostLoad.class);
	}

}