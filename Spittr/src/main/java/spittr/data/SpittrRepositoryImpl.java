package spittr.data;

import org.springframework.stereotype.Repository;
import spittr.pojo.Spitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wangxh on 17-1-5.
 * Package spittr.data
 * DES:
 */
@Repository
public class SpittrRepositoryImpl implements SpittrRepository {
    private final List<Spitter> spitters = new ArrayList<>();

    public SpittrRepositoryImpl() {
        for (int i = 0; i < 100; i++) {
            Spitter spittle = new Spitter("hello from " + i, new Date());
            spittle.setId((long) i);
            spitters.add(spittle);
        }
    }

    @Override
    public List<Spitter> findSpittles(long max, int count) {
        return spitters.subList(0, count).stream().filter( s -> s.getId() < max ).collect(Collectors.toList());
    }

    @Override
    public Spitter findOne(long id) {
        return spitters.stream().filter( s -> s.getId() == id ).findFirst().orElse(null);
    }


}
