package pl.nullpointerexception.SpringAop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AdditionalAuthenticationAspect {

    @Before("@annotation(authentication) && args(credentials,..)")
    public void before(AdditionalAuthentication authentication, AdditionalCredentials credentials) {
        log.info("AdditionalAuthenticationAspect");
        log.info(" username: " + credentials.getUsername());
        log.info(" password: " + credentials.getPassword());

        if (!(credentials.getUsername().equals("test") && credentials.getPassword().equals("pass"))) {
            throw new RuntimeException("Wrong login or password");
        }
    }
}
