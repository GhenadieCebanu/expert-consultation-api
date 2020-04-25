package com.code4ro.legalconsultation.model.dto;

import com.code4ro.legalconsultation.model.dto.documentnode.DocumentNodeDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentConsolidatedDto extends BaseEntityDto {
    private DocumentNodeDto documentNode;
    private DocumentConfigurationDto documentConfigutaion;
}
