package az.ingress.lesson1.rest;

import az.ingress.lesson1.dto.FruitRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/fruits")
@Slf4j
public class FruitController {

    List<FruitRequestDto> fruitList = new ArrayList<>();

    @GetMapping
    public List<FruitRequestDto> get(@RequestParam("from") Integer from,
                                     @RequestParam("to") Integer to
    ) {

        return fruitList.subList(from,to);
    }

    @GetMapping("/{id}/{id2}")
    public FruitRequestDto getFruit(@PathVariable Integer id2) {
        return fruitList.get(id2);
    }

    @PostMapping
    public FruitRequestDto create(@Validated @RequestBody FruitRequestDto fruit) {
        fruitList.add(fruit);
        return fruit;
    }

    @PutMapping("/{id}")
    public FruitRequestDto update(@PathVariable("id") Integer id, @Validated @RequestBody FruitRequestDto fruit) {
        fruitList.set(id, fruit);
        return fruit;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        fruitList.remove(id);

    }

}
