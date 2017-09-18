package com.niit.ChatVat.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ChatVat.Dao.BlogDAO;
import com.niit.ChatVat.model.Blog.Blog;

public class BlogDAOTestCase 
{
	static BlogDAO blogDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext 	annotationConfigApplicationContext=new 	AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.niit.ChatVat");
		annotationConfigApplicationContext.refresh();
		blogDAO=(BlogDAO)annotationConfigApplicationContext.getBean("blogDAO");
	}
	
	
	@Test
	public void createBlogTest() 
	{
		Blog blog=new Blog();
		blog.setBlogId(1001);
		blog.setBlogName("selenium");
		blog.setBlogContent("seleniium is testing tool");
		blog.setUserId("hari@gmail.com");
		blog.setCreateDate(new java.util.Date());
		blog.setStatus("NA");
		blog.setLikes(0);
		
		assertTrue("problem in blog creation",blogDAO.createBlog(blog));
		
	}
	
	@Ignore
	@Test
	public void approveBlogTest()
	{
		Blog blog=new Blog();
		
		blog.setBlogId(1001);
		blog.setBlogName("selenium");
		blog.setBlogContent("seleniium is testing tool");
		blog.setUserId("hari@gmail.com");
		blog.setCreateDate(new java.util.Date());
		blog.setStatus("NA");
		blog.setLikes(0);
		
		assertTrue("problem in Approve Blog",blogDAO.createBlog(blog));
		
		
	}

}
