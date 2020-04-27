package com.code4ro.legalconsultation.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageDto<T> {
    List<T> content;

    private Integer totalPages;
    private Long totalElements;
    private PageableDto pageable;

    public static <T> PageDto<T> map(Page page, List<T> content) {
        PageableDto pageable = PageableDto.builder()
                .pageSize(page.getPageable().getPageSize())
                .pageNumber(page.getPageable().getPageNumber())
                .build();
        return PageDto.<T>builder()
                .content(content)
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .pageable(pageable).build();
    }
}