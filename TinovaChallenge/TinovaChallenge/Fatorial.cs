namespace TinovaChallenge
{
    internal class Fatorial
    {
        private int fatorial;

        public Fatorial()
        {
        }


        public int Evaluate(int fatorial)
        {
            if (fatorial == 1)
                return 1;
            else
                return fatorial * Evaluate(fatorial - 1);
        }
        
    }
}