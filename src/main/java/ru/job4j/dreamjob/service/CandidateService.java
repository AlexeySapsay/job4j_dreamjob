package ru.job4j.dreamjob.service;

import org.springframework.stereotype.Service;
import ru.job4j.dreamjob.model.Candidate;;
import ru.job4j.dreamjob.store.CandidateStore;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateService {
    private final CandidateStore store;

    public CandidateService(CandidateStore store) {
        this.store = store;
    }

    public List<Candidate> findAll() {
        return new ArrayList<>(store.findAll());
    }

    public void add(Candidate candidate) {
        store.add(candidate);
    }

    public Candidate findById(int id) {
        return store.findById(id);
    }

    public Candidate update(Candidate candidate) {
        return store.update(candidate);
    }
}
