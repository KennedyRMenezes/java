package eco.phrases.domain.phrase;

import jakarta.validation.constraints.NotBlank;

public record PhraseInsertData(
        @NotBlank
        String text,
        @NotBlank
        String author,
        String origin
) {
}
