let post = new Post('a', 'n', 'd');

console.log(post);

function Post(title, body, author) {
    this.title = title;
    this.author = author;
    this.body = body;
    this.views = 0;
    this.comments = [];
    this.isLive = false
}

