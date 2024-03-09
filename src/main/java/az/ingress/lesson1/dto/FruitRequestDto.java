package az.ingress.lesson1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FruitRequestDto {

    @NotBlank
    private String name;
    @NotNull
    private Double amount;
    private Double price;
}
