package com.payit.integration;

import static io.dropwizard.testing.ResourceHelpers.resourceFilePath;

import com.payit.ApplicationMain;
import com.payit.api.BlogPost;
import com.payit.fixture.GenerateObjects;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.dropwizard.Configuration;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.stream.IntStream;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class BlogPostEndpointTest {
    @ClassRule
    public static final DropwizardAppRule<Configuration> RULE = new DropwizardAppRule<>(ApplicationMain.class, resourceFilePath("app.yml"));
    protected static final String BASE_URL = "/posts";
    protected Client client;
    protected String serverAddress;

    @Before
    public void setUp() throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        client = ClientBuilder.newClient();
        serverAddress = "http://localhost:" + RULE.getLocalPort();
    }

    @After
    public void cleanUp() throws JsonProcessingException {
        getAll().stream().parallel().forEach(post -> deleteABlogPost(post.getId()));
    }

    @Test
    public void postABlogPostTest() {
        WebTarget target = client.target(serverAddress).path(BASE_URL);

        BlogPost post = target.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(GenerateObjects.generateBlogPost(), MediaType.APPLICATION_JSON_TYPE), BlogPost.class);

        Assert.assertNotNull(post);
    }

    @Test
    public void getABlogPost() {
        BlogPost post = storeABlogPost();
        WebTarget target = client.target(serverAddress).path(BASE_URL + "/" + post.getId());

        BlogPost foundPost = target.request(MediaType.APPLICATION_JSON_TYPE).get(BlogPost.class);

        Assert.assertNotNull(foundPost);
        Assert.assertEquals(post.getId(), foundPost.getId());
    }

    @Test
    public void testGetAllBlogPosts() throws JsonProcessingException {
        int expected = 100;
        IntStream.range(0, expected).forEach(item -> storeABlogPost());

        Assert.assertEquals(expected, getAll().size());
    }

    public void deleteABlogPost(String id) {
        WebTarget target = client.target(serverAddress).path(BASE_URL + "/" + id);
        target.request(MediaType.APPLICATION_JSON_TYPE).delete();
    }

    public BlogPost storeABlogPost() {
        WebTarget target = client.target(serverAddress).path(BASE_URL);

        return target.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(GenerateObjects.generateBlogPost(), MediaType.APPLICATION_JSON_TYPE), BlogPost.class);
    }

    public List<BlogPost> getAll() throws JsonProcessingException {
        WebTarget target = client.target(serverAddress).path(BASE_URL);
        List<BlogPost> allPosts = target.request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType<List<BlogPost>>() {});

        return allPosts;
    }
}
