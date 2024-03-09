package az.ingress.lesson1.rest.service.impl;

import az.ingress.lesson1.domain.FruitEntity;
import az.ingress.lesson1.dto.FruitRequestDto;
import az.ingress.lesson1.dto.FruitResponseDto;
import az.ingress.lesson1.rest.repository.FruitRepository;
import az.ingress.lesson1.rest.service.FruitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class FruitServiceImpl implements FruitService {

    private final FruitRepository fruitRepository;
//
//    FruitServiceImpl() {
//        log.info("Created FruitServiceImpl instance {} ", this);
//    }

    @Override
    public List<FruitResponseDto> get(Integer from, Integer to) {
        return fruitRepository
                .findAll()
                .stream()
                .map(fruitEntity -> FruitResponseDto.builder()
                        .amount(fruitEntity.getAmount())
                        .name(String.valueOf(fruitEntity.getAmount()))
                        .price(fruitEntity.getPrice())
                        .id(fruitEntity.getId())
                        .build())
                .toList();
    }

    @Override
    public Optional<FruitResponseDto> getFruit(Long id) {
        return fruitRepository.findById(id)
                .stream()
                .map(fruitEntity -> FruitResponseDto
                        .builder()
                        .id(fruitEntity.getId())
                        .amount(fruitEntity.getAmount())
                        .name(fruitEntity.getName())
                        .price(fruitEntity.getPrice())
                        .build())
                .findFirst();
    }

    @Override
    public FruitResponseDto create(FruitRequestDto fruit) {

        FruitEntity fruitEntity = FruitEntity.builder()
                .amount(fruit.getAmount())
                .price(fruit.getPrice())
                .name(fruit.getName())
                .build();

        FruitEntity saved = fruitRepository.save(fruitEntity);

        return  FruitResponseDto.builder()
                .price(saved.getPrice())
                .name(saved.getName())
                .amount(saved.getAmount())
                .build();

    }

    @Override
    public FruitResponseDto update(Long id, FruitRequestDto fruit) {

        Optional<FruitEntity> entityById = fruitRepository.findById(id);

         entityById.stream().map(fruitEntity -> )
    }

    @Override
    public void delete(Long id) {

    }
}
