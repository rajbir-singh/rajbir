package com.rajbir.core.repository;

import com.rajbir.core.domain.Post;
import java.util.List;

/**
 * Created by Sony on 30-08-2017.
 */
public interface PostRepository {
    List<Post> getPosts();
}
