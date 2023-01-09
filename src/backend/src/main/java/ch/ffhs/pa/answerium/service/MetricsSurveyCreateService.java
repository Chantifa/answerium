package ch.ffhs.pa.answerium.service;

import ch.ffhs.pa.answerium.common.InMemoryRepository;
import ch.ffhs.pa.answerium.dto.SurveyResponse;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;


@Repository
public class MetricsSurveyCreateService extends InMemoryRepository<SurveyCreateService> {
    private Counter counter;
    private Logger logger = Logger.getLogger("logger metrics create survey");

    @Autowired
    public MetricsSurveyCreateService(MeterRegistry meterRegistry) {
        this.counter = Counter.builder("addedService").description("Number of created Service").register(meterRegistry);
    }

    @Override
    public void add(SurveyCreateService newService) {
        logger.info("added createSurvey");
        counter.increment();
        super.add(newService);
    }


}
