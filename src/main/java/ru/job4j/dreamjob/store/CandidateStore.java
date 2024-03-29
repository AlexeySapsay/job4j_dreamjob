package ru.job4j.dreamjob.store;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.dreamjob.model.Candidate;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
@Repository
public class CandidateStore {

    private static final CandidateStore INST = new CandidateStore();

    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private CandidateStore() {
        int id = atomicInteger.incrementAndGet();
        candidates.put(id, new Candidate(id, "Ivan", "very strong junior",
                null, LocalDateTime.now()));
        id = atomicInteger.incrementAndGet();
        candidates.put(id, new Candidate(id, "Anton",
                "perspective middle", null, LocalDateTime.now()));
        id = atomicInteger.incrementAndGet();
        candidates.put(id, new Candidate(id, "Alex",
                "amazing senior!", null, LocalDateTime.now()));
    }

    public static CandidateStore instOf() {
        return INST;
    }

    public Collection<Candidate> findAll() {
        return candidates.values();
    }

    public void add(Candidate candidate) {
        int id = atomicInteger.incrementAndGet();
        candidate.setId(id);
        candidates.put(candidate.getId(), candidate);
    }

    public Candidate findById(int id) {
        return candidates.get(id);
    }

    public Candidate update(Candidate candidate) {
        return candidates.replace(candidate.getId(), candidate);
    }
}
