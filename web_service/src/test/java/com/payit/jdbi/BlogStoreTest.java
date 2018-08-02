package com.payit.jdbi;

import static com.payit.fixture.GenerateObjects.generateBlogPost;
import static io.dropwizard.testing.ResourceHelpers.resourceFilePath;

import com.payit.ApplicationMain;
import com.payit.ServiceInjector;
import com.payit.api.BlogPost;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Configuration;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

public class BlogStoreTest {
    protected BlogStore blogStore;
    @ClassRule
    public static final DropwizardAppRule<Configuration> RULE = new DropwizardAppRule<>(ApplicationMain.class, resourceFilePath("app.yml"));

    @Before
    public void setUp() {
        Injector injector = Guice.createInjector(new ServiceInjector());
        blogStore = injector.getInstance(BlogStore.class);
    }

    @After
    public void tearDown() {
        blogStore.getAllPosts().stream().forEach(blog -> blogStore.deleteBlogPost(blog.getId()));
    }

    @Test
    public void storeBlogPostTest() {
        BlogPost post = generateBlogPost();
        blogStore.storeBlogPost(post);
        BlogPost storedPost = blogStore.getBlogPostById(post.getId());
        Assert.assertNotNull(storedPost);
    }

    @Test
    public void getBlogPostByIdTest() {
        BlogPost post = generateBlogPost();
        blogStore.storeBlogPost(post);

        BlogPost storedPost = blogStore.getBlogPostById(post.getId());
        Assert.assertNotNull(storedPost);
    }

    @Test
    public void getBlogPostByIdNotFoundTest() {
        BlogPost notFoundPost = blogStore.getBlogPostById(UUID.randomUUID().toString());
        Assert.assertNull(notFoundPost);
    }

    @Test
    public void updateBlogPostTest() throws IllegalAccessException, InvocationTargetException {
        BlogPost post = generateBlogPost();
        blogStore.storeBlogPost(post);

        String newTitle = UUID.randomUUID().toString();
        post.setTitle(newTitle);

        blogStore.updateBlogPost(post.getId(), post);

        BlogPost updatedPost = blogStore.getBlogPostById(post.getId());
        Assert.assertEquals(newTitle, updatedPost.getTitle());
    }

    @Test
    public void getAllPostsTest() {
        int expectedSize = 100;

        IntStream.range(0, expectedSize).parallel().forEach(item -> {
            BlogPost post = generateBlogPost();
            blogStore.storeBlogPost(post);
        });

        List<BlogPost> allBlogPosts = blogStore.getAllPosts();

        Assert.assertEquals(expectedSize, allBlogPosts.size());
    }
}
