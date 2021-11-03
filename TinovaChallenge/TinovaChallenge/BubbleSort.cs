using System.Windows.Forms;

namespace TinovaChallenge
{
    internal class BubbleSort
    {
		private int[] arr;
        private int sizeOfBubbleArray;
        private int nextPos;
                
        public BubbleSort(int size)
        {
            if (size > 0)
            {
                arr = new int[size];
                sizeOfBubbleArray = size;
                nextPos = 0;
            }
            else
            {
                sizeOfBubbleArray = 0;
                MessageBox.Show("Initialization failed. Size must be grather than 0.", "Error", MessageBoxButtons.OK);
            }
        }

        ~BubbleSort()
        {
            // garbage collector destruirá o que foi alocado
        }

        // adiciona um valor ao array
        public void Add(int value)
        {
            if (nextPos >= sizeOfBubbleArray)
                MessageBox.Show("Array size is full.Cannot add new element.", "Error", MessageBoxButtons.OK);
            else
            {
                arr[nextPos] = value;
                nextPos++;
            }
        }

        public void BubbleEvaluate()
        {
            int temp;

            for (int write = 0; write < arr.Length; write++)
            {
                for (int sort = 0; sort < arr.Length - 1; sort++)
                {
                    if (arr[sort] > arr[sort + 1])
                    {
                        temp = arr[sort + 1];
                        arr[sort + 1] = arr[sort];
                        arr[sort] = temp;
                    }
                }
            }

        }

        public string GetArrString()
        {
            string text = "{";
            for(int i=0;i<nextPos;i++)
            {
                if (i == nextPos - 1)
                    text = text + arr[i].ToString() + "}";
                else
                    text = text + arr[i].ToString()+", ";
            }

            return text;
        }


    }
}