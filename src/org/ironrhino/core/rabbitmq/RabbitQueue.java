package org.ironrhino.core.rabbitmq;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.ironrhino.core.message.Queue;
import org.ironrhino.core.util.ReflectionUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;

public abstract class RabbitQueue<T extends Serializable> implements Queue<T> {

	@Autowired
	protected AmqpTemplate amqpTemplate;

	@Autowired
	protected RabbitAdmin rabbitAdmin;

	@Getter
	@Setter
	protected String queueName = "";

	@Getter
	@Setter
	protected boolean durable = true;

	public RabbitQueue() {
		Class<?> clazz = ReflectionUtils.getGenericClass(getClass(), RabbitQueue.class);
		if (clazz != null)
			queueName = clazz.getName();
	}

	@PostConstruct
	public void init() {
		rabbitAdmin.declareQueue(new org.springframework.amqp.core.Queue(queueName, durable, false, false));
	}

	@Override
	public void produce(T message) {
		amqpTemplate.convertAndSend(getQueueName(), message);
	}

}
