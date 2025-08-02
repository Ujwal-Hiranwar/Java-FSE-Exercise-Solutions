import React from 'react';

const BlogDetails = ({ blogs }) => {
  return (
    <div className="separator">
      <h1>Blog Details</h1>
      {blogs && blogs.length ? (
        blogs.map((blog, index) => (
          <div key={index}>
            <h2>{blog.title}</h2>
            <h4>{blog.author}</h4>
            <p>{blog.desc}</p>
          </div>
        ))
      ) : (
        <p>No blogs available</p>
      )}
    </div>
  );
};

export default BlogDetails;
