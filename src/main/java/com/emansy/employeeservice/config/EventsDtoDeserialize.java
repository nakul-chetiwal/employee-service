package com.emansy.employeeservice.config;

import com.emansy.employeeservice.model.EventsDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class EventsDtoDeserialize implements Deserializer<EventsDto> {

    @Override
    public EventsDto deserialize(String topic, byte[] data) {
        ObjectMapper mapper = new ObjectMapper();
        EventsDto event = null;
        try {
            event = mapper.readValue(data, EventsDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return event;
    }
}
