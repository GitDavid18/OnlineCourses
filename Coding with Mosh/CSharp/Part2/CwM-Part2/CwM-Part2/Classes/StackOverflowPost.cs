namespace CwM_Part2.Classes;

public class StackOverflowPost
{
    public string Title { get; }
    public string Description { get; }
    public int Vote { get; private set; }

    public readonly DateTime PublishTime;


    public StackOverflowPost(string title, string description)
    {
        Title       = title;
        Description = description;
        PublishTime = DateTime.Now;
        Vote        = 0;
    }

    public void UpVote()   => Vote++;
    public void DownVote() => Vote--;
}