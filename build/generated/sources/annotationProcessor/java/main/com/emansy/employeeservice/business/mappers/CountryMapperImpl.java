package com.emansy.employeeservice.business.mappers;

import com.emansy.employeeservice.business.repository.model.CountryEntity;
import com.emansy.employeeservice.model.CountryDto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-31T12:31:29+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class CountryMapperImpl implements CountryMapper {

    @Override
    public CountryEntity dtoToEntity(CountryDto countryDto) {
        if ( countryDto == null ) {
            return null;
        }

        CountryEntity countryEntity = new CountryEntity();

        countryEntity.setCode( countryDto.getCode() );
        countryEntity.setName( countryDto.getName() );

        return countryEntity;
    }

    @Override
    public CountryDto entityToDto(CountryEntity countryEntity) {
        if ( countryEntity == null ) {
            return null;
        }

        CountryDto countryDto = new CountryDto();

        countryDto.setCode( countryEntity.getCode() );
        countryDto.setName( countryEntity.getName() );

        return countryDto;
    }
}
