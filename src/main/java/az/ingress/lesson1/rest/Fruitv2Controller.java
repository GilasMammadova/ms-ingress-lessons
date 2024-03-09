package az.ingress.lesson1.rest;

import az.ingress.lesson1.dto.FruitRequestDto;
import az.ingress.lesson1.dto.FruitResponseDto;
import az.ingress.lesson1.rest.service.FruitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v2/fruits")
@Slf4j
public class Fruitv2Controller {

    private final FruitService fruitService;


    @GetMapping
    public List<FruitResponseDto> get(@RequestParam("from") Integer from,
                                      @RequestParam("to") Integer to
    ) {

        return fruitService.get(from, to);
    }

    @GetMapping("/{id}")
    public Optional<FruitResponseDto> getFruit(@PathVariable Long id) {
        return fruitService.getFruit(id);
    }

    @PostMapping
    public FruitResponseDto create(@Validated @RequestBody FruitRequestDto fruit) {

        return fruitService.create(fruit);
    }

    @PutMapping("/{id}")
    public FruitResponseDto update(@PathVariable("id") Long id, @Validated @RequestBody FruitRequestDto fruit) {

        return fruitService.update(id, fruit);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        fruitService.delete(id);

    }

}
