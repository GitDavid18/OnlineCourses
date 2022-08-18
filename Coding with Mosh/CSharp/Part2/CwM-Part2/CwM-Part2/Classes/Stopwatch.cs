namespace CwM_Part2.Classes
{
    internal class Stopwatch
    {
        private DateTime _start;
        private DateTime _end;
        private bool     _isRunning;
        public TimeSpan Duration { get { return _isRunning ? DateTime.Now - _start : _end - _start; } }

        public Stopwatch()
        {
            _start = DateTime.Now;
            _end   = DateTime.Now;
        }

        public void Start()
        {
            Console.WriteLine("Starting stopwatch");
            if (_isRunning)
            {
                Console.WriteLine("Stopwatch is already running");
                return;
            }

            _start     = DateTime.Now;
            _isRunning = true;
        }

        public void Stop()
        {
            Console.WriteLine("Stopping Stopwatch");
            if (_isRunning == false)
            {
                Console.WriteLine("Stopwatch is not running");
                return;
            }

            _isRunning = false;
            _end       = DateTime.Now;
        }
    }
}
