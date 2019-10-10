package com.test.datamode;
import org.springframework.data.repository.CrudRepository;

public interface UrlRepository extends CrudRepository<UrlMapping,Long> {

    UrlMapping findByKey(String key);

}
