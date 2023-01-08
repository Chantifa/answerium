package ch.ffhs.pa.answerium.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class InMemoryRepository<ServiceType extends Service> {
    protected final List<ServiceType> services = new ArrayList<>();

    public void add(ServiceType service) {
        services.add(service);
    }

    public List<ServiceType> all() {
        return services;
    }

    public Optional<ServiceType> byId(UUID id) {
        return services
                .stream()
                .filter(service -> service.getId().equals(id))
                .findFirst();
    }

    public void replace(UUID id, ServiceType newService) {
        services.replaceAll(currentModel -> currentModel.getId().equals(id) ? newService : currentModel);
    }

    public void remove(UUID id) {
        services.removeIf(model -> model.getId().equals(id));
    }

}
