using System.Windows.Forms;

namespace TinovaChallenge
{
    internal class Multiplos
    {
        private int value;

        public Multiplos(string value)
        {
            try
            {
                this.value = int.Parse(value);
            }
            catch
            {
                MessageBox.Show("Invalid input.", "Error", MessageBoxButtons.OK);
                this.value = 0;
            }
        }

        public int SomaMultiplos()
        {
            try
            {
                int res = 0;

                for (int i = 0; i < value; i++)
                {
                    if (i % 3 == 0 || i % 5 == 0)
                    {
                        res += i;
                    }
                }
                return res;
            }
            catch
            {
                MessageBox.Show("Invalid input.", "Error", MessageBoxButtons.OK);
                return -1;
            }
        }
    }
}