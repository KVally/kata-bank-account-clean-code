package core.usecase;

public interface UseCaseExecutor <T, R> {
    T execute (R request);
}
