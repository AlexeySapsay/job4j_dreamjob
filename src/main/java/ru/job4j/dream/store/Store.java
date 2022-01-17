package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://job4j.ru/profile/exercise/82/task-view/443
 * <p>
 * изучение работы с сервлетами
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 13.01.2022
 */
public class Store {

    private static final Store INST = new Store();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private static AtomicInteger postId = new AtomicInteger(4);
    private static AtomicInteger candidateId = new AtomicInteger(4);

    private Store() {
        posts.put(1, new Post(1, "Ivan", "Junior Java Job",
                LocalDateTime.of(2022, 1, 10, 10, 10, 10, 0)));
        posts.put(2, new Post(2, "Alex", "Middle Java Job",
                LocalDateTime.of(2020, 10, 20, 10, 10, 10, 0)));
        posts.put(3, new Post(3, "Youriy", "Senior Java Job",
                LocalDateTime.of(2018, 12, 10, 10, 10, 10, 0)));
        candidates.put(1, new Candidate(1, "Junior Java"));
        candidates.put(2, new Candidate(2, "Middle Java"));
        candidates.put(3, new Candidate(3, "Senior Java"));
    }

    public static Store instOf() {
        return INST;
    }

    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    public Collection<Candidate> findAllCandidates() {
        return candidates.values();
    }

    public void save(Post post) {
        if (post.getId() == 0) {
            post.setId(postId.getAndIncrement());
        }
        posts.put(post.getId(), post);
    }

    public void save(Candidate candidate) {
        if (candidate.getId() == 0) {
            candidate.setId(candidateId.getAndIncrement());
        }
        candidates.put(candidate.getId(), candidate);
    }

    public Post findById(int id) {
        return posts.get(id);
    }

    public Candidate candidateFindById(int id) {
        return candidates.get(id);
    }
}