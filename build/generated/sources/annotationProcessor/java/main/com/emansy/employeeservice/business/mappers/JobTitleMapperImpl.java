package com.emansy.employeeservice.business.mappers;

import com.emansy.employeeservice.business.repository.model.JobTitleEntity;
import com.emansy.employeeservice.model.JobTitleDto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-31T12:31:29+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class JobTitleMapperImpl implements JobTitleMapper {

    @Override
    public JobTitleEntity dtoToEntity(JobTitleDto jobTitleDto) {
        if ( jobTitleDto == null ) {
            return null;
        }

        JobTitleEntity jobTitleEntity = new JobTitleEntity();

        jobTitleEntity.setId( jobTitleDto.getId() );
        jobTitleEntity.setName( jobTitleDto.getName() );

        return jobTitleEntity;
    }

    @Override
    public JobTitleDto entityToDto(JobTitleEntity jobTitleEntity) {
        if ( jobTitleEntity == null ) {
            return null;
        }

        JobTitleDto jobTitleDto = new JobTitleDto();

        jobTitleDto.setId( jobTitleEntity.getId() );
        jobTitleDto.setName( jobTitleEntity.getName() );

        return jobTitleDto;
    }
}
