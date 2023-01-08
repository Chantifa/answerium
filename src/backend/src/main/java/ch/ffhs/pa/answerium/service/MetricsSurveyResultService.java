package ch.ffhs.pa.answerium.service;

import ch.ffhs.pa.answerium.common.InMemoryRepository;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;

public class MetricsSurveyResultService  extends InMemoryRepository<SurveyResultService> {
    private final Counter counter;

    @Autowired
    public MetricsSurveyResultService(MeterRegistry meterRegistry) {
        this.counter = Counter.builder("getResult").description("Number of Results").register(meterRegistry);
    }

    @Override
    public void add(SurveyResultService newService) {
        counter.increment();
        super.add(newService);
    }

}
