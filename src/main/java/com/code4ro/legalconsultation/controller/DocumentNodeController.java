package com.code4ro.legalconsultation.controller;

import com.code4ro.legalconsultation.converters.DocumentNodeMapper;
import com.code4ro.legalconsultation.model.dto.DocumentNodeDto;
import com.code4ro.legalconsultation.model.persistence.DocumentNode;
import com.code4ro.legalconsultation.service.api.DocumentNodeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/document-nodes")
@RequiredArgsConstructor
public class DocumentNodeController {

    private final DocumentNodeService documentNodeService;
    private final DocumentNodeMapper mapper;

    @ApiOperation(value = "Return document node based on id",
            response = DocumentNodeDto.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DocumentNodeDto getDocumentById(@ApiParam("Id of the document node object being requested") @PathVariable UUID id) {
        DocumentNode documentNode = documentNodeService.findById(id);

        return mapper.map(documentNode);
    }

    @ApiOperation(value = "Create a new document node in the platform",
            response = UUID.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UUID> createDocument(
            @Valid @RequestBody DocumentNodeDto documentNodeDto) {

        DocumentNode inputDocumentNode = mapper.map(documentNodeDto);
        DocumentNode documentNode = documentNodeService.create(inputDocumentNode);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(documentNode.getId());
    }
}
