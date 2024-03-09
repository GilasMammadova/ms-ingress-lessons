package az.ingress.lesson1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FruitResponseDto {
    private Integer id;
    private String name;
    private Double amount;
    private Double price;
}
