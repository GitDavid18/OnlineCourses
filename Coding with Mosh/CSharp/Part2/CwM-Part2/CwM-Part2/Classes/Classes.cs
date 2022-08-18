namespace CwM_Part2.Classes;

public class Classes
{
    /// <summary>
    /// Exercise 1
    /// </summary>
    public void RunStopwatch()
    {
        var watch = new Stopwatch();

        watch.Start();
        Thread.Sleep(1000);
        Console.WriteLine($"Current duration : {watch.Duration}");
        watch.Stop();
        Thread.Sleep(1000);
        Console.WriteLine($"Current duration : {watch.Duration}");
        Thread.Sleep(1000);
        watch.Stop();
        Console.WriteLine($"Current duration : {watch.Duration}");
        Thread.Sleep(1000);
        watch.Start();
        Console.WriteLine($"Current duration : {watch.Duration}");
        Thread.Sleep(1000);
        watch.Start();
        Console.WriteLine($"Current duration : {watch.Duration}");
        Thread.Sleep(1000);
        watch.Stop();
        Console.WriteLine($"Current duration : {watch.Duration}");
    }

    /// <summary>
    /// Exercise 2
    /// </summary>
    public void RunStackOverflowPost()
    {
        var post = new StackOverflowPost("Random Title", "Super educational post");
        post.UpVote();
        post.UpVote();
        post.UpVote();
        post.UpVote();
        post.UpVote();
        post.DownVote();

        Console.WriteLine($"My post has a Vote of: {post.Vote} and was published on {post.PublishTime}");
    }
}