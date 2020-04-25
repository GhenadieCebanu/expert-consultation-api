package com.code4ro.legalconsultation.converters;

import com.code4ro.legalconsultation.model.dto.DocumentNodeDto;
import com.code4ro.legalconsultation.model.persistence.DocumentNode;
import org.mapstruct.Mapper;

@Mapper
public interface DocumentNodeMapper {

    DocumentNodeDto map(DocumentNode documentNode);

    DocumentNode map(DocumentNodeDto documentNodeDto);
}
