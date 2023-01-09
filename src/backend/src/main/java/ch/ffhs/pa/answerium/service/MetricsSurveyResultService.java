package ch.ffhs.pa.answerium.service;

import ch.ffhs.pa.answerium.common.InMemoryRepository;
import ch.ffhs.pa.answerium.dto.SurveyResultResponse;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository
public class MetricsSurveyResultService  extends InMemoryRepository<SurveyResultService> {
    private final Counter counter;

    private Logger logger = Logger.getLogger("logger metrics show surveyResults");

    @Autowired
    public MetricsSurveyResultService(MeterRegistry meterRegistry) {
        this.counter = Counter.builder("getResult").description("Number of Results").register(meterRegistry);
    }

    @Override
    public void add(SurveyResultService newService) {
        logger.info("show surveryResults");
        counter.increment();
        super.add(newService);
    }

}
