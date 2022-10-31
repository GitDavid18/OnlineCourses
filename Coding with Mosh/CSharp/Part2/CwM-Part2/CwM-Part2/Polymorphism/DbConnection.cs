using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CwM_Part2.Polymorphism
{
    public abstract class DbConnection
    {
        protected string _connectionString;
        protected virtual TimeSpan _connectionTimeout { get; set; }

        public DbConnection(string connectionString)
        {
            if (string.IsNullOrWhiteSpace(connectionString))
                throw new InvalidDataException("Input cannot be null or empty");    
            _connectionString = connectionString;   
        }

        public abstract void Open();
        public abstract void Close();

    }
}
