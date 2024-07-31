package com.emansy.employeeservice.business.mappers;

import com.emansy.employeeservice.business.repository.model.OfficeEntity;
import com.emansy.employeeservice.model.OfficeDto;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-31T12:31:29+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class OfficeMapperImpl implements OfficeMapper {

    @Autowired
    private CountryMapper countryMapper;

    @Override
    public OfficeEntity dtoToEntity(OfficeDto officeDto) {
        if ( officeDto == null ) {
            return null;
        }

        OfficeEntity officeEntity = new OfficeEntity();

        officeEntity.setCountryEntity( countryMapper.dtoToEntity( officeDto.getCountryDto() ) );
        officeEntity.setId( officeDto.getId() );
        officeEntity.setName( officeDto.getName() );
        officeEntity.setStreetAddress( officeDto.getStreetAddress() );
        officeEntity.setCity( officeDto.getCity() );

        return officeEntity;
    }

    @Override
    public OfficeDto entityToDto(OfficeEntity officeEntity) {
        if ( officeEntity == null ) {
            return null;
        }

        OfficeDto officeDto = new OfficeDto();

        officeDto.setCountryDto( countryMapper.entityToDto( officeEntity.getCountryEntity() ) );
        officeDto.setId( officeEntity.getId() );
        officeDto.setName( officeEntity.getName() );
        officeDto.setStreetAddress( officeEntity.getStreetAddress() );
        officeDto.setCity( officeEntity.getCity() );

        return officeDto;
    }
}
