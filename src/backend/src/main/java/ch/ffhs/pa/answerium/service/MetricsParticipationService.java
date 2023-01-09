package ch.ffhs.pa.answerium.service;

import ch.ffhs.pa.answerium.common.InMemoryRepository;
import ch.ffhs.pa.answerium.dto.ParticipationRequest;
import ch.ffhs.pa.answerium.dto.SurveyResponse;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.logging.Logger;

@Repository
public class MetricsParticipationService extends InMemoryRepository<SurveyParticipationService> {

    private Logger logger = Logger.getLogger("logger metrics surveyParticipation");
    private Counter counter;

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
