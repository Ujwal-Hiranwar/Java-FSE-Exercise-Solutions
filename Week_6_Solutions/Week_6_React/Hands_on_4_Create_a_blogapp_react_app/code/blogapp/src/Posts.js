import React from 'react';
import Post from './Post';

class Posts extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: [],
            hasError: false
        };
    }

    loadPosts() {
        fetch("https://jsonplaceholder.typicode.com/posts")
            .then(response => response.json())
            .then(data => {
                const postList = data.map(item => new Post(item.id, item.title, item.body));
                this.setState({ posts: postList });
            })
            .catch(error => {
                console.error("Error fetching posts:", error);
                this.setState({ hasError: true });
            });
    }

    componentDidMount() {
        this.loadPosts();
    }

    render() {
        if (this.state.hasError) {
            return <h2>Error loading posts...</h2>;
        }
        return (
            <div>
                <h1>Blog Posts</h1>
                {this.state.posts.map(post => (
                    <div key={post.id}>
                        <h2>{post.title}</h2>
                        <p>{post.body}</p>
                    </div>
                ))}
            </div>
        );
    }

    componentDidCatch(error, info) {
        alert("An error occurred in the component.");
        console.error("Error info:", info);
    }
}

export default Posts;
