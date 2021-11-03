using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TinovaChallenge
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }


        private void button1_Click(object sender, EventArgs e)
        {
            int[] arr = {1000, 800, 150, 50};

            textBox1.Text = "Desafio 1- Votos em relação ao total de eleitores";
            
            // verifica se o textbox está vazio
            if (String.IsNullOrEmpty(textBox2.Text))
            {
                textBox2.Text = "1000,800,150,50";
            }
            else
            {
                try
                {
                    arr = textBox2.Text.Split(',').Select(n => Convert.ToInt32(n)).ToArray();
                }
                catch
                {
                    MessageBox.Show("Invalid input.Assuming the default value.", "Error", MessageBoxButtons.OK);
                    textBox2.Text = "1000,800,150,50";

                }
            }

            string text = "";

            // inicializa com os valores da tabela dados do desafio
            Vote voto = new Vote(arr[0],arr[1],arr[2],arr[3]);

            // calcula os 3 tipos de porcentagem. Despresa casas decimais.
            text = text + voto.porcentagemVotosValidos().ToString("N0") + " %\r\n";
            text = text + voto.porcentagemVotosBrancos().ToString("N0") + " %\r\n";
            text = text + voto.porcentagemVotosNulos().ToString("N0") + " %\r\n";

            textBox3.Text = text;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            int[] arr;

            textBox1.Text = "Desafio 2- Ordenação Bubble Sort";

            try
            {
               
                // verifica se o textbox está vazio
                if (String.IsNullOrEmpty(textBox2.Text))
                {
                    textBox2.Text = "5,3,2,4,7,1,0,6";
                    arr = new int[8];
                    arr = textBox2.Text.Split(',').Select(n => Convert.ToInt32(n)).ToArray();
                }
                else
                {
                
                    arr = new int[(textBox2.Text.Split(',').Select(n => Convert.ToInt32(n)).ToArray()).Length];
                    arr = textBox2.Text.Split(',').Select(n => Convert.ToInt32(n)).ToArray();
                    
                }

                // inicializa com os valores do array a ser ordenado do desafio
                // optou-se por adição unitária
                BubbleSort sort = new BubbleSort(arr.Length);
                foreach (int var in arr)
                    sort.Add(var);
                
                textBox2.Text = sort.GetArrString();

                // faz o bubble sort
                sort.BubbleEvaluate();

                textBox3.Text = sort.GetArrString();

            }
            catch
            {
                MessageBox.Show("An error occur. Maybe a invalid input.", "Error", MessageBoxButtons.OK);
            }

        }

        private void button3_Click(object sender, EventArgs e)
        {
            int f = 5;

            textBox1.Text = "Desafio 3- Fatorial";

            try
            {
                // verifica se o textbox está vazio
                if (String.IsNullOrEmpty(textBox2.Text))
                {
                    f = 5;
                    textBox2.Text = f.ToString();
                }
                else
                {
                    f = int.Parse(textBox2.Text);
                }

                // inicializa e faz o fatorial com o valor do exercício: 5
                Fatorial fat = new Fatorial();

                textBox3.Text = fat.Evaluate(f).ToString();
                
            }
            catch
            {
                MessageBox.Show("An error occur. Maybe a invalid input.", "Error", MessageBoxButtons.OK);
            }
        }
            

        private void button4_Click(object sender, EventArgs e)
        {
            textBox1.Text = "Desafio 4- Soma dos multiplos";

            // como pedido no exercicio abre-se um dialogo para entrada de dados
            // verifica se o textbox está vazio
            try
            {
                if (String.IsNullOrEmpty(textBox2.Text))
                {
                    textBox2.Text = "10";
                }
              

                // chama a classe correspondente
                Multiplos mult = new Multiplos(textBox2.Text);
                textBox3.Text = mult.SomaMultiplos().ToString();

            }
            catch
            {
                MessageBox.Show("An error occur. Maybe a invalid input.", "Error", MessageBoxButtons.OK);
            }

       
            
            




        }


    }
}
