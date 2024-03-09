package az.ingress.lesson1.rest.service;

import az.ingress.lesson1.dto.FruitRequestDto;
import az.ingress.lesson1.dto.FruitResponseDto;

import java.util.List;
import java.util.Optional;

public interface FruitService {

    List<FruitResponseDto> get(Integer from,
                               Integer to
    );

    Optional<FruitResponseDto> getFruit(Long id);

    FruitResponseDto create(FruitRequestDto fruit);

    public FruitResponseDto update(Long id, FruitRequestDto fruit);

    public void delete(Long id);
}
