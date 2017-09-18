package com.niit.ChatVat.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ChatVat.model.Blog.Blog;

public class BlogDaoImpl implements BlogDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public BlogDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public boolean createBlog(Blog blog)
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			System.out.println("Insertion Successful");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised:"+e);
			return false;
		}
		
		
	}

	public Blog getBlog(int blogId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Blog> getBlogs() {
		return null;
		
	/*	SessionFactory=sessionFactory.openSession();
		Query query=session.createQuery("from Blog where status='A'");
		List<Blog> listBlog=query.list();
		session.close();
		return listBlog;*/
	}

	@Transactional
	public boolean approveBlog(Blog blog) 
	{
		try
		{
			blog.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised:"+e);
			return false;
		
			
		}
	}

	public boolean editBlog(int blogId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteBlog(int blogId) {
		// TODO Auto-generated method stub
		return false;
	}

	}
