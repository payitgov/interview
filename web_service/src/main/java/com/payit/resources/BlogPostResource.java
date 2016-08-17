package com.payit.resources;

import com.codahale.metrics.annotation.Timed;
import com.payit.api.BlogPost;
import com.payit.service.BlogPostService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/posts")
@Produces(MediaType.APPLICATION_JSON)
public class BlogPostResource {

	private final BlogPostService blogPostService;

	@Inject
	public BlogPostResource(BlogPostService blogPostService) {
		this.blogPostService = blogPostService;
	}

	
	@GET
	@Timed
	public List<BlogPost> getAllBlogPosts(){
		return blogPostService.getAllPosts();
	}

	@POST
	@Timed
	public BlogPost storeBlogPost(BlogPost blogPost){
		return blogPostService.createPost(blogPost);
	}

	@GET
	@Path("/{postID}")
	@Timed
	public BlogPost getBlogPostByID(@PathParam("postID") String postID){
		return blogPostService.getPostById(postID);
	}

	@DELETE
	@Path("/{postID}")
	@Timed
	public void deleteBlogPost(@PathParam("postID") String postID){
		blogPostService.getPostById(postID);
	}

	@PUT
	@Path("/{postID}")
	@Timed
	public void updateBlogPost(@PathParam("postID") String postID, BlogPost blogPost){
		blogPostService.updatePost(postID, blogPost);
	}

}
