package kr.ac.kopo.kopo03.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kopo03.domain.Board;

@Repository
public interface BoardSpecs {
    public static Specification<Board> search(Map<String, Object> filter) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            filter.forEach((key, value) -> {
                switch(key) {
                case "title" :
                    predicates.add(builder.equal(root.get(key).as(String.class), value));
                }
            });
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
