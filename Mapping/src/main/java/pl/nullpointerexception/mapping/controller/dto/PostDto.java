package pl.nullpointerexception.mapping.controller.dto;

import org.hibernate.validator.constraints.Length;

public record PostDto(
        @Length(min = 4) String title,
        @Length(min = 4) String content) {
}
