package ru.job4j.dreamjob.store;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.dreamjob.model.Post;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
@Repository
public class PostStore {

    private static final PostStore INST = new PostStore();

    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private PostStore() {
        int id = atomicInteger.incrementAndGet();
        posts.put(id, new Post(id, "Junior", "Create simple app", null, LocalDateTime.now()));
        id = atomicInteger.incrementAndGet();
        posts.put(id, new Post(id, "Middle", "Create middle hard app", null, LocalDateTime.now()));
        id = atomicInteger.incrementAndGet();
        posts.put(id, new Post(id, "Senior", "Create very hard app", null, LocalDateTime.now()));
    }

    public static PostStore instOf() {
        return INST;
    }

    public Collection<Post> findAll() {
        return posts.values();
    }

    public Post add(Post post) {
        int id = atomicInteger.incrementAndGet();
        post.setId(id);
        return posts.put(post.getId(), post);
    }

    public Post findById(int id) {
        return posts.get(id);
    }

    public Post update(Post post) {
        return posts.replace(post.getId(), post);
    }
}