using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CwM_Part2.Polymorphism
{
    internal class OracleConnection : DbConnection
    {
        public OracleConnection(string connectionString) : base(connectionString)
        {
        }

        public override void Close()
        {
            Console.WriteLine("Close OracleConnection");
        }

        public override void Open()
        {
            Console.WriteLine("Open OracleConnection");
        }
    }
}
