package ch.ffhs.pa.answerium.service;

import ch.ffhs.pa.answerium.common.InMemoryRepository;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository
public class MetricsParticipationService extends InMemoryRepository<SurveyParticipationService> {

    private final Logger logger = Logger.getLogger("logger metrics surveyParticipation");
    private final Counter counter;

    @Autowired
    public MetricsParticipationService(MeterRegistry meterRegistry) {
        this.counter = Counter.builder("addParticipation").description("Number of Survey Participation").register(meterRegistry);
    }

    @Override
    public void add(SurveyParticipationService newService ) {
        logger.info("added surveyParticipation");
        counter.increment();
        super.add(newService);
    }

}
