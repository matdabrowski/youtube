package pl.nullpointerexception.SpringAop.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class SimpleRepository {

    public String getSomethingElseFromRepository() {
        log.info("Repository: getSomethingElseFromRepository");
        return "getSomethingElse";
    }
}
