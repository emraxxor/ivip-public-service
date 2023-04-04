package com.github.emraxxor.ivip.pub.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.emraxxor.ivip.common.configuration.data.KafkaProducerConfigurationData;
import com.github.emraxxor.ivip.common.kafka.AbstractEventProducer;
import com.github.emraxxor.ivip.common.kafka.ProducerEvent;
import com.github.emraxxor.ivip.pub.event.PublicEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(value = "ivip.kafka.producer.enabled", havingValue = "true")
@Component
@Slf4j
public class DefaultEventProducer extends AbstractEventProducer<String,String, PublicEvent> {

    private final ObjectMapper mapper;

    public DefaultEventProducer(
            KafkaProducerConfigurationData kafkaProducerConfigurationData,
            KafkaTemplate<String, String> kafkaTemplate,
            ObjectMapper mapper
    ) {
        super(kafkaProducerConfigurationData, kafkaTemplate);
        this.mapper = mapper;
    }

    @Override
    protected String transform(ProducerEvent<String, PublicEvent> event) {
        try {
            return mapper.writeValueAsString(event);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(),e);
            throw new IllegalStateException();
        }
    }
}
