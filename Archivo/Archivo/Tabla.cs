using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Collections;
using System.IO;

namespace Archivo
{
    public partial class Tabla : Form
    {
        private List<Datos> data = new List<Datos>();

        public Tabla()
        {
            InitializeComponent();
        }

        public void refrescar()
        {
            dataGridView1.DataSource = null;
            dataGridView1.DataSource = data;
        }

        private void buttonmas_Click(object sender, EventArgs e)
        {
            Nuevo n = new Nuevo();
            n.Insert = true;
            if (n.ShowDialog() == DialogResult.OK)
            {
                
                data.Add(new Datos(n.d.Nombre,n.d.Correo,n.d.Legajo,n.d.Carrera));
                refrescar();
            }
        }

        private void Tabla_Load(object sender, EventArgs e)
        {
            refrescar();
        }

        private void buttonsafe_Click(object sender, EventArgs e)
        {
            using(StreamWriter sw = new StreamWriter(@"C:\Form\Alumno.txt"))
            {
                foreach (Datos item in data)
                {
                    sw.WriteLine($"{item.Nombre},{item.Correo},{item.Legajo},{item.Carrera}");
                }

            }
            
        }
    }
}

