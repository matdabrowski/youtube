package pl.nullpointerexception.SpringAop.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.nullpointerexception.SpringAop.repository.SimpleRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class SimpleService {

    private final SimpleRepository simpleRepository;

    public String getSomethingFromService() {
        log.info("Service: getSomethingFromService");
        return getSomethingString();
    }

    private String getSomethingString() {
        log.info("Service: getSomethingString");
        return "something";
    }

    public String getSomethingElseFromService() {
        log.info("Service: getSomethingElseFromService");
        return simpleRepository.getSomethingElseFromRepository();
    }
}
