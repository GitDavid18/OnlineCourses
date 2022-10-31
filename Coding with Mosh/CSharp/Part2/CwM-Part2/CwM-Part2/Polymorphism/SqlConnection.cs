using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CwM_Part2.Polymorphism
{
    internal class SqlConnection : DbConnection
    {
        public SqlConnection(string connectionString) : base(connectionString)
        {
        }

        public override void Close()
        {
            Console.WriteLine("Closing SqlConnection");
        }

        public override void Open()
        {
            Console.WriteLine("Opening SqlConnection");
        }
    }
}
