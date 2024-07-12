using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ArchivoTEST
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void buttonSave_Click(object sender, EventArgs e)
        {
            if (saveFileDialog1.ShowDialog()== DialogResult.OK)
            {
                using (StreamWriter sw = new StreamWriter(saveFileDialog1.FileName)) {
                    sw.WriteLine(Pizarra.Text);
                }
            }

        }

        private void buttonLoad_Click(object sender, EventArgs e)
        {

            if (openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                using (StreamReader sr = new StreamReader(openFileDialog1.FileName))
                {
                    Pizarra.Text=sr.ReadToEnd();
                }
            }
        }

        private void buttonClear_Click(object sender, EventArgs e)
        {
            Pizarra.Text = "";
        }

        private void buttonSee_Click(object sender, EventArgs e)
        {
            string Text = Pizarra.Text;

            // Cantidad de caracteres con espacios
            int cones = Text.Length;

            // Cantidad de caracteres sin espacios
            int sines = Text.Replace(" ", "").Length;

            // Cantidad de palabras
            string[] palablas = Text.Split(new char[] { ' ', '\r', '\n' }, StringSplitOptions.RemoveEmptyEntries);
            int total = palablas.Length;

            string result = $"Cantidad de caracteres (con espacios): {cones}\r\n";
            result += $"Cantidad de caracteres (sin espacios): {sines}\r\n";
            result += $"Cantidad de palabras: {total}\r\n";
            result += $"Palabras más repetidas:\r\n";

            // Contar la frecuencia de cada palabra
            Dictionary<string, int> palafre = new Dictionary<string, int>();
            foreach (string palabra in palablas)
            {
                if (palafre.ContainsKey(palabra))
                {
                    palafre[palabra]++;
                }
                else
                {
                    palafre[palabra] = 1;
                }
            }

            // Obtener las 10 palabras más repetidas
            var topala = palafre.OrderByDescending(w => w.Value).Take(5).ToList();
            int rank = 1;
            foreach (var palabra in topala)
            {
                result += $"{rank}. {palabra.Key} - {palabra.Value} veces, {palabra.Key.Length} caracteres\r\n";
                rank++;
            }

            Panel.Text = result;
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
    }
}
