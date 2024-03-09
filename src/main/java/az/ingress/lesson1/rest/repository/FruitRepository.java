package az.ingress.lesson1.rest.repository;

import az.ingress.lesson1.domain.FruitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<FruitEntity,Long > {
}
