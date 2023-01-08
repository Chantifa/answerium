package ch.ffhs.pa.answerium.service;

import ch.ffhs.pa.answerium.common.InMemoryRepository;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MetricsSurveyCreateService extends InMemoryRepository<SurveyCreateService> {
    private final Counter counter;

    @Autowired
    public MetricsSurveyCreateService(MeterRegistry meterRegistry) {
        this.counter = Counter.builder("addedService").description("Number of created Service").register(meterRegistry);
    }

    @Override
    public void add(SurveyCreateService newService) {
        counter.increment();
        super.add(newService);
    }


}
