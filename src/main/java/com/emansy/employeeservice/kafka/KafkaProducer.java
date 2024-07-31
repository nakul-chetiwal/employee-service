package com.emansy.employeeservice.kafka;

import com.emansy.employeeservice.model.AttendeesDto;
import com.emansy.employeeservice.model.EmployeeDto;
import com.emansy.employeeservice.model.EventDto;
import com.emansy.employeeservice.model.EventIdsWithinDatesDto;
import com.emansy.employeeservice.model.EventsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ExecutionException;

@Log4j2
@RequiredArgsConstructor
@Component
public class KafkaProducer {

    private final ReplyingKafkaTemplate<String, EventIdsWithinDatesDto, EventsDto> eventsReplyingKafkaTemplate;

    private final KafkaTemplate<String, AttendeesDto> attendanceKafkaTemplate;
    private final KafkaTemplate<String,EventIdsWithinDatesDto> kafkaTemplate;

    public Set<EventDto> requestAndReceiveEvents(Set<Long> eventIds, String fromDate, String thruDate)
            throws ExecutionException, InterruptedException {
        ConsumerRecord<String, EventsDto> consumerRecord = eventsReplyingKafkaTemplate.sendAndReceive(
                new ProducerRecord<>("events-request", new EventIdsWithinDatesDto(eventIds, fromDate, thruDate)),
                Duration.ofSeconds(100)
        ).get();
        if (consumerRecord == null) {
            log.error("Something went wrong, no response from kafka topic: events-response");
            return Collections.emptySet();
        }
        Set<EventDto> eventDtos = consumerRecord.value().getEventDtos();
        log.info("{} events received from kafka topic: events-response", eventDtos.size());
        return eventDtos;
    }

    public void sendAttendanceNotification(Boolean whetherToAttendOrToUnattend, Set<EmployeeDto> employeeDtos, EventDto eventDto) {
        attendanceKafkaTemplate.send("attendance-notification",
                new AttendeesDto(whetherToAttendOrToUnattend, employeeDtos, eventDto));
        log.info("Attendance notification for {} employees is sent to kafka topic: attendance-notification",
                employeeDtos.size());
    }

//    public void sendEventDtosRequest(Set<Long> eventIds, String fromDate, String thruDate) throws ExecutionException, InterruptedException {
//        Message<EventIdsWithinDatesDto> message = MessageBuilder
//                .withPayload(new EventIdsWithinDatesDto(eventIds, fromDate, thruDate))
//                .setHeader(KafkaHeaders.TOPIC,"events-request")
//                .build();
//        kafkaTemplate.send(message);
//    }

}
