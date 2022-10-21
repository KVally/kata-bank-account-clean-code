package core.domain.port;

import java.util.Optional;

public interface BaseRepositoryPort <T,ID> {
    T save(T model);
    T update(T model);
    Optional<T> findById(ID id);
}
