using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace Archivo
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void buttonSave_Click(object sender, EventArgs e)
        {
           
                using (StreamWriter sd = new StreamWriter (@"C:\Form\Test.txt"))
                {
                    sd.WriteLine(Pizarra.Text);
                }
        }

        private void buttonRead_Click(object sender, EventArgs e)
        {
            
                using (StreamReader sd = new StreamReader(@"C:\Form\Test.txt"))
                {
                    Pizarra.Text= sd.ReadToEnd();
                }
            

        }

        private void buttonclear_Click(object sender, EventArgs e)
        {
            Pizarra.Text = "";
        }
    }
}
