package com.emansy.employeeservice.business.mappers;

import com.emansy.employeeservice.business.repository.model.EmployeeEntity;
import com.emansy.employeeservice.model.EmployeeDto;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-31T12:31:29+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Autowired
    private JobTitleMapper jobTitleMapper;
    @Autowired
    private OfficeMapper officeMapper;

    @Override
    public EmployeeEntity dtoToEntity(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setJobTitleEntity( jobTitleMapper.dtoToEntity( employeeDto.getJobTitleDto() ) );
        employeeEntity.setOfficeEntity( officeMapper.dtoToEntity( employeeDto.getOfficeDto() ) );
        employeeEntity.setEventIdEntities( idsToEntities( employeeDto.getEventIds() ) );
        employeeEntity.setId( employeeDto.getId() );
        employeeEntity.setFirstName( employeeDto.getFirstName() );
        employeeEntity.setLastName( employeeDto.getLastName() );
        employeeEntity.setEmail( employeeDto.getEmail() );
        employeeEntity.setPhone( employeeDto.getPhone() );
        if ( employeeDto.getWorkingStartTime() != null ) {
            employeeEntity.setWorkingStartTime( LocalTime.parse( employeeDto.getWorkingStartTime() ) );
        }
        if ( employeeDto.getWorkingEndTime() != null ) {
            employeeEntity.setWorkingEndTime( LocalTime.parse( employeeDto.getWorkingEndTime() ) );
        }

        return employeeEntity;
    }

    @Override
    public EmployeeDto entityToDto(EmployeeEntity employeeEntity) {
        if ( employeeEntity == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setJobTitleDto( jobTitleMapper.entityToDto( employeeEntity.getJobTitleEntity() ) );
        employeeDto.setOfficeDto( officeMapper.entityToDto( employeeEntity.getOfficeEntity() ) );
        employeeDto.setEventIds( entitiesToIds( employeeEntity.getEventIdEntities() ) );
        employeeDto.setId( employeeEntity.getId() );
        employeeDto.setFirstName( employeeEntity.getFirstName() );
        employeeDto.setLastName( employeeEntity.getLastName() );
        employeeDto.setEmail( employeeEntity.getEmail() );
        employeeDto.setPhone( employeeEntity.getPhone() );
        if ( employeeEntity.getWorkingStartTime() != null ) {
            employeeDto.setWorkingStartTime( DateTimeFormatter.ISO_LOCAL_TIME.format( employeeEntity.getWorkingStartTime() ) );
        }
        if ( employeeEntity.getWorkingEndTime() != null ) {
            employeeDto.setWorkingEndTime( DateTimeFormatter.ISO_LOCAL_TIME.format( employeeEntity.getWorkingEndTime() ) );
        }

        return employeeDto;
    }
}
