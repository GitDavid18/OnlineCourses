using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CwM_Part2.Inheritance
{
    internal class Stack
    {

        private ArrayList list;
        public Stack()
        {
            list = new ArrayList();
        }

        public void Push(object obj)
        {
            if (obj != null)
                list.Add(obj);
            else
                throw new InvalidOperationException();
        }
        public object Pop() 
        {
            if (list.Count == 0)
                throw new InvalidOperationException();
            var ret = list[list.Count - 1];
            list.RemoveAt(list.Count - 1);
            return ret;
        }
        public void Clear() 
        {
            list.Clear();
        }
    }
}
