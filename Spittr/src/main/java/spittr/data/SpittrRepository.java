package spittr.data;

import spittr.pojo.Spitter;

import java.util.List;

/**
 * Created by wangxh on 17-1-5.
 * Package spittr.data
 * DES:
 */
public interface SpittrRepository {
    List<Spitter> findSpittles(long max, int count);
    Spitter findOne(long id);
}
