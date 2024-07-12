using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Archivo
{
    public partial class Nuevo : Form
    {
        public Datos d;
        public bool Insert { get; set; }
        public Nuevo()
        {
            InitializeComponent();
            d = new Datos();
        }

        private void Nuevo_Load(object sender, EventArgs e)
        {
           

        }

        private void buttonagregar_Click(object sender, EventArgs e)
        {
            if (Insert)
            {
                d.Nombre = textBoxname.Text;
                d.Correo = textBoxcorreo.Text;
                d.Legajo = textBoxlegajo.Text;
                d.Carrera = textBoxcarrera.Text;

               this.DialogResult = DialogResult.OK;
                this.Close();
            }
        }
    }
}
